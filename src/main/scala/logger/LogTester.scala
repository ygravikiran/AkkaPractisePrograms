package logger

import org.slf4j.LoggerFactory
import ch.qos.logback.core.util.StatusPrinter
import ch.qos.logback.classic.LoggerContext

object LogTester extends App{
  def logger = LoggerFactory.getLogger("samplelogger")
 
  StatusPrinter.print((LoggerFactory.getILoggerFactory).asInstanceOf[LoggerContext])
  logger.info("ravi")

}