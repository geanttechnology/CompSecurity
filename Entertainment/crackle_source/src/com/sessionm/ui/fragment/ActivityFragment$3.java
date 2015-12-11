// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui.fragment;

import android.app.Activity;
import com.sessionm.ui.ProgressViewController;

// Referenced classes of package com.sessionm.ui.fragment:
//            ActivityFragment, FragmentActivityController

class troller
    implements com.sessionm.ui.PrepareListener
{

    final ActivityFragment this$0;
    final FragmentActivityController val$activityController;

    public void onFailure(Throwable throwable)
    {
        val$activityController.getActivityContext().runOnUiThread(new Runnable() {

            final ActivityFragment._cls3 this$1;

            public void run()
            {
                ActivityFragment.access$200(this$0).setReloadPropmptState(com.sessionm.ui.ProgressViewController.ReloadPromptState.RELOAD);
            }

            
            {
                this$1 = ActivityFragment._cls3.this;
                super();
            }
        });
    }

    public void onPrepared()
    {
        ActivityFragment.access$100(ActivityFragment.this);
    }

    troller()
    {
        this$0 = final_activityfragment;
        val$activityController = FragmentActivityController.this;
        super();
    }
}
