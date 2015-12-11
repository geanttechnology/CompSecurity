// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.urbanairship:
//            LifeCycleCallbacks

class this._cls0
    implements android.app.ifecycleCallbacks
{

    final LifeCycleCallbacks this$0;

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        LifeCycleCallbacks.this.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity)
    {
        LifeCycleCallbacks.this.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        LifeCycleCallbacks.this.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity)
    {
        LifeCycleCallbacks.this.onActivityStopped(activity);
    }

    cleCallbacks()
    {
        this$0 = LifeCycleCallbacks.this;
        super();
    }
}
