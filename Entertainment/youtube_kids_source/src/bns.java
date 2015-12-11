// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public final class bns
{

    private static final Attributes a = new bnu();
    private static final Map c;
    private final SAXParserFactory b;

    private bns(Map map)
    {
        b.a(map);
        try
        {
            b = SAXParserFactory.newInstance();
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); b.setFeature((String)entry.getKey(), ((Boolean)entry.getValue()).booleanValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException("SAX initilization error", map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException("SAX initilization error", map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException("SAX initilization error", map);
        }
    }

    public static bns a()
    {
        return new bns(c);
    }

    static Attributes b()
    {
        return a;
    }

    public final Object a(InputStream inputstream, bnq bnq)
    {
        b.a(inputstream);
        b.a(bnq);
        XMLReader xmlreader;
        synchronized (b)
        {
            xmlreader = b.newSAXParser().getXMLReader();
        }
        try
        {
            bnq = new bnv(bnq);
            xmlreader.setContentHandler(bnq);
            xmlreader.parse(new InputSource(inputstream));
            if (((bnv) (bnq)).a == null)
            {
                throw new bno("XML is well-formed but invalid");
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new bnp(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new bnp(inputstream);
        }
        break MISSING_BLOCK_LABEL_105;
        inputstream;
        saxparserfactory;
        JVM INSTR monitorexit ;
        throw inputstream;
        inputstream = ((InputStream) (((bnv) (bnq)).a));
        return inputstream;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("http://xml.org/sax/features/namespaces", Boolean.valueOf(false));
        hashmap.put("http://xml.org/sax/features/namespace-prefixes", Boolean.valueOf(true));
        c = Collections.unmodifiableMap(hashmap);
    }
}
