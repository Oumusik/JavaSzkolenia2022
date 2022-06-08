package firstapp

import grails.converters.JSON
import grails.converters.XML

class FuelUsageController {

    FuelCostService fuelCostService

    def index() {
        render "Heroyam Slava"
    }

    def drivingPrice(){

        render fuelCostService.calculateCostByModel(params.model)
    }

    def saveNewCar(){
        Car car = fuelCostService.saveCar("Focus", "Ford", "diesel", 6.2, 1.6)
        render car as JSON
    }


    def showAllCars(){
        render view: 'showAllCars', model: [carList: Car.list()]
    }
}
