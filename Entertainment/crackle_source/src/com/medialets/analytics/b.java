// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.medialets.analytics:
//            MMAnalyticsManager

final class b extends Handler
{

    private MMAnalyticsManager a;

    b(MMAnalyticsManager mmanalyticsmanager)
    {
        a = mmanalyticsmanager;
        super();
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (a.mAnalyticsListener != null)
        {
            a.mAnalyticsListener.onPostComplete();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
