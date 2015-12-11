// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.paypal.android.sdk.az;
import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cx;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.dr;
import com.paypal.android.sdk.ds;
import com.paypal.android.sdk.ea;
import com.paypal.android.sdk.eq;
import com.paypal.android.sdk.ew;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.f;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.fc;
import com.paypal.android.sdk.fd;
import com.paypal.android.sdk.ff;
import com.paypal.android.sdk.fg;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk.payments:
//            t, bg, bh, br, 
//            PayPalService, ac, q, aj, 
//            o, p, i, bq, 
//            r, PayPalConfiguration, n, aa, 
//            ad, ae, af, ag, 
//            ah, ai, v, w, 
//            x, y, z, ab

public final class LoginActivity extends Activity
{

    private bg a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private eq h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private fd o;
    private boolean p;
    private PayPalService q;
    private final ServiceConnection r = new t(this);

    public LoginActivity()
    {
        com/paypal/android/sdk/payments/LoginActivity.getSimpleName();
    }

    static int a(LoginActivity loginactivity, int i1)
    {
        loginactivity.n = i1;
        return i1;
    }

    private eq a(bg bg1)
    {
        g();
        if (bg1 == bg.b)
        {
            bg1 = cn.a();
            if (e == null)
            {
                bg1 = new ew(bg1, d);
            } else
            {
                bg1 = new ew(bg1, new f(e), d);
            }
            return new eq(bg1, f);
        }
        if (bg1 == bg.a)
        {
            return new eq(b, c);
        } else
        {
            return h;
        }
    }

    static PayPalService a(LoginActivity loginactivity, PayPalService paypalservice)
    {
        loginactivity.q = paypalservice;
        return paypalservice;
    }

    static void a(Activity activity, String s, PayPalConfiguration paypalconfiguration)
    {
        Intent intent = new Intent(activity, com/paypal/android/sdk/payments/LoginActivity);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.persistedLogin", null);
        intent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", true);
        intent.putExtra("com.paypal.android.sdk.payments.forceLogin", false);
        intent.putExtra("com.paypal.android.sdk.payments.requestedScopes", s);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", paypalconfiguration);
        activity.startActivityForResult(intent, 1);
    }

    static void a(LoginActivity loginactivity)
    {
        loginactivity.h();
    }

    static void a(LoginActivity loginactivity, bg bg1)
    {
        loginactivity.b(bg1);
    }

