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
import bst;
import bta;
import bti;
import bun;
import buq;
import buw;
import bux;
import buz;
import bvb;
import bvg;
import bvk;
import bvl;
import bvu;
import bwq;
import byu;
import byz;
import bza;
import bzb;
import bzc;
import bzd;
import bzf;
import bzh;
import bzi;
import bzj;
import bzk;
import bzl;
import bzm;
import bzw;
import cao;
import cap;
import caq;
import car;
import cas;
import cat;
import cau;
import cav;
import caw;
import cbl;
import ccm;
import com.paypal.android.sdk.bB;
import com.paypal.android.sdk.bY;
import com.paypal.android.sdk.ce;
import com.paypal.android.sdk.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk.payments:
//            aj, PayPalService, PayPalConfiguration

public final class LoginActivity extends Activity
{

    private final String a = com/paypal/android/sdk/payments/LoginActivity.getSimpleName();
    private aj b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private bY i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private bvg p;
    private boolean q;
    private PayPalService r;
    private final ServiceConnection s = new bzf(this);

    public LoginActivity()
    {
    }

    public static int a(LoginActivity loginactivity, int i1)
    {
        loginactivity.o = i1;
        return i1;
    }

    private bY a(aj aj1)
    {
        g();
        if (aj1 == aj.b)
        {
            aj1 = bun.a();
            if (f == null)
            {
                aj1 = new ce(aj1, e);
            } else
            {
                aj1 = new ce(aj1, new g(f), e);
            }
            return new bY(aj1, g);
        }
        if (aj1 == aj.a)
        {
            return new bY(c, d);
        } else
        {
            return i;
        }
    }

    public static PayPalService a(LoginActivity loginactivity, PayPalService paypalservice)
    {
        loginactivity.r = paypalservice;
        return paypalservice;
    }

    public static void a(Activity activity, bB bb, boolean flag, boolean flag1, String s1, PayPalConfiguration paypalconfiguration)
    {
        Intent intent = new Intent(activity, com/paypal/android/sdk/payments/LoginActivity);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.persistedLogin", bb);
        intent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", flag);
        intent.putExtra("com.paypal.android.sdk.payments.forceLogin", flag1);
        intent.putExtra("com.paypal.android.sdk.payments.requestedScopes", s1);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", paypalconfiguration);
        activity.startActivityForResult(intent, 1);
    }

    public static void a(LoginActivity loginactivity)
    {
        loginactivity.h();
    }

