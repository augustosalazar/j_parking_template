# Parking Lot System

Implementation of a parking lot system using the provided UML diagram.

# UML
![image](https://github.com/user-attachments/assets/33c5d9d4-2bd7-486c-bada-5b0cf3953ff8)

   
## PlantUML code:

```plantuml
@startuml

class Vehicle {
    +int id
    +Vehicle(int)
}

class Car extends Vehicle {
    +Car(int)
}

class Motorcycle extends Vehicle {
    +Motorcycle(int)
}

class User {
    +int id
    +Vehicle vehicle
    +boolean isFree
    +getVehicle(): Vehicle
}

class FreeUser extends User {
    +FreeUser(int, Vehicle)
}

class RegularUser extends User {
    +RegularUser(int, Vehicle)
}

abstract class Slot {
    +int id
    +Vehicle vehicle
    +isFree(): boolean
    +removeVehicle(): void
}

class CarSlot extends Slot {
    +CarSlot(int)
    +parkCar(Car): void
}

class MotorcycleSlot extends Slot {
    +MotorcycleSlot(int)
    +parkMotorcycle(Motorcycle): void
}

class ParkingLot {
    +int id
    +ArrayList<Slot> slots
    +int availableSlots
    +int maxFreeSlots
    +ParkingLot(int, int, int, int)
    +getTotalSlots(): int
    +getAvailableSlots(): int
    +isFull(): boolean
    +parkCar(User): Slot
    +parkMotorcycle(User): Slot
    +unparkVehicle(ParkingEvent): void
}

class ParkingEvent {
    +int id
    +User user
    +Vehicle vehicle
    +Slot slot
    +ParkingLot parkingLot
    +Date startingTime
    +Date endingTime
    +ParkingEvent(int, User, ParkingLot, Slot)
    +endParking(): int
    +getId(): int
    +getUser(): User
    +getParkingLot(): ParkingLot
    +getSlot(): Slot
    +getEndingTime(): Date
}

class ParkingSystem {
    +ArrayList<ParkingLot> parkingLots
    +ArrayList<ParkingEvent> parkingEvents
    +int idOfNextParkingEvent
    +ParkingSystem()
    +addParkingLot(ParkingLot): void
    +parkCar(User): boolean
    +parkMotorcycle(User): boolean
    +endParking(int): boolean
    +getNumberOfParkingEvents(): int
    +getNumberOfCurrentParkingEvents(): int
    +getIdOfParkingWithMoreFreeSlots(): int
    +getNumberOfFreeSlotsInParkingLot(int): int
}

ParkingLot "1" *-- "0..*" Slot
ParkingEvent "1" --> "1" User
ParkingEvent "1" --> "1" Vehicle
ParkingEvent "1" --> "1" Slot
ParkingEvent "1" --> "1" ParkingLot
ParkingSystem "1" *-- "0..*" ParkingLot
ParkingSystem "1" *-- "0..*" ParkingEvent

@enduml


```

## Funcionamiento
Es prohíbido el uso de cualquier tipo de material de consulta, incluyendo libros, apuntes, internet, etc. El trabajo es individual y cualquier intento de copia o fraude será penalizado. No se permite el uso de asistentes de programación como COPILOT o chatGPT. Cualquier duda o aclaración, por favor preguntar al profesor.   
   
Los casos de prueba no pueden ser editados, ni se pueden agregar o quitar casos de prueba. Si se hace, el parcial será anulado y se considerará como copia. Si hay algún error en los casos de prueba, por favor notificar al profesor.

