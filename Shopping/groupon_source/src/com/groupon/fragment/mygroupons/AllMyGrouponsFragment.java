// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.app.LoaderManager;
import com.groupon.abtest.EditOrderAbTestHelper;
import com.groupon.manager.mygroupons.AllMyGrouponsSyncManager;
import com.groupon.manager.mygroupons.BaseMyGrouponsPaginatedSyncManager;
import commonlib.manager.PaginatedSyncManager;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

public class AllMyGrouponsFragment extends BaseMyGrouponsFragment
{

    private AllMyGrouponsSyncManager allMyGrouponsSyncManager;

    public AllMyGrouponsFragment()
    {
    }

    public AllMyGrouponsSyncManager getSyncManager()
    {
        return allMyGrouponsSyncManager;
    }

    public volatile BaseMyGrouponsPaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BaseMyGrouponsFragment.GrouponsListLoaderCallbacks(this, myGrouponsJavaAdapter, "all_groupons", ((EditOrderAbTestHelper)editOrderAbTestHelper.get()).isEditOrderEnabled()));
    }
}
