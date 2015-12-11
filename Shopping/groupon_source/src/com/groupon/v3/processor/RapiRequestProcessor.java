// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.db.dao.DaoBand;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoCollection;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoFinder;
import com.groupon.db.models.Band;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Finder;
import com.groupon.db.models.Pagination;
import com.groupon.service.core.AbTestService;
import com.groupon.util.CardPositionComparator;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.view.list_view.LocationBarHeader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class RapiRequestProcessor extends BackgroundDataProcessor
{

    private AbTestService abTestService;
    private DaoBand daoBand;
    private DaoBusiness daoBusiness;
    private DaoCollection daoCollection;
    private DaoDealSummary daoDealSummary;
    private DaoFinder daoFinder;
    private String dbChannel;
    private GtgAbTestHelper gtgAbTestHelper;
    private boolean isRapiGlobalSearch;
    private boolean isShowBandCardOnSearch1510USCA;
    private LocationBarHeader locationBarHeaderItem;

    public RapiRequestProcessor(Context context, String s, boolean flag)
    {
        super(flag);
        dbChannel = s;
        RoboGuice.getInjector(context).injectMembers(this);
        isShowBandCardOnSearch1510USCA = abTestService.isVariantEnabled("showBandCardOnSearch1510USCA", "on");
        isRapiGlobalSearch = s.startsWith(Channel.RAPI_SEARCH.name());
    }

    private void addGtgMockCardsWhenNeeded(List list, List list1)
    {
        if (!list1.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (gtgAbTestHelper.isGtgJumpoffCardOnFeatured())
        {
            list = new Finder();
            list.type = "gtg_jumpoff_card_with_defaults";
            list.name = "gtg_jumpoff";
            list.channel = Channel.FEATURED.toString();
            list.derivedActualPosition = 0;
            list.derivedTrackingPosition = 0;
            list1.add(((Finder) (list)).derivedActualPosition, list);
            return;
        }
        if (!gtgAbTestHelper.isGtgPromoCardOnFeatured()) goto _L1; else goto _L3
_L3:
        int i;
        byte byte0;
        byte0 = -1;
        i = 0;
_L5:
        int j;
        j = byte0;
        if (i >= list.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((DealSummary)list.get(i)).secondLevelDealCategories.contains("food-and-drink"))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        j = i + 1;
        if (j == -1) goto _L1; else goto _L4
_L4:
        list = new Finder();
        list.type = "gtg_promo_card_with_defaults";
        list.channel = Channel.FEATURED.toString();
        list.derivedActualPosition = j;
        list.derivedTrackingPosition = j;
        list1.add(j, list);
        return;
        i++;
          goto _L5
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        try
        {
            if (locationBarHeaderItem != null)
            {
                list.add(0, locationBarHeaderItem);
            }
            dealsubsetattribute = new ArrayList();
            dealsubsetattribute.addAll(daoBusiness.queryForEq("channel", dbChannel));
            dealsubsetattribute.addAll(daoFinder.queryForEq("channel", dbChannel));
            dealsubsetattribute.addAll(daoCollection.queryForEq("channel", dbChannel));
            pagination = daoDealSummary.queryForEq("channel", dbChannel);
            dealsubsetattribute.addAll(pagination);
            if (isShowBandCardOnSearch1510USCA && isRapiGlobalSearch)
            {
                processingcontext = daoBand.queryForEq("channel", dbChannel).iterator();
                do
                {
                    if (!processingcontext.hasNext())
                    {
                        break;
                    }
                    Band band = (Band)processingcontext.next();
                    if (Strings.notEmpty(band.message))
                    {
                        dealsubsetattribute.add(band);
                    }
                } while (true);
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        Collections.sort(dealsubsetattribute, CardPositionComparator.INSTANCE);
        addGtgMockCardsWhenNeeded(pagination, dealsubsetattribute);
        list.addAll(dealsubsetattribute);
        return list;
    }

    public void setDbChannel(String s)
    {
        dbChannel = s;
    }

    public void setHeader(LocationBarHeader locationbarheader)
    {
        locationBarHeaderItem = locationbarheader;
    }
}
