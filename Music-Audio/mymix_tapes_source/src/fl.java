// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public abstract class fl
{

    private byte a[];
    private fa b;
    private String c;

    public fl(byte abyte0[])
    {
        c = "";
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Buffer cannot be null");
        } else
        {
            a = abyte0;
            return;
        }
    }

    private static boolean a(byte abyte0[])
    {
        try
        {
            abyte0 = new InputStreamReader(new ByteArrayInputStream(abyte0), "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
            }
            return false;
        }
        finally { }
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        return true;
        try
        {
            throw new NullPointerException();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        throw abyte0;
    }

    public final void a()
        throws IOException
    {
        try
        {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            InputSource inputsource = new InputSource(new ByteArrayInputStream(a));
            if (!a(a))
            {
                inputsource.setEncoding("cp1252");
            }
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            fk fk1 = e();
            xmlreader.setContentHandler(fk1);
            xmlreader.parse(inputsource);
            b = fk1.a();
            return;
        }
        catch (SAXException saxexception)
        {
            c = saxexception.getMessage();
        }
    }

    public final boolean b()
    {
        return b != null;
    }

    public final fa c()
    {
        return b;
    }

    public final String d()
    {
        return c;
    }

    protected abstract fk e();
}
