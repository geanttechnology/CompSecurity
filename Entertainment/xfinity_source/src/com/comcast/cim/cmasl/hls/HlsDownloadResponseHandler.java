// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.response.StrictHttpStatusCodeHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsParser, HlsPlaylist

public class HlsDownloadResponseHandler extends DelegatingResponseHandler
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/hls/HlsDownloadResponseHandler);
    private HlsPlaylist file;
    private String finalUrl;
    private final HlsParser parser;

    public HlsDownloadResponseHandler(HlsParser hlsparser)
    {
        parser = hlsparser;
        addDelegateHeadersHandler(new StrictHttpStatusCodeHandler());
    }

    public HlsPlaylist getFile()
    {
        return file;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            file = parser.parseStream(inputstream);
            inputstream = finalUrl.substring(0, finalUrl.lastIndexOf('/') + 1);
            file.setUrlPathPrefix(inputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimIOException(inputstream);
        }
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        super.handleResponseHeaders(s, detailedrequeststatus, map);
        finalUrl = s;
    }

}
