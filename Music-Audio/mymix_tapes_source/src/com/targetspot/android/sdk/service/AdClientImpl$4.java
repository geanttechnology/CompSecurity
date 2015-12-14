// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.content.DialogInterface;
import android.util.Log;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdClientImpl

class this._cls0
    implements android.content..OnDismissListener
{

    final int myId;
    final AdClientImpl this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (AdClientImpl.access$000(AdClientImpl.this) == 1 && AdClientImpl.access$400(AdClientImpl.this) == myId)
        {
            Log.d("AdClient", "User cancelled preroll");
            sendPlaybackStopped(2);
            AdClientImpl.access$002(AdClientImpl.this, 0);
        }
    }

    ()
    {
        this$0 = AdClientImpl.this;
        super();
        myId = AdClientImpl.access$400(AdClientImpl.this);
    }
}