    public static void a(LoginActivity loginactivity, bzw bzw1)
    {
        if (bzw1.b())
        {
            loginactivity.d();
            return;
        }
        boolean flag;
        if (bzw1.a() && bzw1.b.equals("invalid_user"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            loginactivity.o();
            ccm.a(loginactivity, bux.a(buz.bs), 3);
            return;
        }
        if (bzw1.c())
        {
            loginactivity.o();
            ccm.a(loginactivity, bux.a(bzw1.b), 3);
            return;
        }
        if ("invalid_nonce".equals(bzw1.b))
        {
            loginactivity.h = null;
            loginactivity.o();
            ccm.a(loginactivity, bux.a(buz.aL), 5);
            return;
        } else
        {
            loginactivity.h = null;
            loginactivity.o();
            ccm.a(loginactivity, bux.a(bzw1.b), 4);
            return;
        }
    }

    public static void a(LoginActivity loginactivity, aj aj1)
    {
        loginactivity.b(aj1);
    }

    public static void a(LoginActivity loginactivity, String s1)
    {
        loginactivity.d = null;
        loginactivity.g = null;
        loginactivity.o();
        ccm.a(loginactivity, bux.a(s1), 1);
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

    public static void b(LoginActivity loginactivity)
    {
        bY by = loginactivity.a(loginactivity.b);
        if (loginactivity.b == aj.b)
        {
            loginactivity.i = new bY(by.d(), null);
            loginactivity.b(aj.d);
        } else
        {
            loginactivity.i = new bY(by.b(), null);
            loginactivity.b(aj.c);
        }
        loginactivity.r.a(by, loginactivity.l, loginactivity.b(), loginactivity.c(), loginactivity.j);
    }

    public static void b(LoginActivity loginactivity, String s1)
    {
        loginactivity.o();
        if ("invalid_nonce".equals(s1))
        {
            ccm.a(loginactivity, bux.a(buz.aL), 5);
            return;
        } else
        {
            ccm.a(loginactivity, bux.a(s1), 2);
            return;
        }
    }

    private void b(aj aj1)
    {
        (new StringBuilder("changeLoginState:")).append(aj1);
        if (aj1 != null)
        {
            b = aj1;
        } else
        {
            (new StringBuilder("null loginState, refreshing:")).append(b);
        }
        try
        {
            dismissDialog(20);
            dismissDialog(21);
        }
        // Misplaced declaration of an exception variable
        catch (aj aj1) { }
        cap.a[b.ordinal()];
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
        switch (cap.a[b.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            r.a(new caw(this));
            return;

        case 3: // '\003'
        case 4: // '\004'
            r.a(new bza(this));
            return;

        case 5: // '\005'
            r.a(new bzb(this));
            break;
        }
        break MISSING_BLOCK_LABEL_796;
_L7:
        j();
        m();
        p.b.setEnabled(true);
        p.d.setEnabled(true);
        h();
          goto _L15
_L8:
        j();
        n();
        p.b.setEnabled(true);
        p.d.setEnabled(true);
        h();
          goto _L15
_L2:
        showDialog(20);
_L9:
        j();
        m();
        p.b.setEnabled(false);
        p.d.setEnabled(false);
        p.h.setEnabled(false);
          goto _L15
_L3:
        showDialog(20);
_L10:
        j();
        n();
        p.h.setEnabled(false);
          goto _L15
_L11:
        l();
        k();
        p.o.c.setText(bux.a(buz.aY));
        p.l.setEnabled(false);
        p.l.setVisibility(8);
        p.m.setEnabled(false);
        p.m.setVisibility(8);
          goto _L15
_L4:
        showDialog(21);
        l();
        k();
        p.o.c.setText(bux.a(buz.aZ));
        p.l.setEnabled(false);
        p.l.setVisibility(8);
        p.m.setEnabled(false);
        p.m.setVisibility(8);
          goto _L15
_L5:
        showDialog(21);
_L12:
        l();
        k();
        p.o.c.setText(bux.a(buz.aZ));
        p.l.setEnabled(false);
        p.l.setVisibility(0);
        p.m.setEnabled(false);
        p.m.setVisibility(0);
          goto _L15
_L13:
        l();
        k();
        p.o.c.setText(bux.a(buz.aZ));
        p.l.setEnabled(true);
        p.l.setVisibility(0);
        aj1 = p.l;
        aj1.requestFocus();
        (new Handler()).postDelayed(new bzc(aj1), 200L);
        p.m.setVisibility(0);
        i();
          goto _L15
_L6:
        showDialog(20);
        l();
        k();
        p.o.c.setText(bux.a(buz.aZ));
        p.l.setEnabled(false);
        p.l.setVisibility(0);
        p.m.setEnabled(false);
        p.m.setVisibility(0);
          goto _L15
    }

    public static void c(LoginActivity loginactivity)
    {
        loginactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(byu.a())));
        loginactivity.r.a(buw.o, Boolean.valueOf(loginactivity.l));
    }

    private boolean c()
    {
        return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
    }

    private void d()
    {
        if (r.c().g.a.isEmpty())
        {
            o();
            ccm.a(this, bux.a(buz.ba), 10);
            return;
        } else
        {
            b(com.paypal.android.sdk.payments.aj.g);
            return;
        }
    }

    public static void d(LoginActivity loginactivity)
    {
        loginactivity.g();
        bvg bvg1;
        boolean flag;
        if (loginactivity.b == aj.b)
        {
            loginactivity.b(aj.a);
        } else
        {
            loginactivity.b(aj.b);
        }
        loginactivity.f();
        bvg1 = loginactivity.p;
        if (loginactivity.b == aj.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bvg1.a(flag);
    }

    private void e()
    {
        setResult(-1);
        finish();
    }

    public static void e(LoginActivity loginactivity)
    {
        loginactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(cbl.a())));
        loginactivity.r.a(buw.n, Boolean.valueOf(loginactivity.l));
    }

