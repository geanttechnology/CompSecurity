// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.ct;
import com.paypal.android.sdk.cz;
import com.paypal.android.sdk.da;
import com.paypal.android.sdk.db;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.ea;
import com.paypal.android.sdk.ed;
import com.paypal.android.sdk.el;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.fb;
import com.paypal.android.sdk.fc;
import com.paypal.android.sdk.o;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk.payments:
//            cc, ci, b, FuturePaymentInfoActivity, 
//            cb, cq, cd, PayPalService, 
//            bx, cn, ce, cf, 
//            br, cg, by, PayPalConfiguration, 
//            PayPalOAuthScopes, LoginActivity, k, ck, 
//            cl, cm, PayPalAuthorization, bz, 
//            bs, ch

abstract class ca extends Activity
{

    private static final String d = com/paypal/android/sdk/payments/ca.getSimpleName();
    private static final Map l = new cc();
    protected PayPalService a;
    protected PayPalOAuthScopes b;
    protected fb c;
    private boolean e;
    private bx f;
    private boolean g;
    private boolean h;
    private boolean i;
    private cn j;
    private final ServiceConnection k = new ci(this);

    ca()
    {
    }

    private void a(int i1, PayPalAuthorization paypalauthorization)
    {
        Intent intent = new Intent();
        intent.putExtra("com.paypal.android.sdk.authorization", paypalauthorization);
        setResult(i1, intent);
    }

    private void a(int i1, String s, String s1, k k1)
    {
        s = new SpannableString(Html.fromHtml((new StringBuilder()).append(s1).append(s).toString()));
        if (k1 != null)
        {
            s1 = (URLSpan[])s.getSpans(0, s.length(), android/text/style/URLSpan);
            if (s1.length > 0)
            {
                s1 = s1[0];
                s.setSpan(new b(s1, this, com/paypal/android/sdk/payments/FuturePaymentInfoActivity, new cb(this), k1), s.getSpanStart(s1), s.getSpanEnd(s1), 33);
                s.removeSpan(s1);
            }
        } else
        {
            a(((SpannableString) (s)));
        }
        s.setSpan(new BulletSpan(15), 0, s.length(), 0);
        c.c[i1].setVisibility(0);
        c.c[i1].setFocusable(true);
        c.c[i1].setNextFocusLeftId((i1 + 100) - 1);
        c.c[i1].setNextFocusRightId(i1 + 100 + 1);
        c.c[i1].setText(s);
    }

    private void a(SpannableString spannablestring)
    {
        int i1 = 0;
        URLSpan aurlspan[] = (URLSpan[])spannablestring.getSpans(0, spannablestring.length(), android/text/style/URLSpan);
        for (int j1 = aurlspan.length; i1 < j1; i1++)
        {
            URLSpan urlspan = aurlspan[i1];
            spannablestring.setSpan(new com.paypal.android.sdk.payments.cq(urlspan, new cd(this)), spannablestring.getSpanStart(urlspan), spannablestring.getSpanEnd(urlspan), 33);
            spannablestring.removeSpan(urlspan);
        }

    }

    private void a(bx bx1)
    {
        a.d().h = bx1.a;
        a.d().d = bx1.b;
        a.d().c = bx1.c;
        j();
    }

