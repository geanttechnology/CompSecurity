// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cnh extends Enum
{

    public static final cnh a;
    public static final cnh b;
    private static cnh d;
    private static cnh e;
    private static cnh f;
    private static cnh g;
    private static cnh h;
    private static cnh i;
    private static final cnh j[];
    public final String c;

    private cnh(String s, int k, String s1)
    {
        super(s, k);
        c = s1;
    }

    public static cnh valueOf(String s)
    {
        return (cnh)Enum.valueOf(cnh, s);
    }

    public static cnh[] values()
    {
        return (cnh[])j.clone();
    }

    static 
    {
        a = new cnh("ANDROID", 0, "android");
        d = new cnh("ANDROID_TV", 1, "android_tv");
        e = new cnh("TVANDROID", 2, "tvandroid");
        f = new cnh("ANDROID_INSTANT", 3, "android_instant");
        b = new cnh("ANDROID_KIDS", 4, "android_kids");
        g = new cnh("ANDROID_TESTSUITE", 5, "android_testsuite");
        h = new cnh("OTHERAPP", 6, "otherapp");
        i = new cnh("UNKNOWN", 7, "unknown_interface");
        j = (new cnh[] {
            a, d, e, f, b, g, h, i
        });
    }
}
