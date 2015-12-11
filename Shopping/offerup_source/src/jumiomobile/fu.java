// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;

public abstract class fu
    implements Serializable
{

    protected String a;
    protected String b;
    protected String c;

    public fu(String s, String s1, String s2)
    {
        a = "";
        b = "";
        c = "";
        a = s;
        b = s1;
        c = s2;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }
}