    static void a(LoginActivity loginactivity, bh bh1)
    {
        if (bh1.b())
        {
            loginactivity.d();
            return;
        }
        boolean flag;
        if (bh1.a() && bh1.b.equals("invalid_user"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            loginactivity.o();
            br.a(loginactivity, ex.a(fa.bs), 3);
            return;
        }
        if (bh1.c())
        {
            loginactivity.o();
            br.a(loginactivity, ex.a(bh1.b), 3);
            return;
        }
        if ("invalid_nonce".equals(bh1.b))
        {
            loginactivity.g = null;
            loginactivity.o();
            br.a(loginactivity, ex.a(fa.aL), 5);
            return;
        } else
        {
            loginactivity.g = null;
            loginactivity.o();
            br.a(loginactivity, ex.a(bh1.b), 4);
            return;
        }
    }

    static void a(LoginActivity loginactivity, String s)
    {
        loginactivity.c = null;
        loginactivity.f = null;
        loginactivity.o();
        br.a(loginactivity, ex.a(s), 1);
    }

    private String b()
    {
        if (c())
        {
            return "code";
        } else
        {
            return "token";
        }
    }

    static void b(LoginActivity loginactivity)
    {
        eq eq1 = loginactivity.a(loginactivity.a);
        if (loginactivity.a == bg.b)
        {
            loginactivity.h = new eq(eq1.d(), null);
            loginactivity.b(bg.d);
        } else
        {
            loginactivity.h = new eq(eq1.b(), null);
            loginactivity.b(bg.c);
        }
        loginactivity.q.a(eq1, loginactivity.k, loginactivity.b(), loginactivity.c(), loginactivity.i);
    }

    static void b(LoginActivity loginactivity, String s)
    {
        loginactivity.o();
        if ("invalid_nonce".equals(s))
        {
            br.a(loginactivity, ex.a(fa.aL), 5);
            return;
        } else
        {
            br.a(loginactivity, ex.a(s), 2);
            return;
        }
    }

    private void b(bg bg1)
    {
        (new StringBuilder("changeLoginState:")).append(bg1);
        if (bg1 != null)
        {
            a = bg1;
        } else
        {
            (new StringBuilder("null loginState, refreshing:")).append(a);
        }
        try
        {
            dismissDialog(20);
            dismissDialog(21);
        }
        // Misplaced declaration of an exception variable
        catch (bg bg1) { }
        ac.a[a.ordinal()];
        JVM INSTR tableswitch 1 13: default 112
    //                   1 251
    //                   2 301
    //                   3 405
    //                   4 487
    //                   5 669
    //                   6 177
    //                   7 214
    //                   8 257
    //                   9 307
    //                   10 329
    //                   11 493
    //                   12 567
    //                   13 675;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        break; /* Loop/switch isn't completed */
_L14:
        break MISSING_BLOCK_LABEL_675;
_L15:
        switch (ac.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            q.a(new aj(this));
            return;

        case 3: // '\003'
        case 4: // '\004'
            q.a(new o(this));
            return;

        case 5: // '\005'
            q.a(new p(this));
            break;
        }
        break MISSING_BLOCK_LABEL_796;
_L7:
        j();
        m();
        o.b.setEnabled(true);
        o.d.setEnabled(true);
        h();
          goto _L15
_L8:
        j();
        n();
        o.b.setEnabled(true);
        o.d.setEnabled(true);
        h();
          goto _L15
_L2:
        showDialog(20);
_L9:
        j();
        m();
        o.b.setEnabled(false);
        o.d.setEnabled(false);
        o.h.setEnabled(false);
          goto _L15
_L3:
        showDialog(20);
_L10:
        j();
        n();
        o.h.setEnabled(false);
          goto _L15
_L11:
        l();
        k();
        o.o.c.setText(ex.a(fa.aY));
        o.l.setEnabled(false);
        o.l.setVisibility(8);
        o.m.setEnabled(false);
        o.m.setVisibility(8);
          goto _L15
_L4:
        showDialog(21);
        l();
        k();
        o.o.c.setText(ex.a(fa.aZ));
        o.l.setEnabled(false);
        o.l.setVisibility(8);
        o.m.setEnabled(false);
        o.m.setVisibility(8);
          goto _L15
_L5:
        showDialog(21);
_L12:
        l();
        k();
        o.o.c.setText(ex.a(fa.aZ));
        o.l.setEnabled(false);
        o.l.setVisibility(0);
        o.m.setEnabled(false);
        o.m.setVisibility(0);
          goto _L15
_L13:
        l();
        k();
        o.o.c.setText(ex.a(fa.aZ));
        o.l.setEnabled(true);
        o.l.setVisibility(0);
        bg1 = o.l;
        bg1.requestFocus();
        (new Handler()).postDelayed(new q(bg1), 200L);
        o.m.setVisibility(0);
        i();
          goto _L15
_L6:
        showDialog(20);
        l();
        k();
        o.o.c.setText(ex.a(fa.aZ));
        o.l.setEnabled(false);
        o.l.setVisibility(0);
        o.m.setEnabled(false);
        o.m.setVisibility(0);
          goto _L15
    }

    static void c(LoginActivity loginactivity)
    {
        loginactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(com.paypal.android.sdk.payments.i.a())));
        loginactivity.q.a(ea.i, Boolean.valueOf(loginactivity.k));
    }

    private boolean c()
    {
        return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
    }

    private void d()
    {
        if (q.d().e.a.isEmpty())
        {
            o();
            br.a(this, ex.a(fa.ba), 10);
            return;
        } else
        {
            b(bg.g);
            return;
        }
    }

    static void d(LoginActivity loginactivity)
    {
        loginactivity.g();
        fd fd1;
        boolean flag;
        if (loginactivity.a == bg.b)
        {
            loginactivity.b(bg.a);
        } else
        {
            loginactivity.b(bg.b);
        }
        loginactivity.f();
        fd1 = loginactivity.o;
        if (loginactivity.a == bg.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fd1.a(flag);
    }

    private void e()
    {
        setResult(-1);
        finish();
    }

    static void e(LoginActivity loginactivity)
    {
        loginactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bq.a())));
        loginactivity.q.a(ea.h, Boolean.valueOf(loginactivity.k));
    }

    private void f()
    {
        br.a(o.c.b, q.f());
        b(((bg) (null)));
    }

    static void f(LoginActivity loginactivity)
    {
        if (loginactivity.a == bg.j)
        {
            loginactivity.b(bg.i);
        } else
        {
            loginactivity.b(bg.h);
        }
        loginactivity.o.l.setText("");
        loginactivity.q.a(loginactivity.n);
    }

    private void g()
    {
        if (a == bg.b)
        {
            d = o.b.getText().toString();
            f = o.d.getText().toString();
            return;
        } else
        {
            b = o.b.getText().toString();
            c = o.d.getText().toString();
            return;
        }
    }

    static void g(LoginActivity loginactivity)
    {
        loginactivity.i();
    }

    private void h()
    {
        String s;
        String s1;
        boolean flag;
        flag = true;
        s = o.b.getText().toString();
        s1 = o.d.getText().toString();
        if (a != bg.b) goto _L2; else goto _L1
_L1:
        if (!ds.d(s) || !ds.b(s1))
        {
            flag = false;
        }
_L4:
        o.h.setEnabled(flag);
        o.h.setFocusable(flag);
        return;
_L2:
        if (!ds.a(s) || !ds.c(s1))
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void h(LoginActivity loginactivity)
    {
        loginactivity.b(bg.k);
        loginactivity.q.a(loginactivity.a(loginactivity.a), loginactivity.o.l.getText().toString(), loginactivity.k, loginactivity.b(), loginactivity.c(), loginactivity.i);
    }

    private void i()
    {
        boolean flag;
        if (6 == o.l.getText().toString().length())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o.m.setEnabled(flag);
    }

    static void i(LoginActivity loginactivity)
    {
        loginactivity.e();
    }

    private void j()
    {
        o.o.a.setVisibility(8);
        o.k.setEnabled(false);
        o.k.setVisibility(8);
        o.o.c.setVisibility(8);
        o.m.setEnabled(false);
        o.m.setVisibility(8);
        o.l.setEnabled(false);
        o.l.setVisibility(8);
    }

    static void j(LoginActivity loginactivity)
    {
        loginactivity.d();
    }

    static fd k(LoginActivity loginactivity)
    {
        return loginactivity.o;
    }

    private void k()
    {
        br.a(this, null, fa.aT);
        o.k.setEnabled(true);
        o.k.setVisibility(0);
        (new StringBuilder("phone numbers: ")).append(q.d().e.a);
        ArrayList arraylist = new ArrayList(q.d().e.a.values());
        o.o.a((String)arraylist.get(n));
        o.o.a.setVisibility(0);
        if (arraylist.size() > 1)
        {
            o.o.a(true);
            ff ff1 = new ff(this, arraylist, n);
            (new ListView(this)).setAdapter(ff1);
            o.o.b.setOnClickListener(new r(this, ff1, arraylist));
        } else
        {
            o.o.a(false);
        }
        o.o.c.setVisibility(0);
    }

    static PayPalService l(LoginActivity loginactivity)
    {
        return loginactivity.q;
    }

    private void l()
    {
        o.h.setEnabled(false);
        o.h.setVisibility(8);
        o.b.setEnabled(false);
        o.b.setVisibility(8);
        o.d.setEnabled(false);
        o.d.setVisibility(8);
        o.e.setEnabled(false);
        o.e.setVisibility(8);
    }

    private void m()
    {
        br.a(this, null, fa.aq);
        o.b.setVisibility(0);
        o.b.setText(b);
        o.b.setHint(ex.a(fa.ae));
        o.b.setInputType(33);
        o.d.setVisibility(0);
        o.d.setText(c);
        o.d.setHint(ex.a(fa.au));
        o.d.setInputType(129);
        if (o.b.getText().length() > 0 && o.d.getText().length() == 0)
        {
            o.d.requestFocus();
        }
        o.h.setVisibility(0);
        o.e.setVisibility(0);
        o.f.setVisibility(0);
        o.g.setVisibility(0);
        o.j.setText(ex.a(fa.bo));
    }

    static void m(LoginActivity loginactivity)
    {
        switch (ac.a[loginactivity.a.ordinal()])
        {
        case 10: // '\n'
        case 12: // '\f'
        default:
            (new StringBuilder()).append(loginactivity.a).append(" case not handled");
            return;

        case 8: // '\b'
            loginactivity.b(bg.a);
            return;

        case 9: // '\t'
            loginactivity.b(bg.b);
            return;

        case 13: // '\r'
            loginactivity.b(bg.j);
            return;

        case 11: // '\013'
            loginactivity.b(bg.j);
            return;
        }
    }

    private void n()
    {
        br.a(this, null, fa.aq);
        o.b.setVisibility(0);
        o.b.setText(d);
        o.b.setHint(ex.a(fa.aA));
        o.b.setInputType(3);
        o.d.setVisibility(0);
        o.d.setText(f);
        o.d.setHint(ex.a(fa.aB));
        EditText edittext = o.d;
        byte byte0;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            byte0 = 2;
        } else
        {
            byte0 = 18;
        }
        edittext.setInputType(byte0);
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (o.b.getText().length() > 0 && o.d.getText().length() == 0)
        {
            o.d.requestFocus();
        }
        o.h.setVisibility(0);
        o.e.setVisibility(0);
        o.f.setVisibility(0);
        o.g.setVisibility(4);
        o.j.setText(ex.a(fa.bn));
    }

    static void n(LoginActivity loginactivity)
    {
        if (loginactivity.h.a())
        {
            loginactivity.b(bg.a);
            return;
        } else
        {
            loginactivity.b(bg.b);
            return;
        }
    }

    private void o()
    {
        switch (ac.a[a.ordinal()])
        {
        default:
            (new StringBuilder()).append(a).append(" case not handled");
            return;

        case 1: // '\001'
            b(bg.e);
            return;

        case 2: // '\002'
            b(com.paypal.android.sdk.payments.bg.f);
            return;

        case 5: // '\005'
            b(bg.m);
            return;

        case 3: // '\003'
        case 4: // '\004'
            b(bg.l);
            return;
        }
    }

    final void a()
    {
        boolean flag;
        flag = true;
        PayPalConfiguration paypalconfiguration = q.e();
        if (ex.a)
        {
            o.d.setGravity(5);
            o.b.setGravity(5);
            o.l.setGravity(5);
        }
        if (!ds.f(Locale.getDefault().getCountry().toLowerCase(Locale.US)) || !q.d().g)
        {
            o.j.setVisibility(4);
        }
        if (l)
        {
            l = false;
            b = paypalconfiguration.c();
            String s = paypalconfiguration.d();
            if (s != null)
            {
                d = s;
            }
            s = paypalconfiguration.e();
            if (s != null)
            {
                e = s;
            }
            if (paypalconfiguration.f() && !az.c(paypalconfiguration.b()))
            {
                c = paypalconfiguration.g();
                f = paypalconfiguration.h();
            }
        }
        if (getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false) && !m)
        {
            m = true;
            q.i();
        }
        if (q.k()) goto _L2; else goto _L1
