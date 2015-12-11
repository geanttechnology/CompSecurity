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
    Long mProductGLID;

    public ASINData()
    {
    }

    public ASINData(String s, long l)
    {
        mGroupingASIN = s;
        mProductGLID = Long.valueOf(l);
        if (!validate())
        {
            throw new IllegalArgumentException("Grouping ASIN and Product GLID must not be null or empty");
        } else
        {
            return;
        }
    }

    public List getDatapoints()
    {
        ArrayList arraylist = new ArrayList();
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.GROUPING_ASIN.getName(), mGroupingASIN);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PRODUCT_GLID.getName(), mProductGLID.toString());
        return arraylist;
    }

    public String getGroupingASIN()
    {
        return mGroupingASIN;
    }

    public String getProductGLID()
    {
        return mProductGLID.toString();
    }

    public ASINData setGroupingASIN(String s)
    {
        mGroupingASIN = s;
        return this;
    }

    public ASINData setProductGLID(String s)
    {
        try
        {
            mProductGLID = Long.valueOf(Long.parseLong(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    protected boolean validate()
    {
        return mGroupingASIN != null && !mGroupingASIN.isEmpty() && mProductGLID != null;
    }
}
