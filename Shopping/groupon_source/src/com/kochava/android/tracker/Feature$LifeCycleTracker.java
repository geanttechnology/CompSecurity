// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

protected class this._cls0
    implements android.app.ycleCallbacks
{

    final Feature this$0;

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
        Log.i("KochavaTracker", "Tracking Activity Resumed");
        sManager.changeStatus("is_focused");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
    }

    public void onActivityStopped(Activity activity)
    {
    }

    protected sManager()
    {
        this$0 = Feature.this;
        super();
    }
}
