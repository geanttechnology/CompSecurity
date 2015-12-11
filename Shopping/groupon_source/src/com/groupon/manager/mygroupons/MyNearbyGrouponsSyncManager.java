// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.mygroupons;

import android.content.Context;
import com.groupon.util.PausableThreadPoolExecutor;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.manager.mygroupons:
//            BaseMyGrouponsPaginatedSyncManager

public class MyNearbyGrouponsSyncManager extends BaseMyGrouponsPaginatedSyncManager
{

    public static final String NEARBY_GROUPONS_CATEGORY = "nearby_groupons";
    public static final int NEARBY_GROUPONS_DEFAULT_PAGE_SIZE = 30;

    public MyNearbyGrouponsSyncManager(Context context)
    {
        super(context, "nearby_groupons");
        setFirstPageSize(30);
    }

    public MyNearbyGrouponsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor, "nearby_groupons");
        setFirstPageSize(30);
    }

    protected void appendCategoryRelatedParams(List list)
    {
        list.addAll(Arrays.asList(new String[] {
            "sort_attribute", "purchased_at"
        }));
        list.addAll(Arrays.asList(new String[] {
            "sort_order", "descending"
        }));
        list.addAll(Arrays.asList(new String[] {
            "type", "usable"
        }));
    }

    protected int getNextOffset()
        throws Exception
    {
        return 0;
    }

    protected void logPaginationImpresion(int i)
    {
    }
}
