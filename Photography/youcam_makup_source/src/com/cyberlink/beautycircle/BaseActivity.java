// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.av;
import com.cyberlink.beautycircle.controller.a.aw;
import com.cyberlink.beautycircle.controller.a.az;
import com.cyberlink.beautycircle.controller.a.d;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.z;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.view.widgetpool.common.UploadProgressDialog;
import com.perfectcorp.a.b;
import com.perfectcorp.b.a;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

// Referenced classes of package com.cyberlink.beautycircle:
//            j, Globals, c, m, 
//            b

public class BaseActivity extends FragmentActivity
    implements z
{

    public static long b = 0L;
    protected static String d = "bc";
    private static int j = 0;
    private static boolean m = false;
    protected TopBarFragment a;
    public boolean c;
    private Dialog e;
    private Runnable f;
    private String g;
    private TextView h;
    private View i;
    private Bundle k;
    private boolean l;
    private Timer n;

    public BaseActivity()
    {
        a = null;
        f = null;
        g = null;
        h = null;
        i = null;
        k = null;
        c = true;
        l = false;
        n = null;
    }

    static Dialog a(BaseActivity baseactivity)
    {
        return baseactivity.e;
    }

    static Dialog a(BaseActivity baseactivity, Dialog dialog)
    {
        baseactivity.e = dialog;
        return dialog;
    }

    static View a(BaseActivity baseactivity, View view)
    {
        baseactivity.i = view;
        return view;
    }

    static TextView a(BaseActivity baseactivity, TextView textview)
    {
        baseactivity.h = textview;
        return textview;
    }

    static String a(BaseActivity baseactivity, String s)
    {
        baseactivity.g = s;
        return s;
    }

    public static String a(String s, String s1, Long long1)
    {
        if (s1 == null)
        {
            return null;
        } else
        {
            return NetworkEvent.a(s1, long1);
        }
    }

    static Timer a(BaseActivity baseactivity, Timer timer)
    {
        baseactivity.n = timer;
        return timer;
    }

    public static void a(String s, String s1)
    {
label0:
        {
            if (!m)
            {
                d = s;
                m = true;
                if (d == null)
                {
                    d = "bc";
                }
                aq.a = d;
                if (s1 != null)
                {
                    break label0;
                }
                aq.b = "null";
            }
            return;
        }
        aq.b = s1;
    }

    static boolean a(BaseActivity baseactivity, boolean flag)
    {
        baseactivity.l = flag;
        return flag;
    }

    private void b(Bundle bundle)
    {
        Class class1 = getClass();
_L5:
        Field afield[];
        int i1;
        int j1;
        afield = class1.getDeclaredFields();
        j1 = afield.length;
        i1 = 0;
_L3:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        Class class2;
        Object obj;
        obj = afield[i1];
        class2 = ((Field) (obj)).getType();
        if (!android/support/v4/app/Fragment.isAssignableFrom(class2))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Field) (obj)).setAccessible(true);
        obj = (Fragment)((Field) (obj)).get(this);
        if (obj != null)
        {
            try
            {
                getSupportFragmentManager().putFragment(bundle, class2.getName(), ((Fragment) (obj)));
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                illegalaccessexception.printStackTrace();
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                illegalargumentexception.printStackTrace();
            }
        }
        i1++;
          goto _L3
