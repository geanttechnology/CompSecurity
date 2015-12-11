// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            KeyValuePair

public class SimilarItemsResponse
{

    private KeyValuePair datasetInfo;
    private List items;
    private int totalCount;

    public SimilarItemsResponse()
    {
    }

    public void setDatasetInfo(KeyValuePair keyvaluepair)
    {
        datasetInfo = keyvaluepair;
    }

    public void setItems(List list)
    {
        items = list;
    }

    public void setTotalCount(int i)
    {
        totalCount = i;
    }
}
