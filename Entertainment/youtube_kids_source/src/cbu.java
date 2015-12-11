// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class cbu extends bnt
{

    cbu()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (ceb)bmz1.peek();
        if (s.length() == 1)
        {
            if (s.charAt(0) == 'm')
            {
                bmz1.i = cec.a;
            } else
            if (s.charAt(0) == 'f')
            {
                bmz1.i = cec.b;
                return;
            }
        }
    }
}
