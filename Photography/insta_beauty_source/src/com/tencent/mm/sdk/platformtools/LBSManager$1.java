// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log, LBSManager

class al
    implements .CallBack
{

    final LBSManager al;

    public boolean onTimerExpired()
    {
        Log.v("MicroMsg.LBSManager", "get location by GPS failed.");
        al.ag = true;
        al.start();
        LBSManager.a(al);
        return false;
    }

    .CallBack(LBSManager lbsmanager)
    {
        al = lbsmanager;
        super();
    }
}
