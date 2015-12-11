// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package c.a.a.a:
//            d, b

final class c
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private d a;

    c(b b, d d1)
    {
        a = d1;
        super();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        a.onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity)
    {
        a.onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity)
    {
        a.onActivityPaused(activity);
    }

    public final void onActivityResumed(Activity activity)
    {
        a.onActivityResumed(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        a.onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity)
    {
        a.onActivityStarted(activity);
    }

    public final void onActivityStopped(Activity activity)
    {
        a.onActivityStopped(activity);
    }
}
