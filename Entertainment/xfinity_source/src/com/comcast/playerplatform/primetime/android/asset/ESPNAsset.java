// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            Asset

public class ESPNAsset extends Asset
{
    public static class Builder extends Asset.Builder
    {

        public Builder(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
        {
            forEspn(s, s1);
            withAssetInfo((new AssetInfo.Builder()).withStreamId(s).build());
            asStreamType(StreamType.LINEAR);
            withCustomDRMKey(s2);
            withDisneyEspnTokenDelegate(disneyespntokendelegate);
        }
    }


    public ESPNAsset(String s, String s1, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        this(s, null, s1, disneyespntokendelegate);
    }

    public ESPNAsset(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        super(new Builder(s, s1, s2, disneyespntokendelegate));
    }
}
