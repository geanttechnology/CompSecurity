// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.view.widgetcards.CouponTopItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            Location

public class CouponMerchant extends CouponTopItem
{

    public String channel;
    public String customLogoUrl;
    public String description;
    public String hiresLogoUrl;
    public String homepageUrl;
    public int instoreCouponsCount;
    public String logoUrl;
    protected volatile ArrayList merchantLocationList;
    protected Collection merchantLocations;
    public Date modificationDate;
    public String name;
    public int onlineCouponsCount;
    public Long primaryKey;
    protected String remoteId;
    protected String slug;

    public CouponMerchant()
    {
        name = "";
        slug = "";
        description = "";
        logoUrl = "";
        hiresLogoUrl = "";
        homepageUrl = "";
        instoreCouponsCount = 0;
        onlineCouponsCount = 0;
        customLogoUrl = "";
        merchantLocations = Collections.emptyList();
    }

    public String getImageUrl()
    {
        String s1 = hiresLogoUrl;
        String s = s1;
        if (Strings.isEmpty(s1))
        {
            s = logoUrl;
        }
        return s;
    }

    public List getMerchantLocations()
    {
        if (merchantLocationList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (merchantLocationList == null)
        {
            merchantLocationList = new ArrayList(merchantLocations);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return merchantLocationList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getRemoteId()
    {
        return remoteId;
    }

    public String getSlug()
    {
        if (slug == null)
        {
            return "";
        } else
        {
            return slug;
        }
    }

    public String getTitle()
    {
        return name;
    }

    public void setMerchantLocations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Location)collection.next()).parentCouponMerchant = this;
        }

        merchantLocations = ((Collection) (obj));
    }
}
