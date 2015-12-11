// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.assets;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaAssetIds;

public class RecordingAsset extends AbstractXuaAsset
{

    public RecordingAsset(String s)
    {
        setAssetType("RecordingId");
        setAssetClass("cDVR");
        XuaAssetIds xuaassetids = new XuaAssetIds();
        xuaassetids.setRECID(s);
        setAssetIds(xuaassetids);
    }
}
