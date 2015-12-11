// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ct
{

    private static final cu a;

    public static String a(String s)
    {
        return a.a(s);
    }

    public static String b(String s)
    {
        return a.b(s);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new cw();
        } else
        {
            a = new cv();
        }
    }
}
