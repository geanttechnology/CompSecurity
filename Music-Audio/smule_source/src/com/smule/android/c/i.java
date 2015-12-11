// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class i extends Enum
    implements b
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    private static final i f[];
    private String e;

    private i(String s, int j, String s1)
    {
        super(s, j);
        e = s1;
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/smule/android/c/i, s);
    }

    public static i[] values()
    {
        return (i[])f.clone();
    }

    public String a()
    {
        return e;
    }

    static 
    {
        a = new i("NORMAL", 0, "n");
        b = new i("ACTIVE", 1, "a");
        c = new i("CLOSED", 2, "c");
        d = new i("EXPIRED", 3, "e");
        f = (new i[] {
            a, b, c, d
        });
    }
}
