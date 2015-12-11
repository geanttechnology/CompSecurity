// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private static final class <init> extends <init>
{

    public String placementID;
    public String promoCguid;
    public String promoPlacementID;

    public com.ebay.common.net.api.rtm.init> getRequest(Context context, String s, String s1)
    {
        return new com.ebay.common.net.api.rtm.init>(context, placementID, promoPlacementID, promoCguid, s, site, NautilusKernel.getAppVersionName(context), s1);
    }

    public boolean validateResult(com.ebay.common.net.api.rtm.ite ite, List list)
    {
        if (list.size() < 1)
        {
            if (AdRtmDataManager.logger.e)
            {
                AdRtmDataManager.logger.e("Empty RTM Home Screen Ad content");
            }
        } else
        {
            if (list.size() > 1)
            {
                if (AdRtmDataManager.logger.e)
                {
                    AdRtmDataManager.logger.e("RTM exceeded absolute max Home Screen Ad instance limit (1)");
                }
                list.subList(1, list.size()).clear();
            }
            if (TextUtils.isEmpty(((com.ebay.common.rtm.tQuery)list.get(0)).tQuery))
            {
                if (AdRtmDataManager.logger.e)
                {
                    AdRtmDataManager.logger.e("RTM Home Screen Ad content is missing adUnitId");
                    return false;
                }
            } else
            {
                return true;
            }
        }
        return false;
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