_L2:
        class1 = class1.getSuperclass();
        if (!com/cyberlink/beautycircle/BaseActivity.isAssignableFrom(class1))
        {
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static boolean b(BaseActivity baseactivity)
    {
        return baseactivity.l;
    }

    static String c(BaseActivity baseactivity)
    {
        return baseactivity.g;
    }

    private void c(Bundle bundle)
    {
        Class class1 = getClass();
_L5:
        Field afield[];
        int i1;
        int j1;
        afield = class1.getDeclaredFields();
        j1 = afield.length;
        i1 = 0;
_L3:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        Field field;
        Object obj;
        field = afield[i1];
        obj = field.getType();
        if (!android/support/v4/app/Fragment.isAssignableFrom(((Class) (obj))))
        {
            continue; /* Loop/switch isn't completed */
        }
        field.setAccessible(true);
        obj = getSupportFragmentManager().getFragment(bundle, ((Class) (obj)).getName());
        if (obj != null)
        {
            try
            {
                field.set(this, obj);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                illegalaccessexception.printStackTrace();
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                illegalargumentexception.printStackTrace();
            }
        }
        i1++;
          goto _L3
_L2:
        Class class2 = class1.getSuperclass();
        class1 = class2;
        if (!com/cyberlink/beautycircle/BaseActivity.isAssignableFrom(class2))
        {
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static TextView d(BaseActivity baseactivity)
    {
        return baseactivity.h;
    }

    static View e(BaseActivity baseactivity)
    {
        return baseactivity.i;
    }

    static Timer f(BaseActivity baseactivity)
    {
        return baseactivity.n;
    }

    private static void o()
    {
        (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                void1 = AccountManager.c();
                if (void1 != null)
                {
                    SharedPreferences sharedpreferences = Globals.D();
                    String s = sharedpreferences.getString("BC_MemberInfo", null);
                    Object obj = DateFormat.getDateInstance();
                    ((DateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("GMT-0700"));
                    obj = ((DateFormat) (obj)).format(new Date());
                    if (!((String) (obj)).equals(s))
                    {
                        sharedpreferences.edit().putString("BC_MemberInfo", ((String) (obj))).apply();
                        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.t(void1));
                    }
                }
                return null;
            }

        }).d(null);
    }

    public Runnable a()
    {
        Runnable runnable = new Runnable() {

            final BaseActivity a;

            public void run()
            {
                if (!a.isFinishing())
                {
                    a.e();
                }
            }

            
            {
                a = BaseActivity.this;
                super();
            }
        };
        f = runnable;
        return runnable;
    }

    public void a(int i1)
    {
        a(getString(i1));
    }

    public void a(int i1, Float float1, android.content.DialogInterface.OnClickListener onclicklistener, Runnable runnable)
    {
        runOnUiThread(new Runnable(float1, i1, onclicklistener, runnable) {

            final Float a;
            final int b;
            final android.content.DialogInterface.OnClickListener c;
            final Runnable d;
            final BaseActivity e;

            public void run()
            {
                if (com.cyberlink.beautycircle.BaseActivity.a(e) != null)
                {
                    ObjectAnimator objectanimator;
                    boolean flag;
                    boolean flag1;
                    if (a != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!((UploadProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).a())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1 ^ flag)
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "dismiss current ProgressDialog"
                        });
                        com.cyberlink.beautycircle.BaseActivity.a(e).dismiss();
                        com.cyberlink.beautycircle.BaseActivity.a(e, null);
                    }
                }
                if (com.cyberlink.beautycircle.BaseActivity.a(e) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(e, new UploadProgressDialog(e));
                    ((UploadProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).a(e.getString(b));
                    com.cyberlink.beautycircle.BaseActivity.a(e).setOnDismissListener(new android.content.DialogInterface.OnDismissListener(this) {

                        final _cls3 a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            com.cyberlink.beautycircle.BaseActivity.a(a.e, null);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    if (c != null)
                    {
                        com.cyberlink.beautycircle.BaseActivity.a(e).setCancelable(true);
                        ((UploadProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).a(c);
                        com.cyberlink.beautycircle.BaseActivity.a(e).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(this) {

                            final _cls3 a;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                a.c.onClick(com.cyberlink.beautycircle.BaseActivity.a(a.e), 0);
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                    } else
                    {
                        com.cyberlink.beautycircle.BaseActivity.a(e).setCancelable(false);
                    }
                    ((UploadProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).a(10000);
                    if (!e.isFinishing())
                    {
                        com.cyberlink.beautycircle.BaseActivity.a(e).show();
                    }
                    if (com.cyberlink.beautycircle.BaseActivity.b(e))
                    {
                        e.j();
                    }
                }
                if (a != null)
                {
                    objectanimator = ObjectAnimator.ofInt(com.cyberlink.beautycircle.BaseActivity.a(e), "Progress", new int[] {
                        (int)(10000F * a.floatValue())
                    }).setDuration(1000L);
                    objectanimator.setInterpolator(new DecelerateInterpolator());
                    objectanimator.addListener(new android.animation.Animator.AnimatorListener(this) {

                        final _cls3 a;

                        public void onAnimationCancel(Animator animator)
                        {
                        }

                        public void onAnimationEnd(Animator animator)
                        {
                            if (a.d != null)
                            {
                                a.d.run();
                            }
                        }

                        public void onAnimationRepeat(Animator animator)
                        {
                        }

                        public void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    objectanimator.start();
                }
            }

            
            {
                e = BaseActivity.this;
                a = float1;
                b = i1;
                c = onclicklistener;
                d = runnable;
                super();
            }
        });
    }

    public void a(Bundle bundle)
    {
        k = bundle;
    }

    public void a(View view, boolean flag)
    {
    }

    public void a(String s)
    {
        b().c(s);
    }

    public void a(String s, int i1)
    {
        runOnUiThread(new Runnable(s, i1) {

            final String a;
            final int b;
            final BaseActivity c;

            public void run()
            {
                if (com.cyberlink.beautycircle.BaseActivity.d(c) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, (TextView)c.findViewById(j.status_panel));
                }
                if (com.cyberlink.beautycircle.BaseActivity.e(c) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, c.findViewById(j.updown_shadow_panel));
                }
                if (com.cyberlink.beautycircle.BaseActivity.d(c) != null && com.cyberlink.beautycircle.BaseActivity.e(c) != null)
                {
                    com.cyberlink.beautycircle.BaseActivity.d(c).setText(a);
                    if (com.cyberlink.beautycircle.BaseActivity.d(c).getVisibility() == 8)
                    {
                        com.cyberlink.beautycircle.BaseActivity.d(c).setVisibility(0);
                        ObjectAnimator.ofFloat(com.cyberlink.beautycircle.BaseActivity.d(c), "alpha", new float[] {
                            0.0F, 1.0F
                        }).setDuration(200L).start();
                    }
                    if (com.cyberlink.beautycircle.BaseActivity.e(c).getVisibility() == 8)
                    {
                        ObjectAnimator.ofFloat(com.cyberlink.beautycircle.BaseActivity.e(c), "alpha", new float[] {
                            0.0F, 1.0F
                        }).setDuration(200L).start();
                    }
                    if (BaseActivity.f(c) != null)
                    {
                        BaseActivity.f(c).cancel();
                        com.cyberlink.beautycircle.BaseActivity.a(c, null);
                    }
                    com.cyberlink.beautycircle.BaseActivity.a(c, new Timer());
                    BaseActivity.f(c).schedule(new com.cyberlink.beautycircle.b(c), b);
                }
            }

            
            {
                c = BaseActivity.this;
                a = s;
                b = i1;
                super();
            }
        });
    }

    public void a(String s, boolean flag)
    {
        runOnUiThread(new Runnable(flag, s) {

            final boolean a;
            final String b;
            final BaseActivity c;

            public void run()
            {
                if (BaseActivity.f(c) != null)
                {
                    BaseActivity.f(c).cancel();
                    com.cyberlink.beautycircle.BaseActivity.a(c, null);
                }
                if (com.cyberlink.beautycircle.BaseActivity.d(c) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, (TextView)c.findViewById(j.status_panel));
                }
                if (com.cyberlink.beautycircle.BaseActivity.e(c) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, c.findViewById(j.updown_shadow_panel));
                }
                if (a && com.cyberlink.beautycircle.BaseActivity.d(c) != null && com.cyberlink.beautycircle.BaseActivity.e(c) != null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, b);
                    com.cyberlink.beautycircle.BaseActivity.d(c).setText(b);
                    if (com.cyberlink.beautycircle.BaseActivity.d(c).getVisibility() == 8)
                    {
                        com.cyberlink.beautycircle.BaseActivity.d(c).setVisibility(0);
                        ObjectAnimator.ofFloat(com.cyberlink.beautycircle.BaseActivity.d(c), "alpha", new float[] {
                            0.0F, 1.0F
                        }).setDuration(200L).start();
                    }
                    if (com.cyberlink.beautycircle.BaseActivity.e(c).getVisibility() == 8)
                    {
                        ObjectAnimator.ofFloat(com.cyberlink.beautycircle.BaseActivity.e(c), "alpha", new float[] {
                            0.0F, 1.0F
                        }).setDuration(200L).start();
                    }
                    return;
                } else
                {
                    com.cyberlink.beautycircle.BaseActivity.a(c, null);
                    c.m();
                    return;
                }
            }

            
            {
                c = BaseActivity.this;
                a = flag;
                b = s;
                super();
            }
        });
    }

    public TopBarFragment b()
    {
        if (a == null)
        {
            a = (TopBarFragment)getFragmentManager().findFragmentById(j.fragment_topbar_panel);
        }
        return a;
    }

    protected void b(int i1)
    {
        b(getString(i1));
    }

    public void b(int i1, Float float1, android.content.DialogInterface.OnClickListener onclicklistener, Runnable runnable)
    {
        runOnUiThread(new Runnable(float1, i1, onclicklistener, runnable) {

            final Float a;
            final int b;
            final android.content.DialogInterface.OnClickListener c;
            final Runnable d;
            final BaseActivity e;

            public void run()
            {
                if (com.cyberlink.beautycircle.BaseActivity.a(e) != null)
                {
                    ObjectAnimator objectanimator;
                    boolean flag;
                    boolean flag1;
                    if (a != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).isIndeterminate())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1 ^ flag)
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "dismiss current ProgressDialog"
                        });
                        com.cyberlink.beautycircle.BaseActivity.a(e).dismiss();
                        com.cyberlink.beautycircle.BaseActivity.a(e, null);
                    }
                }
                if (com.cyberlink.beautycircle.BaseActivity.a(e) == null)
                {
                    com.cyberlink.beautycircle.BaseActivity.a(e, new ProgressDialog(e));
                    ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setMessage(e.getString(b));
                    com.cyberlink.beautycircle.BaseActivity.a(e).setOnDismissListener(new android.content.DialogInterface.OnDismissListener(this) {

                        final _cls4 a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            com.cyberlink.beautycircle.BaseActivity.a(a.e, null);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    if (a != null)
                    {
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setIndeterminate(false);
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setProgressStyle(1);
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setProgressNumberFormat(null);
                    } else
                    {
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setIndeterminate(true);
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setProgressStyle(0);
                    }
                    if (c != null)
                    {
                        com.cyberlink.beautycircle.BaseActivity.a(e).setCancelable(true);
                        ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setButton(-2, e.getResources().getText(0x1040000), c);
                        com.cyberlink.beautycircle.BaseActivity.a(e).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(this) {

                            final _cls4 a;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                a.c.onClick(com.cyberlink.beautycircle.BaseActivity.a(a.e), -2);
                            }

            
            {
                a = _pcls4;
                super();
            }
                        });
                    } else
                    {
                        com.cyberlink.beautycircle.BaseActivity.a(e).setCancelable(false);
                    }
                    ((ProgressDialog)com.cyberlink.beautycircle.BaseActivity.a(e)).setMax(10000);
                    com.cyberlink.beautycircle.BaseActivity.a(e).show();
                }
                if (a != null)
                {
                    objectanimator = ObjectAnimator.ofInt(com.cyberlink.beautycircle.BaseActivity.a(e), "progress", new int[] {
                        (int)(10000F * a.floatValue())
                    }).setDuration(1000L);
                    objectanimator.addListener(new android.animation.Animator.AnimatorListener(this) {

                        final _cls4 a;

                        public void onAnimationCancel(Animator animator)
                        {
                        }

                        public void onAnimationEnd(Animator animator)
                        {
                            if (a.d != null)
                            {
                                a.d.run();
                            }
                        }

                        public void onAnimationRepeat(Animator animator)
                        {
                        }

                        public void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    objectanimator.setInterpolator(new DecelerateInterpolator());
                    objectanimator.start();
                }
            }

            
            {
                e = BaseActivity.this;
                a = float1;
                b = i1;
                c = onclicklistener;
                d = runnable;
                super();
            }
        });
    }

    protected void b(String s)
    {
        TopBarFragment topbarfragment = b();
        if (topbarfragment != null)
        {
            topbarfragment.c(s);
        }
        c();
    }

    protected void c()
    {
        TopBarFragment topbarfragment = b();
        if (topbarfragment != null)
        {
            topbarfragment.a(this);
        }
        d();
    }

    public void c(String s)
    {
    }

    public String d(String s)
    {
        return null;
    }

    protected void d()
    {
        TopBarFragment topbarfragment = b();
        if (topbarfragment != null)
        {
            topbarfragment.a();
        }
    }

    public String e(String s)
    {
        return a(s, d(s), null);
    }

    protected boolean e()
    {
        if (!com.cyberlink.beautycircle.Globals.b(this)) goto _L2; else goto _L1
_L1:
        if (!getClass().getName().equals(com/cyberlink/beautycircle/controller/activity/MainActivity.getName())) goto _L4; else goto _L3
_L3:
        if (!Globals.l())
        {
            com.cyberlink.beautycircle.c.a(this);
        }
_L2:
        onBackPressed();
        return true;
_L4:
        if (c)
        {
            com.cyberlink.beautycircle.c.a(this, "");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void f()
    {
        e();
    }

    public void finish()
    {
        Globals.n().a(null);
        super.finish();
    }

    public void g()
    {
    }

    public void h()
    {
    }

    public void i()
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(0x1020002).getWindowToken(), 0);
    }

    public void j()
    {
        if (e != null)
        {
            l = false;
            ((UploadProgressDialog)e).b();
            return;
        } else
        {
            l = true;
            return;
        }
    }

    public void k()
    {
        b(m.bc_waiting_text, null, null, null);
    }

    public void l()
    {
        runOnUiThread(new Runnable() {

            final BaseActivity a;

            public void run()
            {
                if (com.cyberlink.beautycircle.BaseActivity.a(a) != null && com.cyberlink.beautycircle.BaseActivity.a(a).isShowing())
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "closeProgress"
                    });
                    com.cyberlink.beautycircle.BaseActivity.a(a).dismiss();
                    com.cyberlink.beautycircle.BaseActivity.a(a, null);
                }
                com.cyberlink.beautycircle.BaseActivity.a(a, false);
            }

            
            {
                a = BaseActivity.this;
                super();
            }
        });
    }

    public void m()
    {
        runOnUiThread(new Runnable() {

            final BaseActivity a;

            public void run()
            {
                if (com.cyberlink.beautycircle.BaseActivity.d(a) != null)
                {
                    com.cyberlink.beautycircle.BaseActivity.d(a).setText("");
                    com.cyberlink.beautycircle.BaseActivity.d(a).setVisibility(8);
                }
                if (com.cyberlink.beautycircle.BaseActivity.e(a) != null)
                {
                    com.cyberlink.beautycircle.BaseActivity.e(a).setVisibility(8);
                }
            }

            
            {
                a = BaseActivity.this;
                super();
            }
        });
    }

    public Bundle n()
    {
        return k;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    public final void onBackPressed()
    {
        Globals.n().a(null);
        i();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.cyberlink.beautycircle.Globals.d = this;
        Runnable runnable = a();
        if (runnable != null)
        {
            Globals.n().a(runnable);
        }
        if (bundle != null)
        {
            c(bundle);
        }
    }

    protected void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            getClass().getSimpleName()
        });
        if (f != null)
        {
            Globals.n().b(f);
            f = null;
        }
        TopBarFragment topbarfragment = b();
        if (topbarfragment != null)
        {
            topbarfragment.b(this);
        }
        Field afield[] = getClass().getDeclaredFields();
        int j1 = afield.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            Field field = afield[i1];
            if (com/cyberlink/beautycircle/utility/u.isAssignableFrom(field.getType()))
            {
                field.setAccessible(true);
                try
                {
                    if (t.a((u)field.get(this)))
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            getClass().getSimpleName(), ".", field.getName(), " is registered but not removed when Activity.onDestroy!!!"
                        });
                    }
                }
                catch (Exception exception)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        exception
                    });
                }
            }
            i1++;
        }
        l();
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            return e();
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            getClass().getSimpleName()
        });
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "savedInstanceState: ", bundle.toString()
        });
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            getClass().getSimpleName()
        });
        com.cyberlink.beautycircle.Globals.d = this;
        super.onResume();
        Globals.n().a(getClass());
    }

    public void onRightBtnClick(View view)
    {
    }

    public void onRightSubBtnClick(View view)
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "outState before super: ", bundle.toString()
        });
        super.onSaveInstanceState(bundle);
        b(bundle);
        com.perfectcorp.utility.e.c(new Object[] {
            "outState after super: ", bundle.toString()
        });
    }

    protected void onStart()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            getClass().getSimpleName()
        });
        super.onStart();
        o();
        com.perfectcorp.a.b.a();
        com.perfectcorp.b.a.a(this, Globals.n().getResources().getString(m.share_flurry_app_key));
        com.perfectcorp.b.a.a();
        if (j == 0)
        {
            b = System.currentTimeMillis();
            com.perfectcorp.a.b.a(new av());
            az.a(Long.valueOf(System.currentTimeMillis()));
        }
        j++;
    }

    protected void onStop()
    {
        boolean flag = true;
        com.perfectcorp.utility.e.c(new Object[] {
            getClass().getSimpleName()
        });
        com.perfectcorp.a.b.b();
        com.perfectcorp.b.a.a(this);
        super.onStop();
        j--;
        if (j == 0)
        {
            m = false;
            if (b > 0L)
            {
                long l1 = System.currentTimeMillis() - b;
                com.perfectcorp.a.b.a(new aw(l1));
                String s = d;
                if (AccountManager.b() == null)
                {
                    flag = false;
                }
                com.perfectcorp.a.b.a(new az(s, l1, flag));
                if (Globals.l && Globals.m)
                {
                    if (Globals.k)
                    {
                        com.perfectcorp.a.b.a(new d("A", "BC_welcome_page_0819"));
                    } else
                    {
                        com.perfectcorp.a.b.a(new d("B", "BC_welcome_page_0819"));
                    }
                    Globals.m = false;
                }
            }
            NetworkManager.e();
        }
    }

    public void showSoftInput(View view)
    {
        InputMethodManager inputmethodmanager;
        if (view != null)
        {
            if ((inputmethodmanager = (InputMethodManager)getSystemService("input_method")) != null)
            {
                inputmethodmanager.showSoftInput(view, 1);
                return;
            }
        }
    }

}
