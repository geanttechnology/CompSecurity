// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;


// Referenced classes of package com.google.android.gms.analytics:
//            s

private static final class  extends Enum
{

    public static final rT rN;
    public static final rT rO;
    public static final rT rP;
    public static final rT rQ;
    public static final rT rR;
    public static final rT rS;
    public static final rT rT;
    private static final rT rU[];

    public static  valueOf(String s1)
    {
        return ()Enum.valueOf(com/google/android/gms/analytics/s$a, s1);
    }

    public static [] values()
    {
        return ([])rU.clone();
    }

    static 
    {
        rN = new <init>("CONNECTING", 0);
        rO = new <init>("CONNECTED_SERVICE", 1);
        rP = new <init>("CONNECTED_LOCAL", 2);
        rQ = new <init>("BLOCKED", 3);
        rR = new <init>("PENDING_CONNECTION", 4);
        rS = new <init>("PENDING_DISCONNECT", 5);
        rT = new <init>("DISCONNECTED", 6);
        rU = (new rU[] {
            rN, rO, rP, rQ, rR, rS, rT
        });
    }

    private (String s1, int i)
    {
        super(s1, i);
    }
}
