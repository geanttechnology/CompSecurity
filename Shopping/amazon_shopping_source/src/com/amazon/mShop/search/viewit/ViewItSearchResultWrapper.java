// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ResultWrapper

public class ViewItSearchResultWrapper extends ResultWrapper
{

    private String mDeletedAsin;
    private boolean mIsRecentlyScanned;
    private List mSearchResults;

    public ViewItSearchResultWrapper(String s, List list, String s1, Date date, boolean flag)
    {
        super(s, date);
        mIsRecentlyScanned = false;
        mSearchResults = list;
        mDeletedAsin = s1;
        mIsRecentlyScanned = flag;
    }

    public List getAsinList()
    {
        ArrayList arraylist = null;
        if (!Util.isEmpty(mSearchResults))
        {
            ArrayList arraylist1 = new ArrayList();
            Iterator iterator = mSearchResults.iterator();
            do
            {
                arraylist = arraylist1;
                if (!iterator.hasNext())
                {
                    break;
                }
                arraylist1.add(((SearchResult)iterator.next()).getBasicProduct().getAsin());
            } while (true);
        }
        return arraylist;
    }

    public String getDeletedAsin()
    {
        return mDeletedAsin;
    }

    public String getLatestScannedOutput(String s)
    {
        if (Util.isEmpty(s))
        {
            s = getSeriesAsinString();
        }
        if (!Util.isEmpty(s))
        {
            if (getResultType().equals(ResultWrapper.ResultType.IMAGE))
            {
                return (new StringBuilder()).append(getResultType().getTypeValue()).append(s).toString();
            } else
            {
                return getOriginalScannedOutput();
            }
        } else
        {
            return null;
        }
    }

    public List getSearchResults()
    {
        return mSearchResults;
    }

    public String getSeriesAsinString()
    {
        Object obj = null;
        String s = null;
        if (!Util.isEmpty(mSearchResults))
        {
            Iterator iterator = mSearchResults.iterator();
            do
            {
                obj = s;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (SearchResult)iterator.next();
                if (s != null)
                {
                    s = (new StringBuilder()).append(s).append(",").append(((SearchResult) (obj)).getBasicProduct().getAsin()).toString();
                } else
                {
                    s = ((SearchResult) (obj)).getBasicProduct().getAsin();
                }
            } while (true);
        }
        return ((String) (obj));
    }

    public boolean isRecentlyScanned()
    {
        return mIsRecentlyScanned;
    }

    public void setDeletedAsin(String s)
    {
        mDeletedAsin = s;
    }

    public void setRecentlyScanned(boolean flag)
    {
        mIsRecentlyScanned = flag;
    }
}
