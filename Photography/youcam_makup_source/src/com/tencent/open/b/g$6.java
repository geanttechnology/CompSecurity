// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Bundle;
import com.tencent.open.a.k;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.c;
import com.tencent.open.utils.m;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.tencent.open.b:
//            g, e

class 
    implements Runnable
{

    final Bundle a;
    final String b;
    final boolean c;
    final String d;
    final g e;

    public void run()
    {
        boolean flag = false;
        if (a == null)
        {
            k.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
            return;
        }
        int j = com.tencent.open.b.e.a();
        if (j == 0)
        {
            j = 3;
        }
        Object obj;
        HttpClient httpclient;
        k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->httpRequest, retryCount: ").append(j).toString());
        httpclient = HttpUtils.a(com.tencent.open.utils.c.a(), null, b);
        obj = HttpUtils.a(a);
        if (c)
        {
            obj = URLEncoder.encode(((String) (obj)));
        }
        if (!d.toUpperCase().equals("GET")) goto _L2; else goto _L1
_L1:
        StringBuffer stringbuffer = new StringBuffer(b);
        stringbuffer.append(((String) (obj)));
        obj = new HttpGet(stringbuffer.toString());
_L6:
        ((HttpUriRequest) (obj)).addHeader("Accept-Encoding", "gzip");
        ((HttpUriRequest) (obj)).addHeader("Content-Type", "application/x-www-form-urlencoded");
        int l = 0;
_L13:
        int i1 = l + 1;
        int i;
        i = httpclient.execute(((HttpUriRequest) (obj))).getStatusLine().getStatusCode();
        k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->httpRequest, statusCode: ").append(i).toString());
        if (i == 200) goto _L4; else goto _L3
_L3:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
_L7:
        if (flag)
        {
            try
            {
                k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                k.b("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor.");
            }
            return;
        }
          goto _L5
_L2:
        HttpPost httppost;
        if (!d.toUpperCase().equals("POST"))
        {
            break MISSING_BLOCK_LABEL_294;
        }
        httppost = new HttpPost(b);
        httppost.setEntity(new ByteArrayEntity(m.e(((String) (obj)))));
        obj = httppost;
          goto _L6
        k.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
        return;
_L4:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
        flag = true;
          goto _L7
        Object obj1;
        obj1;
_L11:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException");
        i = ((flag) ? 1 : 0);
          goto _L8
_L10:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException");
        i = ((flag) ? 1 : 0);
          goto _L8
_L9:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception");
          goto _L7
_L5:
        k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
        return;
        Exception exception;
        exception;
        flag = true;
          goto _L9
        obj1;
        flag = true;
          goto _L10
        obj1;
        flag = true;
          goto _L11
_L8:
        flag = i;
        l = i1;
        if (i1 < j) goto _L13; else goto _L12
_L12:
        flag = i;
          goto _L7
        obj1;
          goto _L10
        exception;
          goto _L9
    }

    xception(g g1, Bundle bundle, String s, boolean flag, String s1)
    {
        e = g1;
        a = bundle;
        b = s;
        c = flag;
        d = s1;
        super();
    }
}
