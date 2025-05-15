import java.util.*;

public class Main {

    public static void main(String[] args) {
        // exemplo de grafo válido
        List<List<Integer>> grafo = new ArrayList<>();
        grafo.add(Arrays.asList(1, 2)); // vizinhos do nó 0
        grafo.add(Arrays.asList(0, 3)); // vizinhos do nó 1
        grafo.add(Arrays.asList(0, 3)); // vizinhos do nó 2
        grafo.add(Arrays.asList(1, 2)); // vizinhos do nó 3

        boolean valido = grafoValido(grafo);
        System.out.println("grafo válido: " + valido);   // deve imprimir true

        // exemplo de grafo inválido
        List<List<Integer>> grafo2 = new ArrayList<>();
        grafo2.add(Arrays.asList(1, 2));     // nó 0
        grafo2.add(Arrays.asList(0, 2, 2));  // nó 1 - aresta paralela (2 repetido)
        grafo2.add(Arrays.asList(0, 1));     // nó 2

        boolean valido2 = grafoValido(grafo2);
        System.out.println("grafo válido: " + valido2);  // deve imprimir false
    }

    // verifica se o grafo é não direcionado e válido
    public static boolean grafoValido(List<List<Integer>> grafo) {
        int v = grafo.size();

        // percorre todos os nós do grafo
        for (int no = 0; no < v; no++) {
            List<Integer> vizinhos = grafo.get(no);
            Set<Integer> visitados = new HashSet<>();

            for (int vizinho : vizinhos) {
                // verifica se o nó é válido
                if (vizinho < 0 || vizinho >= v) return false;

                // verifica se há auto-laço
                if (vizinho == no) return false;

                // verifica se já visitou esse vizinho (arestas paralelas)
                if (visitados.contains(vizinho)) return false;
                visitados.add(vizinho);

                // verifica se a relação é bidirecional
                if (!grafo.get(vizinho).contains(no)) return false;
            }
        }

        return true;
    }
}
