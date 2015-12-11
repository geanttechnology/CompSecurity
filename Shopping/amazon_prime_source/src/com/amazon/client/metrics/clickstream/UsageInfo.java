// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import com.amazon.client.metrics.DataPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo, ASINData, ClickStreamData, ClickStreamHelper

public class UsageInfo
    implements ClickStreamInfo
{

    ASINData mASINData;
    long mCustomerID;
    Map mDatapoints;
    String mHitType;
    Boolean mIsCustomerHit;
    Boolean mIsPrimeCustomer;
    String mPageAction;
    String mPageAssemblyType;
    String mPageType;
    String mPageTypeID;
    String mSiteVariant;
    String mSubPageType;
    String mTabID;
    String mTeamName;

    public UsageInfo(String s, String s1, String s2, String s3)
    {
        validateString("Page Type", s);
        validateString("Hit Type", s1);
        validateString("Team Name", s2);
        validateString("Site Variant", s3);
        mPageType = s;
        mHitType = s1;
        mTeamName = s2;
        mSiteVariant = s3;
        mDatapoints = new HashMap();
    }

    private void addAsinDataPoints(List list)
    {
        if (list != null && !list.isEmpty() && !isASINDataEmpty(mASINData))
        {
            if (mPageTypeID != null)
            {
                if (!mPageTypeID.isEmpty());
            }
            Iterator iterator = mASINData.getDatapoints().iterator();
            while (iterator.hasNext()) 
            {
                list.add((DataPoint)iterator.next());
            }
        }
    }

    private void addInitialDataPoints(List list)
    {
        ClickStreamHelper.addDatapoint(list, ClickStreamData.PAGE_TYPE.getName(), mPageType);
        ClickStreamHelper.addDatapoint(list, ClickStreamData.HIT_TYPE.getName(), mHitType);
        ClickStreamHelper.addDatapoint(list, ClickStreamData.TEAM_NAME.getName(), mTeamName);
        ClickStreamHelper.addDatapoint(list, ClickStreamData.SITE_VARIANT.getName(), mSiteVariant);
    }

    private boolean isASINDataEmpty(ASINData asindata)
    {
        if (mASINData != null)
        {
            boolean flag;
            if (asindata.mGroupingASIN == null || asindata.mGroupingASIN.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag || asindata.mProductGLID != null)
            {
                return false;
            }
        }
        return true;
    }

    private void validateString(String s, String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException(String.format("%s cannot be null or empty", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    public ASINData getASINData()
    {
        return mASINData;
    }

    public List getDataPoints()
    {
        ArrayList arraylist = new ArrayList();
        addInitialDataPoints(arraylist);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PAGE_ACTION.getName(), mPageAction);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.SUB_PAGE_TYPE.getName(), mSubPageType);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PAGE_TYPE_ID.getName(), mPageTypeID);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.TAB_ID.getName(), mTabID);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PAGE_ASSEMBLY_TYPE.getName(), mPageAssemblyType);
        if (mIsCustomerHit != null)
        {
            ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IS_CUSTOMER_HIT.getName(), mIsCustomerHit.toString());
        }
        if (mIsPrimeCustomer != null)
        {
            ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IS_PRIME_CUSTOMER.getName(), mIsPrimeCustomer.toString());
        }
        addAsinDataPoints(arraylist);
        return arraylist;
    }

    public String getHitType()
    {
        return mHitType;
    }

    public String getPageAction()
    {
        return mPageAction;
    }

    public String getPageAssemblyType()
    {
        return mPageAssemblyType;
    }

    public String getPageType()
    {
        return mPageType;
    }

    public String getPageTypeID()
    {
        return mPageTypeID;
    }

    public String getSiteVariant()
    {
        return mSiteVariant;
    }

    public String getSubPageType()
    {
        return mSubPageType;
    }

    public String getTabID()
    {
        return mTabID;
    }

    public String getTeamName()
    {
        return mTeamName;
    }

    public boolean isCustomerHit()
    {
        return mIsCustomerHit.booleanValue();
    }

    public boolean isPrimeCustomer()
    {
        return mIsPrimeCustomer.booleanValue();
    }

    public UsageInfo setASINData(ASINData asindata)
    {
        mASINData = asindata;
        return this;
    }

    public UsageInfo setASINData(String s, Long long1)
    {
        mASINData = new ASINData(s, long1.longValue());
        return this;
    }

    public UsageInfo setIsCustomerHit(boolean flag)
    {
        mIsCustomerHit = Boolean.valueOf(flag);
        return this;
    }

    public UsageInfo setIsPrimeCustomer(boolean flag)
    {
        mIsPrimeCustomer = Boolean.valueOf(flag);
        return this;
    }

    public UsageInfo setPageAction(String s)
    {
        mPageAction = s;
        return this;
    }

    public UsageInfo setPageAssemblyType(String s)
    {
        mPageAssemblyType = s;
        return this;
    }

    public UsageInfo setPageTypeID(String s)
    {
        mPageTypeID = s;
        return this;
    }

    public UsageInfo setSubPageType(String s)
    {
        mSubPageType = s;
        return this;
    }

    public UsageInfo setTabID(String s)
    {
        mTabID = s;
        return this;
    }
}
