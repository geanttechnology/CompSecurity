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
//            HttpUtils, EnvironmentUtils

public static class 
{

    public  sendHttpRequest(String s, String s1, String s2, Integer integer,  )
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        AndroidHttpClient androidhttpclient;
         1;
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
        1 = new ();
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(HttpUtils.access$000(), (new StringBuilder()).append("Sending Http request.\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tcontent type: ").append(s2).append("\n\trequestId: ").append(l).toString());
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
        1.onse = ((HttpResponse) (obj6)).getStatusLine().getStatusCode();
        obj = obj4;
        integer = obj3;
        if (1.onse != 200)
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
        1. = ((AdMetadata) (obj6));
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
        1.e = ((Header) (obj)).getValue();
        integer = obj3;
        obj = new BufferedInputStream(AndroidHttpClient.getUngzippedContent(((HttpEntity) (obj5))));
        .reamContent(((java.io.InputStream) (obj)), 1);
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.e(HttpUtils.access$000(), "Error closing input stream", s);
            }
        }
        androidhttpclient.close();
_L11:
        if (!MMLog.isDebugEnabled()) goto _L8; else goto _L7
_L7:
        if (TextUtils.isEmpty(1.reamContent)) goto _L10; else goto _L9
_L9:
        if (1.e == null || 1.e.contains("text") || 1.e.contains("json"))
        {
            s = 1.e;
        } else
        {
            s = "<non-text-content>";
        }
        MMLog.d(HttpUtils.access$000(), (new StringBuilder()).append("Http text response.\n\tcode: ").append(1.e).append("\n\trequestId: ").append(l).append("\n\tcontent-type: ").append(1.e).append("\n\tcontent: ").append(s).toString());
_L8:
        return 1;
        integer;
         = obj1;
_L15:
        integer = ;
        1.e = 408;
        integer = ;
        MMLog.e(HttpUtils.access$000(), (new StringBuilder()).append("Timeout occurred when trying to get response content.\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tpost content type: ").append(s2).append("\n\ttimeout: ").append(i).append("\n\trequestId: ").append(l).toString());
        if ( != null)
        {
            try
            {
                .close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.e(HttpUtils.access$000(), "Error closing input stream", s);
            }
        }
        androidhttpclient.close();
          goto _L11
        obj;
         = obj2;
_L14:
        integer = ;
        1.e = 400;
        integer = ;
        MMLog.e(HttpUtils.access$000(), (new StringBuilder()).append("Error occurred when trying to get response content.\n\texception: ").append(((Exception) (obj)).toString()).append("\n\turl: ").append(s).append("\n\tpost data: ").append(s1).append("\n\tpost content type: ").append(s2).append("\n\ttimeout: ").append(i).append("\n\trequestId: ").append(l).toString());
        if ( != null)
        {
            try
            {
                .close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.e(HttpUtils.access$000(), "Error closing input stream", s);
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
                MMLog.e(HttpUtils.access$000(), "Error closing input stream", s1);
            }
        }
        androidhttpclient.close();
        throw s;
_L10:
        if (1.e != null)
        {
            MMLog.d(HttpUtils.access$000(), (new StringBuilder()).append("Http bitmap response.\n\tcode: ").append(1.e).append("\n\trequestId: ").append(l).append("\n\tcontent-type: ").append(1.e).append("\n\tbitmap dimensions: ").append(1.e.getWidth()).append(" x ").append(1.e.getHeight()).append("\n\tbitmap size: ").append(1.e.getByteCount()).toString());
            return 1;
        }
        if (1.e != null)
        {
            MMLog.d(HttpUtils.access$000(), (new StringBuilder()).append("Http file response.\n\tcode: ").append(1.e).append("\n\tcontent-type: ").append(1.e).append("\n\trequestId: ").append(l).append("\n\tfile: ").append(1.e.getAbsolutePath()).toString());
            return 1;
        } else
        {
            MMLog.d(HttpUtils.access$000(), (new StringBuilder()).append("Http response.\n\tcode: ").append(1.e).append("\n\tcontent-type: ").append(1.e).append("\n\trequestId: ").append(l).toString());
            return 1;
        }
        s;
        integer = ((Integer) (obj));
        if (true) goto _L13; else goto _L12
_L12:
        integer;
         = ((e) (obj));
        obj = integer;
          goto _L14
        integer;
         = ((e) (obj));
          goto _L15
    }

    public ()
    {
    }
}
