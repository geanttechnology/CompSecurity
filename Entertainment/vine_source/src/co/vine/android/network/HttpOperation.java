// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import android.util.Log;
import co.vine.android.client.VineAPI;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.MeasureInputStream;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

// Referenced classes of package co.vine.android.network:
//            HttpResult, DefaultHttpOperationReader, HttpOperationClient, HttpOperationReader

public class HttpOperation
{

    private static final int DEFAULT_AUTH_RETRIES = 1;
    private static final HttpOperationReader DEFAULT_READER = new DefaultHttpOperationReader();
    public static final int DEFAULT_RETRIES = 0;
    private static final HttpResult EMPTY_RESULTS[] = new HttpResult[0];
    public static final String FORM_URLENCODED_HEADER = "application/x-www-form-urlencoded";
    private static final String HEADER_DATE = "Date";
    public static final int HIGH_PRIORITY_RETRIES = 1;
    public static final int HTTP_MULTIPLE_REDIRECT = 300;
    public static final int HTTP_OK = 200;
    private static final boolean LOGGABLE;
    public static double RATE_LIMIT_BYTES_PER_MS = 0D;
    private static final String TAG = "HttpOperation";
    public static final String USER_AGENT_STRING = System.getProperty("http.agent");
    private static final String X_RATELIMIT_LIMIT = "X-RateLimit-Limit";
    private static final String X_RATELIMIT_REMAINING = "X-RateLimit-Remaining";
    private static final String X_RATELIMIT_RESET = "X-RateLimit-Reset";
    public static final AtomicLong sTimeOffset = new AtomicLong(0L);
    public Exception exception;
    private final HttpClient mHttpClient;
    private final HttpRequestBase mHttpRequest;
    private final HttpOperationReader mReader;
    private HttpResult mResults[];
    public int statusCode;
    public String statusPhrase;
    public String uploadKey;

    public HttpOperation(HttpOperationClient httpoperationclient, HttpRequestBase httprequestbase, HttpOperationReader httpoperationreader, VineAPI vineapi)
    {
        httprequestbase.addHeader("Accept-Encoding", "gzip");
        httprequestbase.addHeader("User-Agent", USER_AGENT_STRING);
        if (vineapi != null)
        {
            vineapi.addClientHeaders(httprequestbase);
        }
        mHttpClient = httpoperationclient.getHttpClient();
        mHttpRequest = httprequestbase;
        if (httpoperationreader == null)
        {
            mReader = DEFAULT_READER;
            return;
        } else
        {
            mReader = httpoperationreader;
            return;
        }
    }

