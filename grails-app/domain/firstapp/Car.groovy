package firstapp

class Car {

    Model model
    Producer producer
    Double fuelConsumption
    FuelType fuelType
    Double engineVolume


    static constraints = {
    }


    public String toString(){
        return "Model: " + model.name + " Producer: " + producer.name + " ID: " + id
    }
}
