// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

// Referenced classes of package com.nielsen.app.sdk:
//            a, AppCache, h, AppConfig, 
//            e, c, AppNative, d, 
//            AppRequestManager, AppScheduler, AppSdk

class AppTaskUploader extends AppScheduler.AppTask
{
    public class AppUploadRequest extends AppRequestManager.AppRequestHandler
    {

        public static final int BUFFER_SIZE = 0x3e800;
        public static final String REQUEST_NAME = "AppTaskUploader";
        public static final int TIMEOUT_CONNECTION = 60000;
        public static final int TIMEOUT_DATA = 60000;
        String a;
        AppRequestManager.AppRequest b;
        String c;
        final AppTaskUploader e;

        public void onError(String s, long l, Exception exception)
        {
            if (AppSdk.a())
            {
                exception = (new StringBuilder()).append("Nielsen AppSDK: Failed sending data ping - ");
                if (c != null && !c.isEmpty())
                {
                    s = c;
                } else
                {
                    s = "EMPTY";
                }
                Log.d("AppSdk", exception.append(s).toString());
            }
            if (AppTaskUploader.a(e).containsKey(a))
            {
                AppTaskUploader.a(e).remove(a);
            }
        }

        public void onFinish(String s, long l, String s1)
        {
            com.nielsen.app.sdk.c.a('I', "UPLOAD ended successfully", new Object[0]);
            if (AppSdk.a())
            {
                s1 = (new StringBuilder()).append("Nielsen AppSDK: Sent data ping successfully - ");
                if (c != null && !c.isEmpty())
                {
                    s = c;
                } else
                {
                    s = "EMPTY";
                }
                Log.d("AppSdk", s1.append(s).toString());
            }
            if (AppTaskUploader.a(e).containsKey(a))
            {
                AppTaskUploader.a(e).remove(a);
            }
        }

        public void onIdle(String s, long l)
        {
        }

        public void onStart(String s, long l)
        {
        }

        public void onUpdate(String s, long l, long l1, long l2, 
                String s1)
        {
        }

        public void startRequest()
            throws Exception
        {
            com.nielsen.app.sdk.c.a('I', "Sending Message: %s", new Object[] {
                c
            });
            b.get(e.c, c);
        }

        public AppUploadRequest(String s)
            throws Exception
        {
            e = AppTaskUploader.this;
            AppRequestManager apprequestmanager = d;
            apprequestmanager.getClass();
            super(apprequestmanager, "AppTaskUploader");
            a = "";
            b = null;
            c = null;
            apprequestmanager = d;
            apprequestmanager.getClass();
            b = new AppRequestManager.AppRequest(apprequestmanager, "AppTaskUploader", this, 60000, 60000, 0x3e800);
            c = s;
            a = (new StringBuilder()).append("AppTaskUploader_").append(String.valueOf(com.nielsen.app.sdk.h.s())).toString();
            AppTaskUploader.a(AppTaskUploader.this).put(a, this);
        }
    }


    public static final String a = "AppUpload";
    public static final int b = 2000;
    String c;
    AppRequestManager d;
    private AppNative e;
    private AppConfig g;
    private h h;
    private Map i;
    private Lock j;

    public AppTaskUploader(AppScheduler appscheduler, long l, String s)
        throws Exception
    {
        long l1 = 2000L;
        appscheduler.getClass();
        if (l > 2000L)
        {
            l1 = l;
        }
        super(appscheduler, "AppUpload", 0L, l1);
        e = null;
        g = null;
        h = null;
        c = "";
        i = null;
        d = null;
        j = new ReentrantLock();
        d = com.nielsen.app.sdk.a.t();
        e = com.nielsen.app.sdk.a.q();
        g = com.nielsen.app.sdk.a.n();
        h = com.nielsen.app.sdk.a.m();
        i = new HashMap();
        c = s;
    }

    static Map a(AppTaskUploader apptaskuploader)
    {
        return apptaskuploader.i;
    }

    public void a(String s)
    {
        c = s;
    }

