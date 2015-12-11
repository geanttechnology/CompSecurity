// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


// Referenced classes of package com.moodmedia.moodpresence:
//            g

static final class c extends Enum
{

    public static final b a;
    public static final b b;
    private static final b d[];
    private int c;

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/moodmedia/moodpresence/g$a, s);
    }

    public static c[] values()
    {
        c ac[] = d;
        int i = ac.length;
        c ac1[] = new d[i];
        System.arraycopy(ac, 0, ac1, 0, i);
        return ac1;
    }

    final int a()
    {
        return c;
    }

    static 
    {
        a = new <init>("SONIC", 0, 0);
        b = new <init>("ULTRASONIC", 1, 1);
        d = (new d[] {
            a, b
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        c = j;
    }
}
