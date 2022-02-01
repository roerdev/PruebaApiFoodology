**Problemática a resolver:**
Implementar un programa que calcule y verifique si uno (cualquiera) de
nuestros restaurantes está visible en rappi en 4 puntos a 5km a la redonda de nuestra cocina de
Cali y nos diga la posición promedio en la que está apareciendo en el listado. El API público de
rappi no tiene métodos que den esa información, por lo que debes obtenerla de otra manera,
interceptando la página web.

**REQUERIMIENTOS**:

**Versión de Java:** 11
**IDE:** Intellij IDEA

El servicio desarrollado se encuentran en siguiente directorio: http://localhost:8080/api-foodology/

**Servicio expuestos:**

- Método POST _/restaurants_ el cual recibe en el body un json que contiene la localización de la cocina con la siguiente estructura:

Ej:

{

    "latitude": 3.4242814233739614,
    "longitude": -76.54170365914733
}

 Endpoint: http://localhost:8080/api-foodology/restaurants

El cual devolverá una lista de los restaurantes con la siguiente estructura:

Ej:

{

    "store_id": "900004872",
    "index": 0,
    "name": "KFC Calle 85 ",
    "location": [
        -74.054819120238,
        4.669691994056
    ],
    "address": "(Servicio a puerta cerrada - Tocar)Calle 85 # 14-33  ",
    "status": "OPEN",
    "open": true,
    "distanceKm": "3.52KM"
}

**store_id:** Id de la tienda asignado por Rappi.

**index:** Posición en el listado.

**name:** Nombre del restaurante.

**location:** Longitud y latitud del restaurante.

**address:** Dirección del restaurante.

**status:** Estado descritivo del restaurante.

**open:** Flag indicativo de apertura del restaurante.

**distanceKm:** Distancia entre el restaurante y la cocina.