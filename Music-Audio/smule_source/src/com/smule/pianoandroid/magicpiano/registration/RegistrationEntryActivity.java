// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.smule.android.b.a.a;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.aw;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.b.e;
import com.smule.pianoandroid.magicpiano.b.h;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            b, e, RegisterActivity, LoginActivity

public class RegistrationEntryActivity extends ag
{

    private static final String a = com/smule/pianoandroid/magicpiano/registration/RegistrationEntryActivity.getName();
    private static String g;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private a h;
    private final com.smule.pianoandroid.magicpiano.registration.b i = new com.smule.pianoandroid.magicpiano.registration.b(this);
    private Dialog j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private CallbackManager m;
    private Handler n;

    public RegistrationEntryActivity()
    {
        b = false;
        c = true;
        f = false;
        h = new a();
        n = new Handler();
    }

    public static Intent a(Activity activity, String s, String s1)
    {
        activity = new Intent(activity, com/smule/pianoandroid/magicpiano/registration/RegistrationEntryActivity);
        activity.putExtra("DEVICE_CHECK", false);
        activity.putExtra("EMAIL_CHECK", true);
        activity.putExtra("HANDLE", s);
        activity.putExtra("EMAIL", s1);
        return activity;
    }

    public static Intent a(Activity activity, boolean flag, boolean flag1, String s, String s1, String s2)
    {
        activity = new Intent(activity, com/smule/pianoandroid/magicpiano/registration/RegistrationEntryActivity);
        activity.putExtra("DEVICE_CHECK", true);
        activity.putExtra("DEVICE_FOUND", flag);
        activity.putExtra("EMAIL_CHECK", false);
        activity.putExtra("HANDLE", s);
        activity.putExtra("EMAIL", s1);
        activity.putExtra("BACK_ALLOWED", flag1);
        activity.putExtra("SIGN_IN_TITLE", s2);
        return activity;
    }

    static String a(String s)
    {
        g = s;
        return s;
    }

    private void a()
    {
        aa.a(a, "googleButtonView - calling MagicGooglePlus - login");
        f = true;
        h.d();
    }

    static void a(RegistrationEntryActivity registrationentryactivity)
    {
        registrationentryactivity.c();
    }

    static void a(RegistrationEntryActivity registrationentryactivity, String s)
    {
        registrationentryactivity.b(s);
    }

    static void a(RegistrationEntryActivity registrationentryactivity, String s, String s1)
    {
        registrationentryactivity.b(s, s1);
    }

