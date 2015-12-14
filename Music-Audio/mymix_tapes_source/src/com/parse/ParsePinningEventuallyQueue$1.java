// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, ConnectivityNotifier

class this._cls0
    implements ityListener
{

    final ParsePinningEventuallyQueue this$0;

    public void networkConnectivityStatusChanged(Intent intent)
    {
        if (intent.getBooleanExtra("noConnectivity", false))
        {
            setConnected(false);
            return;
        } else
        {
            setConnected(ConnectivityNotifier.getNotifier().isConnected());
            return;
        }
    }

    ityListener()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
