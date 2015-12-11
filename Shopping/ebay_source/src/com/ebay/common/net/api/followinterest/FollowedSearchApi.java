// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.text.TextUtils;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            InterestDescriptor, SaasSearchRequest

public class FollowedSearchApi
{

    public FollowedSearchApi()
    {
    }

    public static List retrieveFavoriteSearch(EbayContext ebaycontext, String s, EbaySite ebaysite)
    {
        s = FollowedEntityDataManager.getFollowsSynchronous(ebaycontext, s, ebaysite, true, null);
        ebaycontext = new ArrayList();
        if (s != null && !s.getStatus().hasError())
        {
            ebaysite = (Map)s.getData();
            s = new SearchParameters(EbayCountry.getInstance("US"), 25, 0);
            for (ebaysite = ebaysite.entrySet().iterator(); ebaysite.hasNext();)
            {
                Object obj1 = (java.util.Map.Entry)ebaysite.next();
                Object obj = (FollowDescriptor)((java.util.Map.Entry) (obj1)).getKey();
                if (((FollowDescriptor) (obj)).type == FollowType.INTEREST)
                {
                    obj1 = (InterestDescriptor)((java.util.Map.Entry) (obj1)).getValue();
                    SearchParameters searchparameters = ((InterestDescriptor) (obj1)).getSearchParameters(s);
                    obj = new SavedSearch(((FollowDescriptor) (obj)).getInterestTitle(), searchparameters);
                    obj.id = Long.toString(((InterestDescriptor) (obj1)).interestId);
                    obj.query = ((InterestDescriptor) (obj1)).searchUrl.toString();
                    if (!TextUtils.isEmpty(((InterestDescriptor) (obj1)).searchRequest.keyword))
                    {
                        obj.keywords = ((InterestDescriptor) (obj1)).searchRequest.keyword;
                    } else
                    if (!TextUtils.isEmpty(((InterestDescriptor) (obj1)).searchRequest.sellerName))
                    {
                        obj.keywords = ((InterestDescriptor) (obj1)).searchRequest.sellerName;
                    }
                    ebaycontext.add(obj);
                }
            }

        }
        return ebaycontext;
    }

    public static List retrieveFavoriteSearchNotifications(EbayContext ebaycontext, String s, EbaySite ebaysite)
    {
        s = FollowedEntityDataManager.getFollowsSynchronous(ebaycontext, s, ebaysite, false, null);
        ebaycontext = new ArrayList();
        if (s != null && !s.getStatus().hasError())
        {
            s = ((Map)s.getData()).entrySet().iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                ebaysite = (java.util.Map.Entry)s.next();
                Object obj = (FollowDescriptor)ebaysite.getKey();
                if (((FollowDescriptor) (obj)).type == FollowType.INTEREST)
                {
                    obj = ((FollowDescriptor) (obj)).notifications;
                    if (obj != null && ((List) (obj)).contains(com.ebay.common.model.followinterest.FollowDescriptor.NotificationEnum.PUSH))
                    {
                        ebaycontext.add(((FollowDescriptor)ebaysite.getKey()).getInterestId());
                    }
                }
            } while (true);
        }
        return ebaycontext;
    }
}
