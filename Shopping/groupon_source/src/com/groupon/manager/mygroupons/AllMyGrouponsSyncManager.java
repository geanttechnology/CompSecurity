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

public class AllMyGrouponsSyncManager extends BaseMyGrouponsPaginatedSyncManager
{

    public static final String ALL_GROUPONS_CATEGORY = "all_groupons";

    public AllMyGrouponsSyncManager(Context context)
    {
        super(context, "all_groupons");
    }

    public AllMyGrouponsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor, "all_groupons");
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
            "type", "all"
        }));
    }
}
