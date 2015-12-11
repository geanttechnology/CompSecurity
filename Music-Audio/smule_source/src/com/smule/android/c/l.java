// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class l extends Enum
    implements b
{

    public static final l a;
    public static final l b;
    private static final l d[];
    private String c;

    private l(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/smule/android/c/l, s);
    }

    public static l[] values()
    {
        return (l[])d.clone();
    }

    public String a()
    {
        return c;
    }

    static 
    {
        a = new l("EMAIL", 0, "email");
        b = new l("PHONE", 1, "phone");
        d = (new l[] {
            a, b
        });
    }
}
