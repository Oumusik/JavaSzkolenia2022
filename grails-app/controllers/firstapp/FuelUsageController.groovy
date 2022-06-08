package firstapp

class FuelUsageController {

    FuelCostService fuelCostService

    def index() {
        render "Heroyam Slava"
    }

    def drivingPrice(){

        render fuelCostService.calculateCostByModel(params.model)
    }

    def saveNewCar(){
        render fuelCostService.saveCar("Focus", "Ford", "diesel", 6.2, 1.6)

    }
}
