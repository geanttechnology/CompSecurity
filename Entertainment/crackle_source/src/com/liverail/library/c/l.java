// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.liverail.library.b.a;
import com.liverail.library.g.g;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class l extends DefaultHandler
{

    private static l a = new l();
    private static final String b = "VideoAdServingTemplate";
    private static final String c = "VASTAdTagURL";
    private static final String d = "URL";
    private static final String e = "VAST";
    private static final String f = "version";
    private static final String g = "VASTAdTagURI";
    private g h;
    private boolean i;
    private boolean j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;

    public l()
    {
    }

    public static l a()
    {
        return a;
    }

    public g a(String s)
    {
        Object obj = null;
        h = new g();
        i = false;
        j = false;
        k = null;
        n = false;
        m = false;
        l = false;
        try
        {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(s)), this);
            i = true;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.e((new StringBuilder("VAST Parse ParserConfigurationException ")).append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.e((new StringBuilder("VAST Parse SAXException ")).append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.e((new StringBuilder("VAST Parse IOException ")).append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.e((new StringBuilder("VAST Parse Exception ")).append(s.getMessage()).toString());
        }
        s = obj;
        if (i)
        {
            s = h;
        }
        return s;
    }

    public void characters(char ac[], int i1, int j1)
    {
label0:
        {
            if (j)
            {
                if (k != null)
                {
                    break label0;
                }
                k = new String(ac, i1, j1);
            }
            return;
        }
        k = k.concat(new String(ac, i1, j1));
    }

    public void endElement(String s, String s1, String s2)
    {
        if (!s2.equalsIgnoreCase("VAST") && !s2.equalsIgnoreCase("VideoAdServingTemplate")) goto _L2; else goto _L1
_L1:
        l = false;
        if (!n)
        {
            h.d = true;
        }
_L4:
        j = false;
        k = null;
        return;
_L2:
        if (l && (m && s2.equalsIgnoreCase("URL") || s2.equalsIgnoreCase("VASTAdTagURI")) && k != null && k.length() > 1)
        {
            h.c = k;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void error(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.e((new StringBuilder("error: ")).append(saxparseexception).toString());
    }

    public void fatalError(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.e((new StringBuilder("fatalError: ")).append(saxparseexception).toString());
    }

    public void startDocument()
    {
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
    {
        if (!s2.equalsIgnoreCase("VideoAdServingTemplate")) goto _L2; else goto _L1
_L1:
        l = true;
        h.a = true;
        h.b = "1";
_L4:
        return;
_L2:
        if (!s2.equalsIgnoreCase("VAST"))
        {
            break; /* Loop/switch isn't completed */
        }
        l = true;
        h.a = true;
        int i1 = attributes.getLength() - 1;
        while (i1 >= 0) 
        {
            s = attributes.getLocalName(i1);
            s1 = attributes.getValue(i1);
            if (s.equalsIgnoreCase("version"))
            {
                h.b = s1;
            }
            i1--;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (l && h.a)
        {
            if (!n)
            {
                n = true;
            }
            if (s2.equalsIgnoreCase("VASTAdTagURL"))
            {
                m = true;
                return;
            }
            if (m && s2.equalsIgnoreCase("URL") || s2.equalsIgnoreCase("VASTAdTagURI"))
            {
                j = true;
                k = null;
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void warning(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.d((new StringBuilder("warning: ")).append(saxparseexception).toString());
    }

}
