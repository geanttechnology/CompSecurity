// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class uy
{

    Element a;

    public uy()
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
            Crashlytics.logException(inputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
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
        Object obj = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Log.e("original xml string", s);
        try
        {
            obj = ((DocumentBuilder) (obj)).parse(new ByteArrayInputStream(s.getBytes()));
        }
        catch (SAXException saxexception)
        {
            saxexception.printStackTrace();
            Log.e("error xml string", s);
            Crashlytics.logException(saxexception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        a = ((Document) (obj)).getDocumentElement();
    }
}
