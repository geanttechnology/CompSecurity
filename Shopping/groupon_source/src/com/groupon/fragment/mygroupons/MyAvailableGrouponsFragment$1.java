// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.content.res.Resources;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.models.gdt.GdtUserOrdersData;
import com.groupon.models.gdt.GdtUserOrdersDataContainer;
import com.groupon.models.gdt.GtgMockMyGrouponItemSummary;
import com.groupon.util.Function1;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            MyAvailableGrouponsFragment

class val.grouponsList
    implements Function1
{

    final MyAvailableGrouponsFragment this$0;
    final List val$grouponsList;

    public void execute(GdtUserOrdersDataContainer gdtuserordersdatacontainer)
    {
        if (gdtuserordersdatacontainer != null && gdtuserordersdatacontainer.data != null && gdtuserordersdatacontainer.data.orders.size() > 0)
        {
            int i = gdtuserordersdatacontainer.data.orders.size();
            if (i > 0)
            {
                gdtuserordersdatacontainer = new GtgMockMyGrouponItemSummary(i);
                gdtuserordersdatacontainer.setTitle(getString(0x7f0804da));
                if (i == 1)
                {
                    gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, 1));
                } else
                if (i <= 10)
                {
                    gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                } else
                {
                    gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, i, new Object[] {
                        "10+"
                    }));
                }
                if (val$grouponsList.isEmpty() || val$grouponsList.get(0) != null && !Strings.equals(((MyGrouponItemSummary)val$grouponsList.get(0)).remoteId, "gtg_mock_my_groupon_item_summary_remote_id"))
                {
                    val$grouponsList.add(0, gdtuserordersdatacontainer);
                }
            }
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((GdtUserOrdersDataContainer)obj);
    }

    ()
    {
        this$0 = final_myavailablegrouponsfragment;
        val$grouponsList = List.this;
        super();
    }
}
