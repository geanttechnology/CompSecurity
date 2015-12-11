// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.assets;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaAssetIds;
import java.util.Map;

public class GenericAsset extends AbstractXuaAsset
{

    public GenericAsset(String s, String s1, Map map)
    {
        setAssetType("GenericId");
        setAssetClass(s);
        s = new XuaAssetIds();
        s.setNS(s1);
        s.setOtherIds(map);
        setAssetIds(s);
    }
}
