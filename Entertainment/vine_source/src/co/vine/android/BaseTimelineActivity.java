// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.Menu;
import android.view.MenuInflater;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.LoopManager;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, BaseTimelineFragment

public abstract class BaseTimelineActivity extends BaseControllerActionBarActivity
{

    public BaseTimelineActivity()
    {
    }

    protected abstract BaseTimelineFragment getCurrentTimeLineFragment();

    protected boolean isAutoCaptureIconEnabled()
    {
        return true;
    }

    public void onBackPressed()
    {
        if (BuildUtil.isExplore())
        {
            BaseTimelineFragment basetimelinefragment = getCurrentTimeLineFragment();
            if (basetimelinefragment != null && basetimelinefragment.onBackPressed())
            {
                return;
            }
        }
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (isAutoCaptureIconEnabled() && !BuildUtil.isExplore())
        {
            getMenuInflater().inflate(0x7f100000, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onPause()
    {
        super.onPause();
        LoopManager.get(this).save();
    }
}
