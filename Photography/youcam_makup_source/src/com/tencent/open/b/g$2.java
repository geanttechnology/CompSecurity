// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.k;
import com.tencent.open.utils.c;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.tencent.open.b:
//            g, c, a, b

class 
    implements Runnable
{

    final Bundle a;
    final boolean b;
    final com.tencent.open.b.g c;

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
        ((Bundle) (obj)).putString("os_ver", android.os.d.VERSION.RELEASE);
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
        j = g.a(com.tencent.open.utils.c.a(), null).a("Agent_ReportTimeInterval");
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
            k.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", exception);
        }
        return;
    }

    g(com.tencent.open.b.g g1, Bundle bundle, boolean flag)
    {
        c = g1;
        a = bundle;
        b = flag;
        super();
    }
}
