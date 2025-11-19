
*Diferencias*

Arrays: Piensa en un array como un estacionamiento fijo. Si reservaste 100 espacios, solo tienes 100. Si quieres meter un coche en el medio, tienes que mover todos los demás coches. El lado bueno es que si quieres el coche número 50, vas directo a él .


Listas Enlazadas: Esto es como un tren con vagones sueltos. Cada vagón (nodo) sabe dónde está el siguiente. Esto nos da un tamaño ilimitado, genial para cuando no sabemos cuántos estudiantes o materias habrá. Poner o quitar un vagón es rapidísimo  porque solo cambias un enganche. El problema es que para encontrar el vagón 50, tienes que empezar desde el primero y recorrerlos todos.

*Ventajas*
La principal ventaja es que la lista enlazada puede crecer o decrecer libremente. No es necesario definir un tamaño máximo inicial, lo cual es vital para colecciones cuyo tamaño es desconocido (como el número de miembros o el historial de cambios).

Las operaciones de agregar o quitar elementos al principio o al final de la lista son extremadamente rápidas, ya que solo requieren cambiar punteros (referencias) entre nodos. Esto es ideal para implementar estructuras como la Pila (Historial) y la Cola (Turnos).


*Desventajas*

Para acceder a un elemento en una posición intermedia o final, el sistema debe comenzar desde el primer nodo y recorrer secuencialmente toda la cadena de nodos. Esto hace que las búsquedas y el acceso por índice sean significativamente más lentos que en un array.

Los algoritmos de ordenamiento son inherentemente ineficientes en listas enlazadas. Para ordenar la colección (ej. estudiantes por apellido), es necesario primero convertir toda la lista a un array para aprovechar los algoritmos eficientes de ordenación, lo cual introduce un consumo extra de tiempo y memoria.