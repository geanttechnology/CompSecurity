// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


// Referenced classes of package com.moodmedia.moodpresence:
//            i

static final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/moodmedia/moodpresence/i$a, s);
    }

    public static [] values()
    {
         a1[] = d;
        int j = a1.length;
         a2[] = new d[j];
        System.arraycopy(a1, 0, a2, 0, j);
        return a2;
    }

    static 
    {
        a = new <init>("IDLE", 0);
        b = new <init>("READY", 1);
        c = new <init>("LISTENING", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int j)
    {
        super(s, j);
    }
}