    static void a(ca ca1)
    {
        try
        {
            ca1.dismissDialog(2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ca ca1)
        {
            return;
        }
    }

    static void a(ca ca1, ea ea1)
    {
        ca1.a.a(ea1);
    }

    static void a(ca ca1, el el)
    {
        ca1.j = new cn(el);
        ca1.getIntent().putExtra("com.paypal.android.sdk.payments.ppAppInfo", ca1.j);
        ca1.f();
        try
        {
            ca1.dismissDialog(2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ca ca1)
        {
            return;
        }
    }

    static String b()
    {
        return d;
    }

    private void b(SpannableString spannablestring)
    {
        int i1 = 0;
        URLSpan aurlspan[] = (URLSpan[])spannablestring.getSpans(0, spannablestring.length(), android/text/style/URLSpan);
        for (int j1 = aurlspan.length; i1 < j1; i1++)
        {
            URLSpan urlspan = aurlspan[i1];
            spannablestring.setSpan(new com.paypal.android.sdk.payments.cq(urlspan, new ce(this)), spannablestring.getSpanStart(urlspan), spannablestring.getSpanEnd(urlspan), 33);
            spannablestring.removeSpan(urlspan);
        }

    }

    static void b(ca ca1)
    {
        ca1.i();
    }

    private void c()
    {
label0:
        {
            if (a != null)
            {
                showDialog(2);
                if (a.j())
                {
                    break label0;
                }
                (new StringBuilder("token is expired, get new one. AccessToken: ")).append(a.d().b);
                a.a(new cf(this), true);
            }
            return;
        }
        a.p();
    }

    static void c(ca ca1)
    {
        ca1.e();
    }

    private void d()
    {
        e = bindService(com.paypal.android.sdk.payments.br.a(this), k, 1);
    }

    static void d(ca ca1)
    {
        (new StringBuilder()).append(d).append(".postBindSetup()");
        (new StringBuilder()).append(d).append(".startLoginIfNeeded (access token: ").append(ca1.a.d().f).append(")");
        fb fb1;
        boolean flag;
        if (!ca1.a.k() && !ca1.h)
        {
            (new StringBuilder()).append(d).append(" -- doing the login...");
            ca1.h = true;
            ca1.e();
            flag = true;
        } else
        {
            flag = false;
        }
        fb1 = ca1.c;
        if (ca1.i)
        {
            ca1.i = false;
            ca1.j();
        }
        if (!ca1.g)
        {
            ca1.g = true;
            ca1.a.a(ea.k);
        }
        com.paypal.android.sdk.payments.br.a(fb1.f.b, ca1.a.f());
        ca1.a.b(new cg(ca1));
        ca1.f();
        if (!flag && ca1.j == null)
        {
            ca1.c();
        }
    }

    private void e()
    {
        (new StringBuilder()).append(d).append(".doLogin");
        if (com.paypal.android.sdk.payments.by.a(this, a))
        {
            new cz();
            Intent intent = cz.a(a.e().j(), da.a, db.a, a.c().d().e());
            (new StringBuilder("startActivityForResult(")).append(intent).append(", 2)");
            Log.w("paypal.sdk", "requesting code with scope=null from Authenticator.");
            startActivityForResult(intent, 2);
            return;
        } else
        {
            com.paypal.android.sdk.payments.LoginActivity.a(this, b.b(), a.e());
            return;
        }
    }

    static void e(ca ca1)
    {
        ca1.a.a(ea.m);
        ca1.finish();
    }

    private void f()
    {
        if (b != null && j != null && a != null)
        {
            Object obj = a.e().k();
            if (j.d() != null)
            {
                obj = j.d();
            }
            String s1 = a.e().l().toString();
            if (j.b() != null)
            {
                s1 = j.b();
            }
            String s2 = a.e().m().toString();
            if (j.c() != null)
            {
                s2 = j.c();
            }
            Object obj1 = String.format(ex.a(fa.V), new Object[] {
                (new StringBuilder("<b>")).append(((String) (obj))).append("</b>").toString()
            });
            String s;
            int i1;
            int j1;
            int k1;
            if (ex.a)
            {
                s = "\u200F";
            } else
            {
                s = "";
            }
            c.c[0].setText(Html.fromHtml((new StringBuilder()).append(s).append(((String) (obj1))).toString()));
            if (ex.a)
            {
                c.c[0].setGravity(5);
            }
            c.c[0].setVisibility(0);
            obj1 = b.a();
            if (((List) (obj1)).contains(o.a.a()) || ((List) (obj1)).contains(ct.b.a()) || ((List) (obj1)).contains(ct.c.a()))
            {
                a(1, String.format(ex.a(fa.Y), new Object[] {
                    "future-payment-consent", (new StringBuilder("<b>")).append(((String) (obj))).append("</b>").toString(), (new StringBuilder("<b>")).append(((String) (obj))).append("</b>").toString()
                }), s, com.paypal.android.sdk.payments.k.a);
                j1 = 2;
            } else
            {
                j1 = 1;
            }
            i1 = j1;
            if (((List) (obj1)).contains(ct.a.a()))
            {
                a(j1, ex.a(fa.X), s, null);
                i1 = j1 + 1;
            }
            j1 = i1;
            if (((List) (obj1)).contains(ct.d.a()))
            {
                a(i1, ex.a(fa.W), s, k.b);
                j1 = i1 + 1;
            }
            i1 = j1;
            if (((List) (obj1)).contains(ct.e.a()))
            {
                a(j1, String.format(ex.a(fa.ac), new Object[] {
                    "", obj
                }), s, k.c);
                i1 = j1 + 1;
            }
            j1 = i1;
            if (((List) (obj1)).contains(ct.f.a()))
            {
                a(i1, String.format(ex.a(fa.ab), new Object[] {
                    "", obj
                }), s, k.d);
                j1 = i1 + 1;
            }
            k1 = j1;
            if (((List) (obj1)).contains(ct.g.a()))
            {
                a(j1, ex.a(fa.Z), s, null);
                k1 = j1 + 1;
            }
            i1 = k1;
            if (((List) (obj1)).contains(ct.h.a()))
            {
                a(k1, ex.a(fa.U), s, null);
                i1 = k1 + 1;
            }
            k1 = i1;
            if (!Collections.disjoint(((Collection) (obj1)), o.h))
            {
                if (g().size() > 0)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                k1 = i1;
                if (j1 != 0)
                {
                    a(i1, String.format(ex.a(fa.T), new Object[] {
                        h()
                    }), s, null);
                    k1 = i1 + 1;
                }
            }
            a(k1, String.format(ex.a(fa.aa), new Object[] {
                (new StringBuilder("<b>")).append(((String) (obj))).append("</b>").toString(), s1, s2
            }), s, null);
            c.c[k1].setNextFocusRightId(2);
            s2 = ex.a(fa.aD);
            s1 = Locale.getDefault().getCountry().toLowerCase(Locale.US);
            obj = s1;
            if (dd.b(s1))
            {
                obj = "us";
            }
            obj = String.format(s2, new Object[] {
                String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=p/gen/ua/policy_privacy-outside", new Object[] {
                    obj
                })
            });
            obj = new SpannableString(Html.fromHtml((new StringBuilder()).append(s).append(((String) (obj))).toString()));
            b(((SpannableString) (obj)));
            c.d.setText(((CharSequence) (obj)));
            c.d.setMovementMethod(LinkMovementMethod.getInstance());
            c.d.setNextFocusLeftId((k1 + 1 + 100) - 1);
            c.d.setNextFocusRightId(1);
            obj = dd.b(a.e().a());
            if (obj != null)
            {
                c.e.setText(((CharSequence) (obj)));
                c.e.setVisibility(0);
            }
            c.i.setText(ex.a(fa.F));
            c.g.setOnClickListener(new ck(this));
            c.h.setOnClickListener(new cl(this));
            c.h.setEnabled(true);
            if (f != null)
            {
                a(f);
                f = null;
                return;
            }
        }
    }

