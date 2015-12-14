// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import java.util.Map;

// Referenced classes of package com.millennialmedia.internal:
//            Handshake

public static class sdkEnabled
{

    public volatile String activePlaylistServerBaseUrl;
    public volatile String activePlaylistServerName;
    public volatile int clientMediationTimeout;
    public volatile String config;
    public volatile int exchangeTimeout;
    public volatile String handshakeBaseUrl;
    public volatile int handshakeTtl;
    public volatile int inlineTimeout;
    public volatile int interstitialExpirationDuration;
    public volatile int interstitialTimeout;
    public volatile int minInlineRefreshRate;
    public volatile int nativeExpirationDuration;
    public volatile int nativeTimeout;
    public volatile Map nativeTypeDefinitions;
    public volatile String reportingBaseUrl;
    public volatile int reportingBatchFrequency;
    public volatile int reportingBatchSize;
    public volatile boolean sdkEnabled;
    public volatile int serverToServerTimeout;
    public volatile int vastVideoSkipOffsetMax;
    public volatile int vastVideoSkipOffsetMin;
    public volatile String version;

    public ()
    {
        sdkEnabled = true;
    }
}
