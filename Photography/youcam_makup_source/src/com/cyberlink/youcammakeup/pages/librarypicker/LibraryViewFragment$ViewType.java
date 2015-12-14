// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;


public final class Q extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/youcammakeup/pages/librarypicker/LibraryViewFragment$ViewType, s);
    }

    public static Q[] values()
    {
        return (Q[])e.clone();
    }

    static 
    {
        a = new <init>("PhotoView", 0);
        b = new <init>("AlbumView", 1);
        c = new <init>("PhotoZoomView", 2);
        d = new <init>("Unknow", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
