// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.app.Service;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdClientImpl

class this._cls0 extends PhoneStateListener
{

    final AdClientImpl this$0;

    public void onCallStateChanged(int i, String s)
    {
        if (i != 1) goto _L2; else goto _L1
_L1:
        if (((AudioManager)AdClientImpl.access$300(AdClientImpl.this).getSystemService("audio")).getStreamVolume(2) > 0 && i == 2)
        {
            stopAd(3);
        }
_L4:
        return;
_L2:
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i != 2) goto _L4; else goto _L3
_L3:
        stopAd(3);
        return;
        if (i != 0) goto _L4; else goto _L5
_L5:
    }

    ()
    {
        this$0 = AdClientImpl.this;
        super();
    }
}
