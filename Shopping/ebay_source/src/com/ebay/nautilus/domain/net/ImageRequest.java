// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ImageResponse

public final class ImageRequest extends Request
{

    private final boolean fetchAsBytes;
    private final URL url;

    public ImageRequest(URI uri)
        throws MalformedURLException
    {
        this(uri.toURL());
    }

    public ImageRequest(URL url1)
    {
        this(url1, false);
    }

    public ImageRequest(URL url1, boolean flag)
    {
        super("Image", parseOperationName(url1));
        url = url1;
        fetchAsBytes = flag;
    }

    public static String parseOperationName(URL url1)
    {
        String s = url1.getHost();
        String s1 = url1.getPath();
        url1 = s;
        if (s.contains(".ebaystatic.com"))
        {
            url1 = s;
            if (s1.startsWith("/d/"))
            {
                String as[] = s1.split("/");
                url1 = s;
                if (as.length >= 3)
                {
                    url1 = new StringBuilder(s);
                    for (int i = 1; i < 3; i++)
                    {
                        url1.append((new StringBuilder()).append("/").append(as[i]).toString());
                    }

                    url1 = url1.toString();
                }
            }
        }
        return url1;
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public ImageResponse getResponse()
    {
        return new ImageResponse(fetchAsBytes);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }

    public boolean isTrafficReportable()
    {
        return LogTrackManager.getConfig().isAplsImageLoadingTraffic();
    }
}
