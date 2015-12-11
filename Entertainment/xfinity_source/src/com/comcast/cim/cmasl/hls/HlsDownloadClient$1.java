// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsDownloadClient, HlsDownloadResponseHandler, HlsParser

class val.hlsParser
    implements Provider
{

    final HlsDownloadClient this$0;
    final HlsParser val$hlsParser;

    public HlsDownloadResponseHandler get()
    {
        return new HlsDownloadResponseHandler(val$hlsParser);
    }

    public volatile Object get()
    {
        return get();
    }

    andler()
    {
        this$0 = final_hlsdownloadclient;
        val$hlsParser = HlsParser.this;
        super();
    }
}
