// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.internal.SizableStateManager;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            WebController

class val.activityConfig
    implements Runnable
{

    final WebController this$0;
    final com.millennialmedia.internal.ivityConfig val$activityConfig;

    public void run()
    {
        SizableStateManager sizablestatemanager = getSizableStateManager();
        com.millennialmedia.internal.ger.ExpandParams expandparams = new com.millennialmedia.internal.ger.ExpandParams();
        expandparams.width = -1;
        expandparams.height = -1;
        expandparams.showCloseIndicator = true;
        expandparams.orientation = -1;
        if (!sizablestatemanager.expand(WebController.access$000(WebController.this), expandparams, val$activityConfig))
        {
            WebController.access$100(WebController.this).attachFailed();
        }
    }

    bControllerListener()
    {
        this$0 = final_webcontroller;
        val$activityConfig = com.millennialmedia.internal.ivityConfig.this;
        super();
    }
}