    static void f(ca ca1)
    {
        ca1.a.a(ea.l);
        if (!ca1.a.l())
        {
            (new StringBuilder("code/nonce invalid.  code:")).append(ca1.a.d().d).append(", nonce:").append(ca1.a.d().h);
            com.paypal.android.sdk.payments.br.a(ca1, ex.a(fa.aL), 4);
            return;
        } else
        {
            ca1.showDialog(2);
            ca1.a.a(ca1.b.a());
            return;
        }
    }

    private Set g()
    {
        List list = b.a();
        LinkedHashSet linkedhashset = new LinkedHashSet();
        cm acm[] = cm.values();
        int j1 = acm.length;
        int i1 = 0;
        do
        {
            while (i1 < j1) 
            {
                Object obj = acm[i1];
                if (j.a().contains(((cm) (obj)).name()) && list.contains(((o)l.get(obj)).a()))
                {
                    if (obj == com.paypal.android.sdk.payments.cm.a)
                    {
                        obj = null;
                    } else
                    if (obj == cm.k)
                    {
                        obj = ex.a(fa.G);
                    } else
                    if (obj == cm.i)
                    {
                        obj = ex.a(fa.H);
                    } else
                    if (obj == cm.j)
                    {
                        obj = ex.a(fa.I);
                    } else
                    if (obj == cm.m || obj == cm.n || obj == com.paypal.android.sdk.payments.cm.o || obj == cm.p || obj == cm.q || obj == cm.r)
                    {
                        obj = ex.a(fa.J);
                    } else
                    if (obj == cm.h)
                    {
                        obj = ex.a(fa.K);
                    } else
                    if (obj == cm.d)
                    {
                        obj = ex.a(fa.L);
                    } else
                    if (obj == cm.l)
                    {
                        obj = ex.a(fa.M);
                    } else
                    if (obj == cm.b)
                    {
                        obj = ex.a(fa.N);
                    } else
                    if (obj == cm.c)
                    {
                        obj = ex.a(fa.O);
                    } else
                    if (obj == cm.g)
                    {
                        obj = ex.a(fa.P);
                    } else
                    if (obj == cm.f)
                    {
                        obj = ex.a(fa.Q);
                    } else
                    if (obj == cm.s)
                    {
                        obj = ex.a(fa.R);
                    } else
                    if (obj == cm.e)
                    {
                        obj = ex.a(fa.S);
                    } else
                    {
                        obj = ((cm) (obj)).name();
                    }
                    if (obj != null)
                    {
                        linkedhashset.add(obj);
                    }
                }
                i1++;
            }
            return linkedhashset;
        } while (true);
    }

