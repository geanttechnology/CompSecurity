// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            DisneyAsset

public static class gate extends gate
{

    public gate(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        forDisney(s, s1);
        withAssetInfo((new nit>()).thStreamId(s).ild());
        asStreamType(StreamType.LINEAR);
        withCustomDRMKey(s2);
        withDisneyEspnTokenDelegate(disneyespntokendelegate);
    }
}
