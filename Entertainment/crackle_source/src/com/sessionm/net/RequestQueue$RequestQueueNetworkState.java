// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            RequestQueue

public static final class  extends Enum
{

    public static final fS fQ;
    public static final fS fR;
    public static final fS fS;
    private static final fS fT[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueNetworkState, s);
    }

    public static [] values()
    {
        return ([])fT.clone();
    }

    static 
    {
        fQ = new <init>("CONNECTED", 0);
        fR = new <init>("DISCONNECTED", 1);
        fS = new <init>("CONNECTING", 2);
        fT = (new fT[] {
            fQ, fR, fS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
