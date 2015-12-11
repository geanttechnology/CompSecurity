// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Log;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public final class XmlFormatter
{

    private static final Transformer transformer;

    public XmlFormatter()
    {
    }

    public static String format(String s)
    {
        if (transformer == null)
        {
            return s;
        }
        Object obj;
        try
        {
            obj = new StreamSource(new StringReader(s));
            StreamResult streamresult = new StreamResult(new StringWriter());
            transformer.transform(((javax.xml.transform.Source) (obj)), streamresult);
            obj = streamresult.getWriter().toString();
        }
        catch (Exception exception)
        {
            return s;
        }
        return ((String) (obj));
    }

    public static String format(byte abyte0[])
    {
        return format(new String(abyte0));
    }

    static 
    {
        Transformer transformer1;
        try
        {
            transformer1 = TransformerFactory.newInstance().newTransformer();
            transformer1.setOutputProperty("indent", "yes");
            transformer1.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer1.setOutputProperty("omit-xml-declaration", "yes");
        }
        catch (Exception exception)
        {
            exception = null;
            Log.w(com/ebay/nautilus/kernel/util/XmlFormatter.getSimpleName(), "Failed to initialize. All format requests will fail silently.");
        }
        transformer = transformer1;
    }
}
