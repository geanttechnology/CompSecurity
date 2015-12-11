// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt

public static final class e extends Enum
    implements e
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static c d = new dt.b() {

    };
    private static final c f[];
    private final int e;

    public static e a(int j)
    {
        switch (j)
        {
        default:
            return null;

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;
        }
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/tapjoy/internal/gt$i, s);
    }

    public static c[] values()
    {
        return (c[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    static 
    {
        a = new <init>("APP", 0, 0);
        b = new <init>("CAMPAIGN", 1, 1);
        c = new <init>("CUSTOM", 2, 2);
        f = (new f[] {
            a, b, c
        });
    }

    private _cls1(String s, int j, int k)
    {
        super(s, j);
        e = k;
    }
}