    public boolean execute()
    {
        AppCache appcache;
        long l1;
        j.lock();
        appcache = com.nielsen.app.sdk.a.o();
        l1 = appcache.d();
        if (l1 > 0L) goto _L2; else goto _L1
_L1:
        Object obj = j;
_L4:
        ((Lock) (obj)).unlock();
        return true;
_L2:
        boolean flag = h.r();
        if (!flag)
        {
            obj = j;
            continue; /* Loop/switch isn't completed */
        }
        flag = g.h();
        if (!flag)
        {
            obj = j;
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1;
        flag = h.a();
        flag1 = h.d();
        if (!flag && !flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = j;
        if (true) goto _L4; else goto _L3
_L3:
        Iterator iterator;
        e e1;
        iterator = appcache.a(1, true).iterator();
        e1 = com.nielsen.app.sdk.e.b();
        Object obj1;
        int k;
        long l2;
        obj1 = null;
        l2 = -1L;
        obj = "";
        k = -1;
        l1 = 0L;
_L12:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        AppCache.ProcessorData processordata = (AppCache.ProcessorData)iterator.next();
        int l = processordata.getMessage();
        l;
        JVM INSTR tableswitch 7 7: default 204
    //                   7 307;
           goto _L7 _L8
_L7:
        Object obj2;
        Object obj3 = obj;
        obj = obj1;
        obj2 = "";
        obj1 = obj3;
_L31:
        if (obj2 == null) goto _L10; else goto _L9
_L9:
        Object obj4;
        Object obj5;
        Object obj6;
        obj6 = obj2;
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        if (!((String) (obj2)).isEmpty()) goto _L11; else goto _L10
_L10:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        obj6 = processordata.getData();
_L11:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        (new AppUploadRequest(((String) (obj6)))).startRequest();
_L33:
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L32:
        l2 = processordata.getKey();
          goto _L12
_L8:
        com.nielsen.app.sdk.c.a('I', "parsing PING on Uploader", new Object[0]);
        l = processordata.getProcessor();
        if (k == l) goto _L14; else goto _L13
_L13:
        long l3;
        l3 = l1;
        obj2 = obj1;
        obj5 = e1.a(l);
        if (obj5 != null) goto _L16; else goto _L15
_L15:
        k = l;
          goto _L12
_L16:
        l2 = l1;
        obj4 = obj1;
        if (obj1 == null) goto _L18; else goto _L17
_L17:
        l3 = l1;
        obj2 = obj1;
        ((AppConfig.a) (obj1)).a();
        if (l1 == 0L) goto _L20; else goto _L19
_L19:
        l3 = l1;
        obj2 = obj1;
        e.b(l1);
          goto _L20
_L18:
        l3 = l2;
        obj2 = obj4;
        obj1 = ((d) (obj5)).e();
        l3 = l2;
        obj2 = obj4;
        obj6 = g;
        l3 = l2;
        obj2 = obj4;
        obj6.getClass();
        l3 = l2;
        obj2 = obj4;
        obj1 = new AppConfig.a(((AppConfig) (obj6)), null, ((Map) (obj1)));
        l1 = l2;
        if (obj1 == null) goto _L22; else goto _L21
_L21:
        l1 = e.a();
        l2 = l1;
        ((AppConfig.a) (obj1)).a(l1);
_L22:
        l2 = l1;
        obj2 = ((d) (obj5)).f();
        k = l;
        obj = obj1;
        obj1 = obj2;
_L37:
        if (obj == null) goto _L24; else goto _L23
_L23:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        ((AppConfig.a) (obj)).b(new JSONObject(processordata.getData()));
        if (obj1 == null) goto _L26; else goto _L25
_L25:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        if (((String) (obj1)).isEmpty()) goto _L26; else goto _L27
_L27:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        obj2 = new boolean[1];
        obj2[0] = 0;
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        obj6 = ((AppConfig.a) (obj)).a(((String) (obj1)), ((boolean []) (obj2)));
        if (!obj2[0] || obj6 == null) goto _L29; else goto _L28
_L28:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        if (((String) (obj6)).isEmpty()) goto _L29; else goto _L30
_L30:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        obj2 = (new StringBuilder()).append(((String) (obj6))).append("&rnd=").append(com.nielsen.app.sdk.h.s()).toString();
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        com.nielsen.app.sdk.c.a('I', "generate PING on Uploader", new Object[0]);
          goto _L31
        obj2;
        obj = obj5;
        l1 = l2;
        k = l;
        obj1 = obj4;
_L36:
        com.nielsen.app.sdk.c.a(((Throwable) (obj2)), true, 10, 'E', "Failed sending ping: %s", new Object[] {
            obj
        });
          goto _L32
_L29:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        com.nielsen.app.sdk.c.a('I', "parsing failed. Can't send PING", new Object[0]);
          goto _L33
        obj;
        j.unlock();
        throw obj;
_L26:
        obj5 = obj1;
        l = k;
        l2 = l1;
        obj4 = obj;
        com.nielsen.app.sdk.c.a('I', "no URL to parse. Can't send PING", new Object[0]);
          goto _L33
_L6:
        appcache.a(1, l2);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_852;
        }
        ((AppConfig.a) (obj1)).a();
        if (l1 == 0L)
        {
            break MISSING_BLOCK_LABEL_852;
        }
        e.b(l1);
        obj = j;
_L35:
        ((Lock) (obj)).unlock();
        return true;
        obj;
        com.nielsen.app.sdk.c.a(((Throwable) (obj)), true, 'W', "Error while UPLOADING pings to Census", new Object[0]);
        obj = j;
        if (true) goto _L35; else goto _L34
_L34:
        obj2;
          goto _L36
        obj4;
        l1 = l3;
        k = l;
        obj1 = obj2;
        obj2 = obj4;
          goto _L36
        obj2;
        l1 = l2;
        k = l;
          goto _L36
_L14:
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
          goto _L37
_L24:
        obj2 = "";
          goto _L31
_L20:
        obj4 = null;
        l2 = 0L;
          goto _L18
    }
}
