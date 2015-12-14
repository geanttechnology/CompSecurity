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

    public List getDatapoints()
    {
        ArrayList arraylist = new ArrayList();
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.GROUPING_ASIN.getName(), mGroupingASIN);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.PRODUCT_GLID.getName(), mProductGLID.toString());
        return arraylist;
    }
}
