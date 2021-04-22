// Build the Random Forecaster app
var cities = getColumn("Daily Weather", "City");
var highTemps = getColumn("Daily Weather", "High Temperature");
var lowTemps = getColumn("Daily Weather", "Low Temperature");
var images = getColumn("Daily Weather", "Icon");
var conditions = getColumn("Daily Weather", "Main Condition");
var numberForecast = getColumn("Daily Weather", "Forecast Number");
//Filter
var tomorrowCities = [];
var tomorrowHigh = [];
var tomorrowLow = [];
var tomorrowImages = [];
var tomorrowConditions = [];
onEvent("forecastButton", "click", function( ) {
  forecastChange();
});
for (var i = 0; i < cities.length; i++) {
  if (numberForecast [i] == 1) {
    appendItem(tomorrowCities, cities [i]);
    appendItem(tomorrowHigh, highTemps [i]);
    appendItem(tomorrowLow, lowTemps [i]);
    appendItem(tomorrowImages, images [i]);
    appendItem(tomorrowConditions, conditions [i]);
  }
}
function forecastChange() {
 var update = randomNumber(0, tomorrowCities.length - 1);
  setText("cityOutput", tomorrowCities [update]);
  setText("highTempOutput", tomorrowHigh [update]);
  setText("lowTempOutput", tomorrowLow [update]);
  setProperty("iconOutput", "image", tomorrowImages [update]);
  setText("conditionOutput", tomorrowConditions [update]);
}
