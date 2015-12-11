// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class ResponseCachingPolicy
{

    private static final String AUTH_CACHEABLE_PARAMS[] = {
        "s-maxage", "must-revalidate", "public"
    };
    private static final Set cacheableStatuses = new HashSet(Arrays.asList(new Integer[] {
        Integer.valueOf(200), Integer.valueOf(203), Integer.valueOf(300), Integer.valueOf(301), Integer.valueOf(410)
    }));
    public HttpClientAndroidLog log;
    private final long maxObjectSizeBytes;
    private final boolean neverCache1_0ResponsesWithQueryString;
    private final boolean sharedCache;
    private final Set uncacheableStatuses;

    public ResponseCachingPolicy(long l, boolean flag, boolean flag1, boolean flag2)
    {
        log = new HttpClientAndroidLog(getClass());
        maxObjectSizeBytes = l;
        sharedCache = flag;
        neverCache1_0ResponsesWithQueryString = flag1;
        if (flag2)
        {
            uncacheableStatuses = new HashSet(Arrays.asList(new Integer[] {
                Integer.valueOf(206)
            }));
            return;
        } else
        {
            uncacheableStatuses = new HashSet(Arrays.asList(new Integer[] {
                Integer.valueOf(206), Integer.valueOf(303)
            }));
            return;
        }
    }

    private boolean expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(HttpResponse httpresponse)
    {
        if (httpresponse.getFirstHeader("Cache-Control") == null)
        {
            Object obj = httpresponse.getFirstHeader("Expires");
            httpresponse = httpresponse.getFirstHeader("Date");
            if (obj != null && httpresponse != null)
            {
                obj = DateUtils.parseDate(((Header) (obj)).getValue());
                httpresponse = DateUtils.parseDate(httpresponse.getValue());
                if (obj != null && httpresponse != null && (((Date) (obj)).equals(httpresponse) || ((Date) (obj)).before(httpresponse)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean from1_0Origin(HttpResponse httpresponse)
    {
        Header header = httpresponse.getFirstHeader("Via");
        if (header != null)
        {
            HeaderElement aheaderelement[] = header.getElements();
            if (aheaderelement.length < 0)
            {
                httpresponse = aheaderelement[0].toString().split("\\s")[0];
                if (httpresponse.contains("/"))
                {
                    return httpresponse.equals("HTTP/1.0");
                } else
                {
                    return httpresponse.equals("1.0");
                }
            }
        }
        return HttpVersion.HTTP_1_0.equals(httpresponse.getProtocolVersion());
    }

    private boolean requestProtocolGreaterThanAccepted(HttpRequest httprequest)
    {
        return httprequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) > 0;
    }

    private boolean unknownStatusCode(int i)
    {
        while (i >= 100 && i <= 101 || i >= 200 && i <= 206 || i >= 300 && i <= 307 || i >= 400 && i <= 417 || i >= 500 && i <= 505) 
        {
            return false;
        }
        return true;
    }

    protected boolean hasCacheControlParameterFrom(HttpMessage httpmessage, String as[])
    {
        int i;
        int l;
        boolean flag1;
        flag1 = false;
        httpmessage = httpmessage.getHeaders("Cache-Control");
        l = httpmessage.length;
        i = 0;
_L11:
        boolean flag = flag1;
        if (i >= l) goto _L2; else goto _L1
_L1:
        HeaderElement aheaderelement[];
        int j;
        int i1;
        aheaderelement = httpmessage[i].getElements();
        i1 = aheaderelement.length;
        j = 0;
_L9:
        if (j >= i1) goto _L4; else goto _L3
_L3:
        HeaderElement headerelement;
        int k;
        int j1;
        headerelement = aheaderelement[j];
        j1 = as.length;
        k = 0;
_L8:
        if (k >= j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!as[k].equalsIgnoreCase(headerelement.getName())) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        k++;
        if (true) goto _L8; else goto _L7
_L7:
        j++;
          goto _L9
_L4:
        i++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    protected boolean isExplicitlyCacheable(HttpResponse httpresponse)
    {
        if (httpresponse.getFirstHeader("Expires") != null)
        {
            return true;
        } else
        {
            return hasCacheControlParameterFrom(httpresponse, new String[] {
                "max-age", "s-maxage", "must-revalidate", "proxy-revalidate", "public"
            });
        }
    }

    protected boolean isExplicitlyNonCacheable(HttpResponse httpresponse)
    {
        int i;
        int k;
        boolean flag1;
        flag1 = false;
        httpresponse = httpresponse.getHeaders("Cache-Control");
        k = httpresponse.length;
        i = 0;
_L8:
        boolean flag = flag1;
        if (i >= k) goto _L2; else goto _L1
_L1:
        HeaderElement aheaderelement[];
        int j;
        int l;
        aheaderelement = httpresponse[i].getElements();
        l = aheaderelement.length;
        j = 0;
_L6:
        HeaderElement headerelement;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        headerelement = aheaderelement[j];
        if (!"no-store".equals(headerelement.getName()) && !"no-cache".equals(headerelement.getName()) && (!sharedCache || !"private".equals(headerelement.getName()))) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        return flag;
_L4:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean isResponseCacheable(HttpRequest httprequest, HttpResponse httpresponse)
    {
        if (!requestProtocolGreaterThanAccepted(httprequest)) goto _L2; else goto _L1
_L1:
        log.debug("Response was not cacheable.");
_L4:
        return false;
_L2:
        if (hasCacheControlParameterFrom(httprequest, new String[] {
            "no-store"
        })) goto _L4; else goto _L3
_L3:
        if (httprequest.getRequestLine().getUri().contains("?"))
        {
            if (neverCache1_0ResponsesWithQueryString && from1_0Origin(httpresponse))
            {
                log.debug("Response was not cacheable as it had a query string.");
                return false;
            }
            if (!isExplicitlyCacheable(httpresponse))
            {
                log.debug("Response was not cacheable as it is missing explicit caching headers.");
                return false;
            }
        }
        if (expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(httpresponse)) goto _L4; else goto _L5
_L5:
        Header aheader[];
        if (!sharedCache)
        {
            break; /* Loop/switch isn't completed */
        }
        aheader = httprequest.getHeaders("Authorization");
        if (aheader != null && aheader.length > 0 && !hasCacheControlParameterFrom(httpresponse, AUTH_CACHEABLE_PARAMS)) goto _L4; else goto _L6
_L6:
        return isResponseCacheable(httprequest.getRequestLine().getMethod(), httpresponse);
    }

    public boolean isResponseCacheable(String s, HttpResponse httpresponse)
    {
        boolean flag = false;
        if (!"GET".equals(s))
        {
            log.debug("Response was not cacheable.");
            return false;
        }
        int i = httpresponse.getStatusLine().getStatusCode();
        if (cacheableStatuses.contains(Integer.valueOf(i)))
        {
            flag = true;
        } else
        {
            if (uncacheableStatuses.contains(Integer.valueOf(i)))
            {
                return false;
            }
            if (unknownStatusCode(i))
            {
                return false;
            }
        }
        s = httpresponse.getFirstHeader("Content-Length");
        if (s != null && (long)Integer.parseInt(s.getValue()) > maxObjectSizeBytes)
        {
            return false;
        }
        if (httpresponse.getHeaders("Age").length > 1)
        {
            return false;
        }
        if (httpresponse.getHeaders("Expires").length > 1)
        {
            return false;
        }
        s = httpresponse.getHeaders("Date");
        if (s.length != 1)
        {
            return false;
        }
        if (DateUtils.parseDate(s[0].getValue()) == null)
        {
            return false;
        }
        s = httpresponse.getHeaders("Vary");
        int l = s.length;
        for (int j = 0; j < l; j++)
        {
            HeaderElement aheaderelement[] = s[j].getElements();
            int i1 = aheaderelement.length;
            for (int k = 0; k < i1; k++)
            {
                if ("*".equals(aheaderelement[k].getName()))
                {
                    return false;
                }
            }

        }

        if (isExplicitlyNonCacheable(httpresponse))
        {
            return false;
        }
        return flag || isExplicitlyCacheable(httpresponse);
    }

}
