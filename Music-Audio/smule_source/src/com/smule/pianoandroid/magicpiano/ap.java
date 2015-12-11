// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.jirbo.adcolony.ag;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.d;
import com.smule.android.c.e;
import com.smule.android.d.g;
import com.smule.android.d.u;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.facebook.c;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ar;
import com.smule.android.network.models.f;
import com.smule.pianoandroid.f.b;
import com.smule.pianoandroid.magicpiano.registration.FacebookEmailActivity;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.t;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.publisher.SponsorPayPublisher;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, MagicApplication, aq

public class ap extends com.smule.pianoandroid.magicpiano.ag
    implements ab
{

    private static String B = "STATE_SHOULD_AUTHORIZE";
    private static String C = "STATE_PERFORM_FACEBOOK_LOGIN";
    private static final String e = com/smule/pianoandroid/magicpiano/ap.getName();
    private static String f = "TAPJOY";
    private static String g = "FLURRY";
    private static String h = "SPONSORPAY";
    private static String i = "FB-LOGIN";
    private static String j = "ADCOLONY";
    private static String k = "piandroid.offers";
    private static String l = "FOLLOW_DATA_URI";
    private static String m = "STATE_OFFER_INITIATED";
    private static String n = "STATE_DESIRED_LISTING";
    private static String t = "STARE_REFERRER";
    private static boolean y = false;
    private boolean A;
    private CallbackManager D;
    private g E;
    private int F;
    private Exception G;
    private Observer H;
    private f I;
    private Map J;
    private Runnable K;
    private final Runnable L = new Runnable() {

        final ap a;

        public void run()
        {
        }

            
            {
                a = ap.this;
                super();
            }
    };
    private Handler M;
    Observer a;
    protected View b;
    protected TextView c;
    protected TextView d;
    private aq u;
    private List v;
    private boolean w;
    private String x;
    private boolean z;

    public ap()
    {
        v = new ArrayList();
        w = true;
        z = false;
        F = 0;
        I = null;
        a = null;
        M = new Handler();
    }

    static int a(ap ap1, int i1)
    {
        ap1.F = i1;
        return i1;
    }

    private Dialog a(int i1, int j1)
    {
        Uri uri = Uri.parse(f(getString(0x7f0c013e)));
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(i1).setIcon(0x108008a).setMessage(j1).setCancelable(false).setPositiveButton(0x104000a, null).setNegativeButton(0x7f0c0157, new android.content.DialogInterface.OnClickListener(uri) {

            final Uri a;
            final ap b;

            public void onClick(DialogInterface dialoginterface, int k1)
            {
                dialoginterface = new Intent("android.intent.action.VIEW", a);
                b.startActivity(dialoginterface);
            }

            
            {
                b = ap.this;
                a = uri;
                super();
            }
        });
        return builder.create();
    }

    static g a(ap ap1, g g1)
    {
        ap1.E = g1;
        return g1;
    }

    static f a(ap ap1)
    {
        return ap1.I;
    }

    static f a(ap ap1, f f1)
    {
        ap1.I = f1;
        return f1;
    }

    static aq a(ap ap1, aq aq)
    {
        ap1.u = aq;
        return aq;
    }

    static Exception a(ap ap1, Exception exception)
    {
        ap1.G = exception;
        return exception;
    }

    static Runnable a(ap ap1, Runnable runnable)
    {
        ap1.K = runnable;
        return runnable;
    }

    static List a(ap ap1, List list)
    {
        ap1.v = list;
        return list;
    }

    static Map a(ap ap1, Map map)
    {
        ap1.J = map;
        return map;
    }

    private static void a(Activity activity)
    {
        long l1 = UserManager.n().c();
        SponsorPay.start(MagicApplication.getSponsorpayAppID(), Long.valueOf(l1).toString(), null, activity);
        activity.startActivityForResult(SponsorPayPublisher.getIntentForOfferWallActivity(activity, Boolean.valueOf(false)), 33345);
        com.smule.android.c.a.a(d.b, e.c, null, null);
    }

    public static void a(Activity activity, ViewGroup viewgroup, String s1)
    {
        Object obj = null;
        String as[] = s1.toUpperCase().split("/", 2);
        String s2;
        if (as.length > 0)
        {
            s1 = as[0].trim();
        } else
        {
            s1 = null;
        }
        s2 = s1;
        if (g.equals(s1))
        {
            s2 = s1;
            if (!a(((Context) (activity))))
            {
                aa.c(e, "No ads available from Flurry.");
                s1 = obj;
                if (as.length >= 2)
                {
                    s1 = as[1].trim();
                }
                s2 = s1;
            }
        }
        if (g.equals(s2))
        {
            a(((Context) (activity)), viewgroup);
        } else
        {
            if (h.equals(s2))
            {
                a(activity);
                return;
            }
            if (j.equals(s2))
            {
                b(activity);
                return;
            }
        }
    }

    private static void a(Context context, ViewGroup viewgroup)
    {
        FlurryAds.initializeAds(context);
        FlurryAds.setTargetingKeywords(com.smule.pianoandroid.utils.a.c());
        com.smule.pianoandroid.utils.n.c();
        FlurryAds.setAdListener(new FlurryAdListener(context, viewgroup) {

            final Context a;
            final ViewGroup b;

            public void onAdClicked(String s1)
            {
                com.smule.android.network.managers.d.a().a(4);
            }

            public void onAdClosed(String s1)
            {
                com.smule.android.network.managers.d.a().a(2);
            }

            public void onAdOpened(String s1)
            {
                com.smule.android.network.managers.d.a().a(5);
            }

            public void onApplicationExit(String s1)
            {
            }

            public void onRenderFailed(String s1)
            {
                com.smule.pianoandroid.magicpiano.ap.e();
            }

            public void onRendered(String s1)
            {
                com.smule.android.network.managers.d.a().a(3);
            }

            public void onVideoCompleted(String s1)
            {
                com.smule.android.network.managers.d.a().a(6);
            }

            public boolean shouldDisplayAd(String s1, FlurryAdType flurryadtype)
            {
                return true;
            }

            public void spaceDidFailToReceiveAd(String s1)
            {
                com.smule.pianoandroid.magicpiano.ap.e();
            }

            public void spaceDidReceiveAd(String s1)
            {
                FlurryAds.displayAd(a, "PIANDROID_BUYSMOOLA_RWD", b);
            }

            
            {
                a = context;
                b = viewgroup;
                super();
            }
        });
        FlurryAds.fetchAd(context, "PIANDROID_BUYSMOOLA_RWD", viewgroup, FlurryAdSize.BANNER_TOP);
        com.smule.android.c.a.a(d.b, e.c, null, null);
    }

    private void a(View view, String s1, String s2, Boolean boolean1, boolean flag, Runnable runnable)
    {
        byte byte0 = 8;
        ((TextView)view.findViewById(0x7f0a01e3)).setText(s1);
        s1 = (TextView)view.findViewById(0x7f0a01e4);
        s1.setText(s2);
        if (TextUtils.isEmpty(s2))
        {
            s1.setVisibility(8);
        }
        s1 = view.findViewById(0x7f0a01e5);
        s2 = (TextView)view.findViewById(0x7f0a01e6);
        view = view.findViewById(0x7f0a0040);
        if (!boolean1.booleanValue())
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        if (boolean1.booleanValue())
        {
            s1.setBackgroundDrawable(com.smule.pianoandroid.utils.j.a((String)J.get("unlockButtonColorOn"), (String)J.get("unlockButtonColorOff")));
            if (flag)
            {
                view = (String)J.get("freeTrialKey");
            } else
            {
                view = (String)J.get("unlockButtonTitleKey");
            }
            s2.setText(view);
        } else
        {
            s1.setBackgroundDrawable(com.smule.pianoandroid.utils.j.a((String)J.get("freeButtonColorOn"), (String)J.get("freeButtonColorOff")));
            s2.setText((CharSequence)J.get("freeButtonTitleKey"));
        }
        s1.setOnClickListener(new android.view.View.OnClickListener(runnable) {

            final Runnable a;
            final ap b;

            public void onClick(View view1)
            {
                a.run();
            }

            
            {
                b = ap.this;
                a = runnable;
                super();
            }
        });
    }

    static void a(ap ap1, View view, String s1, String s2, Boolean boolean1, boolean flag, Runnable runnable)
    {
        ap1.a(view, s1, s2, boolean1, flag, runnable);
    }

    static void a(ap ap1, Boolean boolean1)
    {
        ap1.a(boolean1);
    }

    static void a(ap ap1, String s1)
    {
        ap1.e(s1);
    }

    private void a(Boolean boolean1)
    {
        boolean flag = false;
        View view = findViewById(0x7f0a01ea);
        int i1;
        if (boolean1.booleanValue())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = findViewById(0x7f0a01ec);
        if (boolean1.booleanValue())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = findViewById(0x7f0a01eb);
        if (boolean1.booleanValue())
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

    private void a(boolean flag)
    {
        A = flag;
        if (!com.smule.android.facebook.a.a().a(this))
        {
            if (getResources().getConfiguration().orientation == 2)
            {
                z = true;
                setRequestedOrientation(1);
                return;
            } else
            {
                K = new Runnable() {

                    final ap a;

                    public void run()
                    {
                        a.setRequestedOrientation(0);
                    }

            
            {
                a = ap.this;
                super();
            }
                };
                LoginManager.getInstance().logInWithReadPermissions(this, b.b);
                return;
            }
        } else
        {
            LoginManager.getInstance().logInWithReadPermissions(this, b.b);
            return;
        }
    }

    private static boolean a(Context context)
    {
        return FlurryAds.isAdAvailable(context, "PIANDROID_BUYSMOOLA_RWD", FlurryAdSize.BANNER_TOP, 1000L);
    }

    private String[] a(String s1)
    {
        return s1.split(" +");
    }

    static List b(ap ap1)
    {
        return ap1.v;
    }

    private static void b(Activity activity)
    {
        activity = new ag(com.smule.pianoandroid.utils.a.b);
        if (activity.f())
        {
            com.smule.android.c.a.a(d.a, e.b, null, null);
            activity.n();
            return;
        } else
        {
            f();
            MagicApplication.getInstance().showToast(MagicApplication.getContext().getResources().getString(0x7f0c01bd), 1);
            return;
        }
    }

    static void b(ap ap1, String s1)
    {
        ap1.b(s1);
    }

    private void b(String s1)
    {
        if (i.compareToIgnoreCase(s1) == 0)
        {
            if (com.smule.android.network.core.r.a(this))
            {
                if (UserManager.n().h())
                {
                    o();
                    return;
                } else
                {
                    p();
                    return;
                }
            } else
            {
                MagicApplication.getInstance().showToast(getString(0x7f0c00f1), 0);
                return;
            }
        } else
        {
            y = true;
            a(this, (ViewGroup)findViewById(0x7f0a00b5), s1);
            return;
        }
    }

    static int c(ap ap1)
    {
        return ap1.F;
    }

    static Exception d(ap ap1)
    {
        return ap1.G;
    }

    static String d()
    {
        return e;
    }

    static void e()
    {
        f();
    }

    static void e(ap ap1)
    {
        ap1.s();
    }

    private void e(String s1)
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f0a01ec);
        viewgroup.removeAllViews();
        ArrayList arraylist = new ArrayList(v.size());
        for (Iterator iterator = v.iterator(); iterator.hasNext(); arraylist.add(((f)iterator.next()).sku)) { }
        if (F > 0)
        {
            Crittercism.a((new Exception()).initCause(G));
            return;
        }
        s();
        G = new Exception();
        try
        {
            E.a(arraylist, new com.smule.android.d.h(viewgroup, s1) {

                final ViewGroup a;
                final String b;
                final ap c;

                public void a(Map map)
                {
                    com.smule.pianoandroid.magicpiano.ap.g(c);
                    if (map != null) goto _L2; else goto _L1
_L1:
                    if (!com.smule.pianoandroid.magicpiano.ap.b(c).isEmpty())
                    {
                        ((TextView)c.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
                    }
_L4:
                    return;
_L2:
                    c.findViewById(0x7f0a01eb).setVisibility(8);
                    Iterator iterator1 = com.smule.pianoandroid.magicpiano.ap.b(c).iterator();
                    while (iterator1.hasNext()) 
                    {
                        f f1 = (f)iterator1.next();
                        Object obj1 = (u)map.get(f1.sku);
                        Object obj;
                        String s2;
                        Runnable runnable;
                        if (obj1 != null)
                        {
                            obj = ((u) (obj1)).b();
                        } else
                        {
                            obj = "?";
                        }
                        if (f1.trial)
                        {
                            obj = f1.trialLabelKey;
                        } else
                        {
                            obj = (new StringBuilder()).append(f1.labelKey).append(" - ").append(((String) (obj))).toString();
                        }
                        if (f1.trial)
                        {
                            s2 = MessageFormat.format(f1.trialDescriptionKey, new Object[] {
                                ((u) (obj1)).b()
                            });
                        } else
                        {
                            s2 = f1.descriptionKey;
                        }
                        runnable = new Runnable(this, f1.sku, ((u) (obj1))) {

                            final String a;
                            final u b;
                            final _cls7 c;

                            public void run()
                            {
                                Iterator iterator = com.smule.pianoandroid.magicpiano.ap.b(c.c).iterator();
_L7:
                                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                                f f1;
                                f1 = (f)iterator.next();
                                if (f1.sku.compareTo(a) != 0)
                                {
                                    continue; /* Loop/switch isn't completed */
                                }
                                if (!com.smule.pianoandroid.magicpiano.ap.f(c.c).d()) goto _L4; else goto _L3
_L3:
                                if (com.smule.pianoandroid.magicpiano.ap.c(c.c) > 0)
                                {
                                    Crittercism.a((new Exception()).initCause(com.smule.pianoandroid.magicpiano.ap.d(c.c)));
                                    return;
                                }
                                try
                                {
                                    com.smule.pianoandroid.magicpiano.ap.e(c.c);
                                    com.smule.pianoandroid.magicpiano.ap.a(c.c, new Exception());
                                    com.smule.pianoandroid.magicpiano.ap.f(c.c).b(f1.sku);
                                    com.smule.android.c.a.a(a, f1.period, b.b());
                                }
                                catch (IllegalStateException illegalstateexception)
                                {
                                    aa.b(com.smule.pianoandroid.magicpiano.ap.d(), "Subscription purchase was already launched", illegalstateexception);
                                    Crittercism.a(illegalstateexception);
                                }
_L5:
                                com.smule.pianoandroid.utils.t.b();
                                com.smule.pianoandroid.magicpiano.ap.a(c.c, f1);
                                continue; /* Loop/switch isn't completed */
_L4:
                                c.c.showDialog(2);
                                if (true) goto _L5; else goto _L2
_L2:
                                return;
                                if (true) goto _L7; else goto _L6
_L6:
                            }

            
            {
                c = _pcls7;
                a = s1;
                b = u1;
                super();
            }
                        };
                        obj1 = View.inflate(c, 0x7f03005c, null);
                        com.smule.pianoandroid.magicpiano.ap.a(c, ((View) (obj1)), ((String) (obj)), s2, Boolean.valueOf(true), f1.trial, runnable);
                        obj = new android.widget.LinearLayout.LayoutParams(-1, Math.round(c.getResources().getDimension(0x7f0900ee)));
                        a.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj)));
                    }
                    if (TextUtils.isEmpty(b)) goto _L4; else goto _L3
_L3:
                    if (com.smule.pianoandroid.magicpiano.ap.c(c) > 0)
                    {
                        Crittercism.a((new Exception()).initCause(com.smule.pianoandroid.magicpiano.ap.d(c)));
                        return;
                    }
                      goto _L5
_L7:
                    com.smule.pianoandroid.utils.t.b();
                    return;
_L5:
                    try
                    {
                        com.smule.pianoandroid.magicpiano.ap.e(c);
                        com.smule.pianoandroid.magicpiano.ap.a(c, new Exception());
                        com.smule.pianoandroid.magicpiano.ap.f(c).b(b);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Map map)
                    {
                        aa.b(com.smule.pianoandroid.magicpiano.ap.d(), "Subscription purchase was already launched", map);
                        Crittercism.a(map);
                    }
                    if (true) goto _L7; else goto _L6
_L6:
                }

            
            {
                c = ap.this;
                a = viewgroup;
                b = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            aa.b(e, "Failed to retrieve SKU details", s1);
        }
        Crittercism.a(s1);
    }

    static g f(ap ap1)
    {
        return ap1.E;
    }

    private String f(String s1)
    {
        Object obj;
label0:
        {
            if (!s1.contains("%lang%"))
            {
                obj = s1;
                if (!s1.contains("%region%"))
                {
                    break label0;
                }
            }
            obj = Locale.getDefault();
            obj = s1.replace("%lang%", ((Locale) (obj)).getLanguage().toLowerCase()).replace("%region%", ((Locale) (obj)).getCountry().toLowerCase());
        }
        return ((String) (obj));
    }

    private static void f()
    {
        Intent intent = new Intent();
        intent.setAction("PURCHASE_CANCELLED");
        LocalBroadcastManager.getInstance(MagicApplication.getInstance()).sendBroadcast(intent);
    }

    private void g()
    {
        x = getIntent().getStringExtra(i.a);
        Runnable runnable = new Runnable() {

            final ap a;

            public void run()
            {
                if (com.smule.pianoandroid.magicpiano.ap.i(a) != null)
                {
                    Intent intent = new Intent();
                    intent.putExtra(i.a, com.smule.pianoandroid.magicpiano.ap.i(a));
                    a.setResult(216, intent);
                }
                a.finish();
            }

            
            {
                a = ap.this;
                super();
            }
        };
        com.smule.pianoandroid.utils.o.a(this, runnable, runnable, getResources().getString(0x7f0c021a), getResources().getString(0x7f0c0219));
    }

    static void g(ap ap1)
    {
        ap1.t();
    }

    private void h()
    {
        if (E != null)
        {
            E.c();
            E = null;
        }
    }

    static void h(ap ap1)
    {
        ap1.g();
    }

    static String i(ap ap1)
    {
        return ap1.x;
    }

    private void i()
    {
        String s1 = com.smule.android.network.managers.a.a().a(k, "free_smoola_items", null);
        if (s1 == null)
        {
            return;
        }
        android.content.SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putString("free_smoola_items", s1);
        String as[] = a(s1);
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            String s6 = as[i1];
            String s5 = (new StringBuilder()).append(s6).append(".titleKey").toString();
            String s3 = com.smule.android.network.managers.a.a().a(k, s5, null);
            String s2 = s3;
            if (s3 == null)
            {
                s2 = com.smule.android.network.managers.a.a().a(k, (new StringBuilder()).append(s6).append(".title").toString(), null);
            }
            String s7 = (new StringBuilder()).append(s6).append(".descriptionKey").toString();
            String s4 = com.smule.android.network.managers.a.a().a(k, s7, null);
            s3 = s4;
            if (s4 == null)
            {
                s3 = com.smule.android.network.managers.a.a().a(k, (new StringBuilder()).append(s6).append(".description").toString(), null);
            }
            editor.putString(s5, s2);
            editor.putString(s7, s3);
        }

        com.smule.android.f.p.a(editor);
    }

    static Runnable j(ap ap1)
    {
        return ap1.K;
    }

    static boolean k(ap ap1)
    {
        return ap1.A;
    }

    static void l(ap ap1)
    {
        ap1.m();
    }

    private void m()
    {
        com.smule.android.network.core.b.a(new Runnable() {

            final ap a;

            public void run()
            {
                com.smule.android.facebook.a.a().a(new com.smule.android.facebook.d(this) {

                    final _cls16 a;

                    public void a(c c1)
                    {
                        a.a.runOnUiThread(new Runnable(this, c1) {

                            final c a;
                            final _cls1 b;

                            public void run()
                            {
                                if (a == null || TextUtils.isEmpty(a.c))
                                {
                                    Intent intent = new Intent(b.a.a.getApplicationContext(), com/smule/pianoandroid/magicpiano/registration/FacebookEmailActivity);
                                    b.a.a.startActivity(intent);
                                    b.a.a.finish();
                                    return;
                                } else
                                {
                                    ap.s(b.a.a).post(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            (new com.smule.pianoandroid.magicpiano.b.e(a.b.a.a, false)).execute(new Void[0]);
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                    return;
                                }
                            }

            
            {
                b = _pcls1;
                a = c1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls16;
                super();
            }
                });
            }

            
            {
                a = ap.this;
                super();
            }
        });
    }

    static void m(ap ap1)
    {
        ap1.n();
    }

    static Map n(ap ap1)
    {
        return ap1.J;
    }

    private void n()
    {
        M.post(new Runnable() {

            final ap a;

            public void run()
            {
                (new com.smule.pianoandroid.magicpiano.b.c(a)).execute(new Void[0]);
            }

            
            {
                a = ap.this;
                super();
            }
        });
    }

    private void o()
    {
        a(false);
    }

    static void o(ap ap1)
    {
        ap1.i();
    }

    static aq p(ap ap1)
    {
        return ap1.u;
    }

    private void p()
    {
        com.smule.pianoandroid.magicpiano.registration.e.a(new Runnable() {

            final ap a;

            public void run()
            {
            }

            
            {
                a = ap.this;
                super();
            }
        });
        com.smule.android.c.a.a(false);
        a(true);
    }

    private void q()
    {
        SharedPreferences sharedpreferences = getPreferences(0);
        String as[] = a(sharedpreferences.getString("free_smoola_items", "tapjoy"));
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f0a01ef);
        int j1 = as.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            String s1 = as[i1];
            if (!s1.equals("fb-login") || !com.smule.android.facebook.a.a().c() && !com.smule.pianoandroid.f.b.a())
            {
                String s2 = (new StringBuilder()).append(s1).append(".titleKey").toString();
                String s3 = (new StringBuilder()).append(s1).append(".descriptionKey").toString();
                s2 = sharedpreferences.getString(s2, "Free Smoola");
                s3 = sharedpreferences.getString(s3, "More ways to earn Smoola");
                Runnable runnable = new Runnable(s1) {

                    final String a;
                    final ap b;

                    public void run()
                    {
                        if (MagicApplication.isAdvertisingEnabled().booleanValue())
                        {
                            com.smule.pianoandroid.utils.t.b();
                            com.smule.pianoandroid.magicpiano.ap.b(b, a);
                        }
                    }

            
            {
                b = ap.this;
                a = s1;
                super();
            }
                };
                View view = View.inflate(this, 0x7f03005c, null);
                a(view, s2, s3, Boolean.valueOf(false), false, runnable);
                view.setId(s1.hashCode());
                viewgroup.addView(view, new android.widget.LinearLayout.LayoutParams(-1, Math.round(getResources().getDimension(0x7f0900ee))));
            }
            i1++;
        }
    }

    static void q(ap ap1)
    {
        ap1.q();
    }

    private void r()
    {
        Uri uri = getIntent().getData();
        if (uri != null && w)
        {
            w = false;
            String s1 = uri.getPath();
            String s2 = uri.getHost();
            aa.c(e, (new StringBuilder()).append("Intent data : ").append(uri).toString());
            if (s1.contains("tapjoy"))
            {
                b("tapjoy");
                return;
            }
            if (s1.contains("sponsorpay") || s1.contains("fyber"))
            {
                b("sponsorpay");
                return;
            }
            if (s1.contains("flurry"))
            {
                b("flurry");
                return;
            }
            if (s1.startsWith("/tapjoy") || s1.startsWith("/flurry") || s1.startsWith("/sponsorpay"))
            {
                b(s1.substring(1));
                return;
            }
            if (s2.equals("tapjoy") || s2.equals("flurry") || s2.equals("sponsorpay"))
            {
                b(s2);
                return;
            }
        }
    }

    static void r(ap ap1)
    {
        ap1.r();
    }

    static Handler s(ap ap1)
    {
        return ap1.M;
    }

    private void s()
    {
        F = F + 1;
    }

    private void t()
    {
        F = F - 1;
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "Coinpacks";
    }

    public void c()
    {
        try
        {
            com.smule.android.network.managers.a.a().a(k, com.smule.android.f.n.a(this, 0x7f050017));
        }
        catch (IOException ioexception)
        {
            aa.d(e, "Could not set default offers JSON.", ioexception);
        }
        a(Boolean.valueOf(false));
        if (!com.smule.android.network.managers.ap.a().b())
        {
            findViewById(0x7f0a01e8).setVisibility(0);
            findViewById(0x7f0a01f1).setOnClickListener(new android.view.View.OnClickListener() {

                final ap a;

                public void onClick(View view)
                {
                    if (com.smule.android.network.core.r.a(a))
                    {
                        a.a = new Observer(this) {

                            final _cls9 a;

                            public void update(Observable observable, Object obj)
                            {
                                if (((Boolean)obj).booleanValue())
                                {
                                    com.smule.pianoandroid.utils.o.a(a.a, 0x7f0c0232, 0x7f0c01c0);
                                    a.a.findViewById(0x7f0a01e8).setVisibility(8);
                                } else
                                {
                                    com.smule.android.c.a.b("not_subscribed");
                                    com.smule.pianoandroid.utils.o.a(a.a, 0x7f0c0231, 0x7f0c01c0);
                                }
                                com.smule.android.f.h.a().b("AutoRap.PURCHASES_RESTORED", a.a.a);
                                a.a.a = null;
                            }

            
            {
                a = _pcls9;
                super();
            }
                        };
                        com.smule.android.f.h.a().a("AutoRap.PURCHASES_RESTORED", a.a);
                        com.smule.android.c.a.b();
                        ar.a().b(a, false);
                        return;
                    } else
                    {
                        com.smule.pianoandroid.utils.o.a(a, 0x7f0c02c6, 0x7f0c01c0);
                        return;
                    }
                }

            
            {
                a = ap.this;
                super();
            }
            });
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        boolean flag;
        if (E != null)
        {
            flag = E.a(i1, j1, intent);
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            super.onActivityResult(i1, j1, intent);
            D.onActivityResult(i1, j1, intent);
            if (!flag && i1 == 33345)
            {
                aa.a(e, (new StringBuilder()).append("Sponsorpay returned ").append(j1).toString());
            }
        }
    }

    public void onBackPressed()
    {
        h();
        super.onBackPressed();
        overridePendingTransition(0x7f040014, 0x7f040011);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005d);
        getWindow().setFlags(1024, 1024);
        ((TextView)getActionBar().getCustomView().findViewById(0x7f0a0037)).setText(0x7f0c01fc);
        if (bundle != null)
        {
            aa.a(e, "Purchase screen is being recreated.  If you are coming back from an offer wall, you should not see a crash!");
            w = bundle.getBoolean(l, true);
            y = bundle.getBoolean(m, false);
            x = bundle.getString(n);
            z = bundle.getBoolean(B);
            A = bundle.getBoolean(C);
        }
        D = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(D, new FacebookCallback() {

            final ap a;

            public void a(LoginResult loginresult)
            {
                if (com.smule.pianoandroid.magicpiano.ap.j(a) != null)
                {
                    com.smule.pianoandroid.magicpiano.ap.j(a).run();
                    com.smule.pianoandroid.magicpiano.ap.a(a, null);
                }
                if (ap.k(a))
                {
                    ap.l(a);
                    return;
                } else
                {
                    ap.m(a);
                    return;
                }
            }

            public void onCancel()
            {
                aa.a(com.smule.pianoandroid.magicpiano.ap.d(), "Cancel FB connect attempt");
            }

            public void onError(FacebookException facebookexception)
            {
                aa.b(com.smule.pianoandroid.magicpiano.ap.d(), "Failed to connect to FB", facebookexception);
                Toast.makeText(a, "Error connecting to Facebook. Please try again.", 1).show();
            }

            public void onSuccess(Object obj)
            {
                a((LoginResult)obj);
            }

            
            {
                a = ap.this;
                super();
            }
        });
        if (z)
        {
            K = new Runnable() {

                final ap a;

                public void run()
                {
                    a.setRequestedOrientation(0);
                    com.smule.android.network.managers.d.a().a(8);
                }

            
            {
                a = ap.this;
                super();
            }
            };
            LoginManager.getInstance().logInWithReadPermissions(this, b.b);
            z = false;
        }
        H = new Observer() {

            final ap a;

            public void update(Observable observable, Object obj)
            {
                observable = a.findViewById("fb-login".hashCode());
                if (observable != null)
                {
                    ((ViewGroup)a.findViewById(0x7f0a01ec)).removeView(observable);
                }
            }

            
            {
                a = ap.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("CLAIMED_FB_REWARD_NOTIFICATION", H);
        com.smule.pianoandroid.utils.a.a(this);
        bundle = new HashMap();
        bundle.put("pageTitleKey", getString(0x7f0c02d7));
        bundle.put("pageFreeTitleKey", getString(0x7f0c0119));
        bundle.put("unlockButtonTitleKey", getString(0x7f0c02bf));
        bundle.put("freeButtonTitleKey", getString(0x7f0c0118));
        bundle.put("unlockButtonColorOn", "#0c3ff7");
        bundle.put("unlockButtonColorOff", "#187efe");
        bundle.put("freeButtonColorOn", "#797676");
        bundle.put("freeButtonColorOff", "#553682");
        bundle.put("freeTrialKey", getString(0x7f0c0297));
        MagicApplication.getLoader().a("PurchaseActivity.LoadSubs", Arrays.asList(new String[] {
            "InitAppTask.OP_LOCALIZE_SETTINGS"
        }), com.smule.pianoandroid.utils.n.a(this, new Runnable(bundle) {

            final Map a;
            final ap b;

            public void run()
            {
                com.smule.pianoandroid.magicpiano.ap.a(b, com.smule.android.network.managers.a.a().a("piandroid.purchasePage", "layout", a));
                b.c.setText((CharSequence)com.smule.pianoandroid.magicpiano.ap.n(b).get("pageTitleKey"));
                b.d.setText((CharSequence)com.smule.pianoandroid.magicpiano.ap.n(b).get("pageFreeTitleKey"));
                com.smule.pianoandroid.magicpiano.ap.o(b);
                List list = com.smule.android.network.managers.ap.a().f();
                if (list != null)
                {
                    com.smule.pianoandroid.magicpiano.ap.a(b, list);
                }
                com.smule.pianoandroid.magicpiano.ap.a(b, new aq(b));
                com.smule.pianoandroid.magicpiano.ap.a(b, 0);
                com.smule.pianoandroid.magicpiano.ap.a(b, new g());
                com.smule.pianoandroid.magicpiano.ap.f(b).a(b, com.smule.pianoandroid.magicpiano.ap.p(b));
                com.smule.pianoandroid.magicpiano.ap.q(b);
                com.smule.pianoandroid.magicpiano.ap.r(b);
                MagicApplication.getLoader().a("PurchaseActivity.LoadSubs");
            }

            
            {
                b = ap.this;
                a = map;
                super();
            }
        })).a();
        com.smule.pianoandroid.utils.q.y();
        if (getIntent().getBooleanExtra("SHOW_SPONSORPAY", false))
        {
            a(this);
        }
    }

    protected Dialog onCreateDialog(int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return a(0x7f0c0044, 0x7f0c0043);

        case 2: // '\002'
            return a(0x7f0c0038, 0x7f0c0037);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.smule.android.f.h.a().b("CLAIMED_FB_REWARD_NOTIFICATION", H);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        h();
        finish();
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
        com.jirbo.adcolony.q.c();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle == null);
    }

    protected void onResume()
    {
        super.onResume();
        MagicApplication.getInstance().onResume();
        if (y)
        {
            MagicApplication.getInstance().showToast(getResources().getString(0x7f0c01bc), 1);
            com.smule.android.network.managers.d.a().b();
            y = false;
        }
        com.jirbo.adcolony.q.a(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(l, w);
        bundle.putBoolean(m, y);
        bundle.putBoolean(B, z);
        bundle.putBoolean(C, A);
        bundle.putString(n, x);
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
        aa.c(e, "Activity started!");
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }

}
