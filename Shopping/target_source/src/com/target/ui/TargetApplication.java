// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.h.b.s;
import com.parse.Parse;
import com.target.a.a.a;
import com.target.a.a.b;
import com.target.mothership.services.e;
import com.target.mothership.services.i;
import com.target.mothership.services.m;
import com.target.mothership.services.p;
import com.target.ui.analytics.c;
import com.target.ui.service.AppConfigUpdateService;
import com.target.ui.service.TargetGcmTaskService;
import com.target.ui.service.provider.f;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusBuilder;
import io.branch.referral.d;
import java.util.List;

public class TargetApplication extends Application
{

    private static final String TAG = com/target/ui/TargetApplication.getSimpleName();
    private com.target.ui.activity.a mActivityPrerequisites;
    private com.h.a.b refWatcherInstance;

    public TargetApplication()
    {
    }

    public static com.h.a.b a(Context context)
    {
        return ((TargetApplication)context.getApplicationContext()).refWatcherInstance;
    }

    private p a(com.target.mothership.services.f.b.a a1)
    {
        Object obj = new s();
        ((s) (obj)).v().add(com.target.ui.analytics.c.b());
        obj = new e(this, new m(((s) (obj))));
        return new i(com.target.ui.analytics.c.a(a1), ((p) (obj)));
    }

    private void a()
    {
        boolean flag = (new com.target.ui.service.TargetGcmTaskService.a(new a(this))).a((new com.google.android.gms.gcm.PeriodicTask.a()).a("update_app_config").a(com/target/ui/service/TargetGcmTaskService).a(0x15180L).b(900L).b(true).c(false).a(0).a(false).b());
        if ((new com.target.ui.b.a(this, com.target.mothership.a.a.a())).a() || !flag)
        {
            startService(new Intent(this, com/target/ui/service/AppConfigUpdateService));
        }
    }

    private void a(com.target.mothership.a.a a1)
    {
        a1.b("ybCeV1uWJ6gSLQKOZYEkRNlw5ULMFWfy").c("vK3ksggoAIpJKQo4OECH1yMPVtG3B4az").e("1016-0D87DC").d("93B8540D950A4846ADCA407DF0F2D5FA2CE5").a(com.target.mothership.services.f.b.a.a(1));
    }

    public static com.target.ui.activity.a b(Context context)
    {
        return ((TargetApplication)context.getApplicationContext()).mActivityPrerequisites;
    }

    private void b()
    {
        com.target.ui.util.c.a.a a1 = new com.target.ui.util.c.a.a();
        com.target.ui.util.c.a.a(EventBus.builder().installDefaultEventBus(), a1);
    }

    private com.target.mothership.a c()
    {
        com.target.mothership.c.a a1 = com.target.mothership.c.a.Live;
        com.target.mothership.a.a a2 = com.target.mothership.a.a().a(a1).a(this).a("25d84a27bee428a7fb9f2eeb").a(com.target.a.a.b.a(this));
        com.target.ui.util.i.a a3 = com.target.ui.util.i.c(this);
        if (a3 != com.target.ui.util.i.a.UAT);
        if (a3 != com.target.ui.util.i.a.Stage);
        a(a2);
        if (a1 != com.target.mothership.c.a.Debug)
        {
            a2.a(a(a2.mBaseHostProvider));
        }
        return a2.a();
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
        android.support.a.a.a(this);
    }

    public void onCreate()
    {
        super.onCreate();
        refWatcherInstance = com.h.a.a.a(this);
        mActivityPrerequisites = new com.target.ui.activity.a();
        com.target.mothership.c.a(c());
        b();
        com.target.ui.d.a.a(this, new f());
        a();
        Parse.initialize(this, "k1YUenSnNCmDQheQrLdSxQ91GMGUGPLJGTcaHqRJ", "2FvO3gc6GfZmJMmCesi7oNVy35aqDJ8vQOFMBtNv");
        d.c(this);
    }

}
