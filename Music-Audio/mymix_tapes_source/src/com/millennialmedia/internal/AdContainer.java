// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ViewUtils;

// Referenced classes of package com.millennialmedia.internal:
//            ActivityListenerManager

public class AdContainer extends RelativeLayout
{

    private static final String TAG = com/millennialmedia/internal/AdContainer.getSimpleName();
    private ActivityListenerManager.ActivityListener activityListener;

    public AdContainer(Activity activity, ActivityListenerManager.ActivityListener activitylistener)
    {
        super(activity);
        activityListener = activitylistener;
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (activityListener == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "AdContainer not listening for activity lifecycle events, skipping activity lifecycle dispatcher registration");
            }
            return;
        }
        int i = ViewUtils.getActivityHashForView(this);
        if (i == -1)
        {
            MMLog.e(TAG, "Unable to register activity lifecycle listener for AdContainer, no valid activity hash");
            return;
        } else
        {
            ActivityListenerManager.registerListener(i, activityListener);
            return;
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (activityListener == null)
        {
            return;
        }
        int i = ViewUtils.getActivityHashForView(this);
        if (i == -1)
        {
            MMLog.e(TAG, "Unable to unregister activity lifecycle listener for AdContainer, no valid activity hash");
            return;
        } else
        {
            ActivityListenerManager.unregisterListener(i, activityListener);
            return;
        }
    }

}
