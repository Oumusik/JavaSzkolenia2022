package firstapp

class FuelUsageController {

    FuelCostService fuelCostService

    def index() {
        render "Slava Ukrainie"
    }

    def drivingPrice(){

        render fuelCostService.calculateCostByModel(params.model)
    }

    def saveNewCar(){
        render fuelCostService.saveCar("Focus", "Ford", "diesel", 6.2, 1.6)

    }
}
