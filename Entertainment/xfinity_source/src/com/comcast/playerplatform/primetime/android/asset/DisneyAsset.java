// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import android.app.Activity;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            Asset

public class DisneyAsset extends Asset
{
    public static class Builder extends Asset.Builder
    {

        public Builder(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
        {
            forDisney(s, s1);
            withAssetInfo((new AssetInfo.Builder()).withStreamId(s).build());
            asStreamType(StreamType.LINEAR);
            withCustomDRMKey(s2);
            withDisneyEspnTokenDelegate(disneyespntokendelegate);
        }
    }


    private Activity activity;

    public DisneyAsset(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate, Activity activity1)
    {
        super(new Builder(s, s1, s2, disneyespntokendelegate));
        activity = activity1;
    }

    public Activity getActivity()
    {
        return activity;
    }
}
