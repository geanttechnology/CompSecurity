// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.util.Log;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

protected class this._cls0
    implements ComponentCallbacks2
{

    final Feature this$0;

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
    }

    public void onTrimMemory(int i)
    {
        if (i == 20)
        {
            Log.i("KochavaTracker", "Tracking Activity lost focus");
            eStatusManager.changeStatus("is_in_background");
        }
    }

    protected eStatusManager()
    {
        this$0 = Feature.this;
        super();
    }
}
