# VALIDACIÓ DE LA IDEA
Aquesta primera entrega de la pràctica ha de servir-te per a establir els objectius i límits del teu projecte: 

- De quina temàtica tracta el teu projecte? Tria’n una que dominis i que t’agradi.
- A quina necessitat del món real intenta donar-hi solució? Existeixen ja solucions per a aquesta idea?
- Quines seran les funcionalitats de la teva aplicació?
- Què es podrà fer amb el teu programa?
- Quines opcions tindrà el teu menú?

És important tenir clares les respostes abans de fer la primera línia de codi; si no tenim un full de ruta, estem abocats a l’error i al fracàs.
Entrega: Desenvolupa tot els punts marcats en groc.

 
## Modelat del menú

Has de fer un esforç de disseny per a decidir sobre quina temàtica tracta el teu projecte i pensar quines funcionalitats vols que tingui. Pots afegir imatges, logos, dibuixos, links web, etc.

### Temàtica del projecte

Temàtica lliure.  Es permet qualsevol temàtica, podeu consultar el següent [document](./Idees%20Projectes%20DAM%20DAW.md) per agafar idees.


### Funcionalitats

Sabem que en programació estructurada, les opcions del menú s’implementaran amb una estructura de `do-while` amb un `switch-case` a dins. Aquest `switch-case` tindrà tants cases com opcions tingui la nostra aplicació més el case de l’opció sortir i potser el `case default` si el vols utilitzar.

Per tant, ens pot ser molt útil usar un llistat numerat per a detallar les opcions del nostre programa de forma ordenada que posteriorment implementarem en el nostre codi font del menú.

Usant l’exemple del que disposes a sota, pensa i reescriu les opcions del menú principal del teu programa (un mínim de 4 opcions principals + sortir i els seus submenús):

```bash
1.	Opció 1
1.1.	Submenú Opció 1a
1.2.	Submenú Opció 1b
1.3.	...
1.4.	Tornar enrere
2.	Opció 2
2.1.	Submenú Opció 2a
2.2.	…
2.3.	Tornar enrere
3.	Opció 3
4.	…
5.	Sortir de l’aplicació
```

Fins ara hem après a fer programes que interactuen amb l’usuari a través de la consola i en general, les accions que fem son les de sol·licitar dades a l’usuari, mostrar informació, fer càlculs, eliminar dades, ... 

Descriu breument, en una o dues frases, què farà cada una de les opcions del menú del teu programa.
 
 
## Diagrama de flux

Ara que tens clar el menú de la teva aplicació, usa draw.io o similar per a dissenyar el diagrama de flux del menú principal.
Recorda usar les figures geomètriques que hem vist a teoria i exportar el teu disseny en format .png i no fent un screenshot.

 
## Planificació dels mètodes

El següent pas serà començar a planificar quins mètodes ens seran necessaris. A continuació d’aquest document haureu d'incloure, usant JavaDocs, la informació bàsica dels mètodes que necessitareu (no el codi), informant aixi de:

- Els paràmetres d'entrada
- Els paràmetres de sortida
- Una breu descripció de la seva funció