    private void f()
    {
        ccm.a(p.c.b, r.e());
        b(((aj) (null)));
    }

    public static void f(LoginActivity loginactivity)
    {
        if (loginactivity.b == aj.j)
        {
            loginactivity.b(aj.i);
        } else
        {
            loginactivity.b(aj.h);
        }
        loginactivity.p.l.setText("");
        loginactivity.r.a(loginactivity.o);
    }

    private void g()
    {
        if (b == aj.b)
        {
            e = p.b.getText().toString();
            g = p.d.getText().toString();
            return;
        } else
        {
            c = p.b.getText().toString();
            d = p.d.getText().toString();
            return;
        }
    }

    public static void g(LoginActivity loginactivity)
    {
        loginactivity.i();
    }

    private void h()
    {
        String s1;
        String s2;
        boolean flag;
        flag = true;
        s1 = p.b.getText().toString();
        s2 = p.d.getText().toString();
        if (b != aj.b) goto _L2; else goto _L1
_L1:
        if (!bvu.d(s1) || !bvu.b(s2))
        {
            flag = false;
        }
_L4:
        p.h.setEnabled(flag);
        p.h.setFocusable(flag);
        return;
_L2:
        if (!bvu.a(s1) || !bvu.c(s2))
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void h(LoginActivity loginactivity)
    {
        loginactivity.b(aj.k);
        loginactivity.r.a(loginactivity.a(loginactivity.b), loginactivity.p.l.getText().toString(), loginactivity.l, loginactivity.b(), loginactivity.c(), loginactivity.j);
    }

    private void i()
    {
        boolean flag;
        if (6 == p.l.getText().toString().length())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p.m.setEnabled(flag);
    }

    public static void i(LoginActivity loginactivity)
    {
        loginactivity.e();
    }

    private void j()
    {
        p.o.a.setVisibility(8);
        p.k.setEnabled(false);
        p.k.setVisibility(8);
        p.o.c.setVisibility(8);
        p.m.setEnabled(false);
        p.m.setVisibility(8);
        p.l.setEnabled(false);
        p.l.setVisibility(8);
    }

    public static void j(LoginActivity loginactivity)
    {
        loginactivity.d();
    }

    public static bvg k(LoginActivity loginactivity)
    {
        return loginactivity.p;
    }

    private void k()
    {
        ccm.a(this, null, buz.aT);
        p.k.setEnabled(true);
        p.k.setVisibility(0);
        (new StringBuilder("phone numbers: ")).append(r.c().g.a);
        ArrayList arraylist = new ArrayList(r.c().g.a.values());
        p.o.a((String)arraylist.get(o));
        p.o.a.setVisibility(0);
        if (arraylist.size() > 1)
        {
            p.o.a(true);
            bvk bvk1 = new bvk(this, arraylist, o);
            (new ListView(this)).setAdapter(bvk1);
            p.o.b.setOnClickListener(new bzd(this, bvk1, arraylist));
        } else
        {
            p.o.a(false);
        }
        p.o.c.setVisibility(0);
    }

    public static PayPalService l(LoginActivity loginactivity)
    {
        return loginactivity.r;
    }

    private void l()
    {
        p.h.setEnabled(false);
        p.h.setVisibility(8);
        p.b.setEnabled(false);
        p.b.setVisibility(8);
        p.d.setEnabled(false);
        p.d.setVisibility(8);
        p.e.setEnabled(false);
        p.e.setVisibility(8);
    }

    private void m()
    {
        ccm.a(this, null, buz.aq);
        p.b.setVisibility(0);
        p.b.setText(c);
        p.b.setHint(bux.a(buz.ae));
        p.b.setInputType(33);
        p.d.setVisibility(0);
        p.d.setText(d);
        p.d.setHint(bux.a(buz.au));
        p.d.setInputType(129);
        if (p.b.getText().length() > 0 && p.d.getText().length() == 0)
        {
            p.d.requestFocus();
        }
        p.h.setVisibility(0);
        p.e.setVisibility(0);
        p.f.setVisibility(0);
        p.g.setVisibility(0);
        p.j.setText(bux.a(buz.bo));
    }

    public static void m(LoginActivity loginactivity)
    {
        switch (cap.a[loginactivity.b.ordinal()])
        {
        case 10: // '\n'
        case 12: // '\f'
        default:
            (new StringBuilder()).append(loginactivity.b).append(" case not handled");
            return;

        case 8: // '\b'
            loginactivity.b(aj.a);
            return;

        case 9: // '\t'
            loginactivity.b(aj.b);
            return;

        case 13: // '\r'
            loginactivity.b(aj.j);
            return;

        case 11: // '\013'
            loginactivity.b(aj.j);
            return;
        }
    }

    private void n()
    {
        ccm.a(this, null, buz.aq);
        p.b.setVisibility(0);
        p.b.setText(e);
        p.b.setHint(bux.a(buz.aA));
        p.b.setInputType(3);
        p.d.setVisibility(0);
        p.d.setText(g);
        p.d.setHint(bux.a(buz.aB));
        EditText edittext = p.d;
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
        if (p.b.getText().length() > 0 && p.d.getText().length() == 0)
        {
            p.d.requestFocus();
        }
        p.h.setVisibility(0);
        p.e.setVisibility(0);
        p.f.setVisibility(0);
        p.g.setVisibility(4);
        p.j.setText(bux.a(buz.bn));
    }

    public static void n(LoginActivity loginactivity)
    {
        if (loginactivity.i.a())
        {
            loginactivity.b(aj.a);
            return;
        } else
        {
            loginactivity.b(aj.b);
            return;
        }
    }

    private void o()
    {
        switch (cap.a[b.ordinal()])
        {
        default:
            (new StringBuilder()).append(b).append(" case not handled");
            return;

        case 1: // '\001'
            b(aj.e);
            return;

        case 2: // '\002'
            b(aj.f);
            return;

        case 5: // '\005'
            b(aj.m);
            return;

        case 3: // '\003'
        case 4: // '\004'
            b(aj.l);
            return;
        }
    }

    public final void a()
    {
        PayPalConfiguration paypalconfiguration = r.d();
        if (bux.a)
        {
            p.d.setGravity(5);
            p.b.setGravity(5);
            p.l.setGravity(5);
        }
        if (!bvu.f(Locale.getDefault().getCountry().toLowerCase(Locale.US)) || !r.c().i)
        {
            p.j.setVisibility(4);
        }
        if (m)
        {
            m = false;
            c = paypalconfiguration.c();
            String s1 = paypalconfiguration.d();
            if (s1 != null)
            {
                e = s1;
            }
            s1 = paypalconfiguration.e();
            if (s1 != null)
            {
                f = s1;
            }
            if (paypalconfiguration.f() && !bst.c(paypalconfiguration.b()))
            {
                d = paypalconfiguration.g();
                g = paypalconfiguration.h();
            }
        }
        if (getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false) && !n)
        {
            n = true;
            r.h();
        }
        if (r.j()) goto _L2; else goto _L1
_L1:
        if (!k)
        {
            k = true;
            r.a(buw.k, Boolean.valueOf(l));
        }
        if (b != null) goto _L4; else goto _L3
_L3:
        bB bb = (bB)getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
        if (bb == null) goto _L6; else goto _L5
_L5:
        l = true;
        if (bwq.a(c) && bwq.b(bb.b()))
        {
            c = bb.b();
        }
        if (e == null && bb.a() != null)
        {
            e = bb.a().a(bun.a());
        }
        cap.b[bb.c().ordinal()];
        JVM INSTR tableswitch 1 2: default 360
    //                   1 365
    //                   2 375;
           goto _L4 _L7 _L8
_L4:
        f();
        return;
_L7:
        b(aj.a);
        continue; /* Loop/switch isn't completed */
_L8:
        b(aj.b);
        continue; /* Loop/switch isn't completed */
_L6:
        b(aj.a);
        if (true) goto _L4; else goto _L2
_L2:
        e();
        return;
    }

