// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.List;
import org.xml.sax.Attributes;

final class bds extends bnt
{

    bds()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (buv)bmz1.a(buv);
        attributes = Uri.parse(s.trim());
        ((buv) (bmz1)).c.add(attributes.toString());
    }
}
