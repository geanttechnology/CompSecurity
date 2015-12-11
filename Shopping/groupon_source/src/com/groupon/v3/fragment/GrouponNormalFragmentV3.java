// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.groupon.fragment.GrouponFragmentDelegate;
import com.groupon.fragment.GrouponFragmentInterface;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class GrouponNormalFragmentV3 extends Fragment
    implements GrouponFragmentInterface
{

    protected GrouponFragmentDelegate _flddelegate;
    protected boolean hasLoggedWindowDrawnTime;
    protected Logger logger;
    protected long onCreateStartTime;
    protected boolean refreshMenuItemEnabled;

    public GrouponNormalFragmentV3()
    {
        hasLoggedWindowDrawnTime = false;
        refreshMenuItemEnabled = true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getView().post(new Runnable() {

            final GrouponNormalFragmentV3 this$0;

            public void run()
            {
                if (!hasLoggedWindowDrawnTime)
                {
                    hasLoggedWindowDrawnTime = true;
                    String s = getClass().getSimpleName();
                    logger.logGeneralEvent("android_events", "window_drawn", s, (int)(SystemClock.elapsedRealtime() - onCreateStartTime), Logger.NULL_NST_FIELD);
                }
            }

            
            {
                this$0 = GrouponNormalFragmentV3.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        onCreateStartTime = SystemClock.elapsedRealtime();
        super.onCreate(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        _flddelegate.onCreate(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        _flddelegate.onDestroy();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        _flddelegate.onDestroyView(this);
    }

    public void onPause()
    {
        super.onPause();
        _flddelegate.onPause();
    }

    public void onResume()
    {
        super.onResume();
        _flddelegate.onResume();
    }

    public void onSelectionChange(boolean flag)
    {
        _flddelegate.onSelectionChange(flag);
    }

    public void setRefreshMenuItemEnabled(boolean flag)
    {
        refreshMenuItemEnabled = flag;
    }
}
