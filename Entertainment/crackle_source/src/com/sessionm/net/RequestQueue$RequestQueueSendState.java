// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            RequestQueue

public static final class _cls9 extends Enum
{

    public static final fV fU;
    public static final fV fV;
    private static final fV fW[];

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueSendState, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])fW.clone();
    }

    static 
    {
        fU = new <init>("IDLE", 0);
        fV = new <init>("SENDING", 1);
        fW = (new fW[] {
            fU, fV
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
