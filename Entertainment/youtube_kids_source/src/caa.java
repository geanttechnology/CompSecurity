// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

public final class caa extends bnt
{

    public caa()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        if ("self".equals(attributes.getValue("rel")))
        {
            ((cds)bmz1.a(cds)).d = Uri.parse(attributes.getValue("href"));
        }
    }
}
