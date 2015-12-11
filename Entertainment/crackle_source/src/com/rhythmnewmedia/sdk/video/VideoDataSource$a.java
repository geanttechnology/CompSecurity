// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;


// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            VideoDataSource

public static final class d extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c e[];
    public final int d;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/rhythmnewmedia/sdk/video/VideoDataSource$a, s);
    }

    public static d[] values()
    {
        return (d[])e.clone();
    }

    static 
    {
        a = new <init>("unknown", 0, 0);
        b = new <init>("file", 1, 1);
        c = new <init>("stream", 2, 2);
        e = (new e[] {
            a, b, c
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        d = j;
    }
}
