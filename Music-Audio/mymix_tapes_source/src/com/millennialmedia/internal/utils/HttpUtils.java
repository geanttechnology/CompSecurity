// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.graphics.Bitmap;
import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.AdMetadata;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils

public class HttpUtils
{
    public static class HttpRequestHandler
    {

        public Response sendHttpRequest(String s, String s1, String s2, Integer integer, ResponseStreamer responsestreamer)
        {
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            AndroidHttpClient androidhttpclient;
            Response response;
            Object obj5;
            Object obj6;
            int i;
            long l;
            l = System.currentTimeMillis();
            Header header;
            int j;
            int k;
            if (integer == null)
            {
                i = 15000;
            } else
            {
                i = integer.intValue();
            }
            response = new Response();
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj4 = null;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(HttpUtils.TAG, (new StringBuilder()).append("Sending Http request.\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tcontent type: ").append(s2).append("\n\trequestId: ").append(l).toString());
            }
            androidhttpclient = AndroidHttpClient.newInstance(EnvironmentUtils.getUserAgent());
            integer = androidhttpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(integer, i);
            HttpConnectionParams.setSoTimeout(integer, i);
            HttpClientParams.setRedirecting(integer, true);
            integer = obj3;
            obj = new URI(s);
            if (s1 == null) goto _L2; else goto _L1
_L1:
            integer = obj3;
            obj5 = new StringEntity(s1);
            if (s2 == null)
            {
                break MISSING_BLOCK_LABEL_176;
            }
            integer = obj3;
            ((StringEntity) (obj5)).setContentType(s2);
            integer = obj3;
            obj = new HttpPost(((URI) (obj)));
            integer = obj3;
            ((HttpPost) (obj)).setEntity(((HttpEntity) (obj5)));
_L6:
            integer = obj3;
            AndroidHttpClient.modifyRequestToAcceptGzipResponse(((org.apache.http.HttpRequest) (obj)));
            integer = obj3;
            obj6 = androidhttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
            integer = obj3;
            response.code = ((HttpResponse) (obj6)).getStatusLine().getStatusCode();
            obj = obj4;
            integer = obj3;
            if (response.code != 200)
            {
                break MISSING_BLOCK_LABEL_478;
            }
            integer = obj3;
            obj5 = ((HttpResponse) (obj6)).getEntity();
            integer = obj3;
            obj = ((HttpResponse) (obj6)).getAllHeaders();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_406;
            }
            integer = obj3;
            obj6 = new AdMetadata();
            integer = obj3;
            k = obj.length;
            j = 0;
_L4:
            if (j >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            header = obj[j];
            integer = obj3;
            ((AdMetadata) (obj6)).put(header.getName(), header.getValue());
            j++;
            if (true) goto _L4; else goto _L3
_L3:
            break; /* Loop/switch isn't completed */
_L2:
            integer = obj3;
            obj = new HttpGet(((URI) (obj)));
            if (true) goto _L6; else goto _L5
_L5:
            integer = obj3;
            response.adMetadata = ((AdMetadata) (obj6));
            obj = obj4;
            if (obj5 == null)
            {
                break MISSING_BLOCK_LABEL_478;
            }
            integer = obj3;
            obj = ((HttpEntity) (obj5)).getContentType();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_449;
            }
            integer = obj3;
            response.contentType = ((Header) (obj)).getValue();
            integer = obj3;
            obj = new BufferedInputStream(AndroidHttpClient.getUngzippedContent(((HttpEntity) (obj5))));
            responsestreamer.streamContent(((InputStream) (obj)), response);
            if (obj != null)
            {
                try
                {
                    ((BufferedInputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MMLog.e(HttpUtils.TAG, "Error closing input stream", s);
                }
            }
            androidhttpclient.close();
_L11:
            if (!MMLog.isDebugEnabled()) goto _L8; else goto _L7
_L7:
            if (TextUtils.isEmpty(response.content)) goto _L10; else goto _L9
_L9:
            if (response.contentType == null || response.contentType.contains("text") || response.contentType.contains("json"))
            {
                s = response.content;
            } else
            {
                s = "<non-text-content>";
            }
            MMLog.d(HttpUtils.TAG, (new StringBuilder()).append("Http text response.\n\tcode: ").append(response.code).append("\n\trequestId: ").append(l).append("\n\tcontent-type: ").append(response.contentType).append("\n\tcontent: ").append(s).toString());
_L8:
            return response;
            integer;
            responsestreamer = obj1;
_L15:
            integer = responsestreamer;
            response.code = 408;
            integer = responsestreamer;
            MMLog.e(HttpUtils.TAG, (new StringBuilder()).append("Timeout occurred when trying to get response content.\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tpost content type: ").append(s2).append("\n\ttimeout: ").append(i).append("\n\trequestId: ").append(l).toString());
            if (responsestreamer != null)
            {
                try
                {
                    responsestreamer.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MMLog.e(HttpUtils.TAG, "Error closing input stream", s);
                }
            }
            androidhttpclient.close();
              goto _L11
            obj;
            responsestreamer = obj2;
_L14:
            integer = responsestreamer;
            response.code = 400;
            integer = responsestreamer;
            MMLog.e(HttpUtils.TAG, (new StringBuilder()).append("Error occurred when trying to get response content.\n\texception: ").append(((Exception) (obj)).toString()).append("\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tpost content type: ").append(s2).append("\n\ttimeout: ").append(i).append("\n\trequestId: ").append(l).toString());
            if (responsestreamer != null)
            {
                try
                {
                    responsestreamer.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MMLog.e(HttpUtils.TAG, "Error closing input stream", s);
                }
            }
            androidhttpclient.close();
              goto _L11
            s;
_L13:
            if (integer != null)
            {
                try
                {
                    integer.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    MMLog.e(HttpUtils.TAG, "Error closing input stream", s1);
                }
            }
            androidhttpclient.close();
            throw s;
_L10:
            if (response.bitmap != null)
            {
                MMLog.d(HttpUtils.TAG, (new StringBuilder()).append("Http bitmap response.\n\tcode: ").append(response.code).append("\n\trequestId: ").append(l).append("\n\tcontent-type: ").append(response.contentType).append("\n\tbitmap dimensions: ").append(response.bitmap.getWidth()).append(" x ").append(response.bitmap.getHeight()).append("\n\tbitmap size: ").append(response.bitmap.getByteCount()).toString());
                return response;
            }
            if (response.file != null)
            {
                MMLog.d(HttpUtils.TAG, (new StringBuilder()).append("Http file response.\n\tcode: ").append(response.code).append("\n\tcontent-type: ").append(response.contentType).append("\n\trequestId: ").append(l).append("\n\tfile: ").append(response.file.getAbsolutePath()).toString());
                return response;
            } else
            {
                MMLog.d(HttpUtils.TAG, (new StringBuilder()).append("Http response.\n\tcode: ").append(response.code).append("\n\tcontent-type: ").append(response.contentType).append("\n\trequestId: ").append(l).toString());
                return response;
            }
            s;
            integer = ((Integer) (obj));
            if (true) goto _L13; else goto _L12
_L12:
            integer;
            responsestreamer = ((ResponseStreamer) (obj));
            obj = integer;
              goto _L14
            integer;
            responsestreamer = ((ResponseStreamer) (obj));
              goto _L15
        }

        public HttpRequestHandler()
        {
        }
    }

