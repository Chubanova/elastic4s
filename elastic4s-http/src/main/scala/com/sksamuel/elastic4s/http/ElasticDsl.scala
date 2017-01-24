package com.sksamuel.elastic4s.http

import com.sksamuel.elastic4s.http.get.GetHttpExecutables
import com.sksamuel.elastic4s.http.index.{CreateIndexExecutables, IndexHttpExecutables, RefreshIndexExecutables}
import com.sksamuel.exts.Logging

trait ElasticDsl
  extends Logging
    with IndexHttpExecutables
    with CreateIndexExecutables
    with GetHttpExecutables
    with RefreshIndexExecutables

object ElasticDsl extends ElasticDsl
