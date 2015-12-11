// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mraid.MraidController;

// Referenced classes of package com.mopub.mobileads:
//            MraidActivity, EventForwardingBroadcastReceiver

class this._cls0
    implements com.mopub.mraid.MraidListener
{

    final MraidActivity this$0;

    public void onClose()
    {
        MraidActivity.access$000(MraidActivity.this).loadJavascript(Activity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
        finish();
    }

    public void onExpand()
    {
    }

    public void onFailedToLoad()
    {
        MoPubLog.d("MraidActivity failed to load. Finishing the activity");
        EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
        finish();
    }

    public void onLoaded(View view)
    {
        MraidActivity.access$000(MraidActivity.this).loadJavascript(Activity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
    }

    public void onOpen()
    {
        EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
    }

    roadcastReceiver()
    {
        this$0 = MraidActivity.this;
        super();
    }
}
