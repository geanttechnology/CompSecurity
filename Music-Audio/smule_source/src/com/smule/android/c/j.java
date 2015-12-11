// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class j extends Enum
    implements b
{

    public static final j a;
    public static final j b;
    private static final j d[];
    private String c;

    private j(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/smule/android/c/j, s);
    }

    public static j[] values()
    {
        return (j[])d.clone();
    }

    public String a()
    {
        return c;
    }

    static 
    {
        a = new j("NEW", 0, "new");
        b = new j("EXISTING", 1, "existing");
        d = (new j[] {
            a, b
        });
    }
}
