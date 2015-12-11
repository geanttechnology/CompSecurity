// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponPagination;
import com.groupon.db.models.CouponSummary;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractPaginatedSyncManagerProcess

public class CouponResultSyncManagerProcess extends AbstractPaginatedSyncManagerProcess
{
    public static class CouponListContainer
    {

        public List coupons;
        public List merchants;
        protected CouponPagination pagination;

        public CouponListContainer()
        {
        }
    }


    protected com.groupon.v3.view.list_view.CouponListItemType.ListItemType couponListItemType;
    protected String couponSlug;
    protected DaoCouponMerchant daoCouponMerchant;
    protected DaoCouponSummary daoCouponSummary;
    protected boolean isCouponMerchant;
    protected com.groupon.activity.CouponInstoreOnlinePage.PageType pageType;

    public CouponResultSyncManagerProcess(Context context, String s, com.groupon.v3.view.list_view.CouponListItemType.ListItemType listitemtype, com.groupon.activity.CouponInstoreOnlinePage.PageType pagetype, String s1, boolean flag)
    {
        super(context, s);
        couponListItemType = listitemtype;
        pageType = pagetype;
        couponSlug = s1;
        isCouponMerchant = flag;
    }

    public int getNextOffset()
        throws Exception
    {
        return getNextOffset(dbChannel);
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo, int i, int j)
    {
        universalinfo = new ArrayList();
        universalinfo.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(i)
        }));
        universalinfo.addAll(Arrays.asList(new Serializable[] {
            "limit", Integer.valueOf(j)
        }));
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[];
            static final int $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[];

            static 
            {
                $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType = new int[com.groupon.activity.CouponInstoreOnlinePage.PageType.values().length];
                try
                {
                    $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[com.groupon.activity.CouponInstoreOnlinePage.PageType.INSTORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[com.groupon.activity.CouponInstoreOnlinePage.PageType.ONLINE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType = new int[com.groupon.v3.view.list_view.CouponListItemType.ListItemType.values().length];
                try
                {
                    $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_MERCHANT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_CATEGORY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.v3.view.list_view.CouponListItemType.ListItemType[couponListItemType.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 155
    //                   2 184;
           goto _L1 _L2 _L3
_L1:
        _cls1..SwitchMap.com.groupon.activity.CouponInstoreOnlinePage.PageType[pageType.ordinal()];
        JVM INSTR tableswitch 1 2: default 124
    //                   1 213
    //                   2 240;
           goto _L4 _L5 _L6
_L4:
        universalinfo.addAll(Arrays.asList(new String[] {
            "view", "android"
        }));
        return universalinfo.toArray();
_L2:
        universalinfo.addAll(Arrays.asList(new String[] {
            "merchant_slug", couponSlug
        }));
          goto _L1
_L3:
        universalinfo.addAll(Arrays.asList(new String[] {
            "categories", couponSlug
        }));
          goto _L1
_L5:
        universalinfo.addAll(Arrays.asList(new String[] {
            "instore_offer", "true"
        }));
          goto _L4
_L6:
        universalinfo.addAll(Arrays.asList(new String[] {
            "online_offer", "true"
        }));
          goto _L4
    }

    public String getSyncUrl(UniversalInfo universalinfo, int i, int j)
    {
        return "https:/freebies/coupons";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoCouponSummary.getLastUpdated(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        inputstream = (CouponListContainer)obj;
        if (((CouponListContainer) (inputstream)).merchants == null || ((CouponListContainer) (inputstream)).coupons == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Coupons Not loaded");
            }
        } else
        {
            if (i == 0)
            {
                daoCouponSummary.deleteByChannelId(dbChannel);
                if (isCouponMerchant)
                {
                    daoCouponMerchant.deleteForChannel(dbChannel);
                    for (obj = ((CouponListContainer) (inputstream)).merchants.iterator(); ((Iterator) (obj)).hasNext(); daoCouponMerchant.saveCouponMerchant(universalinfo))
                    {
                        universalinfo = (CouponMerchant)((Iterator) (obj)).next();
                        universalinfo.channel = dbChannel;
                    }

                }
            }
            daoPagination.deleteByChannelId(dbChannel);
            for (obj = ((CouponListContainer) (inputstream)).coupons.iterator(); ((Iterator) (obj)).hasNext(); daoCouponSummary.save(new CouponSummary(universalinfo, dbChannel)))
            {
                universalinfo = (CouponDetail)((Iterator) (obj)).next();
                universalinfo.afterJsonDeserializationPostProcessor();
            }

            savePagination(dbChannel, i, ((CouponListContainer) (inputstream)).pagination.toPagination(), ((CouponListContainer) (inputstream)).coupons.size());
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/manager/sync_process/CouponResultSyncManagerProcess$CouponListContainer);
    }
}
