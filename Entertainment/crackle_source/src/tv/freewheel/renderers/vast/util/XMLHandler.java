// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;

import android.util.Log;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package tv.freewheel.renderers.vast.util:
//            XMLElement

public class XMLHandler
{

    private static final String CLASSTAG = "XMLHandler";

    public XMLHandler()
    {
    }

    public static String createXMLDocument(XMLElement xmlelement)
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        Log.d("XMLHandler", "Create xml document");
        XmlSerializer xmlserializer = Xml.newSerializer();
        StringWriter stringwriter = new StringWriter();
        xmlserializer.setOutput(stringwriter);
        xmlserializer.startDocument("UTF-8", Boolean.valueOf(true));
        xmlelement.toXML(xmlserializer);
        xmlserializer.endDocument();
        return stringwriter.toString();
    }

    public static String getTextNodeValue(Node node)
    {
        node = node.getChildNodes();
        for (int i = 0; i < node.getLength(); i++)
        {
            String s = node.item(i).getNodeValue();
            if (!s.trim().equals(""))
            {
                return s.trim();
            }
        }

        return "";
    }

    public static final Element getXMLElementFromString(String s, String s1)
        throws Exception
    {
        Object obj;
        obj = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentbuilder;
        try
        {
            documentbuilder = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new Exception("new DocumentBuilder failed");
        }
        obj = new ByteArrayInputStream(s.getBytes("UTF-8"));
        s = ((String) (obj));
_L2:
        obj = documentbuilder.parse(s).getElementsByTagName(s1);
        if (((NodeList) (obj)).getLength() == 0)
        {
            throw new Exception((new StringBuilder()).append("no root node").append(s1).append(" found in document").toString());
        }
        break; /* Loop/switch isn't completed */
        s1;
        throw new Exception("parse xml failed");
        s1;
        if (s != null)
        {
            s.close();
        }
        throw s1;
        obj;
        s = new ByteArrayInputStream(s.getBytes());
        if (true) goto _L2; else goto _L1
_L1:
        s1 = (Element)((NodeList) (obj)).item(0);
        if (s != null)
        {
            s.close();
        }
        return s1;
        s1;
        throw new Exception("IO Error occurred");
    }
}
