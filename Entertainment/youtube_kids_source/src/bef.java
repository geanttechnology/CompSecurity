// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bef extends bnt
{

    bef()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        attributes = s.split(",");
        int j = attributes.length;
        int i = 0;
        while (i < j) 
        {
            s = attributes[i];
            if ("rm=true".equals(s))
            {
                bmz1.U = true;
            } else
            if ("blockAllAds=true".equals(s))
            {
                bmz1.U = false;
            }
            i++;
        }
    }
}
