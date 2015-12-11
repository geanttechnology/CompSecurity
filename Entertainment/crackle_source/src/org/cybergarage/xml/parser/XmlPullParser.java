// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml.parser;

import java.io.InputStream;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParser extends Parser
{

    public XmlPullParser()
    {
    }

    public Node parse(InputStream inputstream)
        throws ParserException
    {
        try
        {
            XmlPullParserFactory xmlpullparserfactory = XmlPullParserFactory.newInstance();
            xmlpullparserfactory.setNamespaceAware(true);
            inputstream = parse(xmlpullparserfactory.newPullParser(), inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException(inputstream);
        }
        return inputstream;
    }

    public Node parse(org.xmlpull.v1.XmlPullParser xmlpullparser, InputStream inputstream)
        throws ParserException
    {
        Object obj;
        InputStream inputstream1;
        Object obj2;
        Object obj3;
        int i;
        obj = null;
        inputstream1 = null;
        StringBuffer stringbuffer;
        int j;
        try
        {
            xmlpullparser.setInput(inputstream, null);
            i = xmlpullparser.getEventType();
        }
        // Misplaced declaration of an exception variable
        catch (org.xmlpull.v1.XmlPullParser xmlpullparser)
        {
            throw new ParserException(xmlpullparser);
        }
          goto _L1
_L9:
        i = xmlpullparser.next();
        inputstream1 = inputstream;
        obj = obj3;
          goto _L1
_L5:
        obj2 = new Node();
        inputstream = xmlpullparser.getPrefix();
        obj3 = xmlpullparser.getName();
        stringbuffer = new StringBuffer();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (inputstream.length() > 0)
        {
            stringbuffer.append(inputstream);
            stringbuffer.append(":");
        }
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (((String) (obj3)).length() > 0)
        {
            stringbuffer.append(((String) (obj3)));
        }
        ((Node) (obj2)).setName(stringbuffer.toString());
        j = xmlpullparser.getAttributeCount();
        i = 0;
_L3:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (inputstream1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream1.addNode(((Node) (obj2)));
        break; /* Loop/switch isn't completed */
        ((Node) (obj2)).setAttribute(xmlpullparser.getAttributeName(i), xmlpullparser.getAttributeValue(i));
        i++;
        if (true) goto _L3; else goto _L2
_L7:
        obj2 = xmlpullparser.getText();
        inputstream = inputstream1;
        obj3 = obj;
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream = inputstream1;
        obj3 = obj;
        if (inputstream1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream1.setValue(((String) (obj2)));
        inputstream = inputstream1;
        obj3 = obj;
        continue; /* Loop/switch isn't completed */
_L6:
        inputstream = inputstream1.getParentNode();
        obj3 = obj;
        continue; /* Loop/switch isn't completed */
_L1:
        if (i == 1)
        {
            return ((Node) (obj));
        }
        i;
        JVM INSTR tableswitch 2 4: default 300
    //                   2 41
    //                   3 250
    //                   4 194;
           goto _L4 _L5 _L6 _L7
_L4:
        inputstream = inputstream1;
        obj3 = obj;
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj1 = obj2;
        inputstream = ((InputStream) (obj1));
        obj3 = obj;
        if (obj == null)
        {
            inputstream = ((InputStream) (obj1));
            obj3 = obj2;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }
}
