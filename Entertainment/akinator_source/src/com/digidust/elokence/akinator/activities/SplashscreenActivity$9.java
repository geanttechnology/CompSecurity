// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.util.Log;
import io.presage.utils.IADHandler;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements IADHandler
{

    final SplashscreenActivity this$0;

    public void onAdClosed()
    {
        SplashscreenActivity.access$1502(SplashscreenActivity.this, true);
    /* block-local class not found */
    class _cls2 {}

        runOnUiThread(new _cls2());
        Log.i("PRESAGE", "ad closed");
    }

    public void onAdFound()
    {
        Log.i("PRESAGE", "ad found");
    }

    public void onAdNotFound()
    {
        Log.i("PRESAGE", "ad not found");
        SplashscreenActivity.access$1502(SplashscreenActivity.this, true);
    /* block-local class not found */
    class _cls1 {}

        runOnUiThread(new _cls1());
    }

    _cls1()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}
