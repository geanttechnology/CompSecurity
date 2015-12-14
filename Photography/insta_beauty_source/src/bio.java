// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bio
{

    public String a;
    public int b;

    public bio()
    {
    }

    public static bio a(String s, int i)
    {
        bio bio1 = new bio();
        bio1.a = s;
        bio1.b = i;
        return bio1;
    }

    public bio a()
    {
        bio bio1 = new bio();
        bio1.a = a;
        bio1.b = b;
        return bio1;
    }

    public boolean b()
    {
        return b > 1;
    }
}
