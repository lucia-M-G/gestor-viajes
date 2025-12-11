# Propostes de Projectes en Java (Programació Estructurada/Imperativa)

**Developers RECORDEU:** Aquesta pràctica esta enfocada a consolidar lògica, arrays, matrius i descomposició modular (funcions/mètodes estàtics) sense utilitzar classes ni objectes.

---

## EXEMPLE 1. Sistema de Reserves de Sala de Cinema (Matrius)
Aquest projecte és ideal per treballar amb matrius bidimensionals i lògica de coordenades.

* **Descripció:** L'aplicació ha de gestionar una sala de cinema representada per una matriu.
* **Estructures de Dades:**
    * `int[][] sala`: Una matriu (ex: 10x10) on `0` és lliure, `1` és ocupat, `2` és reservat.
    * `double recaptacioTotal`: Variable acumuladora.
* **Funcionalitats (Menú):**
    1.  **Mostrar sala:** Dibuixar la matriu per consola (utilitzant símbols com `[ ]`, `[X]`).
    2.  **Comprar entrada:** L'usuari tria fila i columna. El programa comprova si està lliure.
    3.  **Anul·lar reserva:** Alliberar un seient prèviament ocupat.
    4.  **Caixa del dia:** Calcular quants diners s'han guanyat (preus diferents segons si la fila és VIP o normal).
* **Repte addicional:** Suggerir automàticament el primer seient lliure més proper a la pantalla (fila 0).

## EXEMPLE 2. Joc de "Vaixells" (Hundir la flota - Versió Simplificada)
Perfecte per treballar bucles niats i lògica condicional complexa.

* **Descripció:** Un joc d'un sol jugador contra la màquina (o dos jugadors per torns al mateix teclat).
* **Estructures de Dades:**
    * `char[][] taulerJugador`: On es veuen els trets (Aigua 'A', Tocat 'X', Vaixell 'V').
    * `boolean[][] taulerOcult`: On la màquina ha amagat els vaixells realment.
* **Funcionalitats:**
    1.  **Col·locació aleatòria:** Una funció que col·loca els vaixells de la màquina sense que es solapin (ús de `Math.random`).
    2.  **Disparar:** L'usuari introdueix coordenades (ex: "5,3").
    3.  **Comprovació:** El sistema avalua si ha tocat aigua o vaixell i actualitza el tauler visible.
    4.  **Condició de victòria:** Bucle que no acaba fins que s'enfonsen tots els vaixells.

## EXEMPLE 3. Gestió d'Estoc de Magatzem (Arrays Paral·lels)
Com que no es poden usar objectes (Ex: `Producte p = new Producte()`), els alumnes han d'aprendre a sincronitzar dades mitjançant índexs en múltiples arrays.

* **Descripció:** Petit ERP per gestionar productes d'una botiga de tecnologia.
* **Estructures de Dades:**
    * `String[] nomsProductes`
    * `double[] preus`
    * `int[] quantitats`
    * `int comptadorProductes`: Per saber quants n'hi ha realment (mida lògica vs mida física).
* **Funcionalitats:**
    1.  **Alta producte:** Afegir dades a la primera posició lliure dels arrays. Validar que no estigui ple.
    2.  **Llistar productes:** Mostrar una taula formatada (`printf`) amb tots els productes.
    3.  **Modificar estoc:** Buscar un producte per nom i canviar-ne la quantitat.
    4.  **Productes sota mínims:** Mostrar només els productes amb menys de 5 unitats.
    5.  **Ordenar:** Ordenar els arrays (Bubble Sort o similar) segons el preu (del més car al més barat). *Nota: En moure un preu, cal moure el nom i la quantitat corresponent.*

## EXEMPLE 4. Analitzador de Dades Meteorològiques (Estadística)

* **Descripció:** Registrar la temperatura de cada dia del mes i extreure'n estadístiques.
* **Estructures de Dades:**
    * `double[] temperatures`: Array de mida 30 o 31.
* **Funcionalitats:**
    1.  **Introducció de dades:** Omplir l'array manualment o aleatòriament.
    2.  **Temperatura Mitjana:** Recórrer l'array sumant i dividir.
    3.  **Màxima i Mínima:** Trobar el valor més alt i més baix i dir quin dia (índex + 1) va passar.
    4.  **Histograma visual:** Pintar barres d'asteriscs horitzontals segons la temperatura de cada dia.
        * Exemple: `Dia 1 (12ºC): ************`
    5.  **Dies per sobre de la mitjana:** Llistar quins dies ha fet més calor que la mitjana del mes.

---

s