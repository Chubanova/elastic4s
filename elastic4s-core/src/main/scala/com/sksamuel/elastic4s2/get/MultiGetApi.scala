package com.sksamuel.elastic4s2.get

import com.sksamuel.elastic4s2.Executable
import org.elasticsearch.action.get._
import org.elasticsearch.client.Client

import scala.collection.JavaConverters._
import scala.concurrent.Future

trait MultiGetApi extends GetDsl {

  def multiget(gets: Iterable[GetDefinition]): MultiGetDefinition = MultiGetDefinition(gets.toSeq)
  def multiget(gets: GetDefinition*): MultiGetDefinition = MultiGetDefinition(gets)

  implicit object MultiGetDefinitionExecutable
    extends Executable[MultiGetDefinition, MultiGetResponse, MultiGetResult] {
    override def apply(c: Client, t: MultiGetDefinition): Future[MultiGetResult] = {
      injectFutureAndMap(c.multiGet(t.build, _))(MultiGetResult.apply)
    }
  }
}
