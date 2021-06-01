package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
      val marcelo = Empleado(36)
      val cristian = Empleado(30)
      val brian = Empleado(41)
      val ezequiel = Empleado(29)

      val tarea1 = Tarea(50, marcelo, 304)
      val tarea2 = Tarea(24, ezequiel, 689)

      tarea1.agregarEmpleado(cristian)
      tarea1.agregarEmpleado(brian)
      tarea1.agregarEmpleado(ezequiel)

      tarea2.agregarEmpleado(cristian)

      describe("nomina de empleados") {
          tarea1.nominaDeEmpleados().shouldBe(listOf(cristian, brian, ezequiel, marcelo))
          tarea2.nominaDeEmpleados().shouldBe(listOf(cristian, ezequiel))
      }
      describe("cuanto tiempo le lleva una tarea")
      {
          tarea1.cuantoTiempoLlevaTerminar().shouldBe(16)
          tarea2.cuantoTiempoLlevaTerminar().shouldBe(24)
      }

      describe("costos de tarea") {
          tarea1.costoDeTarea().shouldBe(3704)
          tarea2.costoDeTarea().shouldBe(2105)
      }

      describe("tarea de integración") {
          val jonny = Empleado(50)
          val rodrigo = Empleado(43)
          val tarea3 = Tarea(69, rodrigo, 1678)
          val tareaDeIntegracion1 = TareasDeIntegracion(cristian)
          val tareaDeIntegracion2 = TareasDeIntegracion(brian)

          tarea3.agregarEmpleado(cristian)
          tarea3.agregarEmpleado(ezequiel)
          tarea3.agregarEmpleado(jonny)
          tareaDeIntegracion1.agregarSubtarea(tarea1)
          tareaDeIntegracion1.agregarSubtarea(tarea2)

          tareaDeIntegracion2.agregarSubtarea(tarea2)
          tareaDeIntegracion2.agregarSubtarea(tarea3)
          it("horas necesarias") {
              tareaDeIntegracion1.cuantoTiempoLlevaTerminar().shouldBe(45)
              tareaDeIntegracion2.cuantoTiempoLlevaTerminar().shouldBe(52)
          }
          it("costos") {
              tareaDeIntegracion1.costoDeTarea().shouldBe(5983)
              tareaDeIntegracion2.costoDeTarea().shouldBe(9534)
          }
          it("nominas") {
              tareaDeIntegracion1.nominaDeEmpleados().shouldBe(listOf(cristian, brian, ezequiel, marcelo, cristian, ezequiel, cristian))
              tareaDeIntegracion2.nominaDeEmpleados().shouldBe(listOf(cristian, ezequiel, cristian, ezequiel, jonny, rodrigo, brian))
          }
      }

  }
})
