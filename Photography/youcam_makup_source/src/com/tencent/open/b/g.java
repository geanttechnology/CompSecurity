// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.c;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.utils.n;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open.b:
//            e, b, f, c, 
//            a

public class g
{

    protected static g a;
    protected Random b;
    protected List c;
    protected List d;
    protected HandlerThread e;
    protected Handler f;
    protected Executor g;
    protected Executor h;

    private g()
    {
        e = null;
        b = new Random();
        d = Collections.synchronizedList(new ArrayList());
        c = Collections.synchronizedList(new ArrayList());
        g = k.b();
        h = k.b();
        if (e == null)
        {
            e = new HandlerThread("opensdk.report.handlerthread", 10);
            e.start();
        }
        if (e.isAlive() && e.getLooper() != null)
        {
            f = new Handler(e.getLooper()) {

                final g a;

                public void handleMessage(Message message)
                {
                    message.what;
                    JVM INSTR tableswitch 1000 1001: default 28
                //                               1000 34
                //                               1001 44;
                       goto _L1 _L2 _L3
_L1:
                    super.handleMessage(message);
                    return;
_L2:
                    a.b();
                    continue; /* Loop/switch isn't completed */
_L3:
                    a.e();
                    if (true) goto _L1; else goto _L4
_L4:
                }

            
            {
                a = g.this;
                super(looper);
            }
            };
        }
    }

    public static g a()
    {
        com/tencent/open/b/g;
        JVM INSTR monitorenter ;
        g g1;
        if (a == null)
        {
            a = new g();
        }
        g1 = a;
        com/tencent/open/b/g;
        JVM INSTR monitorexit ;
        return g1;
        Exception exception;
        exception;
        throw exception;
    }

    protected int a(int i)
    {
        if (i == 0)
        {
            int j = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Common_CGIReportFrequencySuccess");
            i = j;
            if (j == 0)
            {
                i = 10;
            }
        } else
        {
            int l = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Common_CGIReportFrequencyFailed");
            i = l;
            if (l == 0)
            {
                return 100;
            }
        }
        return i;
    }