    public static HttpOperation createBasicAuthDeleteRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HttpOperationReader httpoperationreader)
    {
        httpoperationclient = new HttpOperation(httpoperationclient, new HttpDelete(stringbuilder.toString()), httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        return httpoperationclient;
    }

    public static HttpOperation createBasicAuthDeleteRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HttpOperationReader httpoperationreader, String s)
    {
        httpoperationclient = new HttpOperation(httpoperationclient, new HttpDelete(stringbuilder.toString()), httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient, s);
        return httpoperationclient;
    }

    public static HttpOperation createBasicAuthGetRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HttpOperationReader httpoperationreader)
    {
        httpoperationclient = new HttpOperation(httpoperationclient, new HttpGet(stringbuilder.toString()), httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        return httpoperationclient;
    }

    public static HttpOperation createBasicAuthGetRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HttpOperationReader httpoperationreader, String s)
    {
        httpoperationclient = new HttpOperation(httpoperationclient, new HttpGet(stringbuilder.toString()), httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient, s);
        return httpoperationclient;
    }

    public static HttpOperation createBasicAuthJsonPostRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HashMap hashmap, HttpOperationReader httpoperationreader)
    {
        httpoperationclient = createPostRequest(httpoperationclient, stringbuilder, hashmap, httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        vineapi.addContentTypeHeader(httpoperationclient, "application/json");
        return httpoperationclient;
    }

    public static transient HttpOperation createBasicAuthPostRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, ArrayList arraylist, HttpOperationReader httpoperationreader, String as[])
    {
        httpoperationclient = createPostRequest(httpoperationclient, stringbuilder, arraylist, httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            vineapi.addContentTypeHeader(httpoperationclient, as[i]);
        }

        return httpoperationclient;
    }

    public static HttpOperation createBasicAuthPutRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, ArrayList arraylist, HttpOperationReader httpoperationreader)
    {
        stringbuilder = new HttpPut(stringbuilder.toString());
        if (arraylist != null)
        {
            try
            {
                stringbuilder.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                arraylist.printStackTrace();
            }
        }
        httpoperationclient = new HttpOperation(httpoperationclient, stringbuilder, httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        return httpoperationclient;
    }

    public static HttpOperation createGetRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, HttpOperationReader httpoperationreader, VineAPI vineapi)
    {
        return new HttpOperation(httpoperationclient, new HttpGet(stringbuilder.toString()), httpoperationreader, vineapi);
    }

    public static HttpOperation createMediaPutRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, HttpOperationReader httpoperationreader, HttpEntity httpentity, VineAPI vineapi)
    {
        stringbuilder = new HttpPut(stringbuilder.toString());
        if (httpentity != null)
        {
            stringbuilder.setEntity(httpentity);
        }
        httpoperationclient = new HttpOperation(httpoperationclient, stringbuilder, httpoperationreader, vineapi);
        vineapi.addSessionKeyAuthHeader(httpoperationclient);
        return httpoperationclient;
    }

    private static HttpOperation createPostRequest(HttpOperationClient httpoperationclient, CharSequence charsequence, HashMap hashmap, HttpOperationReader httpoperationreader, VineAPI vineapi)
    {
        charsequence = new HttpPost(charsequence.toString());
        if (hashmap != null)
        {
            try
            {
                ObjectMapper objectmapper = new ObjectMapper();
                hashmap = new StringEntity(objectmapper.writeValueAsString(objectmapper.valueToTree(hashmap)), "UTF-8");
                hashmap.setContentType("application/json");
                hashmap.setContentEncoding("UTF-8");
                charsequence.setEntity(hashmap);
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                SLog.e("Failed to create Post Request.", hashmap);
            }
        }
        return new HttpOperation(httpoperationclient, charsequence, httpoperationreader, vineapi);
    }

    public static HttpOperation createPostRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, ArrayList arraylist, HttpOperationReader httpoperationreader, VineAPI vineapi)
    {
        stringbuilder = new HttpPost(stringbuilder.toString());
        if (arraylist != null)
        {
            try
            {
                stringbuilder.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                arraylist.printStackTrace();
            }
        }
        return new HttpOperation(httpoperationclient, stringbuilder, httpoperationreader, vineapi);
    }

    public static HttpOperation createResourceGetRequest(HttpOperationClient httpoperationclient, StringBuilder stringbuilder, VineAPI vineapi, HttpOperationReader httpoperationreader)
    {
        httpoperationclient = new HttpOperation(httpoperationclient, new HttpGet(stringbuilder.toString()), httpoperationreader, vineapi);
        if (stringbuilder.toString().startsWith("https"))
        {
            vineapi.addSessionKeyAuthHeader(httpoperationclient);
        }
        return httpoperationclient;
    }

    public void cancel()
    {
        mHttpRequest.abort();
    }

    public HttpOperation execute()
    {
        return execute(0);
    }

    public final HttpOperation execute(int i)
    {
        Object obj1;
        Object obj5;
        HttpRequestBase httprequestbase;
        ArrayList arraylist;
        int j;
        int l;
        long l5;
        l = 1;
        obj5 = null;
        obj1 = null;
        httprequestbase = mHttpRequest;
        arraylist = new ArrayList(Math.max(i, 0) + 1);
        l5 = -1L;
        j = i;
_L13:
        Object obj2;
        long l1;
        long l3;
        long l4;
        long l7;
        long l8;
        long l9;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        l4 = 0L;
        l14 = 0L;
        l13 = 0L;
        prepareRequest(sTimeOffset.get());
        if (LOGGABLE)
        {
            Log.d("HttpOperation", (new StringBuilder()).append(httprequestbase.getMethod()).append(" ").append(httprequestbase.getURI()).toString());
        }
        l15 = System.currentTimeMillis();
        l8 = l5;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l5;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Object obj3 = mHttpClient.execute(httprequestbase);
        l8 = l5;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l5;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Object obj = ((HttpResponse) (obj3)).getStatusLine();
        l8 = l5;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l5;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        int i1 = ((StatusLine) (obj)).getStatusCode();
        l8 = l5;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l5;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        long l6 = System.currentTimeMillis() - l15;
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        String s1 = ((StatusLine) (obj)).getReasonPhrase();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        if (!LOGGABLE) goto _L2; else goto _L1
_L1:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Log.d("HttpOperation", (new StringBuilder()).append(i1).append("/").append(s1).append(" [").append(httprequestbase.getURI()).append("]").toString());
          goto _L2
_L15:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        obj1 = ((HttpResponse) (obj3)).getEntity();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        l14 = System.currentTimeMillis() - l15;
        l15 = l13;
        l5 = l4;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        l15 = l13;
        l5 = l4;
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        if (!((HttpEntity) (obj1)).isStreaming()) goto _L4; else goto _L5
_L5:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        if (((HttpEntity) (obj1)).getContentEncoding() == null) goto _L7; else goto _L6
_L6:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Object obj4 = ((HttpEntity) (obj1)).getContentEncoding().getValue();
_L17:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        obj3 = ((HttpEntity) (obj1)).getContentType();
        if (obj3 == null) goto _L9; else goto _L8
_L8:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        String s = ((Header) (obj3)).getValue();
_L18:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        l = (int)((HttpEntity) (obj1)).getContentLength();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_960;
        }
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Log.d("HttpOperation", (new StringBuilder()).append("read: Encoding: ").append(((String) (obj4))).append(", type: ").append(s).append(", length: ").append(l).toString());
        obj3 = null;
        l5 = l4;
        MeasureInputStream measureinputstream = new MeasureInputStream(((HttpEntity) (obj1)).getContent());
        obj2 = measureinputstream;
        if (s != null) goto _L11; else goto _L10
