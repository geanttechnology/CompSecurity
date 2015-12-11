// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.Serializable;

public class cm
    implements Serializable
{

    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public cm(byte byte0)
    {
        this(byte0, false);
    }

    public cm(byte byte0, String s)
    {
        b = byte0;
        a = true;
        c = s;
        d = false;
    }

    public cm(byte byte0, boolean flag)
    {
        b = byte0;
        a = false;
        c = null;
        d = flag;
    }

    public boolean a()
    {
        return a;
    }

    public String b()
    {
        return c;
    }

    public boolean c()
    {
        return b == 12;
    }

    public boolean d()
    {
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e()
    {
        return d;
    }
}
