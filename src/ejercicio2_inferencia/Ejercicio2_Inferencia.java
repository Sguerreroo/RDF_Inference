package ejercicio2_inferencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Derivation;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class Ejercicio2_Inferencia {
/*
    public static void main(String[] args) {
        LogCtl.setCmdLogging();

        Model data = RDFDataMgr.loadModel("data.ttl");
        Model schema = RDFDataMgr.loadModel("schema.ttl");

        showData(data);
        
        Reasoner reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setDerivationLogging(true);
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, ReasonerVocabulary.RDFS_SIMPLE);
        reasoner = reasoner.bindSchema(schema);
        
        InfModel grafoInferido = ModelFactory.createInfModel(reasoner, data);
        
//        showResult(grafoInferido);
        
        showClasses(grafoInferido);
        
        validateGraph(grafoInferido);
        
//        showDerivations(grafoInferido);
        
//        showDerivationsFormatted(grafoInferido);
    }
*/
    private static void showData(Model data) {
        System.out.println("-----------------SHOW DATA-----------------");
        StmtIterator iterador = data.listStatements();
        while (iterador.hasNext()) {
            Statement declaration = iterador.next();
            System.out.println(declaration.toString());
        }
    }

    private static void showResult(Model schema) {
        System.out.println("-----------------SHOW RESULTS-----------------");
        StmtIterator iterador = schema.listStatements();
        while (iterador.hasNext()) {
            Statement declaracion = iterador.next();
            System.out.println(declaracion.toString());
        }    
    }

    private static void showClasses(InfModel grafoInferido) {
        System.out.println("-----------------SHOW CLASSES-----------------");
        StmtIterator iterador = grafoInferido.listStatements((Resource) null, RDF.type, (RDFNode) null);
        while (iterador.hasNext()) {
            Statement declaracion = iterador.next();
            System.out.println(declaracion.toString());
        }        
    }

    private static void validateGraph(InfModel grafoInferido) {
        System.out.println("-----------------VALIDATION-----------------");
        ValidityReport validation = grafoInferido.validate();
        if (validation.isValid()) {
            System.out.println("GRAFO CORRECTO");
        } else {
            System.out.println("GRAFO INCORRECTO");
            Iterator iterador = validation.getReports();
            while (iterador.hasNext()) {
                Object informe = iterador.next();
                System.out.println("Inconsistencia: " + informe.toString());
            }
        }
    }

    private static void showDerivations(InfModel grafoInferido) {
        System.out.println("-----------------SHOW DERIVATIONS-----------------");
        StmtIterator iterador = grafoInferido.listStatements((Resource) null, RDF.type, (RDFNode) null);
        while (iterador.hasNext()) {
                Statement declaracion = iterador.next();
                System.out.println(declaracion.toString());
            Iterator<Derivation> iteradorDerivacion = grafoInferido.getDerivation(declaracion);
            if (iteradorDerivacion.hasNext()) {
                while (iteradorDerivacion.hasNext()) {
                    Derivation derivacion = iteradorDerivacion.next();
                    System.out.println("Derivación: " + derivacion.toString());
                }
            } else {
                System.out.println("No inferida");
            }
            System.out.println("");
        }
    }

    private static void showDerivationsFormatted(InfModel grafoInferido) {
        System.out.println("-----------------SHOW DERIVATIONS FORMATTED-----------------");
        PrintWriter salida;
        try {
            salida = new PrintWriter(new File("ejemplo.txt"));
            StmtIterator iterador = grafoInferido.listStatements((Resource) null, RDF.type, (RDFNode) null);
            while (iterador.hasNext()) {
                Statement declaracion = iterador.next();
                System.out.println(declaracion.toString());
                Iterator<Derivation> iteradorDerivacion = grafoInferido.getDerivation(declaracion);
                if (iteradorDerivacion.hasNext()) {
                    while (iteradorDerivacion.hasNext()) {
                        Derivation derivacion = iteradorDerivacion.next();
                        derivacion.printTrace(salida, true);
                    }                    
                } else {
                    System.out.println("No inferido");
                }
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2_Inferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