_L10:
        obj1 = obj2;
        j = l;
_L20:
        obj3 = obj1;
        l5 = l4;
        mReader.readInput(i1, j, ((java.io.InputStream) (obj1)));
        obj3 = obj1;
        l5 = l4;
        l4 = measureinputstream.getReadTime();
        obj3 = obj1;
        l5 = l4;
        if (!SLog.sLogsOn)
        {
            break MISSING_BLOCK_LABEL_1121;
        }
        obj3 = obj1;
        l5 = l4;
        if (RATE_LIMIT_BYTES_PER_MS == -1D)
        {
            break MISSING_BLOCK_LABEL_1121;
        }
        obj3 = obj1;
        l5 = l4;
        l1 = (long)((double)j / RATE_LIMIT_BYTES_PER_MS - (double)l4);
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_1121;
        }
        obj3 = obj1;
        l5 = l4;
        SLog.d("Rate limiting: {}ms.", Long.valueOf(l1));
        obj3 = obj1;
        l5 = l4;
        Thread.sleep(l1);
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        l5 = System.currentTimeMillis();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        Util.closeSilently(((java.io.Closeable) (obj1)));
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        l13 = System.currentTimeMillis();
        l15 = l13 - l5;
        l5 = l4;
_L4:
        int k;
        l1 = l14 + l5 + l15;
        if (l6 != -1L && (SLog.sLogsOn || Math.random() > 0.10000000000000001D))
        {
            obj1 = httprequestbase.getURI();
            SLog.d("{}, {} took {} ms to open and {} total.", new Object[] {
                ((URI) (obj1)).getHost(), ((URI) (obj1)).getPath(), Long.valueOf(l6), Long.valueOf(l1)
            });
            FlurryUtils.trackRespondTime(((URI) (obj1)).getHost(), ((URI) (obj1)).getPath(), l6, l1, ((URI) (obj1)).toString().contains("/r/videos/"));
        }
        obj1 = new HttpResult(i1, s1);
        obj1.exception = null;
        obj1.durationMs = l1;
        obj1.uploadKey = ((String) (obj));
        if (i1 != 200)
        {
            mReader.onHandleError(((HttpResult) (obj1)));
        }
        arraylist.add(obj1);
        i--;
        l5 = l6;
        l = k;
        obj1 = obj;
        j = i;
        if (i >= 0) goto _L13; else goto _L12
