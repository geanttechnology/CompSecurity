// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package io.branch.referral:
//            Branch, ShareLinkManager, PrefHelper, BranchUtil

private class <init>
    implements android.app.server
{

    private int activityCnt_;
    final Branch this$0;

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
        if (Branch.access$400(Branch.this) == activity)
        {
            Branch.access$402(Branch.this, null);
        }
    }

    public void onActivityPaused(Activity activity)
    {
        Branch.access$1200(Branch.this, activity);
        if (Branch.access$1300(Branch.this) != null)
        {
            Branch.access$1300(Branch.this).cancelShareLinkDialog(true);
        }
    }

    public void onActivityResumed(Activity activity)
    {
        Branch.access$402(Branch.this, activity);
        if (Branch.access$100(Branch.this).getTouchDebugging())
        {
            Branch.access$1100(Branch.this, activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        if (activityCnt_ < 1)
        {
            if (BranchUtil.isTestModeEnabled(Branch.access$700(Branch.this)))
            {
                setDebug();
            }
            android.net.Uri uri = null;
            if (activity.getIntent() != null)
            {
                uri = activity.getIntent().getData();
            }
            initSessionWithData(uri, activity);
        }
        activityCnt_ = activityCnt_ + 1;
    }

    public void onActivityStopped(Activity activity)
    {
        activityCnt_ = activityCnt_ - 1;
        if (activityCnt_ < 1)
        {
            Branch.access$1400(Branch.this);
        }
    }

    private ()
    {
        this$0 = Branch.this;
        super();
        activityCnt_ = 0;
    }

    activityCnt_(activityCnt_ activitycnt_)
    {
        this();
    }
}
