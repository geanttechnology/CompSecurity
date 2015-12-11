// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo, ClickStreamData, ClickStreamHelper

public class ImpressionTrackingData
    implements ClickStreamInfo
{

    List mImpressionData;
    Map mImpressionMetadata;
    String mImpressionType;
    String mProgramGroup;

    public ImpressionTrackingData()
    {
    }

    public List getDataPoints()
    {
        ArrayList arraylist = new ArrayList();
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IMPRESSION_PROGRAM_GROUP.getName(), mProgramGroup);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IMPRESSION_TYPE.getName(), mImpressionType);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IMPRESSION_DATA.getName(), ClickStreamHelper.listToString(mImpressionData));
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IMPRESSION_METADATA.getName(), ClickStreamHelper.mapToString(mImpressionMetadata));
        return arraylist;
    }

    public List getImpresionData()
    {
        return mImpressionData;
    }

    public Map getImpressionMetadata()
    {
        return mImpressionMetadata;
    }

    public String getImpressionProgramGroup()
    {
        return mProgramGroup;
    }

    public String getImpressionType()
    {
        return mImpressionType;
    }

    public ImpressionTrackingData setImpresionData(List list)
    {
        mImpressionData = list;
        return this;
    }

    public ImpressionTrackingData setImpressionMetadata(Map map)
    {
        mImpressionMetadata = map;
        return this;
    }

    public ImpressionTrackingData setImpressionProgramGroup(String s)
    {
        mProgramGroup = s;
        return this;
    }

    public ImpressionTrackingData setImpressionType(String s)
    {
        mImpressionType = s;
        return this;
    }
}
