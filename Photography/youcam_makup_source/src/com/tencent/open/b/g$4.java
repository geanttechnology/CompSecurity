// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import com.tencent.open.a.k;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.c;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.net.SocketTimeoutException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.tencent.open.b:
//            g, f

class 
    implements Runnable
{

    final com.tencent.open.b.g a;

    public void run()
    {
        int i;
        int j;
        boolean flag;
        int l;
        flag = false;
        android.os.Bundle bundle;
        HttpClient httpclient;
        HttpPost httppost;
        int i1;
        try
        {
            bundle = a.c();
        }
        catch (Exception exception)
        {
            k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", exception);
            return;
        }
        if (bundle == null)
        {
            return;
        }
        i = g.a(c.a(), null).a("Common_HttpRetryCount");
        if (i == 0)
        {
            i = 3;
        }
        k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportCgi, retryCount: ").append(i).toString());
        j = 0;
_L4:
        l = j + 1;
        httpclient = HttpUtils.a(c.a(), null, "http://wspeed.qq.com/w.cgi");
        httppost = new HttpPost("http://wspeed.qq.com/w.cgi");
        httppost.addHeader("Accept-Encoding", "gzip");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httppost.setEntity(new ByteArrayEntity(m.e(HttpUtils.a(bundle))));
        i1 = httpclient.execute(httppost).getStatusLine().getStatusCode();
        k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportCgi, statusCode: ").append(i1).toString());
        j = ((flag) ? 1 : 0);
        if (i1 != 200)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        f.a().b("report_cgi");
        j = 1;
_L2:
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        f.a().a("report_cgi", a.c);
        a.c.clear();
        return;
        Object obj;
        obj;
        k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", ((Throwable) (obj)));
        break MISSING_BLOCK_LABEL_279;
        obj;
        k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", ((Throwable) (obj)));
        break MISSING_BLOCK_LABEL_279;
        Exception exception1;
        exception1;
        k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", exception1);
        j = ((flag) ? 1 : 0);
        break; /* Loop/switch isn't completed */
        for (j = l; l < i; j = l)
        {
            continue; /* Loop/switch isn't completed */
        }

        j = ((flag) ? 1 : 0);
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    xception(com.tencent.open.b.g g1)
    {
        a = g1;
        super();
    }
}
