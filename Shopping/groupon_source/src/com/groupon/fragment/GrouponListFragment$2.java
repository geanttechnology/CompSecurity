// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.database.DataSetObserver;
import android.os.SystemClock;
import android.widget.ListAdapter;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            GrouponListFragment

class val.adapter extends DataSetObserver
{

    final GrouponListFragment this$0;
    final ListAdapter val$adapter;

    public void onChanged()
    {
        super.onChanged();
        if (!GrouponListFragment.access$200(GrouponListFragment.this) && val$adapter.getCount() > 1)
        {
            logger.logPageLoad("", getClass().getSimpleName(), 0, GrouponListFragment.access$100(GrouponListFragment.this), (int)(SystemClock.elapsedRealtime() - GrouponListFragment.access$100(GrouponListFragment.this)), Logger.NULL_NST_FIELD);
            GrouponListFragment.access$202(GrouponListFragment.this, true);
            val$adapter.unregisterDataSetObserver(this);
        }
    }

    ()
    {
        this$0 = final_grouponlistfragment;
        val$adapter = ListAdapter.this;
        super();
    }
}
