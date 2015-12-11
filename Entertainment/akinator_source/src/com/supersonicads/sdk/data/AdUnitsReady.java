// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAObj

public class AdUnitsReady extends SSAObj
{

    private static String FIRST_CAMPAIGN_CREDITS = "firstCampaignCredits";
    private static String NUM_OF_AD_UNITS = "numOfAdUnits";
    private static String PRODUCT_TYPE = "productType";
    private static String TOTAL_NUMBER_CREDITS = "totalNumberCredits";
    private static String TYPE = "type";
    private String mFirstCampaignCredits;
    private String mNumOfAdUnits;
    private boolean mNumOfAdUnitsExist;
    private String mProductType;
    private String mTotalNumberCredits;
    private String mType;

    public AdUnitsReady(String s)
    {
        super(s);
        if (containsKey(TYPE))
        {
            setType(getString(TYPE));
        }
        if (containsKey(NUM_OF_AD_UNITS))
        {
            setNumOfAdUnits(getString(NUM_OF_AD_UNITS));
            setNumOfAdUnitsExist(true);
        } else
        {
            setNumOfAdUnitsExist(false);
        }
        if (containsKey(FIRST_CAMPAIGN_CREDITS))
        {
            setFirstCampaignCredits(getString(FIRST_CAMPAIGN_CREDITS));
        }
        if (containsKey(TOTAL_NUMBER_CREDITS))
        {
            setTotalNumberCredits(getString(TOTAL_NUMBER_CREDITS));
        }
        if (containsKey(PRODUCT_TYPE))
        {
            setProductType(getString(PRODUCT_TYPE));
        }
    }

    private void setNumOfAdUnitsExist(boolean flag)
    {
        mNumOfAdUnitsExist = flag;
    }

    public String getFirstCampaignCredits()
    {
        return mFirstCampaignCredits;
    }

    public String getNumOfAdUnits()
    {
        return mNumOfAdUnits;
    }

    public String getProductType()
    {
        return mProductType;
    }

    public String getTotalNumberCredits()
    {
        return mTotalNumberCredits;
    }

    public String getType()
    {
        return mType;
    }

    public boolean isNumOfAdUnitsExist()
    {
        return mNumOfAdUnitsExist;
    }

    public void setFirstCampaignCredits(String s)
    {
        mFirstCampaignCredits = s;
    }

    public void setNumOfAdUnits(String s)
    {
        mNumOfAdUnits = s;
    }

    public void setProductType(String s)
    {
        mProductType = s;
    }

    public void setTotalNumberCredits(String s)
    {
        mTotalNumberCredits = s;
    }

    public void setType(String s)
    {
        mType = s;
    }

}
