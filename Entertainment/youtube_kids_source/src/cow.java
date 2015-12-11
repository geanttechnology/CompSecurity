// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Set;
import org.xml.sax.Attributes;

final class cow extends bnt
{

    cow()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        String s = attributes.getValue("rel");
        if (cov.b().contains(s))
        {
            bmz1 = (cpw)bmz1.a(cpw);
            attributes = Uri.parse(attributes.getValue("href"));
            if ("next".equals(s))
            {
                bmz1.e = attributes;
            } else
            if ("previous".equals(s))
            {
                bmz1.d = attributes;
                return;
            }
        }
    }
}
