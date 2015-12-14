// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            SpeechKit

public static final class a extends Enum
{

    public static final DRAGON_NLU DRAGON_NLU;
    public static final DRAGON_NLU NVC;
    private static final DRAGON_NLU b[];
    private int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/nuance/nmdp/speechkit/SpeechKit$CmdSetType, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public final int getIndex()
    {
        return a;
    }

    static 
    {
        NVC = new <init>("NVC", 0, 0);
        DRAGON_NLU = new <init>("DRAGON_NLU", 1, 1);
        b = (new b[] {
            NVC, DRAGON_NLU
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