    private String h()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = g().iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            if (!flag)
            {
                stringbuilder.append(", ");
            } else
            {
                flag = false;
            }
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
    }

    private void i()
    {
        a(-1, new PayPalAuthorization(a.f(), a.d().d.b(), a.d().c));
        finish();
    }

    private void j()
    {
        String s = a.d().d.a();
        if (s != null && Arrays.asList(s.split(" ")).containsAll(b.a()))
        {
            i();
            return;
        } else
        {
            c();
            return;
        }
    }

    protected abstract void a();

    public void finish()
    {
        super.finish();
        (new StringBuilder()).append(d).append(".finish");
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        (new StringBuilder()).append(d).append(".onActivityResult(").append(i1).append(",").append(j1).append(",").append(intent).append(")");
        switch (i1)
        {
        default:
            Log.e(d, (new StringBuilder("unhandled requestCode ")).append(i1).toString());
            return;

        case 1: // '\001'
            if (j1 == -1)
            {
                if (a == null)
                {
                    i = true;
                    return;
                } else
                {
                    j();
                    return;
                }
            } else
            {
                a(j1, ((PayPalAuthorization) (null)));
                finish();
                return;
            }

        case 2: // '\002'
            break;
        }
        if (j1 == -1)
        {
            intent = com.paypal.android.sdk.payments.bz.a(intent.getExtras());
            if (a == null)
            {
                f = intent;
                return;
            } else
            {
                a(intent);
                return;
            }
        } else
        {
            a(j1, ((PayPalAuthorization) (null)));
            finish();
            return;
        }
    }

    public void onBackPressed()
    {
        a.a(ea.m);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new StringBuilder()).append(d).append(".onCreate");
        if (bundle == null)
        {
            bundle = getClass().getName();
            Object obj = getCallingActivity();
            boolean flag;
            if (obj == null)
            {
                Log.e("paypal.sdk", (new StringBuilder()).append(bundle).append(" called by a null activity, not allowed").toString());
                flag = false;
            } else
            {
                obj = ((ComponentName) (obj)).getClassName();
                if (!((String) (obj)).startsWith("com.paypal.android.sdk.payments."))
                {
                    Log.e("paypal.sdk", (new StringBuilder()).append(bundle).append(" called by ").append(((String) (obj))).append(" which is not part of the SDK, not allowed").toString());
                    flag = false;
                } else
                {
                    flag = true;
                }
            }
            if (!flag)
            {
                finish();
            }
            g = false;
        } else
        {
            g = bundle.getBoolean("pageTrackingSent");
            h = bundle.getBoolean("isLoginActivityStarted");
        }
        a();
        j = (cn)getIntent().getParcelableExtra("com.paypal.android.sdk.payments.ppAppInfo");
        d();
        dd.b(this);
        dd.a(this);
        c = new fb(this);
        setContentView(c.a);
        com.paypal.android.sdk.payments.br.a(this, c.b, null);
        c.g.setText(ex.a(fa.f));
        c.g.setVisibility(0);
        f();
    }

    protected Dialog onCreateDialog(int i1, Bundle bundle)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return com.paypal.android.sdk.payments.br.a(this, fa.bk, bundle.getString("alert_errors"), new bs());

        case 2: // '\002'
            return com.paypal.android.sdk.payments.br.a(this, fa.aE, fa.bp);

        case 3: // '\003'
            return com.paypal.android.sdk.payments.br.a(this, fa.an, bundle, i1);

        case 4: // '\004'
            return com.paypal.android.sdk.payments.br.a(this, fa.aM, bundle, new ch(this));
        }
    }

    protected void onDestroy()
    {
        (new StringBuilder()).append(d).append(".onDestroy");
        if (a != null)
        {
            a.m();
        }
        if (e)
        {
            unbindService(k);
            e = false;
        }
        super.onDestroy();
    }

    protected void onRestart()
    {
        super.onRestart();
        d();
    }

    protected void onResume()
    {
        super.onResume();
        (new StringBuilder()).append(d).append(".onResume");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", g);
        bundle.putBoolean("isLoginActivityStarted", h);
    }

}