_L12:
        i = i1;
        obj1 = s1;
        obj4 = obj5;
_L30:
        statusCode = i;
        statusPhrase = ((String) (obj1));
        exception = ((Exception) (obj4));
        uploadKey = ((String) (obj));
        mResults = new HttpResult[arraylist.size()];
        arraylist.toArray(mResults);
        return this;
_L34:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        obj4 = ((HttpResponse) (obj3)).getHeaders("X-Upload-Key");
        k = l;
        obj = obj1;
        i = j;
        if (obj4 == null) goto _L15; else goto _L14
_L14:
        k = l;
        obj = obj1;
        i = j;
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        if (obj4.length <= 0) goto _L15; else goto _L16
_L16:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        obj = obj4[0].getValue();
        k = l;
        i = j;
          goto _L15
_L35:
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        obj = ((HttpResponse) (obj3)).getLastHeader("Date");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1839;
        }
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        l5 = Util.DATE_TIME_RFC1123.parse(((Header) (obj)).getValue()).getTime();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        long l16 = System.currentTimeMillis();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l4;
        obj2 = obj1;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l4;
        sTimeOffset.set(l5 - l16);
        k = l;
        obj = obj1;
        i = j;
        if (l > 0)
        {
            k = l - 1;
            i = j + 1;
            obj = obj1;
        }
          goto _L15
_L7:
        obj4 = null;
          goto _L17
_L9:
        s = null;
          goto _L18
_L11:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("application/octet-stream")) goto _L20; else goto _L19
_L19:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("video/avc")) goto _L20; else goto _L21
_L21:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("video/webm")) goto _L20; else goto _L22
_L22:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("video/mp4")) goto _L20; else goto _L23
_L23:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("binary/octet-stream")) goto _L20; else goto _L24
_L24:
        obj3 = obj2;
        l5 = l4;
        if (!s.startsWith("application/json"))
        {
            break MISSING_BLOCK_LABEL_2090;
        }
        j = l;
        obj1 = obj2;
        if (obj4 == null) goto _L20; else goto _L25
_L25:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (!((String) (obj4)).equals("gzip")) goto _L20; else goto _L26
_L26:
        obj3 = obj2;
        l5 = l4;
        obj1 = new GZIPInputStream(((java.io.InputStream) (obj2)));
        j = -1;
          goto _L20
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("text/html"))
        {
            break MISSING_BLOCK_LABEL_2185;
        }
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("text/plain"))
        {
            break MISSING_BLOCK_LABEL_2185;
        }
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("text/xml"))
        {
            break MISSING_BLOCK_LABEL_2185;
        }
        obj3 = obj2;
        l5 = l4;
        if (s.startsWith("application/xml"))
        {
            break MISSING_BLOCK_LABEL_2185;
        }
        obj3 = obj2;
        l5 = l4;
        if (!s.startsWith("image/"))
        {
            break MISSING_BLOCK_LABEL_2246;
        }
        j = l;
        obj1 = obj2;
        if (obj4 == null) goto _L20; else goto _L27
_L27:
        j = l;
        obj1 = obj2;
        obj3 = obj2;
        l5 = l4;
        if (!((String) (obj4)).equals("gzip")) goto _L20; else goto _L28