    public final void onBackPressed()
    {
        r.a(buw.p, Boolean.valueOf(l));
        super.onBackPressed();
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onCreate");
        j = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
        q = bindService(ccm.b(this), s, 1);
        bwq.b(this);
        bwq.a(this);
        p = new bvg(this);
        setContentView(p.a);
        p.f.setText(bux.a(buz.aO));
        p.g.setText(bux.a(buz.aj));
        p.i.setText(bux.a(buz.ap));
        p.i.setHint(bux.a(buz.ap));
        p.k.setText(bux.a(buz.aU));
        p.l.setHint(bux.a(buz.aW));
        p.n.setText(bux.a(buz.ap));
        p.o.b(bux.a(buz.aX));
        byz byz1 = new byz(this);
        p.b.addTextChangedListener(byz1);
        p.d.addTextChangedListener(byz1);
        p.h.setOnClickListener(new bzm(this));
        p.g.setOnClickListener(new caq(this));
        p.j.setOnClickListener(new car(this));
        p.f.setOnClickListener(new cas(this));
        p.o.c.setOnClickListener(new cat(this));
        p.l.addTextChangedListener(new cau(this));
        p.m.setOnClickListener(new cav(this));
        if (bundle == null)
        {
            k = false;
            m = true;
        } else
        {
            m = false;
            k = bundle.getBoolean("PP_PageTrackingSent");
            b = (aj)bundle.getParcelable("PP_LoginType");
            c = bundle.getString("PP_SavedEmail");
            e = bundle.getString("PP_SavedPhone");
            f = bundle.getString("PP_savedPhoneCountryCode");
            d = bundle.getString("PP_SavedPassword");
            g = bundle.getString("PP_SavedPIN");
            l = bundle.getBoolean("PP_IsReturningUser");
            n = bundle.getBoolean("PP_IsClearedLogin");
            j = bundle.getString("PP_RequestedScopes");
            h = bundle.getString("PP_SavedOTP");
            i = (bY)bundle.getParcelable("PP_OriginalLoginData");
            o = bundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
        }
        p.l.setText(h);
    }

