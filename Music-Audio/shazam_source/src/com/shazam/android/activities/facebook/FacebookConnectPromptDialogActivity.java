// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.shazam.android.activities.b;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.FacebookLogInEventFactory;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.i.b.au.d;
import com.shazam.i.b.g.b.a;
import com.shazam.l.a.c;
import com.shazam.model.facebook.FacebookLoginErrorSource;

public class FacebookConnectPromptDialogActivity extends com.shazam.android.activities.b
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final FacebookConnectPromptDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.c(a);
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.d(a);
        }

        private a()
        {
            a = FacebookConnectPromptDialogActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final FacebookConnectPromptDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.signUp(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, "likepopupfb"));
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.b(a).a();
        }

        private b()
        {
            a = FacebookConnectPromptDialogActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c extends com.shazam.p.g.c
    {

        final FacebookConnectPromptDialogActivity a;

        public final void a()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_SUCCESS, "likepopupfb", null));
            FacebookConnectPromptDialogActivity.e(a);
        }

        public final void a(FacebookLoginErrorSource facebookloginerrorsource)
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_ERROR, facebookloginerrorsource, "likepopupfb", null));
            FacebookConnectPromptDialogActivity.f(a);
        }

        public final void b()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_CANCEL, "likepopupfb", null));
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.d(a);
        }

        public final void c()
        {
            FacebookConnectPromptDialogActivity.g(a);
        }

        public final void d()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.b(a).c();
            FacebookConnectPromptDialogActivity.h(a).a();
        }

        private c()
        {
            a = FacebookConnectPromptDialogActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d extends com.shazam.p.i.a
    {

        final FacebookConnectPromptDialogActivity a;

        public final void a()
        {
            FacebookConnectPromptDialogActivity.h(a).c();
        }

        public final void g()
        {
            FacebookConnectPromptDialogActivity.g(a);
        }

        public final void h()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.FAILED, "likepopupfb", "socialsignup"));
            FacebookConnectPromptDialogActivity.f(a);
        }

        public final void i()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.FACEBOOK_ACCESS_TOKEN_MISSING, "socialsignup"));
            FacebookConnectPromptDialogActivity.f(a);
        }

        public final void j()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.success(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, "likepopupfb"));
            FacebookConnectPromptDialogActivity.i(a);
        }

        public final void k()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.c(a);
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.d(a);
        }

        public final void l()
        {
            com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.UNAUTHORIZED, "likepopupfb", "socialsignup"));
            com.shazam.android.activities.b.b.a(a, "", false);
            a.finish();
        }

        public final void m()
        {
            FacebookConnectPromptDialogActivity.h(a).d();
        }

        private d()
        {
            a = FacebookConnectPromptDialogActivity.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }


    private final s g = com.shazam.i.b.au.d.a();
    private final EventAnalytics h = com.shazam.i.b.g.b.a.a();
    private com.shazam.l.g.a i;
    private com.shazam.l.a.c j;

    public FacebookConnectPromptDialogActivity()
    {
    }

    static EventAnalytics a(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        return facebookconnectpromptdialogactivity.h;
    }

    private void a()
    {
        h.logEvent(AccountLoginEventFactory.cancel(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, "likepopupfb"));
    }

    static com.shazam.l.g.a b(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        return facebookconnectpromptdialogactivity.i;
    }

    static void c(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        facebookconnectpromptdialogactivity.a();
    }

    static void d(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        facebookconnectpromptdialogactivity.finish();
    }

    static void e(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        s s1 = facebookconnectpromptdialogactivity.g;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.b = (new StringBuilder()).append(facebookconnectpromptdialogactivity.getString(0x7f09016b)).append(" Facebook").toString();
        a1.h = 0x7f0300b8;
        s1.a(a1.a());
        facebookconnectpromptdialogactivity.finish();
    }

    static void f(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        facebookconnectpromptdialogactivity.g.a(r.a(0x7f090125));
        facebookconnectpromptdialogactivity.finish();
    }

    static void g(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        facebookconnectpromptdialogactivity.b(0x7f0300ad);
        ((com.shazam.android.activities.b) (facebookconnectpromptdialogactivity)).b.setEnabled(false);
        ((com.shazam.android.activities.b) (facebookconnectpromptdialogactivity)).a.setEnabled(false);
        ((com.shazam.android.activities.b) (facebookconnectpromptdialogactivity)).c.setEnabled(false);
    }

    static com.shazam.l.a.c h(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        return facebookconnectpromptdialogactivity.j;
    }

    static void i(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        s s1 = facebookconnectpromptdialogactivity.g;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09009f;
        a1.h = 0x7f0300b8;
        s1.a(a1.a());
        facebookconnectpromptdialogactivity.finish();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(0x7f09007e);
        b(0x7f03001f);
        d(0x7f09005c);
        c(0x7f0900bb);
        a(new b((byte)0));
        b(new a((byte)0));
        super.e = false;
        i = com.shazam.i.n.c.a.a(this, new c((byte)0));
        j = com.shazam.i.n.a.a.a(this, new d((byte)0), false);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        i.c();
        j.b();
    }
}
