// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.app.Activity;
import com.groupon.service.cachebust.EmergencyDialogDisplayManager;

// Referenced classes of package com.groupon.callbacks:
//            BaseActivityLifecycleCallback

public class UIStateActivityLifecycleCallback extends BaseActivityLifecycleCallback
{

    private final EmergencyDialogDisplayManager emergencyDialogDisplayManager;

    public UIStateActivityLifecycleCallback(EmergencyDialogDisplayManager emergencydialogdisplaymanager)
    {
        emergencyDialogDisplayManager = emergencydialogdisplaymanager;
    }

    public void onActivityPaused(Activity activity)
    {
        emergencyDialogDisplayManager.setCurrentActivity(null);
    }

    public void onActivityResumed(Activity activity)
    {
        emergencyDialogDisplayManager.setCurrentActivity(activity);
    }
}
