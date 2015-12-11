// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            XMLEntity, XMLAttribute

public class XMLElement extends XMLEntity
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/XMLElement.getName();
    private static final DocumentBuilderFactory XML_DOCUMENT_FACTORY = DocumentBuilderFactory.newInstance();
    private List mEntityChildren;
    private final String mInnerText;
    private final String mName;

    public transient XMLElement(String s, String s1, XMLAttribute axmlattribute[])
    {
        this(s, s1, (XMLEntity[])axmlattribute);
    }

    private transient XMLElement(String s, String s1, XMLEntity axmlentity[])
    {
        mName = s;
        mInnerText = s1;
        mEntityChildren = new LinkedList();
        mEntityChildren.addAll(Arrays.asList(axmlentity));
    }

    public transient XMLElement(String s, XMLEntity axmlentity[])
    {
        this(s, null, axmlentity);
    }

    public static String convertElementToString(Node node)
    {
        TransformerFactory transformerfactory = TransformerFactory.newInstance();
        Transformer transformer = transformerfactory.newTransformer();
        Object obj;
        if (node instanceof Document)
        {
            obj = "no";
        } else
        {
            obj = "yes";
        }
        try
        {
            transformer.setOutputProperty("omit-xml-declaration", ((String) (obj)));
            obj = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(((java.io.Writer) (obj))));
            return ((StringWriter) (obj)).getBuffer().toString();
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            MAPLog.e(TAG, (new StringBuilder("convertDocumentToString: Unable to convert XML Document to text since the transformer could not be constructed. Error: ")).append(node.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            MAPLog.e(TAG, (new StringBuilder("convertDocumentToString: Unable to convert XML Document to text. Error: ")).append(node.getMessage()).toString());
        }
        return null;
    }

    private Element createElement(Document document)
    {
        document = document.createElement(mName);
        if (mInnerText != null)
        {
            document.setTextContent(mInnerText);
        }
        for (Iterator iterator = mEntityChildren.iterator(); iterator.hasNext(); ((XMLEntity)iterator.next()).toXML(document)) { }
        return document;
    }

    public XMLElement addAttribute(String s, String s1)
    {
        addNewChild(new XMLAttribute(s, s1));
        return this;
    }

    public boolean addNewChild(XMLEntity xmlentity)
    {
        return mEntityChildren.add(xmlentity);
    }

    public XMLElement addNewChildElement(String s, String s1)
    {
        addNewChild(new XMLElement(s, s1, new XMLAttribute[0]));
        return this;
    }

    public String convertToString()
    {
        Object obj;
        try
        {
            obj = XML_DOCUMENT_FACTORY.newDocumentBuilder().newDocument();
            ((Document) (obj)).appendChild(createElement(((Document) (obj))));
            obj = convertElementToString(((Node) (obj)));
        }
        catch (ParserConfigurationException parserconfigurationexception)
        {
            MAPLog.e(TAG, (new StringBuilder("convertToString: Unable to construct an XML Document since the document factory could not be constructed. Error: ")).append(parserconfigurationexception.getMessage()).toString());
            return null;
        }
        return ((String) (obj));
    }

    void toXML(Element element)
    {
        element.appendChild(createElement(element.getOwnerDocument()));
    }

}
