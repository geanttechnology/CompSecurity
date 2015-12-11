// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;

import java.util.List;

// Referenced classes of package com.flurry.android.impl.ads.protocol.v13:
//            AdSpaceLayout

public class AdFrame
{

    public String adGuid;
    public AdSpaceLayout adSpaceLayout;
    public long assetExpirationTimestampUTCMillis;
    public int binding;
    public List cacheBlacklistedAssets;
    public List cacheWhitelistedAssets;
    public int cachingEnum;
    public List callbacks;
    public String content;
    public String display;

    public AdFrame()
    {
    }
}
