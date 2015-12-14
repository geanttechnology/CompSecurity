// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class aw
{

    public static final boolean a;

    public aw()
    {
    }

    public static String a()
    {
        return "1.0.0.0";
    }

    public static String b()
    {
        return "1.6.0.0B06";
    }

    static 
    {
        boolean flag;
        if (!aw.getName().endsWith("Config"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
