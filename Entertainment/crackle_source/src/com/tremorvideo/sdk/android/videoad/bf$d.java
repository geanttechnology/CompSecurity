// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf

public static final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tremorvideo/sdk/android/videoad/bf$d, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    static 
    {
        a = new <init>("Asset", 0);
        b = new <init>("Video", 1);
        c = new <init>("Survey", 2);
        d = new <init>("HTML5", 3);
        e = new <init>("VAST", 4);
        f = new <init>("ProcessBIN", 5);
        g = new <init>("ProcessEmbedPlayer", 6);
        h = new <init>("ProcessMovieBoard", 7);
        i = new <init>("Invalid", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
