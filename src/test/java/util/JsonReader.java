package util;

import com.fasterxml.jackson.databind.JsonNode;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import java.io.File;
        import java.io.IOException;

public class JsonReader {

    public static void main(String[] args) throws IOException {

        // Création d'un objet ObjectMapper pour lire le fichier JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Lecture du fichier JSON dans un objet JsonNode
        JsonNode rootNode = objectMapper.readTree(new File("TestData/example.json"));

        // Extraction des valeurs du nœud racine
        String nom = rootNode.get("nom").asText();
        int age = rootNode.get("age").asInt();

        // Extraction des valeurs du nœud "adresse"
        JsonNode adresseNode = rootNode.get("adresse");
        String rue = adresseNode.get("rue").asText();
        String ville = adresseNode.get("ville").asText();

        // Extraction des valeurs du nœud "langages"
        JsonNode langagesNode = rootNode.get("langages");
        String[] langages = objectMapper.convertValue(langagesNode, String[].class);

        // Affichage des valeurs extraites
        System.out.println("Nom : " + nom);
        System.out.println("Age : " + age);
        System.out.println("Rue : " + rue);
        System.out.println("Ville : " + ville);
        System.out.println("Langages : ");
        for (String langage : langages) {
            System.out.println("- " + langage);
        }
    }
}
