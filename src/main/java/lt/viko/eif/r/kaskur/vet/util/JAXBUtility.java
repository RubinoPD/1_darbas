package lt.viko.eif.r.kaskur.vet.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Utility class for JAXB operations, including marshalling and unmarshalling Java objects to and from XML.
 */

public class JAXBUtility {

    /**
     * Marshals a Java object to an XML file.
     *
     * @param object the Java object to be marshalled
     * @param file   the file to which the XML content is written
     * @throws JAXBException if any problem occurs during marshalling
     */
    public static void transformToXML(Object object, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, file);
    }

    /**
     * Unmarshals an XML file to a Java object.
     *
     * @param clazz the class type to be unmarshalled
     * @param file  the XML file to be unmarshalled
     * @param <T>   the type of the Java object
     * @return the Java object resulting from unmarshalling the XML file
     * @throws JAXBException if any problem occurs during unmarshalling
     */
    public static <T> T transformToPOJO(Class<T> clazz, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(file));
    }

    /**
     * Marshals a Java object to the console (standard output).
     *
     * @param object the Java object to be marshalled
     * @throws JAXBException if any problem occurs during marshalling
     */
    public static void marshalToConsole(Object object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, System.out);
    }
}
