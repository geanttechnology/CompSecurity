// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            s

public static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s1)
    {
        return ()Enum.valueOf(com/tremorvideo/sdk/android/richmedia/s$b, s1);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("VideoRemaining", 0);
        b = new <init>("VideoElapsed", 1);
        c = new <init>("SceneRemaining", 2);
        d = new <init>("SceneElapsed", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s1, int i)
    {
        super(s1, i);
    }
}
