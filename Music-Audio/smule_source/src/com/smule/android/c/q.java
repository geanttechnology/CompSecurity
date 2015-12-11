// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class q extends Enum
    implements b
{

    public static final q a;
    public static final q b;
    private static final q d[];
    private String c;

    private q(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/smule/android/c/q, s);
    }

    public static q[] values()
    {
        return (q[])d.clone();
    }

    public String a()
    {
        return c;
    }

    static 
    {
        a = new q("VIDEO", 0, "true");
        b = new q("NOT_VIDEO", 1, "false");
        d = (new q[] {
            a, b
        });
    }
}
