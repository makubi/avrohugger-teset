package at.makubi.avrohugger.test

import java.io.File
import java.nio.file.Paths

import avrohugger.Generator
import avrohugger.filesorter.AvdlFileSorter
import avrohugger.format.Standard

object Main extends App {

  val generator = Generator(
    format = Standard
  )

  val schemaDirectory = Paths.get("src/main/avro").toAbsolutePath.toFile

  listFiles(schemaDirectory).foreach { schemaFile =>
    generator.fileToFile(schemaFile)
  }

  def listFiles(inputDirectory: File): Seq[File] = {
    val allFiles = inputDirectory.listFiles()

    AvdlFileSorter.sortSchemaFiles(allFiles)
  }
}