    public void a(Bundle bundle, String s, boolean flag)
    {
        if (bundle != null)
        {
            com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->reportVia, bundle: ").append(bundle.toString()).toString());
            if (a("report_via", s) || flag)
            {
                g.execute(new Runnable(bundle, flag) {

                    final Bundle a;
                    final boolean b;
                    final g c;

                    public void run()
                    {
                        int j;
                        int l;
                        Object obj = new Bundle();
                        ((Bundle) (obj)).putString("uin", "1000");
                        ((Bundle) (obj)).putString("imei", com.tencent.open.b.c.b(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("imsi", com.tencent.open.b.c.c(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("android_id", com.tencent.open.b.c.d(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("mac", com.tencent.open.b.c.a());
                        ((Bundle) (obj)).putString("platform", "1");
                        ((Bundle) (obj)).putString("os_ver", android.os.Build.VERSION.RELEASE);
                        ((Bundle) (obj)).putString("position", m.b(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("network", com.tencent.open.b.a.a(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("language", com.tencent.open.b.c.b());
                        ((Bundle) (obj)).putString("resolution", com.tencent.open.b.c.a(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("apn", com.tencent.open.b.a.b(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("model_name", Build.MODEL);
                        ((Bundle) (obj)).putString("timezone", TimeZone.getDefault().getID());
                        ((Bundle) (obj)).putString("sdk_ver", "2.9.1.lite");
                        ((Bundle) (obj)).putString("qz_ver", m.d(com.tencent.open.utils.c.a(), "com.qzone"));
                        ((Bundle) (obj)).putString("qq_ver", m.c(com.tencent.open.utils.c.a(), "com.tencent.mobileqq"));
                        ((Bundle) (obj)).putString("qua", m.e(com.tencent.open.utils.c.a(), com.tencent.open.utils.c.b()));
                        ((Bundle) (obj)).putString("packagename", com.tencent.open.utils.c.b());
                        ((Bundle) (obj)).putString("app_ver", m.d(com.tencent.open.utils.c.a(), com.tencent.open.utils.c.b()));
                        if (a != null)
                        {
                            ((Bundle) (obj)).putAll(a);
                        }
                        obj = new b(((Bundle) (obj)));
                        c.d.add(obj);
                        l = c.d.size();
                        j = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Agent_ReportTimeInterval");
                        int i;
                        i = j;
                        if (j == 0)
                        {
                            i = 10000;
                        }
                        if (c.a("report_via", l) || b)
                        {
                            c.e();
                            c.f.removeMessages(1001);
                            return;
                        }
                        try
                        {
                            if (!c.f.hasMessages(1001))
                            {
                                Message message = Message.obtain();
                                message.what = 1001;
                                c.f.sendMessageDelayed(message, i);
                                return;
                            }
                        }
                        catch (Exception exception)
                        {
                            com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", exception);
                        }
                        return;
                    }

            
            {
                c = g.this;
                a = bundle;
                b = flag;
                super();
            }
                });
                return;
            }
        }
    }

    public void a(String s, long l, long l1, long l2, 
            int i)
    {
        a(s, l, l1, l2, i, "", false);
    }

    public void a(String s, long l, long l1, long l2, 
            int i, String s1, boolean flag)
    {
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->reportCgi, command: ").append(s).append(" | startTime: ").append(l).append(" | reqSize:").append(l1).append(" | rspSize: ").append(l2).append(" | responseCode: ").append(i).append(" | detail: ").append(s1).toString());
        if (!a("report_cgi", (new StringBuilder()).append("").append(i).toString()) && !flag)
        {
            return;
        } else
        {
            h.execute(new Runnable(l, s, s1, i, l1, l2, flag) {

                final long a;
                final String b;
                final String c;
                final int d;
                final long e;
                final long f;
                final boolean g;
                final g h;

                public void run()
                {
                    int i1 = 1;
                    Object obj;
                    StringBuilder stringbuilder;
                    Object obj1;
                    long l3;
                    long l4;
                    l3 = SystemClock.elapsedRealtime();
                    l4 = a;
                    obj = new Bundle();
                    obj1 = com.tencent.open.b.a.a(com.tencent.open.utils.c.a());
                    ((Bundle) (obj)).putString("apn", ((String) (obj1)));
                    ((Bundle) (obj)).putString("appid", "1000067");
                    ((Bundle) (obj)).putString("commandid", b);
                    ((Bundle) (obj)).putString("detail", c);
                    stringbuilder = new StringBuilder();
                    stringbuilder.append("network=").append(((String) (obj1))).append('&');
                    obj1 = stringbuilder.append("sdcard=");
                    int j;
                    int j1;
                    if (Environment.getExternalStorageState().equals("mounted"))
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    try
                    {
                        ((StringBuilder) (obj1)).append(j).append('&');
                        stringbuilder.append("wifi=").append(com.tencent.open.b.a.e(com.tencent.open.utils.c.a()));
                        ((Bundle) (obj)).putString("deviceInfo", stringbuilder.toString());
                        j = 100 / h.a(d);
                    }
                    catch (Exception exception)
                    {
                        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", exception);
                        return;
                    }
                    if (j > 0) goto _L2; else goto _L1
_L1:
                    j = i1;
_L4:
                    ((Bundle) (obj)).putString("frequency", (new StringBuilder()).append(j).append("").toString());
                    ((Bundle) (obj)).putString("reqSize", (new StringBuilder()).append(e).append("").toString());
                    ((Bundle) (obj)).putString("resultCode", (new StringBuilder()).append(d).append("").toString());
                    ((Bundle) (obj)).putString("rspSize", (new StringBuilder()).append(f).append("").toString());
                    ((Bundle) (obj)).putString("timeCost", (new StringBuilder()).append(l3 - l4).append("").toString());
                    ((Bundle) (obj)).putString("uin", "1000");
                    obj = new b(((Bundle) (obj)));
                    h.c.add(obj);
                    j1 = h.c.size();
                    i1 = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Agent_ReportTimeInterval");
                    j = i1;
                    if (i1 == 0)
                    {
                        j = 10000;
                    }
                    if (h.a("report_cgi", j1) || g)
                    {
                        h.b();
                        h.f.removeMessages(1000);
                        return;
                    }
                    if (!h.f.hasMessages(1000))
                    {
                        obj = Message.obtain();
                        obj.what = 1000;
                        h.f.sendMessageDelayed(((Message) (obj)), j);
                        return;
                    }
                    return;
_L2:
                    if (j > 100)
                    {
                        j = 100;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                h = g.this;
                a = l;
                b = s;
                c = s1;
                d = i;
                e = l1;
                f = l2;
                g = flag;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, String s1, Bundle bundle, boolean flag)
    {
        k.a(new Runnable(bundle, s, flag, s1) {

            final Bundle a;
            final String b;
            final boolean c;
            final String d;
            final g e;

            public void run()
            {
                boolean flag1 = false;
                if (a == null)
                {
                    com.tencent.open.a.k.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                    return;
                }
                int j = com.tencent.open.b.e.a();
                if (j == 0)
                {
                    j = 3;
                }
                Object obj;
                HttpClient httpclient;
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->httpRequest, retryCount: ").append(j).toString());
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
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->httpRequest, statusCode: ").append(i).toString());
                if (i == 200) goto _L4; else goto _L3
_L3:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
_L7:
                if (flag1)
                {
                    try
                    {
                        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor.");
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
                com.tencent.open.a.k.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                return;
_L4:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                flag1 = true;
                  goto _L7
                Object obj1;
                obj1;
_L11:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException");
                i = ((flag1) ? 1 : 0);
                  goto _L8
_L10:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException");
                i = ((flag1) ? 1 : 0);
                  goto _L8
_L9:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception");
                  goto _L7
_L5:
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                return;
                Exception exception;
                exception;
                flag1 = true;
                  goto _L9
                obj1;
                flag1 = true;
                  goto _L10
                obj1;
                flag1 = true;
                  goto _L11
_L8:
                flag1 = i;
                l = i1;
                if (i1 < j) goto _L13; else goto _L12
_L12:
                flag1 = i;
                  goto _L7
                obj1;
                  goto _L10
                exception;
                  goto _L9
            }

            
            {
                e = g.this;
                a = bundle;
                b = s;
                c = flag;
                d = s1;
                super();
            }
        });
    }

    protected boolean a(String s, int i)
    {
        int j;
        boolean flag;
        j = 5;
        flag = false;
        if (!s.equals("report_cgi")) goto _L2; else goto _L1
_L1:
        int l = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Common_CGIReportMaxcount");
        if (l != 0)
        {
            j = l;
        }
_L4:
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->availableCount, report: ").append(s).append(" | dataSize: ").append(i).append(" | maxcount: ").append(j).toString());
        if (i >= j)
        {
            flag = true;
        }
        return flag;
_L2:
        if (s.equals("report_via"))
        {
            int i1 = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Agent_ReportBatchCount");
            if (i1 != 0)
            {
                j = i1;
            }
        } else
        {
            j = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean a(String s, String s1)
    {
        boolean flag = true;
        boolean flag1 = false;
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->availableFrequency, report: ").append(s).append(" | ext: ").append(s1).toString());
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        int i;
        if (s.equals("report_cgi"))
        {
            try
            {
                i = Integer.parseInt(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            i = a(i);
            if (b.nextInt(100) >= i)
            {
                flag = false;
            }
        } else
        if (s.equals("report_via"))
        {
            i = com.tencent.open.b.e.a(s1);
            if (b.nextInt(100) < i)
            {
                flag = true;
            } else
            {
                flag = flag1;
            }
        } else
        {
            i = 100;
            flag = flag1;
        }
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->availableFrequency, result: ").append(flag).append(" | frequency: ").append(i).toString());
        return flag;
    }

    protected void b()
    {
        h.execute(new Runnable() {

            final g a;

            public void run()
            {
                int i;
                int j;
                boolean flag;
                int l;
                flag = false;
                Bundle bundle;
                HttpClient httpclient;
                HttpPost httppost;
                int i1;
                try
                {
                    bundle = a.c();
                }
                catch (Exception exception)
                {
                    com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", exception);
                    return;
                }
                if (bundle == null)
                {
                    return;
                }
                i = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Common_HttpRetryCount");
                if (i == 0)
                {
                    i = 3;
                }
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportCgi, retryCount: ").append(i).toString());
                j = 0;
_L4:
                l = j + 1;
                httpclient = HttpUtils.a(com.tencent.open.utils.c.a(), null, "http://wspeed.qq.com/w.cgi");
                httppost = new HttpPost("http://wspeed.qq.com/w.cgi");
                httppost.addHeader("Accept-Encoding", "gzip");
                httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                httppost.setEntity(new ByteArrayEntity(m.e(HttpUtils.a(bundle))));
                i1 = httpclient.execute(httppost).getStatusLine().getStatusCode();
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportCgi, statusCode: ").append(i1).toString());
                j = ((flag) ? 1 : 0);
                if (i1 != 200)
                {
                    break MISSING_BLOCK_LABEL_193;
                }
                com.tencent.open.b.f.a().b("report_cgi");
                j = 1;
_L2:
                if (j != 0)
                {
                    break MISSING_BLOCK_LABEL_213;
                }
                com.tencent.open.b.f.a().a("report_cgi", a.c);
                a.c.clear();
                return;
                Object obj;
                obj;
                com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", ((Throwable) (obj)));
                break MISSING_BLOCK_LABEL_279;
                obj;
                com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", ((Throwable) (obj)));
                break MISSING_BLOCK_LABEL_279;
                Exception exception1;
                exception1;
                com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", exception1);
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

            
            {
                a = g.this;
                super();
            }
        });
    }

    protected Bundle c()
    {
        Object obj;
        if (c.size() == 0)
        {
            return null;
        }
        obj = (b)c.get(0);
        if (obj == null)
        {
            com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        Object obj1 = (String)((b) (obj)).a.get("appid");
        obj = com.tencent.open.b.f.a().a("report_cgi");
        if (obj != null)
        {
            c.addAll(((java.util.Collection) (obj)));
        }
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->prepareCgiData, mCgiList size: ").append(c.size()).toString());
        if (c.size() == 0)
        {
            return null;
        }
        obj = new Bundle();
        int i;
        try
        {
            ((Bundle) (obj)).putString("appid", ((String) (obj1)));
            ((Bundle) (obj)).putString("releaseversion", "OpenSdk_2.9.1.lite");
            ((Bundle) (obj)).putString("device", Build.DEVICE);
            ((Bundle) (obj)).putString("qua", "V1_AND_OpenSDK_2.9.1.lite_1077_RDM_B");
            ((Bundle) (obj)).putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", ((Throwable) (obj)));
            return null;
        }
        i = 0;
        if (i >= c.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (b)c.get(i);
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_1").toString(), (String)((b) (obj1)).a.get("apn"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_2").toString(), (String)((b) (obj1)).a.get("frequency"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_3").toString(), (String)((b) (obj1)).a.get("commandid"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_4").toString(), (String)((b) (obj1)).a.get("resultCode"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_5").toString(), (String)((b) (obj1)).a.get("timeCost"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_6").toString(), (String)((b) (obj1)).a.get("reqSize"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_7").toString(), (String)((b) (obj1)).a.get("rspSize"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_8").toString(), (String)((b) (obj1)).a.get("detail"));
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_9").toString(), (String)((b) (obj1)).a.get("uin"));
        obj1 = (new StringBuilder()).append(com.tencent.open.b.c.e(com.tencent.open.utils.c.a())).append("&").append((String)((b) (obj1)).a.get("deviceInfo")).toString();
        ((Bundle) (obj)).putString((new StringBuilder()).append(i).append("_10").toString(), ((String) (obj1)));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_182;
_L1:
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->prepareCgiData, end. params: ").append(((Bundle) (obj)).toString()).toString());
        return ((Bundle) (obj));
    }

    protected Bundle d()
    {
        JSONArray jsonarray;
        Iterator iterator;
        List list = com.tencent.open.b.f.a().a("report_via");
        if (list != null)
        {
            d.addAll(list);
        }
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->prepareViaData, mViaList size: ").append(d.size()).toString());
        if (d.size() == 0)
        {
            return null;
        }
        jsonarray = new JSONArray();
        iterator = d.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1;
        b b1;
        Iterator iterator1;
        Serializable serializable = (Serializable)iterator.next();
        jsonobject1 = new JSONObject();
        b1 = (b)serializable;
        iterator1 = b1.a.keySet().iterator();
_L4:
        String s2;
        if (!iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = (String)iterator1.next();
        String s1 = (String)b1.a.get(s2);
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        try
        {
            jsonobject1.put(s2, s);
        }
        catch (JSONException jsonexception)
        {
            com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", jsonexception);
        }
        if (true) goto _L4; else goto _L3
_L3:
        jsonarray.put(jsonobject1);
          goto _L5
_L2:
        com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->prepareViaData, JSONArray array: ").append(jsonarray.toString()).toString());
        Bundle bundle = new Bundle();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("data", jsonarray);
        }
        catch (JSONException jsonexception1)
        {
            com.tencent.open.a.k.a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", jsonexception1);
            return null;
        }
        bundle.putString("data", jsonobject.toString());
        return bundle;
    }

    protected void e()
    {
        g.execute(new Runnable() {

            final g a;

            public void run()
            {
                int i;
                int j;
                int l;
                int i1;
                int j1;
                int k1;
                int l1;
                int i2;
                long l2;
                long l3;
                long l4;
                long l5;
                long l7;
                boolean flag;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                boolean flag5;
                boolean flag6;
                boolean flag7;
                Bundle bundle;
                n n1;
                JSONObject jsonobject;
                long l6;
                boolean flag1;
                try
                {
                    bundle = a.d();
                }
                catch (Exception exception)
                {
                    com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", exception);
                    return;
                }
                if (bundle == null)
                {
                    return;
                }
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportVia, params: ").append(bundle.toString()).toString());
                i2 = com.tencent.open.b.e.a();
                i1 = 0;
                flag1 = false;
                l5 = SystemClock.elapsedRealtime();
                l7 = 0L;
                l6 = 0L;
                l = 0;
_L5:
                j = i1 + 1;
                flag2 = flag1;
                l1 = j;
                flag3 = flag1;
                i1 = j;
                flag4 = flag1;
                flag5 = flag1;
                j1 = j;
                flag6 = flag1;
                k1 = j;
                flag7 = flag1;
                n1 = HttpUtils.a(com.tencent.open.utils.c.a(), "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", bundle);
                flag2 = flag1;
                l1 = j;
                flag3 = flag1;
                i1 = j;
                flag4 = flag1;
                flag5 = flag1;
                j1 = j;
                flag6 = flag1;
                k1 = j;
                flag7 = flag1;
                jsonobject = m.d(n1.a);
                flag2 = flag1;
                l1 = j;
                flag3 = flag1;
                i1 = j;
                flag4 = flag1;
                flag5 = flag1;
                j1 = j;
                flag7 = flag1;
                i = jsonobject.getInt("ret");
_L8:
                if (i == 0) goto _L2; else goto _L1
_L1:
                flag = flag1;
                i = j;
                flag2 = flag1;
                l1 = j;
                flag3 = flag1;
                i1 = j;
                flag4 = flag1;
                flag5 = flag1;
                j1 = j;
                flag6 = flag1;
                k1 = j;
                flag7 = flag1;
                if (TextUtils.isEmpty(n1.a)) goto _L3; else goto _L2
_L3:
                flag2 = flag;
                l1 = i;
                flag3 = flag;
                i1 = i;
                flag4 = flag;
                flag5 = flag;
                j1 = i;
                flag6 = flag;
                k1 = i;
                flag7 = flag;
                l2 = n1.b;
                flag2 = flag;
                l1 = i;
                flag3 = flag;
                i1 = i;
                flag5 = flag;
                j1 = i;
                flag6 = flag;
                k1 = i;
                flag7 = flag;
                l7 = n1.c;
                j = i;
                l4 = l5;
                l3 = l2;
                l2 = l7;
                i = l;
_L9:
                l = i;
                flag1 = flag;
                l6 = l2;
                l7 = l3;
                l5 = l4;
                i1 = j;
                if (j < i2) goto _L5; else goto _L4
_L4:
                l6 = l2;
_L10:
                a.a("mapp_apptrace_sdk", l4, l3, l6, i, null, false);
                if (!flag) goto _L7; else goto _L6
_L6:
                com.tencent.open.b.f.a().b("report_via");
_L11:
                a.d.clear();
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", (new StringBuilder()).append("-->doReportVia, uploadSuccess: ").append(flag).toString());
                return;
                JSONException jsonexception;
                jsonexception;
                i = -4;
                  goto _L8
                Object obj1;
                obj1;
                l4 = SystemClock.elapsedRealtime();
                j = l1;
                i = -7;
                l2 = 0L;
                l3 = 0L;
                flag = flag2;
                  goto _L9
                obj1;
                l4 = SystemClock.elapsedRealtime();
                l3 = 0L;
                l2 = 0L;
                i = -8;
                flag = flag3;
                j = i1;
                  goto _L9
                Object obj;
                obj;
                a.d.clear();
                com.tencent.open.a.k.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                return;
                obj;
                flag = flag4;
_L13:
                i = Integer.parseInt(((com.tencent.open.utils.HttpUtils.HttpStatusException) (obj)).getMessage().replace("http status code error:", ""));
                l = i;
_L12:
                i = l;
                l4 = l5;
                l3 = l7;
                  goto _L10
                obj1;
                l3 = 0L;
                l2 = 0L;
                i = HttpUtils.a(((IOException) (obj1)));
                flag = flag5;
                l4 = l5;
                j = j1;
                  goto _L9
_L7:
                com.tencent.open.b.f.a().a("report_via", a.d);
                  goto _L11
                obj;
                  goto _L12
                obj;
                l7 = l2;
                  goto _L13
_L2:
                flag = true;
                i = i2;
                  goto _L3
                obj1;
                l3 = 0L;
                l2 = 0L;
                i = -4;
                flag = flag6;
                l4 = l5;
                j = k1;
                  goto _L9
                obj1;
                l3 = 0L;
                l2 = 0L;
                i = -6;
                j = i2;
                flag = flag7;
                l4 = l5;
                  goto _L9
            }

            
            {
                a = g.this;
                super();
            }
        });
    }
}
