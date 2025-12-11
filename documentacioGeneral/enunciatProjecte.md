# Aquesta pràctica aplica als mòduls 0485 Programació (RA1, RA3, RA7) i 0487 Entorns (RA4). 

La nota obtinguda es replicarà per tots els mòduls implicats.

La pràctica es realitza de forma grupal i s’haurà de superar una entrevista de correcció amb el professorat. No superar l’entrevista (vol dir no conèixer el propi programa), suposarà suspendre directament l’activitat. Davant del dubte, el professor, pot requerir desenvolupar una funcionalitat extra sobre la pràctica presentada, per tal de demostrar el domini del codi entregat. 

Qualsevol indici de copia, suposarà un 0 pel que copia i un 0 pel que es deixa copiar.

Heu d’implementar un software que resolgui una idea o necessitat del món real i que sigui del vostre interès.
La idea, és que usant les habilitats de programació lineal vistes a classe (sense fer ús de funcions ni tècniques no vistes a classe), desenvolupeu en grup i de forma autònoma un programa en Java usant IntelliJ que solucioni el problema plantejat.

La temàtica és lliure però serà necessari que inclogui els elements avaluables que podeu veure a l’apartat de rúbriques.



 
## Rúbrica d’avaluació (10 punts)

- Treball a l'aula: (+2 punts)
- Entrega + presentació: (+8 punts)


## Requisits 0485-Programació

- Els algoritmes estan dissenyats i implementats de manera eficient. S'eviten repeticions innecessàries de codi i variables redundants, la solució preveu múltiples casuístiques facilitant el manteniment i l'ampliació de funcionalitats en un futur.
- Menú d’usuari amb opció de sortir de l’aplicació o seguir operant.
- Ús de consola per a interactuar amb l’usuari amb control d’errors.
- Ús adequat d’estructures condicionals (IF-ELSE i/o SWITCH).
- Ús de adequat d’estructures iteratives (WHILE, DO-WHILE, FOR), utilitzant sentències de salt (break, continue) si fossin necessàries.
- Ús adequat de col·leccions estàtiques (vectors i/o matrius) i realitzar operacions amb elles: guardar dades, ordenar, fer cerques, etc
- Ús adequat de col·leccions dinàmiques (Arraylists) i realitzar operacions amb elles: guardar dades, ordenar, fer cerques, etc
- Ús adequat de mètodes per encapsular correctament les funcionalitats i operacions concurrents

I finalment també es considerarà que el codi sigui net i comprensible:
- Noms de variables auto-explicatius, nomenclatura lowerCamelCase, respectar l’abast d’us de variables. Ús de tipatge de dades adequat per a cada variable. Ús de constants, si aplica. 
- Posar comentaris explicatius a les parts de codi més importants.
- Identació.


## Requisits 0487-Entorns de desenvolupament:

L'ús del repositori de Github de classe és obligat en aquesta pràctica. Cal crear el repositori seguint l’enllaç penjat a Sallenet.

Es valorarà el següent:
- Ús del repositori aportat pel professor
- Ús correcte del control de versions
- Creació d'una branca per funcionalitat
- Ús d'eines de gestió de projectes (Github Projects, Trello, ClickUp...)
- Creació d'una Release per a l'entrega final
 
## Entregables

La pràctica tindrà les següents entregues:

- Diagrames fets a la validació de la idea
- Release del projecte
- Presentació

## RECORDEU DEVELOPERS!!Requisits Tècnics

1.  **Modularitat:** El `main` només ha de contenir el bucle del menú principal (`do-while` + `switch`). Tota la lògica ha d'estar encapsulada en funcions estàtiques (ex: `public static void mostrarTauler(int[][] m)`).
2.  **Validació d'Entrada:** Crear una funció auxiliar (ex: `llegirEnter(int min, int max)`) per evitar que el programa peti si l'usuari posa lletres on van números (`hasNextInt`).
3.  **Estil de codi:** Noms de variables descriptius i comentaris JavaDoc a les funcions.


**Consultar dates d’entrega a Sallenet**.
