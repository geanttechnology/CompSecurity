// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class bib
{

    Element a;

    public bib()
    {
    }

    public Element a()
    {
        return a;
    }

    public void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        DocumentBuilder documentbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        try
        {
            inputstream = documentbuilder.parse(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return;
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        a = inputstream.getDocumentElement();
    }

    public void a(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        DocumentBuilder documentbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Log.v("data", s);
        try
        {
            s = documentbuilder.parse(new ByteArrayInputStream(s.getBytes()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        a = s.getDocumentElement();
    }
}
