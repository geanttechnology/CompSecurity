// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class hb
{

    private static final String a = hb.getSimpleName();

    public hb()
    {
    }

    public static String a(Document document)
    {
        try
        {
            StringWriter stringwriter = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "no");
            transformer.setOutputProperty("method", "xml");
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.transform(new DOMSource(document), new StreamResult(stringwriter));
            document = stringwriter.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Document document)
        {
            throw new RuntimeException("Error converting to String", document);
        }
        return document;
    }

    public static void a(Node node)
    {
        gs.d(a, (new StringBuilder()).append(" nodeName=\"").append(node.getNodeName()).append("\"").toString());
        String s = node.getNamespaceURI();
        if (s != null)
        {
            gs.d(a, (new StringBuilder()).append(" uri=\"").append(s).append("\"").toString());
        }
        s = node.getPrefix();
        if (s != null)
        {
            gs.d(a, (new StringBuilder()).append(" pre=\"").append(s).append("\"").toString());
        }
        s = node.getLocalName();
        if (s != null)
        {
            gs.d(a, (new StringBuilder()).append(" local=\"").append(s).append("\"").toString());
        }
        s = node.getNodeValue();
        if (s != null)
        {
            gs.d(a, " nodeValue=");
            if (s.trim().equals(""))
            {
                gs.d(a, "[WS]");
            } else
            {
                gs.d(a, (new StringBuilder()).append("\"").append(node.getNodeValue()).append("\"").toString());
            }
        }
        gs.d(a, "");
    }

    public static void b(Node node)
    {
        int i;
        boolean flag;
        short word0;
        flag = false;
        i = 0;
        word0 = node.getNodeType();
        word0;
        JVM INSTR tableswitch 1 12: default 76
    //                   1 258
    //                   2 131
    //                   3 366
    //                   4 146
    //                   5 321
    //                   6 306
    //                   7 351
    //                   8 161
    //                   9 191
    //                   10 206
    //                   11 176
    //                   12 336;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        gs.d(a, (new StringBuilder()).append("UNSUPPORTED NODE: ").append(word0).toString());
        a(node);
_L15:
        for (node = node.getFirstChild(); node != null; node = node.getNextSibling())
        {
            b(node);
        }

        break; /* Loop/switch isn't completed */
_L3:
        gs.d(a, "ATTR:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L5:
        gs.d(a, "CDATA:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L9:
        gs.d(a, "COMM:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L12:
        gs.d(a, "DOC_FRAG:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L10:
        gs.d(a, "DOC:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L11:
        gs.d(a, "DOC_TYPE:");
        a(node);
        NamedNodeMap namednodemap = ((DocumentType)node).getEntities();
        while (i < namednodemap.getLength()) 
        {
            b(((Node) ((Entity)namednodemap.item(i))));
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        gs.d(a, "ELEM:");
        a(node);
        NamedNodeMap namednodemap1 = node.getAttributes();
        int j = ((flag) ? 1 : 0);
        while (j < namednodemap1.getLength()) 
        {
            b(namednodemap1.item(j));
            j++;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        gs.d(a, "ENT:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L6:
        gs.d(a, "ENT_REF:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L13:
        gs.d(a, "NOTATION:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L8:
        gs.d(a, "PROC_INST:");
        a(node);
        continue; /* Loop/switch isn't completed */
_L4:
        gs.d(a, "TEXT:");
        a(node);
        if (true) goto _L15; else goto _L14
_L14:
    }

}