    public static class Response
    {

        public AdMetadata adMetadata;
        public Bitmap bitmap;
        public int code;
        public String content;
        public String contentType;
        public File file;

        public Response()
        {
        }
    }

    public static interface ResponseStreamer
    {

        public abstract void streamContent(InputStream inputstream, Response response);
    }


    private static final int DEFAULT_TIMEOUT = 15000;
    private static final String TAG = com/millennialmedia/internal/utils/HttpUtils.getSimpleName();
    public static HttpRequestHandler httpRequestHandler = new HttpRequestHandler();

    public HttpUtils()
    {
    }

    public static Response getBitmapFromGetRequest(String s)
    {
        return httpRequestHandler.sendHttpRequest(s, null, null, null, new IOUtils.BitmapStreamer());
    }

    public static Response getContentFromGetRequest(String s)
    {
        return httpRequestHandler.sendHttpRequest(s, null, null, null, new IOUtils.StringStreamer());
    }

    public static Response getContentFromPostRequest(String s, int i)
    {
        return httpRequestHandler.sendHttpRequest(s, null, null, Integer.valueOf(i), new IOUtils.StringStreamer());
    }

    public static Response getContentFromPostRequest(String s, String s1, String s2)
    {
        return httpRequestHandler.sendHttpRequest(s, s1, s2, null, new IOUtils.StringStreamer());
    }

    public static Response getContentFromPostRequest(String s, String s1, String s2, int i)
    {
        return httpRequestHandler.sendHttpRequest(s, s1, s2, Integer.valueOf(i), new IOUtils.StringStreamer());
    }


}
