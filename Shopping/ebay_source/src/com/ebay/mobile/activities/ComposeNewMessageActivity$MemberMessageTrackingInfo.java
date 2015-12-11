// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.activities:
//            ComposeNewMessageActivity

public static class primaryCategoryId extends BaseDataMapped
    implements Parcelable
{

    public static android.os.ageTrackingInfo.siteId CREATOR = new android.os.Parcelable.Creator() {

        public ComposeNewMessageActivity.MemberMessageTrackingInfo createFromParcel(Parcel parcel)
        {
            return (ComposeNewMessageActivity.MemberMessageTrackingInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageTrackingInfo);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ComposeNewMessageActivity.MemberMessageTrackingInfo[] newArray(int i)
        {
            return new ComposeNewMessageActivity.MemberMessageTrackingInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String askSellerExperimentState;
    private String currentPrice;
    private Map messageTagInfo;
    private String primaryCategoryId;
    private SourceIdentification sid;
    private String siteId;

    public String getAskSellerExperimentState()
    {
        return askSellerExperimentState;
    }

    public String getCurrentPrice()
    {
        return currentPrice;
    }

    public Map getMessageTag()
    {
        return messageTagInfo;
    }

    public String getPrimaryCategoryId()
    {
        return primaryCategoryId;
    }

    public SourceIdentification getSid()
    {
        return sid;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public siteId setAskSellerExperimentState(String s)
    {
        askSellerExperimentState = s;
        return this;
    }

    public void setCurrentPrice(String s)
    {
        currentPrice = s;
    }

    public void setMessageTag(Map map)
    {
        messageTagInfo = map;
    }

    public void setPrimaryCategoryId(String s)
    {
        primaryCategoryId = s;
    }

    public void setSid(SourceIdentification sourceidentification)
    {
        sid = sourceidentification;
    }

    public void setSiteId(String s)
    {
        siteId = s;
    }



    public _cls1()
    {
    }

    public _cls1(String s, String s1, String s2)
    {
        currentPrice = s;
        siteId = s1;
        primaryCategoryId = s2;
    }
}