    protected final Dialog onCreateDialog(int i1, Bundle bundle)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return ccm.a(this, buz.bm, bundle, new bzh(this));

        case 2: // '\002'
            return ccm.a(this, buz.bh, bundle, new bzi(this));

        case 3: // '\003'
            return ccm.a(this, buz.bm, bundle, new bzj(this));

        case 4: // '\004'
            return ccm.a(this, buz.bm, bundle, new bzk(this));

        case 5: // '\005'
            return ccm.a(this, buz.aM, bundle, new bzl(this));

        case 10: // '\n'
            return ccm.a(this, buz.bm, bundle, new cao(this));

        case 20: // '\024'
            return ccm.a(this, buz.c, buz.bp);

        case 21: // '\025'
            return ccm.a(this, buz.aV, buz.bp);
        }
    }

    protected final void onDestroy()
    {
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onDestroy");
        if (r != null)
        {
            r.n();
        }
        if (q)
        {
            unbindService(s);
            q = false;
        }
        super.onDestroy();
    }

    protected final void onResume()
    {
        super.onResume();
        (new StringBuilder()).append(getClass().getSimpleName()).append(".onResume");
        if (r != null)
        {
            f();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        g();
        bundle.putParcelable("PP_LoginType", b);
        bundle.putString("PP_SavedEmail", c);
        bundle.putString("PP_SavedPhone", e);
        bundle.putString("PP_savedPhoneCountryCode", f);
        bundle.putString("PP_SavedPassword", d);
        bundle.putString("PP_SavedPIN", g);
        bundle.putBoolean("PP_IsReturningUser", l);
        bundle.putBoolean("PP_PageTrackingSent", k);
        bundle.putBoolean("PP_IsClearedLogin", n);
        bundle.putString("PP_RequestedScopes", j);
        bundle.putString("PP_SavedOTP", h);
        bundle.putParcelable("PP_OriginalLoginData", i);
        bundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", o);
    }
}
