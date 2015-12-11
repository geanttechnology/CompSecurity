// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private static final class <init> extends <init>
{

    private static final String APLS_RTM_AD_ERR_DOMAIN = "rtmAdRequest";
    private static final int MAX_ADS_IN_RESPONSE = 10;
    public String categoryId;
    public String keywords;
    public int searchResultCount;

    public com.ebay.common.net.api.rtm.init> getRequest(Context context, String s, String s1)
    {
        return new com.ebay.common.net.api.rtm.t>(context, keywords, searchResultCount, categoryId, s, site, NautilusKernel.getAppVersionName(context), s1);
    }

    public boolean validateResult(com.ebay.common.net.api.rtm.ite ite, List list)
    {
        if (list.size() > 10)
        {
            LogTrackManager.addLogErrorData(new LogTrackError(ite.onName(), ite.onName(), ite.Url().toString(), ite.getClass().toString(), "rtmAdRequest", "rtmAdErrTooManyAds", (Throwable)null));
            if (AdRtmDataManager.logger.l)
            {
                AdRtmDataManager.logger.l(String.format("RTM exceeded absolute max ad instance limit (%d)", new Object[] {
                    Integer.valueOf(10)
                }));
            }
            list.subList(10, list.size()).clear();
        }
        boolean flag1 = ((com.ebay.common.rtm.ble)list.get(0)).ble;
        for (list = list.iterator(); list.hasNext();)
        {
            com.ebay.common.rtm.dQuery dquery = (com.ebay.common.rtm.ble)list.next();
            boolean flag;
            if (dquery.ble == flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                LogTrackManager.addLogErrorData(new LogTrackError(ite.onName(), ite.onName(), ite.Url().toString(), ite.getClass().toString(), "rtmAdRequest", "rtmAdErrMixedModels", (Throwable)null));
                if (AdRtmDataManager.logger.l)
                {
                    AdRtmDataManager.logger.l("RTM Ad content contained mixed ad results");
                }
                return false;
            }
            if (flag1)
            {
                if (!TextUtils.isEmpty(dquery.ble) && dquery.ble != null && dquery.ble != null && !TextUtils.isEmpty(dquery.ing) && !TextUtils.isEmpty(dquery.ing))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (!TextUtils.isEmpty(dquery.ing) && !TextUtils.isEmpty(dquery.ing) && dquery.ing != null && !TextUtils.isEmpty(dquery.ing))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                LogTrackManager.addLogErrorData(new LogTrackError(ite.onName(), ite.onName(), ite.Url().toString(), ite.getClass().toString(), "rtmAdRequest", "rtmAdErrMissingFields", (Throwable)null));
                if (AdRtmDataManager.logger.l)
                {
                    AdRtmDataManager.logger.l("RTM Ad content is missing one or more required fields");
                }
                return false;
            }
        }

        return true;
    }

    private ()
    {
        super(null);
    }

    ( )
    {
        this();
    }
}
