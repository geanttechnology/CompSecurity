// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            XMLParserInterface

class XMLParser
    implements XMLParserInterface
{

    XMLParser()
    {
    }

    public void errorHandler(int i)
    {
    }

    public Document getDomElement(String s)
        throws ParserConfigurationException, SAXException, IOException
    {
        Object obj = DocumentBuilderFactory.newInstance();
        ((DocumentBuilderFactory) (obj)).setCoalescing(true);
        obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
        InputSource inputsource = new InputSource();
        inputsource.setCharacterStream(new StringReader(s));
        return ((DocumentBuilder) (obj)).parse(inputsource);
    }

    public final boolean getElementsBoolValue(Node node)
    {
        boolean flag1 = true;
        if (node == null || !node.hasChildNodes()) goto _L2; else goto _L1
_L1:
        node = node.getFirstChild();
_L7:
        if (node != null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L5:
        return flag;
_L3:
        if (node.getNodeType() != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (node.getNodeName().equals("successStatus")) goto _L5; else goto _L4
_L4:
        node = node.getNextSibling();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final String getElementsStringValue(Node node)
    {
        if (node == null || !node.hasChildNodes()) goto _L2; else goto _L1
_L1:
        node = node.getFirstChild();
_L5:
        if (node != null) goto _L3; else goto _L2
_L2:
        return "";
_L3:
        if (node.getNodeType() == 4)
        {
            return node.getNodeValue();
        }
        if (node.getNodeType() == 3)
        {
            return node.getTextContent();
        }
        node = node.getNextSibling();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String getValue(Element element, String s)
    {
        return getElementsStringValue(element.getElementsByTagName(s).item(0));
    }

    public void parse(HttpEntity httpentity)
    {
        try
        {
            httpentity = getDomElement(EntityUtils.toString(httpentity));
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            Utils.sdkLog("XMLParser.Parse(); Error: ", 5, httpentity);
            errorHandler(5);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            Utils.sdkLog("XMLParser.Parse(); Error: ", 5, httpentity);
            errorHandler(5);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            Utils.sdkLog("XMLParser.Parse(); Error: ", 5, httpentity);
            errorHandler(5);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            Utils.sdkLog("XMLParser.Parse(); Error: ", 5, httpentity);
            errorHandler(5);
            return;
        }
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        httpentity = (Element)httpentity.getElementsByTagName("user-verified-media-item").item(0);
        getElementsStringValue(httpentity.getElementsByTagName("url").item(0));
        getElementsBoolValue(httpentity.getElementsByTagName("blackout-status").item(0));
        if (!getElementsBoolValue(httpentity.getElementsByTagName("auth-status").item(0)))
        {
            getElementsStringValue(httpentity.getElementsByTagName("errorMessage").item(0));
        }
    }
}
