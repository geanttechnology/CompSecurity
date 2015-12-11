// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.TimerTask;

// Referenced classes of package com.adobe.mobile:
//            AbstractHitDatabase, ReferrerHandler, StaticMethods

protected class kickFlag extends TimerTask
{

    private boolean kickFlag;
    final AbstractHitDatabase this$0;

    public void run()
    {
        ReferrerHandler.setReferrerProcessed(true);
        StaticMethods.logDebugFormat("%s - Referrer timeout has expired without referrer data", new Object[] {
            logPrefix
        });
        kick(kickFlag);
    }

    (boolean flag)
    {
        this$0 = AbstractHitDatabase.this;
        super();
        kickFlag = false;
        kickFlag = flag;
    }
}
