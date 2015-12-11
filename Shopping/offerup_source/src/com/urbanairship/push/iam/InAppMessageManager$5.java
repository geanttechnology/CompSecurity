// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.Cancelable;
import com.urbanairship.LifeCycleCallbacks;
import com.urbanairship.UAirship;
import java.lang.ref.WeakReference;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageManager

final class _cls2 extends LifeCycleCallbacks
{

    public final void onActivityPaused(Activity activity)
    {
        if (InAppMessageManager.access$1100() != null && !InAppMessageManager.access$1100().isDone())
        {
            InAppMessageManager.access$1100().cancel();
            return;
        } else
        {
            UAirship.shared().getInAppMessageManager().onActivityPaused(activity);
            return;
        }
    }

    public final void onActivityResumed(Activity activity)
    {
        class _cls3
            implements com.urbanairship.UAirship.OnReadyCallback
        {

            final InAppMessageManager._cls5 this$0;
            final WeakReference val$weakReference;

            public void onAirshipReady(UAirship uairship)
            {
                uairship = (Activity)weakReference.get();
                if (uairship != null)
                {
                    UAirship.shared().getInAppMessageManager().onActivityResumed(uairship);
                }
            }

            _cls3()
            {
                this$0 = InAppMessageManager._cls5.this;
                weakReference = weakreference;
                super();
            }
        }

        Cancelable _tmp = InAppMessageManager.access$1102(UAirship.shared(new _cls3()));
    }

    public final void onActivityStarted(Activity activity)
    {
label0:
        {
            InAppMessageManager.access$908();
            if (!InAppMessageManager.access$1000())
            {
                boolean _tmp = InAppMessageManager.access$1002(true);
                if (!UAirship.isFlying())
                {
                    break label0;
                }
                UAirship.shared().getInAppMessageManager().onForeground();
            }
            return;
        }
        class _cls1
            implements com.urbanairship.UAirship.OnReadyCallback
        {

            final InAppMessageManager._cls5 this$0;

            public void onAirshipReady(UAirship uairship)
            {
                UAirship.shared().getInAppMessageManager().onForeground();
            }

            _cls1()
            {
                this$0 = InAppMessageManager._cls5.this;
                super();
            }
        }

        UAirship.shared(new _cls1());
    }

    public final void onActivityStopped(Activity activity)
    {
        InAppMessageManager.access$910();
        class _cls2
            implements Runnable
        {

            final InAppMessageManager._cls5 this$0;

            public void run()
            {
                if (InAppMessageManager.access$900() == 0)
                {
                    boolean _tmp = InAppMessageManager.access$1002(false);
                }
            }

            _cls2()
            {
                this$0 = InAppMessageManager._cls5.this;
                super();
            }
        }

        if (InAppMessageManager.access$900() == 0)
        {
            (new Handler(Looper.getMainLooper())).postDelayed(new _cls2(), 500L);
        }
    }

    _cls2(Application application)
    {
        super(application);
    }
}
