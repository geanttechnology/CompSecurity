// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.SparseIntArray;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;

final class cda extends bnt
{

    cda()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (cef)bmz1.a(cef);
        cdy cdy1 = new cdy();
        cdy1.d = attributes.getValue("type");
        cdy1.b = Uri.parse(attributes.getValue("url"));
        int i = a.b(attributes.getValue("yt:format"), -1);
        cdy1.a = cdw.a().get(i);
        attributes = cdy1.a();
        b.a(attributes);
        if (((cef) (bmz1)).b == null)
        {
            bmz1.b = new HashSet();
        }
        ((cef) (bmz1)).b.add(attributes);
    }
}
