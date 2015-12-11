// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.ListFragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.fragment:
//            GrouponFragmentInterface, GrouponFragmentDelegate

public abstract class GrouponListFragment extends ListFragment
    implements GrouponFragmentInterface
{

    private GrouponFragmentDelegate _flddelegate;
    private boolean hasLoggedPageLoadTime;
    private boolean hasLoggedWindowDrawnTime;
    protected Logger logger;
    private long onCreateStartTime;

    public GrouponListFragment()
    {
        hasLoggedPageLoadTime = false;
        hasLoggedWindowDrawnTime = false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getView().post(new Runnable() {

            final GrouponListFragment this$0;

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
                this$0 = GrouponListFragment.this;
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
        setListAdapter(null);
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

    public void setListAdapter(final ListAdapter adapter)
    {
        super.setListAdapter(adapter);
        if (adapter != null)
        {
            adapter.registerDataSetObserver(new DataSetObserver() {

                final GrouponListFragment this$0;
                final ListAdapter val$adapter;

                public void onChanged()
                {
                    super.onChanged();
                    if (!hasLoggedPageLoadTime && adapter.getCount() > 1)
                    {
                        logger.logPageLoad("", getClass().getSimpleName(), 0, onCreateStartTime, (int)(SystemClock.elapsedRealtime() - onCreateStartTime), Logger.NULL_NST_FIELD);
                        hasLoggedPageLoadTime = true;
                        adapter.unregisterDataSetObserver(this);
                    }
                }

            
            {
                this$0 = GrouponListFragment.this;
                adapter = listadapter;
                super();
            }
            });
        }
    }



/*
    static boolean access$002(GrouponListFragment grouponlistfragment, boolean flag)
    {
        grouponlistfragment.hasLoggedWindowDrawnTime = flag;
        return flag;
    }

*/




/*
    static boolean access$202(GrouponListFragment grouponlistfragment, boolean flag)
    {
        grouponlistfragment.hasLoggedPageLoadTime = flag;
        return flag;
    }

*/
}
