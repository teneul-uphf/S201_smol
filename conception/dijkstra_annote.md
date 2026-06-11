# L'algorithme de Dijkstra en Java

## Pseudocode complet

D'après [Wikipédia](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Pseudocode) :

| Variable   | Type    | Contient                                                                | Exemple                                                             |
|:-----------|:--------|:------------------------------------------------------------------------|:--------------------------------------------------------------------|
| `dist`     | Tableau | current distances from the source to other vertices                     | `dist[u]` is the current distance from the source to the vertex `u` |
| `prev`     | Tableau | previous-hop nodes on the shortest path from source to the given vertex |                                                                     |

```
 1  function Dijkstra(Graph, source):
 2     
 3      for each vertex v in Graph.Vertices:
 4          dist[v] ← INFINITY // array that contains the current distances from the source to other vertices
 5          prev[v] ← UNDEFINED
 6          add v to Q // Q est la liste des noeuds à exporer
 7      dist[source] ← 0 // la distance de la source à la source est 0, faut le préciser...
 8     
 9      while Q is not empty: // Tant qu'il reste des noeuds à explorer
10          u ← vertex in Q with minimum dist[u] // appelons u le noeud avec la plus petite distance connue à la source.
11          Q.remove(u) // On enlève u des noeuds à explorer
12         
13          for each edge (u, v) in Graph: // Pour chaque arête que forme u à ses voisins v :
14              alt ← dist[u] + 1   // appelons alt la distance minimale qui sépare v de la source en passant par u.
15              if alt < dist[v]:   // si cette distance est plus courte :
16                  dist[v] ← alt       // la distance de la source au noeud v est maintenant celle-ci
17                  prev[v] ← u         // le noeud précédent v est maintenant u, donc.
18
19      return dist[], prev[] // Retourne la distance minimale de la source vers chaque noeud, et la liste des noeuds précédant chaque noeud.
```

### Implémentation en Java

| Élément du pseudocode | Rôle                                                                       | Type Java / Classe                                                         |
|-----------------------|----------------------------------------------------------------------------|----------------------------------------------------------------------------|
| `Graph`               | Représente le graphe                                                       |                                                                            |
| `v:vertex`            | Représenter un noeud du graphe                                             | `Noeud`; un `Record` implémentant Comparable (pour les comparer entre eux) |
| `dist[v]`             | Lier un noeud `v` à la distance minimale, actuellement connue, à la source | `HashMap<Noeud, int>`                                                      |
| `prev[v]`             | Lier un noeud `v` à celui qui le précède                                   | `HashMap<Noeud, Noeud>`                                                    |
| `Q:vertexSet`         | Queue listant des noeuds à explorer                                        | `PriorityQueue`                                                            |

Dans mon cas, il n'y a pas de pondération des arêtes. Je vais simplifier l'algorithme.

## Dijkstra sans pondération

Fonction dijkstra(Jeu jeu) -> pile:

- distances : dictionnaire<Noeud noeud, int distanceDeLaSource> vide
- precedents : dictionnaire<Noeud noeud, Noeud noeud precendent> vide
- aExplorer : queue des nœuds à explorer vide

- Noeud source = nouveau Noeud(noLigneRobot, noColonneRobot)
- mettre (source, 0) dans distances 
- mettre source dans aExplorer 

- Noeud arrivee = null (pas trouvée)
- pour chaque noeud d'aExplorer :
  - si l'arrivée n'est pas trouvée :
    - récuperer ses voisins et les mettre dans la queue noeudsVoisins
    - pour chaque noeudVoisin de noeudsVoisins :
      - s'il est de distance inconnue et que l'arrivée n'est pas trouvée :
        - ajouter (noeudVoisin, distances[noeud]+1) à distances
        - ajouter noeudVoisin à aExplorer
        - s'il est des mêmes coordonnées que l'objectif :
          - arrivee = noeudVoisin
    - supprimer le noeud d'aExplorer

- chemin : pile
- noeud n = arrivee
- piler arrivee à chemin

- Tant que precedent[n] n'est pas null:
  - piler precedent[n] à chemin
  - n est maintenant precedent[n]

- renvoyer chemin




























---
Prompt Claude
---

J'ai pu me débrouiller finalement, merci. J'ai finalisé une version minimale, permettant de "brancher" au modèle une classe "JoueurHumain" implémentant une interface "Joueur" que le modèle peut appeller pour le choix de l'action et le choix du déplacement du joueur, si l'action choisie est "se déplacer".


Je peux maintenant faire ce qui m'intéresse vraiment : m'exercer pour la SAÉ S2.02, dont je te joins le sujet. Plus précisément, m'exercer sur l'implémentation de l'algorithme de Dijkstra pour automatiser les déplacements d'un robot, à l'aide d'une classe JoueurIA.


Pour simplifier, il n'y aura qu'un seul robot, qu'une mine et un entrepôt. Comme je veux m'entraîner uniquement sur Dijkstra, je définirai la case cible de l'IA en dur.


---


Le professeur nous a donné des pistes pour Dijkstra.



