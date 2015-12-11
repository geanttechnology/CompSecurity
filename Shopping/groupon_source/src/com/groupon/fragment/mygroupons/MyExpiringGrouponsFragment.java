// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.app.LoaderManager;
import com.groupon.abtest.EditOrderAbTestHelper;
import com.groupon.manager.mygroupons.BaseMyGrouponsPaginatedSyncManager;
import com.groupon.manager.mygroupons.MyExpiringGrouponsSyncManager;
import commonlib.manager.PaginatedSyncManager;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

public class MyExpiringGrouponsFragment extends BaseMyGrouponsFragment
{

    private MyExpiringGrouponsSyncManager myExpiringGrouponsSyncManager;

    public MyExpiringGrouponsFragment()
    {
    }

    public volatile BaseMyGrouponsPaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public MyExpiringGrouponsSyncManager getSyncManager()
    {
        return myExpiringGrouponsSyncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BaseMyGrouponsFragment.GrouponsListLoaderCallbacks(this, myGrouponsJavaAdapter, "expiring_groupons", ((EditOrderAbTestHelper)editOrderAbTestHelper.get()).isEditOrderEnabled()));
    }
}
