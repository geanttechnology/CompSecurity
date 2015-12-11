// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            Rating, Recommendation, Tip, Deal

public class Merchant
{

    public String facebookUrl;
    public boolean isTop;
    public String name;
    public Deal parentDeal;
    public Long primaryKey;
    public String profileHtml;
    public Collection ratings;
    public Collection recommendations;
    public String remoteId;
    public Collection tips;
    public String twitterUrl;
    public String uuid;
    public String websiteUrl;

    public Merchant()
    {
        remoteId = "";
        name = "";
        uuid = "";
        websiteUrl = "";
        facebookUrl = "";
        twitterUrl = "";
        isTop = false;
        profileHtml = "";
        ratings = Collections.emptyList();
        tips = Collections.emptyList();
        recommendations = Collections.emptyList();
    }

    public void setRatings(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Rating)collection.next()).parentMerchant = this;
        }

        ratings = ((Collection) (obj));
    }

    public void setRecommendations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Recommendation)collection.next()).parentMerchant = this;
        }

        recommendations = ((Collection) (obj));
    }

    public void setTips(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Tip)collection.next()).parentMerchant = this;
        }

        tips = ((Collection) (obj));
    }
}
