// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.shazam.android.activities.d;
import com.shazam.android.analytics.AgofReportingDisabler;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.RegistrationEventFactory;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.b;
import com.shazam.i.b.c;
import com.shazam.i.b.g.b.a;

public class LegacyEmailRegistrationActivity extends BaseAppCompatActivity
    implements d, AgofReportingDisabler
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final LegacyEmailRegistrationActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.LegacyEmailRegistrationActivity.c(a).logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.RegistrationEventFactory.RegistrationAction.CHOOSE_ACCOUNT));
            if (com.shazam.android.activities.account.LegacyEmailRegistrationActivity.d(a))
            {
                view = com.shazam.android.activities.account.LegacyEmailRegistrationActivity.a();
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
                intent.setPackage("com.google.android.gms");
                intent.putExtra("allowableAccounts", null);
                intent.putExtra("allowableAccountTypes", view);
                intent.putExtra("addAccountOptions", null);
                intent.putExtra("selectedAccount", null);
                intent.putExtra("alwaysPromptForAccount", true);
                intent.putExtra("descriptionTextOverride", null);
                intent.putExtra("authTokenType", null);
                intent.putExtra("addAccountRequiredFeatures", null);
                intent.putExtra("setGmsCoreAccount", false);
                intent.putExtra("overrideTheme", 0);
                intent.putExtra("overrideCustomTheme", 0);
                a.startActivityForResult(intent, 123);
            }
        }

        private a()
        {
            a = LegacyEmailRegistrationActivity.this;
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

        final LegacyEmailRegistrationActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.LegacyEmailRegistrationActivity.a(a).logEvent(view, AccountLoginEventFactory.done());
            view = a;
            if (((LegacyEmailRegistrationActivity) (view)).c.b())
            {
                ((LegacyEmailRegistrationActivity) (view)).b.a();
                ((LegacyEmailRegistrationActivity) (view)).a.logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.RegistrationEventFactory.RegistrationAction.REGISTER));
            }
            com.shazam.android.activities.account.LegacyEmailRegistrationActivity.b(a);
        }

        private b()
        {
            a = LegacyEmailRegistrationActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.view.View.OnClickListener
    {

        final LegacyEmailRegistrationActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.LegacyEmailRegistrationActivity.a(a).logEvent(view, AccountLoginEventFactory.skip());
            com.shazam.android.activities.account.LegacyEmailRegistrationActivity.b(a);
        }

        private c()
        {
            a = LegacyEmailRegistrationActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private static final String d[] = {
        "com.google"
    };
    final EventAnalytics a = com.shazam.i.b.g.b.a.a();
    final com.shazam.android.service.a.b b = com.shazam.i.b.b.a();
    final com.shazam.android.persistence.a.c c = new com.shazam.android.persistence.a.d(AccountManager.get(com.shazam.i.b.c.a()), com.shazam.i.b.c.a().getResources(), com.shazam.i.b.ah.f.a());
    private TextView e;
    private final EventAnalyticsFromView f = com.shazam.i.b.g.b.a.b();

    public LegacyEmailRegistrationActivity()
    {
    }

    static EventAnalyticsFromView a(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        return legacyemailregistrationactivity.f;
    }

    static String[] a()
    {
        return d;
    }

    private void b()
    {
        e.setText(c.a());
    }

    static void b(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        legacyemailregistrationactivity.finish();
    }

    static EventAnalytics c(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        return legacyemailregistrationactivity.a;
    }

    static boolean d(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(legacyemailregistrationactivity);
        if (i != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i))
            {
                GooglePlayServicesUtil.getErrorDialog(i, legacyemailregistrationactivity, 1001).show();
            }
            return false;
        } else
        {
            return true;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 123 123: default 20
    //                   123 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            intent = intent.getStringExtra("authAccount");
            c.a(intent);
            b();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        f.logEvent(e, AccountLoginEventFactory.skip());
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030025);
        findViewById(0x7f1100cb).setOnClickListener(new b((byte)0));
        ((TextView)findViewById(0x7f1100ca)).setOnClickListener(new c((byte)0));
        e = (TextView)findViewById(0x7f1100c9);
        e.setOnClickListener(new a((byte)0));
        b();
    }

}
