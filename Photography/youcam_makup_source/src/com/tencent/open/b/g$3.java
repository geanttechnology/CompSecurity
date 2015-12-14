// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.open.a.k;
import com.tencent.open.utils.c;
import com.tencent.open.utils.g;
import java.util.List;

// Referenced classes of package com.tencent.open.b:
//            g, a, b

class 
    implements Runnable
{

    final long a;
    final String b;
    final String c;
    final int d;
    final long e;
    final long f;
    final boolean g;
    final com.tencent.open.b.g h;

    public void run()
    {
        int j = 1;
        Object obj;
        StringBuilder stringbuilder;
        Object obj1;
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        l2 = a;
        obj = new Bundle();
        obj1 = com.tencent.open.b.a.a(com.tencent.open.utils.c.a());
        ((Bundle) (obj)).putString("apn", ((String) (obj1)));
        ((Bundle) (obj)).putString("appid", "1000067");
        ((Bundle) (obj)).putString("commandid", b);
        ((Bundle) (obj)).putString("detail", c);
        stringbuilder = new StringBuilder();
        stringbuilder.append("network=").append(((String) (obj1))).append('&');
        obj1 = stringbuilder.append("sdcard=");
        int i;
        int l;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            ((StringBuilder) (obj1)).append(i).append('&');
            stringbuilder.append("wifi=").append(com.tencent.open.b.a.e(com.tencent.open.utils.c.a()));
            ((Bundle) (obj)).putString("deviceInfo", stringbuilder.toString());
            i = 100 / h.a(d);
        }
        catch (Exception exception)
        {
            k.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", exception);
            return;
        }
        if (i > 0) goto _L2; else goto _L1
_L1:
        i = j;
_L4:
        ((Bundle) (obj)).putString("frequency", (new StringBuilder()).append(i).append("").toString());
        ((Bundle) (obj)).putString("reqSize", (new StringBuilder()).append(e).append("").toString());
        ((Bundle) (obj)).putString("resultCode", (new StringBuilder()).append(d).append("").toString());
        ((Bundle) (obj)).putString("rspSize", (new StringBuilder()).append(f).append("").toString());
        ((Bundle) (obj)).putString("timeCost", (new StringBuilder()).append(l1 - l2).append("").toString());
        ((Bundle) (obj)).putString("uin", "1000");
        obj = new b(((Bundle) (obj)));
        h.c.add(obj);
        l = h.c.size();
        j = com.tencent.open.utils.g.a(com.tencent.open.utils.c.a(), null).a("Agent_ReportTimeInterval");
        i = j;
        if (j == 0)
        {
            i = 10000;
        }
        if (h.a("report_cgi", l) || g)
        {
            h.b();
            h.f.removeMessages(1000);
            return;
        }
        if (!h.f.hasMessages(1000))
        {
            obj = Message.obtain();
            obj.what = 1000;
            h.f.sendMessageDelayed(((Message) (obj)), i);
            return;
        }
        return;
_L2:
        if (i > 100)
        {
            i = 100;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    g(com.tencent.open.b.g g1, long l, String s, String s1, int i, long l1, long l2, boolean flag)
    {
        h = g1;
        a = l;
        b = s;
        c = s1;
        d = i;
        e = l1;
        f = l2;
        g = flag;
        super();
    }
}
