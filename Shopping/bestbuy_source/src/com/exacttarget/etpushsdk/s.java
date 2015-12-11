// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPush

final class s
    implements android.app.Application.ActivityLifecycleCallbacks
{

    s()
    {
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        ETPush.b(activity, true);
    }

    public void onActivityResumed(Activity activity)
    {
        ETPush.a(activity, true);
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
}
