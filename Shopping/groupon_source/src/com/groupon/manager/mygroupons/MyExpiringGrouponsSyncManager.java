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

public class MyExpiringGrouponsSyncManager extends BaseMyGrouponsPaginatedSyncManager
{

    public static final String EXPIRING_GROUPONS_CATEGORY = "expiring_groupons";

    public MyExpiringGrouponsSyncManager(Context context)
    {
        super(context, "expiring_groupons");
    }

    public MyExpiringGrouponsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor, "expiring_groupons");
    }

    protected void appendCategoryRelatedParams(List list)
    {
        list.addAll(Arrays.asList(new String[] {
            "sort_attribute", "expires_at"
        }));
        list.addAll(Arrays.asList(new String[] {
            "sort_order", "ascending"
        }));
        list.addAll(Arrays.asList(new String[] {
            "type", "available"
        }));
    }
}
