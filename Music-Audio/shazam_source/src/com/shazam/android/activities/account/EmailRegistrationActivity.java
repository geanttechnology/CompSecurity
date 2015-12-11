// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.shazam.android.ad.e;
import com.shazam.android.analytics.AgofReportingDisabler;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.RegistrationEventFactory;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.j.g.j;
import com.shazam.android.widget.image.LargeBitmapImageView;
import com.shazam.android.widget.text.EmailValidEditText;
import com.shazam.android.widget.text.ValidationLabelContainerViewGroup;
import com.shazam.i.b.ah.c;
import com.shazam.i.b.b;
import com.shazam.i.b.g.b.a;
import com.shazam.model.account.EmailAddressAccessor;
import com.shazam.model.account.EmailValidator;
import com.shazam.model.account.EmailViewState;

public class EmailRegistrationActivity extends BaseAppCompatActivity
    implements AgofReportingDisabler
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final EmailRegistrationActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.EmailRegistrationActivity.c(a).logEvent(view, AccountLoginEventFactory.skip());
            EmailRegistrationActivity.h(a);
        }

        private a()
        {
            a = EmailRegistrationActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends e
    {

        final EmailRegistrationActivity a;

        public final void onTextChanged(CharSequence charsequence, int k, int l, int i1)
        {
            super.onTextChanged(charsequence, k, l, i1);
            if (com.shazam.android.activities.account.EmailRegistrationActivity.a(a))
            {
                EmailRegistrationActivity.i(a);
                return;
            } else
            {
                com.shazam.android.activities.account.EmailRegistrationActivity.j(a);
                return;
            }
        }

        private b()
        {
            a = EmailRegistrationActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener
    {

        final EmailRegistrationActivity a;

        private void a()
        {
            if (com.shazam.android.activities.account.EmailRegistrationActivity.a(a))
            {
                com.shazam.android.activities.account.EmailRegistrationActivity.c(a).logEvent(com.shazam.android.activities.account.EmailRegistrationActivity.b(a), AccountLoginEventFactory.done());
                j j1 = com.shazam.android.activities.account.EmailRegistrationActivity.e(a);
                String s = EmailRegistrationActivity.d(a).getText().toString();
                j1.a.b("pk_re", s);
                EmailRegistrationActivity.f(a).a();
                EmailRegistrationActivity.g(a).logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.RegistrationEventFactory.RegistrationAction.REGISTER));
                EmailRegistrationActivity.h(a);
            }
        }

        public final void onClick(View view)
        {
            a();
        }

        public final boolean onEditorAction(TextView textview, int k, KeyEvent keyevent)
        {
            if (k == 6)
            {
                a();
                return true;
            } else
            {
                return false;
            }
        }

        private c()
        {
            a = EmailRegistrationActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private final EmailAddressAccessor a = com.shazam.i.b.ah.c.a();
    private final EventAnalytics b = com.shazam.i.b.g.b.a.a();
    private final com.shazam.android.service.a.b c = com.shazam.i.b.b.a();
    private final j d = com.shazam.i.b.n.b.n();
    private final c e = new c((byte)0);
    private final EmailValidator f = new com.shazam.android.ag.a.a();
    private final EventAnalyticsFromView g = com.shazam.i.b.g.b.a.b();
    private EmailValidEditText h;
    private View i;
    private ValidationLabelContainerViewGroup j;

    public EmailRegistrationActivity()
    {
    }

    static boolean a(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.f.a(emailregistrationactivity.h.getText().toString());
    }

    static View b(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.i;
    }

    static EventAnalyticsFromView c(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.g;
    }

    static EmailValidEditText d(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.h;
    }

    static j e(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.d;
    }

    static com.shazam.android.service.a.b f(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.c;
    }

    static EventAnalytics g(EmailRegistrationActivity emailregistrationactivity)
    {
        return emailregistrationactivity.b;
    }

    static void h(EmailRegistrationActivity emailregistrationactivity)
    {
        Intent intent = com.shazam.android.activities.b.a.b(emailregistrationactivity, false);
        intent.setFlags(32768);
        emailregistrationactivity.startActivity(intent);
    }

    static void i(EmailRegistrationActivity emailregistrationactivity)
    {
        emailregistrationactivity.h.a(EmailViewState.VALID);
        emailregistrationactivity.j.a(EmailViewState.VALID);
        emailregistrationactivity.i.setEnabled(true);
    }

    static void j(EmailRegistrationActivity emailregistrationactivity)
    {
        emailregistrationactivity.h.a(EmailViewState.INVALID);
        emailregistrationactivity.j.a(EmailViewState.INVALID);
        emailregistrationactivity.i.setEnabled(false);
    }

    public void onBackPressed()
    {
        g.logEvent(i, AccountLoginEventFactory.skip());
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001d);
        ((LargeBitmapImageView)findViewById(0x7f1100c6)).a(0x7f020082, 0x7f0f0090);
        i = findViewById(0x7f1100cb);
        i.setOnClickListener(e);
        ((TextView)findViewById(0x7f1100ca)).setOnClickListener(new a((byte)0));
        j = (ValidationLabelContainerViewGroup)findViewById(0x7f1100c8);
        h = (EmailValidEditText)findViewById(0x7f1100c9);
        h.addTextChangedListener(new b((byte)0));
        h.setOnEditorActionListener(e);
        bundle = a.a();
        h.append(bundle);
    }
}
