// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaAssetIds, AnalyticsAssetInfo

public abstract class AbstractXuaAsset
{

    private String assetClass;
    private XuaAssetIds assetIds;
    private AnalyticsAssetInfo assetInfo;
    private AbstractXuaAsset assetParent;
    private String assetType;

    public AbstractXuaAsset()
    {
    }

    public String getAssetClass()
    {
        return assetClass;
    }

    public XuaAssetIds getAssetIds()
    {
        return assetIds;
    }

    public AnalyticsAssetInfo getAssetInfo()
    {
        return assetInfo;
    }

    public AbstractXuaAsset getAssetParent()
    {
        return assetParent;
    }

    public String getAssetType()
    {
        return assetType;
    }

    public void setAssetClass(String s)
    {
        assetClass = s;
    }

    public void setAssetIds(XuaAssetIds xuaassetids)
    {
        assetIds = xuaassetids;
    }

    public void setAssetInfo(AnalyticsAssetInfo analyticsassetinfo)
    {
        assetInfo = analyticsassetinfo;
    }

    public void setAssetParent(AbstractXuaAsset abstractxuaasset)
    {
        assetParent = abstractxuaasset;
    }

    public void setAssetType(String s)
    {
        assetType = s;
    }
}
