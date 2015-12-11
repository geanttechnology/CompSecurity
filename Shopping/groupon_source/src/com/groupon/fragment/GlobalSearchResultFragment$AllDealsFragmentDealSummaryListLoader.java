// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.abtest.MerchantSpecialsAbTestHelper;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.Business;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import com.groupon.service.core.AbTestService;
import com.groupon.util.CollectionUtils;
import com.groupon.util.DealCardListUtils;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            DealCardListLoader, GlobalSearchResultFragment

protected static class merchantSpecialsAbTestHelper extends DealCardListLoader
{

    private AbTestService abTestService;
    private DaoBusiness businessDao;
    private DealCardListUtils dealCardListUtils;
    private int firstPageSize;
    private GlobalSearchResultFragment globalSearchResultFragment;
    private boolean isShowExactMatchMerchant1410USCAmatchAbove;
    private boolean isShowExactMatchMerchant1410USCAmatchBelow;
    private boolean isShowExactMatchMerchant1410USCAmatchNoDeals;
    private MerchantSpecialsAbTestHelper merchantSpecialsAbTestHelper;
    private boolean merchantSpecialsEnabledDivisions;
    private String otherDealChannel;

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        ArrayList arraylist;
        Pagination pagination;
        int l;
        if (GlobalSearchResultFragment.access$100(globalSearchResultFragment) == 0)
        {
            return null;
        }
        Object obj1;
        DealSubsetAttribute dealsubsetattribute;
        Object obj2;
        List list;
        DealSubsetAttribute dealsubsetattribute1;
        int i;
        int j;
        int k;
        boolean flag;
        try
        {
            list = dealSummaryDao.queryForEq("channel", pagerChannelAndSubchannel);
            pagination = (Pagination)CollectionUtils.getFirstItem(paginationDao.queryForEq("channel", pagerChannelAndSubchannel), null);
            dealsubsetattribute1 = (DealSubsetAttribute)CollectionUtils.getFirstItem(dealSubsetAttributeDao.queryForEq("channel", pagerChannelAndSubchannel), null);
            obj = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        obj2 = null;
        arraylist = new ArrayList();
        i = 0;
        k = 0;
        j = 0;
        l = 0;
        dealsubsetattribute = obj2;
        obj1 = obj;
        if (pagination == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        if (pagination.hasMorePages())
        {
            k = pagination.getCount();
            l = pagination.getCurrentOffset();
        }
        flag = getContext().getResources().getBoolean(0x7f090007);
        i = k;
        j = l;
        dealsubsetattribute = obj2;
        obj1 = obj;
        if (k > firstPageSize)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        i = k;
        j = l;
        dealsubsetattribute = obj2;
        obj1 = obj;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        obj1 = dealSummaryDao.queryForEq("channel", otherDealChannel);
        dealsubsetattribute = (DealSubsetAttribute)CollectionUtils.getFirstItem(dealSubsetAttributeDao.queryForEq("channel", otherDealChannel), null);
        j = l;
        i = k;
        l = i;
        k = j;
        if (pagination == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        l = i;
        k = j;
        if (pagination.hasMorePages())
        {
            l = pagination.getCount();
            k = pagination.getCurrentOffset();
        }
        obj = arraylist;
        if (pagination == null) goto _L2; else goto _L1
_L1:
        obj = arraylist;
        if (!merchantSpecialsEnabledDivisions) goto _L2; else goto _L3
_L3:
        if (l != 0) goto _L5; else goto _L4
_L4:
        if (isShowExactMatchMerchant1410USCAmatchNoDeals) goto _L6; else goto _L5
_L5:
        if (isShowExactMatchMerchant1410USCAmatchAbove) goto _L6; else goto _L7
_L7:
        obj = arraylist;
        if (!isShowExactMatchMerchant1410USCAmatchBelow) goto _L2; else goto _L6
_L6:
        if (l != 0) goto _L9; else goto _L8
_L8:
        if (isShowExactMatchMerchant1410USCAmatchNoDeals) goto _L10; else goto _L9
_L9:
        if (!isShowExactMatchMerchant1410USCAmatchAbove) goto _L11; else goto _L10
_L10:
        obj = businessDao.queryBuilder().where().eq("channel", pagerChannelAndSubchannel).and().eq("isExactMatch", Boolean.valueOf(true));
        obj = (Business)businessDao.queryForFirst(((Where) (obj)).prepare());
        if (obj == null) goto _L13; else goto _L12
_L12:
        if (!((Business) (obj)).isExactMatch || pagination.getNextOffset() >= l) goto _L13; else goto _L14
_L14:
        arraylist.add(obj);
        obj = arraylist;
_L2:
        obj = new businessDao(list, new EndlessList(((List) (obj1)), ((List) (obj1)).size(), ((List) (obj1)).size(), dealsubsetattribute), new EndlessList(((List) (obj)), ((List) (obj)).size(), ((List) (obj)).size(), null), l, k, dealsubsetattribute1);
        return ((List) (obj));
_L13:
        obj = arraylist;
        if (pagination.getNextOffset() < l) goto _L2; else goto _L15
_L15:
        obj = businessDao.queryForEq("channel", pagerChannelAndSubchannel);
          goto _L2
_L11:
        obj = arraylist;
        if (!isShowExactMatchMerchant1410USCAmatchBelow) goto _L2; else goto _L16
_L16:
        obj = arraylist;
        if (pagination.getNextOffset() < l) goto _L2; else goto _L17
_L17:
        obj = businessDao.queryForEq("channel", pagerChannelAndSubchannel);
          goto _L2
    }

    protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
    {
        boolean flag = Strings.equals(channelupdateevent.getChannel(), pagerChannelAndSubchannel);
        if (flag)
        {
            GlobalSearchResultFragment.access$102(globalSearchResultFragment, 1);
        }
        return flag;
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((ChannelUpdateEvent)updateevent);
    }

    public (Class class1, Class class2, Context context, String s, GlobalSearchResultFragment globalsearchresultfragment)
    {
        super(class1, class2, context, s);
        globalSearchResultFragment = globalsearchresultfragment;
        otherDealChannel = GlobalSearchResultFragment.access$000(globalsearchresultfragment);
        firstPageSize = dealCardListUtils.getFirstPageSize();
        isShowExactMatchMerchant1410USCAmatchNoDeals = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchNoDeals");
        isShowExactMatchMerchant1410USCAmatchAbove = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchAbove");
        isShowExactMatchMerchant1410USCAmatchBelow = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchBelow");
        class1 = globalsearchresultfragment.getGlobalSearchResultActivity().getPlace();
        merchantSpecialsEnabledDivisions = merchantSpecialsAbTestHelper.isMerchantSpecialsEnabled(class1);
    }
}
