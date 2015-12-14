// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.cyberlink.you.utility.ULogUtility;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.cyberlink.you:
//            a, g

public class MonitorService extends Service
{

    private static String a = "MonitorService";
    private static boolean b = true;
    private DefaultHttpClient c;
    private HttpHead d;
    private HttpParams e;
    private Runnable f;

    public MonitorService()
    {
        f = new Runnable() {

            final MonitorService a;

            public void run()
            {
_L5:
                if (!MonitorService.a()) goto _L2; else goto _L1
_L1:
                if (!com.cyberlink.you.a.a().g() || !g.a().b()) goto _L4; else goto _L3
_L3:
                Object obj2;
                String s;
                long l3;
                l3 = System.currentTimeMillis();
                obj2 = null;
                s = "";
                Object obj;
                long l;
                obj = MonitorService.b(a).execute(MonitorService.a(a));
                l = System.currentTimeMillis();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_68;
                }
                obj2 = ((HttpResponse) (obj)).getEntity();
                long l2;
                obj = s;
                l2 = l;
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_90;
                }
                ((HttpEntity) (obj2)).consumeContent();
                l2 = l;
                obj = s;
_L6:
                Object obj1;
                if (l2 == -1L)
                {
                    Log.w(MonitorService.b(), ((String) (obj)));
                    ULogUtility.a(((String) (obj)), "Monitor");
                } else
                {
                    long l1 = l2 - l3;
                    if (l1 > 5000L)
                    {
                        ULogUtility.a((new StringBuilder()).append("Slow response ").append(l1).append(" ms").toString(), "Monitor");
                    }
                }
_L4:
                try
                {
                    Thread.sleep(5000L);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((InterruptedException) (obj)).printStackTrace();
                }
                  goto _L5
                obj;
                ((Exception) (obj)).printStackTrace();
                obj = s;
                l2 = l;
                  goto _L6
                obj1;
                l = -1L;
_L7:
                obj2 = ((Exception) (obj1)).toString();
                obj1 = obj2;
                l2 = l;
                if (false)
                {
                    try
                    {
                        throw new NullPointerException();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        ((Exception) (obj1)).printStackTrace();
                    }
                    obj1 = obj2;
                    l2 = l;
                }
                  goto _L6
                obj1;
                if (false)
                {
                    try
                    {
                        throw new NullPointerException();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
                throw obj1;
_L2:
                Log.d(MonitorService.b(), "exit monitor");
                return;
                obj1;
                  goto _L7
            }

            
            {
                a = MonitorService.this;
                super();
            }
        };
    }

    static HttpHead a(MonitorService monitorservice)
    {
        return monitorservice.d;
    }

    static boolean a()
    {
        return b;
    }

    static String b()
    {
        return a;
    }

    static DefaultHttpClient b(MonitorService monitorservice)
    {
        return monitorservice.c;
    }

    private static void c()
    {
        b = false;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        Log.d(a, "onCreate");
        e = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(e, 3000);
        HttpConnectionParams.setSoTimeout(e, 3000);
        HttpClientParams.setRedirecting(e, false);
        c = new DefaultHttpClient(e);
        c.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        d = new HttpHead(new String(new char[] {
            'h', 't', 't', 'p', ':', '/', '/', 'w', 'w', 'w', 
            '.', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'c', 'o', 
            'm'
        }));
        d.setHeader(new BasicHeader("User-Agent", "U Monitor Agent 1.0"));
        d.setHeader(new BasicHeader("Connection", "close"));
        b = true;
        (new Thread(f)).start();
        super.onCreate();
    }

    public void onDestroy()
    {
        c();
        super.onDestroy();
        Log.d(a, "onDestroy");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }

    public void onTaskRemoved(Intent intent)
    {
        c();
        Log.d(a, (new StringBuilder()).append("onTaskRemoved ").append(intent.toString()).toString());
        com.cyberlink.you.a.a().f();
        stopSelf();
        super.onTaskRemoved(intent);
    }

}
