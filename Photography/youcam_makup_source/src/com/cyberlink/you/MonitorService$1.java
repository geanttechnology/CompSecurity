// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.util.Log;
import com.cyberlink.you.utility.ULogUtility;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.cyberlink.you:
//            MonitorService, a, g

class a
    implements Runnable
{

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

    ty(MonitorService monitorservice)
    {
        a = monitorservice;
        super();
    }
}
