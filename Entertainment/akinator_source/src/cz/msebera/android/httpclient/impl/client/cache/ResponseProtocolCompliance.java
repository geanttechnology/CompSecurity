// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            IOUtils, WarningValue

class ResponseProtocolCompliance
{

    private static final String UNEXPECTED_100_CONTINUE = "The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.";
    private static final String UNEXPECTED_PARTIAL_CONTENT = "partial content was returned for a request that did not ask for it";

    ResponseProtocolCompliance()
    {
    }

    private boolean backendResponseMustNotHaveBody(HttpRequest httprequest, HttpResponse httpresponse)
    {
        return "HEAD".equals(httprequest.getRequestLine().getMethod()) || httpresponse.getStatusLine().getStatusCode() == 204 || httpresponse.getStatusLine().getStatusCode() == 205 || httpresponse.getStatusLine().getStatusCode() == 304;
    }

    private void consumeBody(HttpResponse httpresponse)
        throws IOException
    {
        httpresponse = httpresponse.getEntity();
        if (httpresponse != null)
        {
            IOUtils.consume(httpresponse);
        }
    }

    private void ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(HttpRequest httprequest, HttpResponse httpresponse)
    {
        while (!httprequest.getRequestLine().getMethod().equalsIgnoreCase("OPTIONS") || httpresponse.getStatusLine().getStatusCode() != 200 || httpresponse.getFirstHeader("Content-Length") != null) 
        {
            return;
        }
        httpresponse.addHeader("Content-Length", "0");
    }

    private void ensure206ContainsDateHeader(HttpResponse httpresponse)
    {
        if (httpresponse.getFirstHeader("Date") == null)
        {
            httpresponse.addHeader("Date", DateUtils.formatDate(new Date()));
        }
    }

    private void ensure304DoesNotContainExtraEntityHeaders(HttpResponse httpresponse)
    {
        int i = 0;
        String as[] = new String[8];
        as[0] = "Allow";
        as[1] = "Content-Encoding";
        as[2] = "Content-Language";
        as[3] = "Content-Length";
        as[4] = "Content-MD5";
        as[5] = "Content-Range";
        as[6] = "Content-Type";
        as[7] = "Last-Modified";
        if (httpresponse.getStatusLine().getStatusCode() == 304)
        {
            for (int j = as.length; i < j; i++)
            {
                httpresponse.removeHeaders(as[i]);
            }

        }
    }

    private void ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(HttpRequest httprequest, HttpResponse httpresponse)
        throws IOException
    {
        if (httprequest.getFirstHeader("Range") != null || httpresponse.getStatusLine().getStatusCode() != 206)
        {
            return;
        } else
        {
            consumeBody(httpresponse);
            throw new ClientProtocolException("partial content was returned for a request that did not ask for it");
        }
    }

    private void identityIsNotUsedInContentEncoding(HttpResponse httpresponse)
    {
        Header aheader[] = httpresponse.getHeaders("Content-Encoding");
        if (aheader != null && aheader.length != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        int k = aheader.length;
        for (int i = 0; i < k; i++)
        {
            Header header = aheader[i];
            Object obj = new StringBuilder();
            boolean flag1 = true;
            HeaderElement aheaderelement[] = header.getElements();
            int l = aheaderelement.length;
            int j = 0;
            while (j < l) 
            {
                HeaderElement headerelement = aheaderelement[j];
                if ("identity".equalsIgnoreCase(headerelement.getName()))
                {
                    flag = true;
                } else
                {
                    if (!flag1)
                    {
                        ((StringBuilder) (obj)).append(",");
                    }
                    ((StringBuilder) (obj)).append(headerelement.toString());
                    flag1 = false;
                }
                j++;
            }
            obj = ((StringBuilder) (obj)).toString();
            if (!"".equals(obj))
            {
                arraylist.add(new BasicHeader("Content-Encoding", ((String) (obj))));
            }
        }

        if (flag)
        {
            httpresponse.removeHeaders("Content-Encoding");
            Iterator iterator = arraylist.iterator();
            while (iterator.hasNext()) 
            {
                httpresponse.addHeader((Header)iterator.next());
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void removeResponseTransferEncoding(HttpResponse httpresponse)
    {
        httpresponse.removeHeaders("TE");
        httpresponse.removeHeaders("Transfer-Encoding");
    }

    private void requestDidNotExpect100ContinueButResponseIsOne(HttpRequestWrapper httprequestwrapper, HttpResponse httpresponse)
        throws IOException
    {
        if (httpresponse.getStatusLine().getStatusCode() == 100)
        {
            if (!((httprequestwrapper = httprequestwrapper.getOriginal()) instanceof HttpEntityEnclosingRequest) || !((HttpEntityEnclosingRequest)httprequestwrapper).expectContinue())
            {
                consumeBody(httpresponse);
                throw new ClientProtocolException("The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.");
            }
        }
    }

    private void transferEncodingIsNotReturnedTo1_0Client(HttpRequestWrapper httprequestwrapper, HttpResponse httpresponse)
    {
        if (httprequestwrapper.getOriginal().getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) >= 0)
        {
            return;
        } else
        {
            removeResponseTransferEncoding(httpresponse);
            return;
        }
    }

    private void warningsWithNonMatchingWarnDatesAreRemoved(HttpResponse httpresponse)
    {
        Date date = DateUtils.parseDate(httpresponse.getFirstHeader("Date").getValue());
        if (date != null) goto _L2; else goto _L1
_L1:
        Header aheader[];
        return;
_L2:
        if ((aheader = httpresponse.getHeaders("Warning")) != null && aheader.length != 0)
        {
            ArrayList arraylist = new ArrayList();
            boolean flag = false;
            int k = aheader.length;
            for (int i = 0; i < k; i++)
            {
                WarningValue awarningvalue[] = WarningValue.getWarningValues(aheader[i]);
                int l = awarningvalue.length;
                int j = 0;
                while (j < l) 
                {
                    WarningValue warningvalue = awarningvalue[j];
                    Date date1 = warningvalue.getWarnDate();
                    if (date1 == null || date1.equals(date))
                    {
                        arraylist.add(new BasicHeader("Warning", warningvalue.toString()));
                    } else
                    {
                        flag = true;
                    }
                    j++;
                }
            }

            if (flag)
            {
                httpresponse.removeHeaders("Warning");
                Iterator iterator = arraylist.iterator();
                while (iterator.hasNext()) 
                {
                    httpresponse.addHeader((Header)iterator.next());
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void ensureProtocolCompliance(HttpRequestWrapper httprequestwrapper, HttpResponse httpresponse)
        throws IOException
    {
        if (backendResponseMustNotHaveBody(httprequestwrapper, httpresponse))
        {
            consumeBody(httpresponse);
            httpresponse.setEntity(null);
        }
        requestDidNotExpect100ContinueButResponseIsOne(httprequestwrapper, httpresponse);
        transferEncodingIsNotReturnedTo1_0Client(httprequestwrapper, httpresponse);
        ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(httprequestwrapper, httpresponse);
        ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(httprequestwrapper, httpresponse);
        ensure206ContainsDateHeader(httpresponse);
        ensure304DoesNotContainExtraEntityHeaders(httpresponse);
        identityIsNotUsedInContentEncoding(httpresponse);
        warningsWithNonMatchingWarnDatesAreRemoved(httpresponse);
    }
}
