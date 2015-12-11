// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamData, ClickStreamHelper

public class ASINData
{

    String mGroupingASIN;
    String mProductGLID;

    public ASINData()
    {
    }

    public List getDatapoints()
    {
        ArrayList arraylist = new ArrayList();
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.GROUPING_ASIN.getName(), mGroupingASIN);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PRODUCT_GLID.getName(), mProductGLID);
        return arraylist;
    }

    public String getGroupingASIN()
    {
        return mGroupingASIN;
    }

    public String getProductGLID()
    {
        return mProductGLID;
    }

    public ASINData setGroupingASIN(String s)
    {
        mGroupingASIN = s;
        return this;
    }

    public ASINData setProductGLID(String s)
    {
        mProductGLID = s;
        return this;
    }
}
