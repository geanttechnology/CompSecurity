// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.app.ExpandableListActivity;

// Referenced classes of package com.google.analytics.tracking.android:
//            EasyTracker

public class TrackedExpandableListActivity extends ExpandableListActivity
{

    public TrackedExpandableListActivity()
    {
    }

    protected void onStart()
    {
        super.onStart();
        EasyTracker.getInstance().activityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        EasyTracker.getInstance().activityStop(this);
    }
}
