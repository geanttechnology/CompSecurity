// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            Request

public static final class  extends Enum
{

    public static final fc fa;
    public static final fc fb;
    public static final fc fc;
    private static final fc fd[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/Request$Priority, s);
    }

    public static [] values()
    {
        return ([])fd.clone();
    }

    static 
    {
        fa = new <init>("LOW", 0);
        fb = new <init>("NORMAL", 1);
        fc = new <init>("HIGH", 2);
        fd = (new fd[] {
            fa, fb, fc
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
