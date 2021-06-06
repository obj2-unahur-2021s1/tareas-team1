package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
      val marcelo = Empleado(36)
      val cristian = Empleado(30)
      val brian = Empleado(41)
      val ezequiel = Empleado(29)
      val david = Empleado(78)
      val elena = Empleado(67)


      val tarea1 = Tarea(50, marcelo, 304)
      val tarea2 = Tarea(24, david, 689)

      tarea1.agregarEmpleado(cristian)
      tarea1.agregarEmpleado(brian)
      tarea1.agregarEmpleado(ezequiel)

      tarea2.agregarEmpleado(elena)

      describe("nomina de empleados") {
          tarea1.nominaDeEmpleados().shouldBe(listOf(cristian, brian, ezequiel, marcelo))
          tarea2.nominaDeEmpleados().shouldBe(listOf(elena, david))
      }

      describe("cuanto tiempo le lleva una tarea") {
          tarea1.cuantoTiempoLlevaTerminar().shouldBe(16)
          tarea2.cuantoTiempoLlevaTerminar().shouldBe(24)
      }

      describe("costos de tarea") {
          tarea1.costoDeTarea().shouldBe(3704)
          tarea2.costoDeTarea().shouldBe(4169)
      }

      describe("tarea de integracion") {
          val jonny = Empleado(50)
          val rodrigo = Empleado(43)
          val tomas = Empleado(56)
          val julian = Empleado(67)

          val tarea3 = Tarea(69, julian, 1678)
          val tarea4 = Tarea(67, tomas, 1231)

          val tareaDeIntegracion1 = TareasDeIntegracion(jonny)
          val tareaDeIntegracion2 = TareasDeIntegracion(rodrigo)
          val tareaDeIntegracion3 = TareasDeIntegracion(julian)

          tarea3.agregarEmpleado(cristian)
          tarea3.agregarEmpleado(ezequiel)
          tarea3.agregarEmpleado(jonny)

          tareaDeIntegracion1.agregarSubtarea(tarea1)
          tareaDeIntegracion1.agregarSubtarea(tarea2)

          tareaDeIntegracion2.agregarSubtarea(tarea2)
          tareaDeIntegracion2.agregarSubtarea(tarea3)

          tareaDeIntegracion3.agregarSubtarea(tarea1)
          tareaDeIntegracion3.agregarSubtarea(tarea4)


          it("horas necesarias") {
              tareaDeIntegracion1.cuantoTiempoLlevaTerminar().shouldBe(45)
              tareaDeIntegracion2.cuantoTiempoLlevaTerminar().shouldBe(52)
          }

          it("costos") {
              tareaDeIntegracion1.costoDeTarea().shouldBe(8109)
              tareaDeIntegracion2.costoDeTarea().shouldBe(13366)
          }

          it("nominas") {
              tareaDeIntegracion2.nominaDeEmpleados().shouldBe(listOf(elena, david, cristian, ezequiel, jonny, julian, rodrigo ))
              tareaDeIntegracion1.nominaDeEmpleados().shouldBe(listOf(cristian, brian, ezequiel, marcelo, elena, david, jonny))
              tareaDeIntegracion2.agregarSubtarea(tareaDeIntegracion3)
              tareaDeIntegracion2.nominaDeEmpleados().shouldBe(listOf(elena, david, cristian, ezequiel, jonny, julian,cristian, brian, ezequiel, marcelo, tomas, julian, rodrigo))
          }
      }
  }
})