    private void a(String s, String s1)
    {
        e = true;
        if ("IN_PROGRESS" == g)
        {
            i.b();
            i.a(getString(0x7f0c016c), "");
        }
        k = new android.view.View.OnClickListener(s1) {

            final String a;
            final RegistrationEntryActivity b;

            public void onClick(View view)
            {
                if (!RegistrationEntryActivity.c(b))
                {
                    com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(b, a, null);
                    RegistrationEntryActivity.d(b).dismiss();
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a("IN_PROGRESS");
                    com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.e(b).a(b.getString(0x7f0c016c), "");
                    UserManager.n().a(new com.smule.android.network.managers.UserManager.LoginResponseCallback(this) {

                        final _cls12 a;

                        public void handleResponse(aw aw1)
                        {
                            a.b.runOnUiThread(new Runnable(this, aw1) {

                                final aw a;
                                final _cls1 b;

                                public void run()
                                {
                                    if (a.a.a != p.a)
                                    {
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.e(b.a.b).f();
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a("FAILURE");
                                        return;
                                    }
                                    if (a.a.a())
                                    {
                                        if (RegistrationEntryActivity.d(b.a.b) != null)
                                        {
                                            RegistrationEntryActivity.d(b.a.b).dismiss();
                                        }
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.e(b.a.b).a();
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a("SUCCESS");
                                        com.smule.pianoandroid.magicpiano.registration.e.b();
                                        com.smule.pianoandroid.magicpiano.registration.e.a(b.a.b);
                                        return;
                                    } else
                                    {
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.e(b.a.b).g();
                                        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a("FAILURE");
                                        com.smule.android.network.core.b.a(a.a);
                                        return;
                                    }
                                }

            
            {
                b = _pcls1;
                a = aw1;
                super();
            }
                            });
                        }

                        public volatile void handleResponse(Object obj)
                        {
                            handleResponse((aw)obj);
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = RegistrationEntryActivity.this;
                a = s;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final RegistrationEntryActivity a;

            public void onClick(View view)
            {
                RegistrationEntryActivity.f(a);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        };
        j = o.a(this, s, s1, k, l);
        j.setCancelable(true);
        j.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final RegistrationEntryActivity a;

            public void onCancel(DialogInterface dialoginterface)
            {
                RegistrationEntryActivity.f(a);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
    }

    private void a(String s, String s1, boolean flag)
    {
        com.smule.android.c.a.j();
        e = false;
        j = new Dialog(this, 0x7f0d007f);
        j.requestWindowFeature(1);
        View view = getLayoutInflater().inflate(0x7f03006e, null, false);
        j.setContentView(view);
        j.setCancelable(d);
        Object obj = (TextView)view.findViewById(0x7f0a0037);
        if (s != null)
        {
            ((TextView) (obj)).setTypeface(z.c(this));
            ((TextView) (obj)).setText(s);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)view.findViewById(0x7f0a006d);
        ((TextView) (obj)).setTypeface(z.c(this));
        if (s1 != null)
        {
            ((TextView) (obj)).setText(s1);
        }
        ((TextView)view.findViewById(0x7f0a023c)).setTypeface(z.b(this));
        m = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(m, new FacebookCallback() {

            final RegistrationEntryActivity a;

            public void a(LoginResult loginresult)
            {
                aa.a("Success", "Login");
                com.smule.android.c.a.c();
                com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(a);
            }

            public void onCancel()
            {
                Toast.makeText(a, "Login Cancel", 1).show();
            }

            public void onError(FacebookException facebookexception)
            {
                Toast.makeText(a, facebookexception.getMessage(), 1).show();
            }

            public void onSuccess(Object obj1)
            {
                a((LoginResult)obj1);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
        s1 = new android.view.View.OnClickListener() {

            final RegistrationEntryActivity a;

            public void onClick(View view1)
            {
                com.smule.android.c.a.c(com.smule.android.c.h.c.a());
                LoginManager.getInstance().logInWithReadPermissions(a, com.smule.pianoandroid.f.b.b);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        };
        obj = (Button)view.findViewById(0x7f0a0236);
        ((Button) (obj)).setTypeface(z.d(this));
        ((Button) (obj)).setOnClickListener(s1);
        view.findViewById(0x7f0a0235).setOnClickListener(s1);
        view.findViewById(0x7f0a0234).setOnClickListener(s1);
        s1 = new android.view.View.OnClickListener() {

            final RegistrationEntryActivity a;

            public void onClick(View view1)
            {
                com.smule.android.c.a.f();
                com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.b(a);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        };
        obj = (Button)view.findViewById(0x7f0a0239);
        ((Button) (obj)).setTypeface(z.d(this));
        ((Button) (obj)).setOnClickListener(s1);
        view.findViewById(0x7f0a0238).setOnClickListener(s1);
        view.findViewById(0x7f0a0237).setOnClickListener(s1);
        s1 = (Button)view.findViewById(0x7f0a023e);
        s1.setTypeface(z.d(this));
        s1.setOnClickListener(new android.view.View.OnClickListener(s) {

            final String a;
            final RegistrationEntryActivity b;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(b, a);
            }

            
            {
                b = RegistrationEntryActivity.this;
                a = s;
                super();
            }
        });
        s1 = (Button)view.findViewById(0x7f0a0135);
        s1.setTypeface(z.d(this));
        s1.setOnClickListener(new android.view.View.OnClickListener(s) {

            final String a;
            final RegistrationEntryActivity b;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(b, null, a);
            }

            
            {
                b = RegistrationEntryActivity.this;
                a = s;
                super();
            }
        });
        s = (Button)view.findViewById(0x7f0a023f);
        if (flag)
        {
            s.setVisibility(0);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final RegistrationEntryActivity a;

                public void onClick(View view1)
                {
                    com.smule.android.c.a.i();
                    a.finish();
                    com.smule.pianoandroid.magicpiano.registration.e.b(a);
                }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
            });
        } else
        {
            s.setVisibility(4);
        }
        j.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final RegistrationEntryActivity a;

            public void onCancel(DialogInterface dialoginterface)
            {
                com.smule.android.c.a.i();
                a.finish();
                com.smule.pianoandroid.magicpiano.registration.e.b(a);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
        j.show();
    }

    static boolean a(RegistrationEntryActivity registrationentryactivity, boolean flag)
    {
        registrationentryactivity.f = flag;
        return flag;
    }

    private void b()
    {
        j.dismiss();
        if (c)
        {
            com.smule.pianoandroid.magicpiano.registration.e.b(this);
            finish();
            return;
        } else
        {
            b(((String) (null)));
            return;
        }
    }

    static void b(RegistrationEntryActivity registrationentryactivity)
    {
        registrationentryactivity.a();
    }

    private void b(String s)
    {
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/registration/RegisterActivity);
        intent.putExtra("SIGN_IN_TITLE", s);
        startActivity(intent);
        finish();
    }

    private void b(String s, String s1)
    {
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/registration/LoginActivity);
        if (s != null)
        {
            intent.putExtra("param_email", s);
        }
        intent.putExtra("SIGN_IN_TITLE", s1);
        startActivity(intent);
        finish();
    }

    private void c()
    {
        n.post(new Runnable() {

            final RegistrationEntryActivity a;

            public void run()
            {
                (new e(a, false)).execute(new Void[0]);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
    }

    static boolean c(RegistrationEntryActivity registrationentryactivity)
    {
        return registrationentryactivity.c;
    }

    static Dialog d(RegistrationEntryActivity registrationentryactivity)
    {
        return registrationentryactivity.j;
    }

    private void d()
    {
        n.post(new Runnable() {

            final RegistrationEntryActivity a;

            public void run()
            {
                (new h(a, RegistrationEntryActivity.i(a), Boolean.valueOf(false))).execute(new Void[0]);
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
    }

    static com.smule.pianoandroid.magicpiano.registration.b e(RegistrationEntryActivity registrationentryactivity)
    {
        return registrationentryactivity.i;
    }

    static void f(RegistrationEntryActivity registrationentryactivity)
    {
        registrationentryactivity.b();
    }

    static boolean g(RegistrationEntryActivity registrationentryactivity)
    {
        return registrationentryactivity.f;
    }

    static void h(RegistrationEntryActivity registrationentryactivity)
    {
        registrationentryactivity.d();
    }

    static a i(RegistrationEntryActivity registrationentryactivity)
    {
        return registrationentryactivity.h;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (h.a(i1, j1, intent))
        {
            aa.a(a, "onActivityResult handled by G+");
            return;
        } else
        {
            m.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onBackPressed()
    {
    }

    public void onCreate(Bundle bundle)
    {
        String s;
        String s1;
        String s2;
        String s3;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag2 = true;
        super.onCreate(bundle);
        setContentView(0x7f030060);
        h.a(this);
        s = getIntent().getStringExtra("HANDLE");
        s1 = getIntent().getStringExtra("EMAIL");
        boolean flag = getIntent().getBooleanExtra("DEVICE_CHECK", true);
        flag3 = getIntent().getBooleanExtra("EMAIL_CHECK", false);
        flag4 = getIntent().getBooleanExtra("DEVICE_FOUND", false);
        d = getIntent().getBooleanExtra("BACK_ALLOWED", false);
        s2 = getIntent().getStringExtra("SIGN_IN_TITLE");
        s3 = getIntent().getStringExtra("SIGN_IN_MESSAGE");
        c = flag;
        if (bundle == null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        flag1 = bundle.getBoolean("IS_THIS_YOU", true);
        f = bundle.getBoolean("GPLUS_LOGIN_PRESSED", false);
        g = "NONE";
_L5:
        if (flag1)
        {
            a(s, s1);
            return;
        } else
        {
            a(s2, s3, d);
            return;
        }
_L2:
        if (!c) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (flag4) goto _L5; else goto _L4
_L4:
        if (c)
        {
            flag1 = false;
        } else
        {
            flag1 = flag2;
            if (!flag3)
            {
                aa.b(a, "unexpected state!!");
                flag1 = flag2;
            }
        }
          goto _L5
    }

    public void onDestroy()
    {
        i.c();
        if (j != null)
        {
            j.dismiss();
            j = null;
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        i.c();
        b = false;
    }

    public void onResume()
    {
        super.onResume();
        b = true;
        if (j != null)
        {
            j.show();
        }
        if ("IN_PROGRESS" == g)
        {
            i.b();
            i.a(getString(0x7f0c016c), "");
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("IS_THIS_YOU", e);
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
        h.a(new Runnable() {

            final RegistrationEntryActivity a;

            public void run()
            {
                if (!RegistrationEntryActivity.g(a))
                {
                    return;
                } else
                {
                    com.smule.android.c.a.g();
                    com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.h(a);
                    com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(a, false);
                    return;
                }
            }

            
            {
                a = RegistrationEntryActivity.this;
                super();
            }
        });
    }

    protected void onStop()
    {
        super.onStop();
        h.a();
        i.c();
        MagicApplication.onActivityStop(this);
    }

}