_L1:
        if (!j)
        {
            j = true;
            q.a(ea.e, Boolean.valueOf(k));
        }
        if (a != null) goto _L4; else goto _L3
_L3:
        dr dr1 = (dr)getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
        if (dr1 == null) goto _L6; else goto _L5
_L5:
        k = true;
        if (dd.a(b))
        {
            if (dd.a(dr1.b()))
            {
                flag = false;
            }
            if (flag)
            {
                b = dr1.b();
            }
        }
        if (d == null && dr1.a() != null)
        {
            d = dr1.a().a(cn.a());
        }
        ac.b[dr1.c().ordinal()];
        JVM INSTR tableswitch 1 2: default 364
    //                   1 374
    //                   2 384;
           goto _L4 _L7 _L8
_L4:
        f();
        return;
_L7:
        b(bg.a);
        continue; /* Loop/switch isn't completed */
_L8:
        b(bg.b);
        continue; /* Loop/switch isn't completed */
_L6:
        b(bg.a);
        if (true) goto _L4; else goto _L2
_L2:
        e();
        return;
    }

    public final void onBackPressed()
    {
        q.a(ea.j, Boolean.valueOf(k));
        super.onBackPressed();
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onCreate");
        i = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
        p = bindService(br.a(this), r, 1);
        dd.b(this);
        dd.a(this);
        o = new fd(this);
        setContentView(o.a);
        o.f.setText(ex.a(fa.aO));
        o.g.setText(ex.a(fa.aj));
        o.i.setText(ex.a(fa.ap));
        o.i.setHint(ex.a(fa.ap));
        o.k.setText(ex.a(fa.aU));
        o.l.setHint(ex.a(fa.aW));
        o.n.setText(ex.a(fa.ap));
        o.o.b(ex.a(fa.aX));
        n n1 = new n(this);
        o.b.addTextChangedListener(n1);
        o.d.addTextChangedListener(n1);
        o.h.setOnClickListener(new aa(this));
        o.g.setOnClickListener(new ad(this));
        o.j.setOnClickListener(new ae(this));
        o.f.setOnClickListener(new af(this));
        o.o.c.setOnClickListener(new ag(this));
        o.l.addTextChangedListener(new ah(this));
        o.m.setOnClickListener(new ai(this));
        if (bundle == null)
        {
            j = false;
            l = true;
        } else
        {
            l = false;
            j = bundle.getBoolean("PP_PageTrackingSent");
            a = (bg)bundle.getParcelable("PP_LoginType");
            b = bundle.getString("PP_SavedEmail");
            d = bundle.getString("PP_SavedPhone");
            e = bundle.getString("PP_savedPhoneCountryCode");
            c = bundle.getString("PP_SavedPassword");
            f = bundle.getString("PP_SavedPIN");
            k = bundle.getBoolean("PP_IsReturningUser");
            m = bundle.getBoolean("PP_IsClearedLogin");
            i = bundle.getString("PP_RequestedScopes");
            g = bundle.getString("PP_SavedOTP");
            h = (eq)bundle.getParcelable("PP_OriginalLoginData");
            n = bundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
        }
        o.l.setText(g);
    }

    protected final Dialog onCreateDialog(int i1, Bundle bundle)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return br.a(this, fa.bm, bundle, new v(this));

        case 2: // '\002'
            return br.a(this, fa.bh, bundle, new w(this));

        case 3: // '\003'
            return br.a(this, fa.bm, bundle, new x(this));

        case 4: // '\004'
            return br.a(this, fa.bm, bundle, new y(this));

        case 5: // '\005'
            return br.a(this, fa.aM, bundle, new z(this));

        case 10: // '\n'
            return br.a(this, fa.bm, bundle, new ab(this));

        case 20: // '\024'
            return br.a(this, fa.c, fa.bp);

        case 21: // '\025'
            return br.a(this, fa.aV, fa.bp);
        }
    }

    protected final void onDestroy()
    {
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onDestroy");
        if (q != null)
        {
            q.n();
        }
        if (p)
        {
            unbindService(r);
            p = false;
        }
        super.onDestroy();
    }

    protected final void onResume()
    {
        super.onResume();
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onResume");
        if (q != null)
        {
            f();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        g();
        bundle.putParcelable("PP_LoginType", a);
        bundle.putString("PP_SavedEmail", b);
        bundle.putString("PP_SavedPhone", d);
        bundle.putString("PP_savedPhoneCountryCode", e);
        bundle.putString("PP_SavedPassword", c);
        bundle.putString("PP_SavedPIN", f);
        bundle.putBoolean("PP_IsReturningUser", k);
        bundle.putBoolean("PP_PageTrackingSent", j);
        bundle.putBoolean("PP_IsClearedLogin", m);
        bundle.putString("PP_RequestedScopes", i);
        bundle.putString("PP_SavedOTP", g);
        bundle.putParcelable("PP_OriginalLoginData", h);
        bundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", n);
    }
}
