package firstapp

import grails.gorm.transactions.Transactional
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

@Transactional
class FuelCostService {
    static final String FUEL_SERVICE_ADDRESS = "https://www.autocentrum.pl/paliwa/ceny-paliw/pb";

    def calculateCostByFuelUsage(Double fuelUsage){
        Document doc = Jsoup.connect(FUEL_SERVICE_ADDRESS).get();
        String priceText = doc.select("div.price").first().text();
        String[] priceParts = priceText.split(" ")
        String number = priceParts[0].replace(",",".")
        Double price = Double.parseDouble(number);
        return price * fuelUsage
    }

    def calculateCostByModel(String model){
        if(model == "ford"){
            return calculateCostByFuelUsage(7.6)
        }else if(model == "vw"){
            return calculateCostByFuelUsage(6.9)
        }else {
            return 0
        }
    }

    def saveCar(String model, String producer, String fuelType, Double fuelConsumption, Double engineVolume){
        Car car = new Car(model: model, producer: producer,
                            fuelType: fuelType,
                            fuelConsumption: fuelConsumption,
                            engineVolume: engineVolume,
                            number: 1)

        car.save()
    }
}
