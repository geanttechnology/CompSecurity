// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashSet;
import java.util.Set;

public final class bvy
{

    public final byte a[];
    public final String b;
    public final Set c;

    public bvy(bmw bmw1)
    {
        this(bmw1, ((byte []) (null)));
    }

    public bvy(bmw bmw1, dre dre1)
    {
        if (dre1 != null)
        {
            dre1 = dre1.a;
        } else
        {
            dre1 = null;
        }
        this(bmw1, ((byte []) (dre1)));
    }

    public bvy(bmw bmw1, byte abyte0[])
    {
        b = ((bmw)b.a(bmw1)).a(16);
        c = new HashSet();
        a = abyte0;
    }

    public static boolean a(byte abyte0[])
    {
        return abyte0 != null && abyte0.length > 0;
    }
}
