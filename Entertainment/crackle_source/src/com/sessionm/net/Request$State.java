// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            Request

public static final class  extends Enum
{

    public static final fh fe;
    public static final fh ff;
    public static final fh fg;
    public static final fh fh;
    private static final fh fi[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/Request$State, s);
    }

    public static [] values()
    {
        return ([])fi.clone();
    }

    public boolean be()
    {
        return this == fg || this == fh;
    }

    static 
    {
        fe = new <init>("UNSENT", 0);
        ff = new <init>("SENDING", 1);
        fg = new <init>("COMPLETED", 2);
        fh = new <init>("FAILED", 3);
        fi = (new fi[] {
            fe, ff, fg, fh
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
