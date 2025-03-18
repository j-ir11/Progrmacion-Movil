import 'dart:io';
import 'package:intl/intl.dart';

void main() {
  bool isRunning = true;

  while (isRunning) {
    print('Seleccione una opción:');
    print('1. Sumar tres números');
    print('2. Ingresar nombre completo');
    print('3. Ingresar fecha de nacimiento y calcular tiempo vivido');
    print('4. Salir');

    String? option = stdin.readLineSync();

    switch (option) {
      case '1':
        sumNumbers();
        break;
      case '2':
        enterName();
        break;
      case '3':
        calculateTimeLived();
        break;
      case '4':
        print('¡Hasta luego!');
        isRunning = false;
        break;
      default:
        print('Opción no válida, intente de nuevo.');
        break;
    }
  }
}

// Función para sumar tres números
void sumNumbers() {
  print('Ingrese el primer número:');
  double num1 = double.parse(stdin.readLineSync()!);

  print('Ingrese el segundo número:');
  double num2 = double.parse(stdin.readLineSync()!);

  print('Ingrese el tercer número:');
  double num3 = double.parse(stdin.readLineSync()!);

  double sum = num1 + num2 + num3;
  print('La suma es: $sum');
}

// Función para ingresar el nombre completo
void enterName() {
  print('Ingrese su nombre completo:');
  String? name = stdin.readLineSync();
  print('Hola, $name!');
}

// Función para calcular el tiempo vivido desde la fecha de nacimiento
void calculateTimeLived() {
  print('Ingrese su fecha de nacimiento (DD/MM/YYYY):');
  String? birthDate = stdin.readLineSync();

  DateTime birthDateTime = DateFormat('dd/MM/yyyy').parse(birthDate!);
  DateTime currentDate = DateTime.now();

  Duration difference = currentDate.difference(birthDateTime);

  int years = difference.inDays ~/ 365;
  int months = (difference.inDays % 365) ~/ 30;
  int weeks = difference.inDays ~/ 7;
  int days = difference.inDays;
  int hours = difference.inHours;
  int minutes = difference.inMinutes;
  int seconds = difference.inSeconds;

  print('Tiempo vivido desde su nacimiento:');
  print('$years años');
  print('$months meses');
  print('$weeks semanas');
  print('$days días');
  print('$hours horas');
  print('$minutes minutos');
  print('$seconds segundos');
}

