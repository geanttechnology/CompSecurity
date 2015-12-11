// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.SparseArray;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class cie extends aqm
{

    private SparseArray a;
    private String b;
    private String c;

    cie()
    {
    }

    protected final aqj a(int i, int j, List list, List list1)
    {
        return new cif(i, j, list, list1, b, c);
    }

    protected final aqj a(XmlPullParser xmlpullparser, String s, Uri uri, long l, long l1, 
            aqs aqs)
    {
        a = new SparseArray();
        b = xmlpullparser.getAttributeValue(null, "yt:langName");
        c = null;
        return super.a(xmlpullparser, s, uri, l, l1, aqs);
    }

    protected final aqk a(XmlPullParser xmlpullparser)
    {
        String s = xmlpullparser.getAttributeValue(null, "schemeIdUri");
        do
        {
            xmlpullparser.next();
            if (b(xmlpullparser, "yt:SystemURL"))
            {
                String s1 = xmlpullparser.getAttributeValue(null, "type");
                if (s1.equals("widevine"))
                {
                    xmlpullparser.next();
                    a.put(4, xmlpullparser.getText());
                } else
                if (s1.equals("playready"))
                {
                    xmlpullparser.next();
                    a.put(5, xmlpullparser.getText());
                }
            }
        } while (!a(xmlpullparser, "ContentProtection"));
        return new cig(s, a);
    }

    protected final void b(XmlPullParser xmlpullparser)
    {
        if (b(xmlpullparser, "Role"))
        {
            c = xmlpullparser.getAttributeValue(null, "value");
        }
    }
}
