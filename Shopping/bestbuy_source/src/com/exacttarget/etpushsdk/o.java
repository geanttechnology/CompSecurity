// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.event.ReadyAimFireInitCompletedEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.i;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush, ETPushConfig, ETAnalytics, 
//            ETLocationManager, ETCloudPageManager

final class o
    implements Runnable
{

    final ETPushConfig a;

    o(ETPushConfig etpushconfig)
    {
        a = etpushconfig;
        super();
    }

    public void run()
    {
        boolean flag;
        flag = false;
        try
        {
            ETPush.a(new ETPush.a(1));
            d.a(a.b);
            d.b(a.c);
            d.c(a.d);
            d.a(a.e);
            d.b(a.f);
            d.c(a.g);
            d.e(a.i);
            d.d(a.h);
            d.a();
            i.a(ETPush.k());
            ETPush.a(new ETPush(null));
            ETPush.a(new Registration());
            ETPush.a(Boolean.valueOf(ETPush.l()));
            com.exacttarget.etpushsdk.ETPush.n().setPushEnabled(com.exacttarget.etpushsdk.ETPush.m());
            ETPush.o().c();
            m.a("~!ETPush", "ETPush singleton getInstance initialization completed.");
            if (!d.a(ETPush.k()))
            {
                ETPush.p();
            }
            if (a.e | a.f)
            {
                ETAnalytics.a(ETPush.k());
            }
            if (a.g)
            {
                ETLocationManager.a(ETPush.k());
            }
            if (a.i)
            {
                ETCloudPageManager.a(ETPush.k());
            }
        }
        catch (ETException etexception)
        {
            m.c("~!ETPush", etexception.getMessage(), etexception);
            ETPush.q();
            ETPush.a(null);
            EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(false, etexception));
            return;
        }
        ETPush.r().c();
        m.a("~!ETPush", "readyAimFire() initialization completed");
        if (ETPush.s() != null)
        {
            EventBus.getInstance().register(ETPush.s());
        }
        EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(true));
        if (d.a(ETPush.k()) || !ETPush.s().j()) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(com.exacttarget.etpushsdk.ETPush.n().getSystemTokenFromCache())) goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        ETPush.s().i();
_L2:
        return;
_L4:
        if (((Integer)d.a(ETPush.a(), "gcm_app_version_key", Integer.valueOf(0x80000000), new Object[] {
    ETPush.a().getSharedPreferences("~!ETPush", 0)
})).intValue() == n.a())
        {
            break MISSING_BLOCK_LABEL_400;
        }
        m.b("~!ETPush", "App version code changed.");
        flag = true;
        String s = (String)d.a(ETPush.a(), "gcm_sender_id_key", null, new Object[] {
            ETPush.a().getSharedPreferences("~!ETPush", 0)
        });
        if (s.equals(d.d()))
        {
            continue; /* Loop/switch isn't completed */
        }
        m.a("~!ETPush", String.format("GCM Sender Id changed. Old: %s New: %s", new Object[] {
            s, d.d()
        }));
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        try
        {
            ETPush.f();
            return;
        }
        catch (ETException etexception1)
        {
            m.c("~!ETPush", etexception1.getMessage(), etexception1);
        }
        return;
    }
}
