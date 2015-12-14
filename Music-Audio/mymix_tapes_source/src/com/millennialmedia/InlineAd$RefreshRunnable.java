// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.view.ViewGroup;
import com.millennialmedia.internal.ActivityListenerManager;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia:
//            InlineAd, MMLog

private static class inlineAdRef
    implements Runnable
{

    WeakReference inlineAdRef;

    public void run()
    {
        final InlineAd inlineAd = (InlineAd)inlineAdRef.get();
        if (inlineAd == null)
        {
            MMLog.e(InlineAd.access$000(), "InlineAd instance has been destroyed, shutting down refresh behavior");
            return;
        }
        if (InlineAd.access$200(inlineAd) == null || InlineAd.access$200(inlineAd).intValue() <= 0)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(InlineAd.access$000(), "Inline refresh disabled, aborting refresh behavior");
            }
            InlineAd.access$402(inlineAd, null);
            return;
        }
        android.app.Activity activity = ViewUtils.getActivityForView(InlineAd.access$100(inlineAd));
        if (activity == null)
        {
            MMLog.e(InlineAd.access$000(), "Unable to find valid activity context for placement container, aborting refresh");
            return;
        }
        boolean flag;
        if (ActivityListenerManager.getLifecycleState(activity) == com.millennialmedia.internal.ifecycleState.RESUMED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (InlineAd.access$100(inlineAd).isShown() && !InlineAd.access$500(inlineAd) && !InlineAd.access$600(inlineAd) && flag)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final InlineAd.RefreshRunnable this$0;
                final InlineAd val$inlineAd;

                public void run()
                {
                    InlineAd.access$700(inlineAd);
                }

            
            {
                this$0 = InlineAd.RefreshRunnable.this;
                inlineAd = inlinead;
                super();
            }
            });
        }
        InlineAd.access$402(inlineAd, ThreadUtils.runOnWorkerThreadDelayed(this, InlineAd.access$200(inlineAd).intValue()));
    }

    _cls1.val.inlineAd(InlineAd inlinead)
    {
        inlineAdRef = new WeakReference(inlinead);
    }
}
