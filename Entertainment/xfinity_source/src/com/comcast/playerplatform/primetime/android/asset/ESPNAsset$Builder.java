// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            ESPNAsset

public static class legate extends legate
{

    public legate(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        forEspn(s, s1);
        withAssetInfo((new <init>()).withStreamId(s).build());
        asStreamType(StreamType.LINEAR);
        withCustomDRMKey(s2);
        withDisneyEspnTokenDelegate(disneyespntokendelegate);
    }
}
