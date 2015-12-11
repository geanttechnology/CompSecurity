// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.shazam.android.activities.c;
import com.shazam.android.activities.d;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.StartupEventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.k.f.j;
import com.shazam.android.util.s;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.c.f;
import com.shazam.android.widget.facebook.FacebookLoginButton;
import com.shazam.android.widget.image.LargeBitmapImageView;
import com.shazam.g.e;
import com.shazam.i.b.ay.a.a;
import com.shazam.k.t;
import com.shazam.model.Factory;
import com.shazam.model.account.UserState;
import com.shazam.model.configuration.EmailRegistrationConfiguration;
import com.shazam.model.configuration.EmailRegistrationStyleConfiguration;
import com.shazam.p.i.b;

public class SignUpActivity extends BaseAppCompatActivity
    implements android.content.DialogInterface.OnClickListener, com.shazam.android.activities.c, com.shazam.android.activities.d, com.shazam.p.i.b
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final SignUpActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.SignUpActivity.a(a).logEvent(view, AccountLoginEventFactory.signUp(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK));
            com.shazam.android.activities.account.SignUpActivity.b(a).c();
        }

        private a()
        {
            a = SignUpActivity.this;
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

        final SignUpActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.SignUpActivity.a(a).logEvent(view, AccountLoginEventFactory.cancel());
            view = com.shazam.android.activities.account.SignUpActivity.b(a);
            ((com.shazam.l.a.c) (view)).g.a(UserState.ANONYMOUS);
            if (((com.shazam.l.a.c) (view)).e.a() && !((com.shazam.l.a.c) (view)).f.a() && ((com.shazam.l.a.c) (view)).l)
            {
                ((com.shazam.l.a.c) (view)).a.d();
                return;
            } else
            {
                ((com.shazam.l.a.c) (view)).a.c();
                return;
            }
        }

        private b()
        {
            a = SignUpActivity.this;
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

        final SignUpActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.SignUpActivity.c(a).dismiss();
            com.shazam.android.activities.account.SignUpActivity.b(a).d();
        }

        private c()
        {
            a = SignUpActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d
        implements android.view.View.OnClickListener
    {

        final SignUpActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.SignUpActivity.a(a).logEvent(view, AccountLoginEventFactory.logIn(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL));
            com.shazam.android.activities.account.SignUpActivity.b(a).a.f();
        }

        private d()
        {
            a = SignUpActivity.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }

    private final class e
        implements android.view.View.OnClickListener
    {

        final SignUpActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.SignUpActivity.a(a).logEvent(view, AccountLoginEventFactory.signUp(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL));
            com.shazam.android.activities.account.SignUpActivity.b(a).a.e();
        }

        private e()
        {
            a = SignUpActivity.this;
            super();
        }

        e(byte byte0)
        {
            this();
        }
    }


    private final com.shazam.android.j.r.a a = com.shazam.i.b.n.b.o();
    private final f b = com.shazam.i.b.ay.a.a.b();
    private final s c = com.shazam.i.b.au.d.c();
    private final EventAnalyticsFromView d = com.shazam.i.b.g.b.a.b();
    private final j e = new j();
    private final Factory f = new com.shazam.android.fragment.c.b();
    private com.shazam.l.a.c g;
    private FacebookLoginButton h;
    private TextView i;
    private View j;
    private View k;
    private View l;
    private AlertDialog m;
    private AlertDialog n;
    private AnimatorViewFlipper o;
    private View p;

    public SignUpActivity()
    {
    }

    static EventAnalyticsFromView a(SignUpActivity signupactivity)
    {
        return signupactivity.d;
    }

    static com.shazam.l.a.c b(SignUpActivity signupactivity)
    {
        return signupactivity.g;
    }

    private void b(int i1)
    {
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = i1;
        a1.h = 0x7f0300b6;
        s1.a(a1.a());
        o();
    }

    static AlertDialog c(SignUpActivity signupactivity)
    {
        return signupactivity.m;
    }

    private void o()
    {
        FacebookLoginButton facebookloginbutton = h;
        facebookloginbutton.a.animate().alpha(1.0F).start();
        facebookloginbutton.b.animate().alpha(0.0F).setListener(new com.shazam.android.widget.a.c(facebookloginbutton.b, 8)).start();
        j.setEnabled(true);
        l.setEnabled(true);
        k.setEnabled(true);
    }

    public final void a()
    {
        a(0);
    }

    public final void a(int i1)
    {
        o.a(1, i1);
        h.a();
        com.shazam.i.b.g.b.b.a().sendStartupEvent();
    }

    public final void a(String s1)
    {
        i.setText(s1);
    }

    public final void b()
    {
        String s1 = a.a();
        String s2 = a.b();
        if (!com.shazam.b.e.a.c(s1))
        {
            if (com.shazam.b.e.a.c(s2))
            {
                s1 = s2;
            } else
            {
                s1 = getString(0x7f0900fa);
            }
        }
        p.setVisibility(8);
        n = (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0900b8)).setMessage(s1).setPositiveButton(0x7f0900fd, this).setNegativeButton(0x7f090079, this).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final SignUpActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.finish();
            }

            
            {
                a = SignUpActivity.this;
                super();
            }
        }).show();
    }

    public final void c()
    {
        android.os.Parcelable parcelable = getIntent().getParcelableExtra("com.shazam.android.FirstTimeUser.ON_SUCCESS_INTENT");
        boolean flag;
        if (parcelable instanceof Intent)
        {
            startActivity((Intent)parcelable);
            finish();
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            com.shazam.android.activities.b.a.a(this, false);
            finish();
        }
    }

    public final void d()
    {
        b.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.h, new Object[0]), j, com.shazam.android.k.f.j.a(getIntent()));
    }

    public final void e()
    {
        b.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.i, new Object[0]), k, com.shazam.android.k.f.j.a(getIntent()));
    }

    public final void f()
    {
        b.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.j, new Object[0]));
    }

    public final void g()
    {
        FacebookLoginButton facebookloginbutton = h;
        facebookloginbutton.a.animate().alpha(0.0F).start();
        facebookloginbutton.b.setVisibility(0);
        facebookloginbutton.b.animate().alpha(1.0F).start();
        j.setEnabled(false);
        l.setEnabled(false);
        k.setEnabled(false);
    }

    public final void h()
    {
        d.logEvent(h, AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.FAILED, "socialsignup"));
        b(0x7f090071);
    }

    public final void i()
    {
        d.logEvent(h, AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.FACEBOOK_ACCESS_TOKEN_MISSING, "socialsignup"));
        b(0x7f09007f);
    }

    public final void j()
    {
        d.logEvent(h, AccountLoginEventFactory.success(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK));
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09009f;
        a1.h = 0x7f0300b8;
        s1.a(a1.a());
        c();
    }

    public final void k()
    {
        o();
    }

    public final void l()
    {
        d.logEvent(h, AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.FACEBOOK, BeaconErrorCode.UNAUTHORIZED, "socialsignup"));
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09008a;
        a1.h = 0x7f0300b6;
        s1.a(a1.a());
        com.shazam.android.activities.b.b.a(this);
        finish();
    }

    public final void m()
    {
        m = (AlertDialog)f.create(this);
        m.show();
        m.getButton(-1).setOnClickListener(new c((byte)0));
    }

    public final void n()
    {
        b.a(this, Uri.parse(com.shazam.android.k.f.a.g), j, com.shazam.android.k.f.j.a(getIntent()));
    }

    public void onClick(DialogInterface dialoginterface, int i1)
    {
        p.setVisibility(0);
        switch (i1)
        {
        default:
            finish();
            return;

        case -1: 
            d.logEvent(k, AccountLoginEventFactory.retry());
            break;
        }
        g.a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002e);
        ((LargeBitmapImageView)findViewById(0x7f1100c6)).a(0x7f020082, 0x7f0f0090);
        i = (TextView)findViewById(0x7f110108);
        j = findViewById(0x7f11010a);
        k = findViewById(0x7f11010d);
        l = findViewById(0x7f11010c);
        h = (FacebookLoginButton)findViewById(0x7f11010b);
        o = (AnimatorViewFlipper)findViewById(0x7f1100d2);
        p = findViewById(0x7f1100d9);
        j.setOnClickListener(new e((byte)0));
        k.setOnClickListener(new b((byte)0));
        l.setOnClickListener(new d((byte)0));
        h.setOnClickListener(new a((byte)0));
        boolean flag;
        if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("com.shazam.android.extras.FROM_LAUNCH"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = com.shazam.i.n.a.a.a(this, this, flag);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        g.b();
    }

    protected void onPause()
    {
        super.onPause();
        if (n != null)
        {
            n.dismiss();
        }
        com.shazam.l.a.c c1 = g;
        c1.b.b();
        c1.c.b();
        c1.n.b();
        c1.m.b();
    }

    protected void onResume()
    {
        super.onResume();
        g.a();
    }
}
