// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.IOException;

public class ah extends IOException
{

    private int a;
    private String b;

    public ah(int i, String s)
    {
        a = 0;
        b = "";
        a = i;
        b = s;
    }

    public int a()
    {
        return a;
    }

    public boolean b()
    {
        return a == 401;
    }

    public String getMessage()
    {
        return b;
    }
}
