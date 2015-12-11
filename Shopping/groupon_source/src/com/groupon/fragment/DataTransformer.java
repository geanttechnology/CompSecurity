// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.models.EndlessList;
import com.groupon.models.gdt.GtgMockDealSummary;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class DataTransformer
{

    public DataTransformer()
    {
    }

    protected void addGtgMockCardsWhenNeeded(EndlessList endlesslist)
    {
        byte byte0 = -1;
        int i = 0;
        do
        {
label0:
            {
                int j = byte0;
                if (i < endlesslist.size())
                {
                    if (!((DealSummary)endlesslist.get(i)).secondLevelDealCategories.contains("food-and-drink"))
                    {
                        break label0;
                    }
                    j = i + 1;
                }
                if (j != -1)
                {
                    endlesslist.add(j, new GtgMockDealSummary("gtg_mock_promo_deal_summary_remote_id"));
                }
                return;
            }
            i++;
        } while (true);
    }

    public void transform(EndlessList endlesslist, List list, List list1)
    {
        Iterator iterator = endlesslist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DealSummary dealsummary = (DealSummary)iterator.next();
            if (dealsummary.derivedIsSmuggled)
            {
                iterator.remove();
                list1.add(dealsummary);
            }
        } while (true);
        if (list1.size() > 0)
        {
            Object obj = new HashSet();
            for (Iterator iterator1 = list1.iterator(); iterator1.hasNext(); ((HashSet) (obj)).add(((DealSummary)iterator1.next()).remoteId)) { }
            for (Iterator iterator2 = list.iterator(); iterator2.hasNext();)
            {
                WidgetSummary widgetsummary = (WidgetSummary)iterator2.next();
                Object obj1 = widgetsummary.dealSummaries;
                if (Strings.equals(widgetsummary.viewLayout, "rotating_image_layout"))
                {
                    DealSummary adealsummary[] = (DealSummary[])((Collection) (obj1)).toArray(new DealSummary[0]);
                    int i = adealsummary.length - 1;
                    while (i >= 0 && ((HashSet) (obj)).contains(adealsummary[i].remoteId)) 
                    {
                        ((Collection) (obj1)).remove(adealsummary[i]);
                        i--;
                    }
                } else
                {
                    obj1 = ((Collection) (obj1)).iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        if (((HashSet) (obj)).contains(((DealSummary)((Iterator) (obj1)).next()).remoteId))
                        {
                            ((Iterator) (obj1)).remove();
                        }
                    }
                }
            }

            obj = list.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (((WidgetSummary)((Iterator) (obj)).next()).dealSummaries.size() == 0)
                {
                    ((Iterator) (obj)).remove();
                }
            } while (true);
            if (list.size() == 0)
            {
                endlesslist.addAll(0, list1);
                list1.clear();
            }
        }
        addGtgMockCardsWhenNeeded(endlesslist);
    }
}
