// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class f extends Enum
    implements b
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;
    private static final f i[];
    private String h;

    private f(String s, int j, String s1)
    {
        super(s, j);
        h = s1;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/smule/android/c/f, s);
    }

    public static f[] values()
    {
        return (f[])i.clone();
    }

    public String a()
    {
        return h;
    }

    static 
    {
        a = new f("SOLO", 0, "SOLO");
        b = new f("DUET", 1, "DUET");
        c = new f("GROUP", 2, "GROUP");
        d = new f("BACKUP", 3, "BACKUP");
        e = new f("MIX", 4, "MIX");
        f = new f("BATTLE", 5, "BATTLE");
        g = new f("UNDEFINED", 6, "UNDEFINED");
        i = (new f[] {
            a, b, c, d, e, f, g
        });
    }
}
