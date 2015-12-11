// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.models.dealsearch.CardDisplayOption;
import com.groupon.util.BuyUtils;
import com.groupon.util.ImageUrl;
import com.groupon.view.UrlImageView;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.db.models:
//            Card, Deal, Option, DealSummary

public class CardDeal extends Card
{

    private BuyUtils buyUtil;
    private DaoDealSummary dealSummaryDao;

    public CardDeal()
    {
    }

    private Option findOptionWithUuid(String s)
    {
        for (Iterator iterator = ((Deal)data).options.iterator(); iterator.hasNext();)
        {
            Option option = (Option)iterator.next();
            if (option.uuid.equals(s))
            {
                return option;
            }
        }

        return null;
    }

    private Map generateOptionIdShowPriorityMap()
    {
        HashMap hashmap = new HashMap();
        int i = 0;
        Iterator iterator = displayOptions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (CardDisplayOption)iterator.next();
            if (((CardDisplayOption) (obj)).name.equals("optionUuid"))
            {
                obj = findOptionWithUuid(((CardDisplayOption) (obj)).value);
                if (obj != null)
                {
                    hashmap.put(((Option) (obj)).remoteId, Integer.valueOf(i));
                    i++;
                }
            }
        } while (true);
        return hashmap;
    }

    public void save(String s, Context context, int i, int j)
        throws SQLException
    {
        RoboGuice.getInjector(context).injectMembers(this);
        ((Deal)data).afterJsonDeserializationPostProcessor(buyUtil, generateOptionIdShowPriorityMap());
        ((Deal)data).derivedActualPosition = i;
        ((Deal)data).derivedTrackingPosition = j;
        dealSummaryDao.save(new DealSummary((Deal)data, s));
        UrlImageView.prefetch((Application)context.getApplicationContext(), new ImageUrl(((Deal)data).largeImageUrl));
    }
}
