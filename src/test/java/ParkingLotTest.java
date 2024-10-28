import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.uninorte.Car;
import com.uninorte.FreeUser;
import com.uninorte.Motorcycle;
import com.uninorte.ParkingEvent;
import com.uninorte.ParkingLot;
import com.uninorte.RegularUser;
import com.uninorte.Slot;

public class ParkingLotTest {
    
    @Test
    public void testParkCar() {
        // esto contruye un ParkingLot con id 1, 10 slots para carros, 15 slots para motos y 3 slots para usuarios gratis (los 3 gratis no cuentan para la cantidad de slots disponibles)
        ParkingLot parkingLot = new ParkingLot(1, 10, 15, 3);
        // esto contruye un carro con id 1
        Car car = new Car(1);
        // esto contruye un usuario regular con id 1 y el carro anterior
        RegularUser regularUser = new RegularUser(1, car);

        // parkCar parquea el carro del usuario regular y devuelve el slot en el que fue parqueado
        assertNotEquals(null, parkingLot.parkCar(regularUser));
        // getAvailableSlots devuelve la cantidad de slots disponibles en el parqueadero (carros + motos)
        // esto verifica que el carro haya sido disminuido en 1
        assertEquals(24, parkingLot.getAvailableSlots());
    }
    
    @Test
    public void testParkMotorcycle() {
        ParkingLot parkingLot = new ParkingLot(1, 10, 15, 3);
        Motorcycle motorcycle = new Motorcycle(1);
        RegularUser regularUser = new RegularUser(1, motorcycle);        
        parkingLot.parkMotorcycle(regularUser);
        assertEquals(24, parkingLot.getAvailableSlots());
    }
    
    @Test
    public void testParkFreeUser() {
        ParkingLot parkingLot = new ParkingLot(1, 10, 15, 1);
        Car car = new Car(1);
        FreeUser freeUser = new FreeUser(1, car);
        assertNotEquals(null, parkingLot.parkCar(freeUser));
        Car car2 = new Car(2);
        FreeUser freeUser2 = new FreeUser(2, car2);       
        // debería devolver null porque ya no hay slots gratis 
        assertEquals(null, parkingLot.parkCar(freeUser2));
    }
    
    
    @Test
    public void testUnparkCar() {
        ParkingLot parkingLot = new ParkingLot(1, 10, 15, 1);
        Car car = new Car(1);
        FreeUser freeUser = new FreeUser(1, car);
        Slot slot = parkingLot.parkCar(freeUser);
        // esto construye un evento de parqueo con id 0, el usuario gratis y el slot en el que fue parqueado
        ParkingEvent pe = new ParkingEvent(0, freeUser, parkingLot, slot);
        assertEquals(24, parkingLot.getAvailableSlots());
        parkingLot.unparkVehicle(pe);
        assertEquals(25, parkingLot.getAvailableSlots());
    }
    
//     @Test
//     public void testUnparkMotorcycle() {
//         ParkingLot parkingLot = new ParkingLot(1, 1, 1);
//         Motorcycle motorcycle = new Motorcycle("ABC123", "Yamaha", "R15", "Black");
//         parkingLot.parkMotorcycle(motorcycle);
//         parkingLot.unparkMotorcycle();
//         assertNull(parkingLot.getMotorcycleSlot().getVehicle());
// }
}