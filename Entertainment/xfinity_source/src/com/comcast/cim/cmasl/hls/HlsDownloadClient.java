// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsDownloadResponseHandler, HlsParser, HlsPlaylist

public class HlsDownloadClient
{

    HttpService downloadHttpService;
    final RequestProviderFactory requestProviderFactory;

    public HlsDownloadClient(HttpService httpservice, RequestProviderFactory requestproviderfactory)
    {
        downloadHttpService = httpservice;
        requestProviderFactory = requestproviderfactory;
    }

    public HlsPlaylist downloadHlsFile(String s, HlsParser hlsparser)
    {
        return downloadHlsFile(s, hlsparser, null);
    }

    public HlsPlaylist downloadHlsFile(String s, final HlsParser hlsParser, Map map)
    {
        s = requestProviderFactory.create(s);
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); s.addHeader((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        return ((HlsDownloadResponseHandler)downloadHttpService.executeRequest(s, new Provider() {

            final HlsDownloadClient this$0;
            final HlsParser val$hlsParser;

            public HlsDownloadResponseHandler get()
            {
                return new HlsDownloadResponseHandler(hlsParser);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = HlsDownloadClient.this;
                hlsParser = hlsparser;
                super();
            }
        })).getFile();
    }
}
