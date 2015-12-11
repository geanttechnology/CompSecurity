// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.shazam.android.activities.d;
import com.shazam.android.ad.e;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ConfigurablePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.k.f.j;
import com.shazam.android.util.s;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.c.f;
import com.shazam.android.widget.text.EmailValidEditText;
import com.shazam.android.widget.text.ValidationLabelContainerViewGroup;
import com.shazam.i.b.ah.c;
import com.shazam.i.b.ay.a.a;
import com.shazam.model.Factory;
import com.shazam.model.account.EmailAddressAccessor;
import com.shazam.model.account.EmailValidator;
import com.shazam.model.account.EmailViewState;
import com.shazam.p.a.b;

public class EmailSignupActivity extends BaseAppCompatActivity
    implements com.shazam.android.activities.d, SessionConfigurable, com.shazam.p.a.b
{
    private final class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final EmailSignupActivity a;

        public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            com.shazam.android.activities.account.EmailSignupActivity.b(a).requestFocus();
        }

        private a()
        {
            a = EmailSignupActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends e
    {

        final EmailSignupActivity a;

        public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
            com.shazam.l.a.b b1 = com.shazam.android.activities.account.EmailSignupActivity.a(a);
            charsequence = charsequence.toString();
            if (b1.b.a(charsequence))
            {
                b1.a.a();
                b1.a.d();
                b1.g = charsequence;
                return;
            } else
            {
                b1.a.b();
                b1.a.c();
                return;
            }
        }

        private b()
        {
            a = EmailSignupActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c extends e
    {

        final EmailSignupActivity a;

        public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
            com.shazam.android.activities.account.EmailSignupActivity.a(a).h = charsequence.toString();
        }

        private c()
        {
            a = EmailSignupActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d
        implements android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener
    {

        final EmailSignupActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.EmailSignupActivity.d(a);
        }

        public final boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
        {
            if (i1 == 5)
            {
                if (com.shazam.android.activities.account.EmailSignupActivity.c(a).isEnabled())
                {
                    com.shazam.android.activities.account.EmailSignupActivity.d(a);
                }
                return true;
            } else
            {
                return false;
            }
        }

        private d()
        {
            a = EmailSignupActivity.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }


    private final EmailAddressAccessor a = com.shazam.i.b.ah.c.a();
    private final f b = com.shazam.i.b.ay.a.a.b();
    private final s c = com.shazam.i.b.au.d.c();
    private final j d = new j();
    private final EventAnalyticsFromView e = com.shazam.i.b.g.b.a.b();
    private final d f = new d((byte)0);
    private com.shazam.l.a.b g;
    private View h;
    private EmailValidEditText i;
    private TextView j;
    private ArrayAdapter k;
    private ValidationLabelContainerViewGroup l;
    private AnimatorViewFlipper m;

    public EmailSignupActivity()
    {
    }

    static com.shazam.l.a.b a(EmailSignupActivity emailsignupactivity)
    {
        return emailsignupactivity.g;
    }

    static TextView b(EmailSignupActivity emailsignupactivity)
    {
        return emailsignupactivity.j;
    }

    static View c(EmailSignupActivity emailsignupactivity)
    {
        return emailsignupactivity.h;
    }

    static void d(EmailSignupActivity emailsignupactivity)
    {
        emailsignupactivity.e.logEvent(emailsignupactivity.i, AccountLoginEventFactory.eventWithAction("sendemail"));
        emailsignupactivity = emailsignupactivity.g;
        com.shazam.g.a a1 = (com.shazam.g.a)((com.shazam.l.a.b) (emailsignupactivity)).d.create(((com.shazam.l.a.b) (emailsignupactivity)).g);
        a1.a(new com.shazam.l.a.b.a(emailsignupactivity, (byte)0));
        a1.a();
        ((com.shazam.l.a.b) (emailsignupactivity)).a.b();
        ((com.shazam.l.a.b) (emailsignupactivity)).a.g();
    }

    private boolean j()
    {
        Intent intent = getIntent();
        return intent != null && intent.getData() != null && com.shazam.android.k.f.a.j.equals(intent.getData().toString());
    }

    private String k()
    {
        if (j())
        {
            return "emaillogin";
        } else
        {
            return "emailsignup";
        }
    }

    public final void a()
    {
        h.setEnabled(true);
    }

    public final void a(String s1)
    {
        i.append(s1);
        j.requestFocus();
    }

    public final void a(String as[])
    {
        k.addAll(as);
    }

    public final void b()
    {
        h.setEnabled(false);
    }

    public final void c()
    {
        i.a(EmailViewState.INVALID);
        l.a(EmailViewState.INVALID);
    }

    public void configureWith(Page page)
    {
        ((ConfigurablePage)page).setPageName(k());
    }

    public final void d()
    {
        i.a(EmailViewState.VALID);
        l.a(EmailViewState.VALID);
    }

    public final void e()
    {
        b.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.k, new Object[0]), i, com.shazam.android.k.f.j.a(getIntent()));
    }

    public final void f()
    {
        e.logEvent(i, AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL, BeaconErrorCode.FAILED, k()));
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090071;
        a1.h = 0x7f0300b6;
        s1.a(a1.a());
    }

    public final void g()
    {
        m.setDisplayedChild(1);
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(h.getWindowToken(), 0);
    }

    public final void h()
    {
        m.setDisplayedChild(0);
    }

    public final void i()
    {
        e.logEvent(i, AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL, BeaconErrorCode.UNAUTHORIZED, k()));
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09008a;
        a1.h = 0x7f0300b6;
        s1.a(a1.a());
        com.shazam.android.activities.b.b.b(this);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        g = new com.shazam.l.a.b(this, new com.shazam.android.ag.a.a(), a, com.shazam.i.b.v.b.a(getSupportLoaderManager(), this), com.shazam.i.b.a.a.a(), com.shazam.i.b.ad.a.a.a());
        h = findViewById(0x7f1100d1);
        j = (TextView)findViewById(0x7f1100d0);
        h = findViewById(0x7f1100d1);
        m = (AnimatorViewFlipper)findViewById(0x7f1100b4);
        i = (EmailValidEditText)findViewById(0x7f1100b5);
        l = (ValidationLabelContainerViewGroup)findViewById(0x7f1100cf);
        k = new ArrayAdapter(this, 0x1090003);
        i.setAdapter(k);
        i.addTextChangedListener(new b((byte)0));
        i.setOnItemClickListener(new a((byte)0));
        j.addTextChangedListener(new c((byte)0));
        h.setOnClickListener(f);
        setupToolbar(getToolbar());
        setDisplayHomeAsUp(false);
        setDisplayShowTitle(false);
        bundle = g;
        String s1 = ((com.shazam.l.a.b) (bundle)).c.a();
        int i1;
        int j1;
        if (com.shazam.b.e.a.c(s1))
        {
            ((com.shazam.l.a.b) (bundle)).a.a(s1);
        } else
        {
            ((com.shazam.l.a.b) (bundle)).a.c();
            ((com.shazam.l.a.b) (bundle)).a.b();
        }
        ((com.shazam.l.a.b) (bundle)).a.a(((com.shazam.l.a.b) (bundle)).c.b());
        if (j())
        {
            i.setOnEditorActionListener(f);
            i1 = 0;
            j1 = 0x7f09009d;
        } else
        {
            j.setOnEditorActionListener(f);
            j1 = 0x7f090061;
            i1 = 1;
        }
        ((TextView)findViewById(0x7f1100cd)).setText(j1);
        setTitle(j1);
        bundle = j;
        if (i1 != 0)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        bundle.setVisibility(i1);
    }

    protected void onStop()
    {
        super.onStop();
        h();
    }
}
