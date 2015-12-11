// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public class pz
{

    protected Object a;
    private String b;

    public pz(String s)
    {
        b = s;
    }

    public pz(String s, Object obj)
    {
        b = s;
        a = obj;
    }

    public Object b()
    {
        return a;
    }

    public String c()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(c()).append(": ").append(b()).toString();
    }
}
