// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            LoginService

public static class daoPagination extends Thread
{

    private DaoMyGrouponItem daoMyGrouponItem;
    private DaoMyGrouponItemSummary daoMyGrouponItemSummary;
    private DaoPagination daoPagination;

    private List getGrouponCategoriesList()
    {
        return Arrays.asList(new String[] {
            "available_groupons", "expiring_groupons", "nearby_groupons", "all_groupons"
        });
    }

    public void run()
    {
        try
        {
            daoMyGrouponItem.clearAll();
            daoMyGrouponItemSummary.clearAll();
            daoPagination.deleteByChannelIds(getGrouponCategoriesList());
            return;
        }
        catch (Exception exception)
        {
            Ln.w(exception);
        }
    }

    public (DaoMyGrouponItem daomygrouponitem, DaoMyGrouponItemSummary daomygrouponitemsummary, DaoPagination daopagination)
    {
        daoMyGrouponItem = daomygrouponitem;
        daoMyGrouponItemSummary = daomygrouponitemsummary;
        daoPagination = daopagination;
    }
}
