// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.assets;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaAssetIds;

public class PAIDAsset extends AbstractXuaAsset
{

    public PAIDAsset(String s, String s1, String s2, String s3)
    {
        setAssetType("PAID");
        setAssetClass(s);
        s = new XuaAssetIds();
        s.setPID(s1);
        s.setAID(s2);
        s.setMediaGUID(s3);
        setAssetIds(s);
    }
}