_L28:
        obj3 = obj2;
        l5 = l4;
        obj1 = new GZIPInputStream(((java.io.InputStream) (obj2)));
        j = -1;
          goto _L20
        obj3 = obj2;
        l5 = l4;
        throw new IOException((new StringBuilder()).append("Unsupported content type: ").append(s).toString());
        obj1;
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l5;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l5;
        l4 = System.currentTimeMillis();
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l5;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l5;
        Util.closeSilently(((java.io.Closeable) (obj3)));
        l8 = l6;
        l9 = l13;
        l10 = l14;
        l1 = l5;
        obj2 = obj;
        l7 = l6;
        l11 = l13;
        l12 = l14;
        l3 = l5;
        l4 = System.currentTimeMillis() - l4;
        l8 = l6;
        l9 = l4;
        l10 = l14;
        l1 = l5;
        obj2 = obj;
        l7 = l6;
        l11 = l4;
        l12 = l14;
        l3 = l5;
        throw obj1;
        Exception exception1;
        exception1;
        l7 = l8;
        l11 = l9;
        l12 = l10;
        l3 = l1;
        if (!LOGGABLE)
        {
            break MISSING_BLOCK_LABEL_2522;
        }
        l7 = l8;
        l11 = l9;
        l12 = l10;
        l3 = l1;
        Log.d("HttpOperation", (new StringBuilder()).append("[").append(httprequestbase.getURI()).append("]").toString(), exception1);
        l7 = l8;
        l11 = l9;
        l12 = l10;
        l3 = l1;
        httprequestbase.abort();
        j = 0;
        s = null;
        l1 = l10 + l1 + l9;
        obj4 = exception1;
        obj1 = s;
        i = j;
        obj = obj2;
        if (-1L == -1L) goto _L30; else goto _L29
_L29:
        if (SLog.sLogsOn) goto _L32; else goto _L31
_L31:
        obj4 = exception1;
        obj1 = s;
        i = j;
        obj = obj2;
        if (Math.random() <= 0.10000000000000001D) goto _L30; else goto _L32
_L32:
        obj = httprequestbase.getURI();
        SLog.d("{}, {} took {} ms to open and {} total.", new Object[] {
            ((URI) (obj)).getHost(), ((URI) (obj)).getPath(), Long.valueOf(-1L), Long.valueOf(l1)
        });
        FlurryUtils.trackRespondTime(((URI) (obj)).getHost(), ((URI) (obj)).getPath(), -1L, l1, ((URI) (obj)).toString().contains("/r/videos/"));
        obj4 = exception1;
        obj1 = s;
        i = j;
        obj = obj2;
          goto _L30
        obj;
        long l2 = l12 + l3 + l11;
        if (l7 != -1L && (SLog.sLogsOn || Math.random() > 0.10000000000000001D))
        {
            obj1 = httprequestbase.getURI();
            SLog.d("{}, {} took {} ms to open and {} total.", new Object[] {
                ((URI) (obj1)).getHost(), ((URI) (obj1)).getPath(), Long.valueOf(l7), Long.valueOf(l2)
            });
            FlurryUtils.trackRespondTime(((URI) (obj1)).getHost(), ((URI) (obj1)).getPath(), l7, l2, ((URI) (obj1)).toString().contains("/r/videos/"));
        }
        throw obj;
_L2:
        k = l;
        obj = obj1;
        i = j;
        i1;
        JVM INSTR lookupswitch 5: default 2872
    //                   200: 1486
    //                   401: 1652
    //                   500: 457
    //                   502: 457
    //                   503: 457;
           goto _L33 _L34 _L35 _L36 _L36 _L36
_L36:
        continue; /* Loop/switch isn't completed */
_L33:
        i = 0;
        k = l;
        obj = obj1;
        if (true) goto _L15; else goto _L37
_L37:
    }

    public HttpRequestBase getHttpRequest()
    {
        return mHttpRequest;
    }

    public HttpOperationReader getReader()
    {
        return mReader;
    }

    public HttpResult[] getResults()
    {
        if (mResults == null)
        {
            return EMPTY_RESULTS;
        } else
        {
            return mResults;
        }
    }

    public boolean isOK()
    {
        return statusCode == 200;
    }

    public boolean isSuccessful()
    {
        return statusCode >= 200 && statusCode < 300;
    }

    protected void prepareRequest(long l)
    {
    }

    static 
    {
        RATE_LIMIT_BYTES_PER_MS = -1D;
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("HttpOperation", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
    }
}
