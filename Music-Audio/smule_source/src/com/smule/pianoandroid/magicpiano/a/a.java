// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.e.d;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.magicpiano.GameRewardsActivity;
import com.smule.pianoandroid.magicpiano.an;
import com.smule.pianoandroid.magicpiano.b;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            e

public class a
{

    static final String a = com/smule/pianoandroid/magicpiano/a/a.getName();
    boolean b;
    boolean c;
    an d;
    FragmentManager e;
    FragmentActivity f;
    Observer g;
    Runnable h;
    Runnable i;

    public a(FragmentActivity fragmentactivity)
    {
        b = false;
        c = false;
        d = null;
        g = null;
        h = null;
        i = null;
        e = fragmentactivity.getSupportFragmentManager();
        f = fragmentactivity;
        h = new Runnable() {

            final a a;

            public void run()
            {
                a.a(a);
                com.smule.pianoandroid.magicpiano.a.a.b(a);
            }

            
            {
                a = a.this;
                super();
            }
        };
        i = new Runnable() {

            final a a;

            public void run()
            {
                a.c(a);
            }

            
            {
                a = a.this;
                super();
            }
        };
        h();
    }

    public static void a(Activity activity)
    {
        Intent intent = new Intent(activity, com/smule/pianoandroid/magicpiano/GameRewardsActivity);
        intent.putExtra("LEVEL", com.smule.pianoandroid.e.e.a().f());
        activity.startActivityForResult(intent, 216);
    }

    static void a(a a1)
    {
        a1.g();
    }

    static void b(a a1)
    {
        a1.f();
    }

    static void c(a a1)
    {
        a1.e();
    }

    private void d()
    {
        f.runOnUiThread(i);
    }

    static void d(a a1)
    {
        a1.d();
    }

    private void e()
    {
        if (!b)
        {
            return;
        }
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            d = new an(f, f.getString(0x7f0c02b6));
        } else
        {
            d = new an(f, f.getString(0x7f0c0055));
        }
        d.a(false);
        com.smule.pianoandroid.magicpiano.a.e.a(new Runnable() {

            final a a;

            public void run()
            {
                if (!a.f.isFinishing())
                {
                    a.f.runOnUiThread(a.h);
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void f()
    {
        if (c)
        {
            return;
        }
        if (com.smule.pianoandroid.magicpiano.a.e.b() && com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            c = true;
            return;
        } else
        {
            b b1 = (b)e.findFragmentById(0x7f0a0133);
            return;
        }
    }

    private void g()
    {
        if (d != null)
        {
            d.dismiss();
            d = null;
        }
    }

    private void h()
    {
        g = new Observer() {

            final a a;

            public void update(Observable observable, Object obj)
            {
                aa.a(a.a, "Got level up notification!");
                com.smule.pianoandroid.magicpiano.a.a.d(a);
            }

            
            {
                a = a.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("game.level.update", g);
    }

    private void i()
    {
        com.smule.android.f.h.a().b("game.level.update", g);
    }

    public void a()
    {
        if (c)
        {
            aa.b(a, "Achievement state dialog still showing on onResume!!! Please call onActivityResult first!");
        }
        b = true;
        d();
    }

    public boolean a(int j)
    {
        return j == 215 || j == 216;
    }

    public boolean a(int j, int k, Intent intent)
    {
        if (a(j))
        {
            if ((com.smule.pianoandroid.e.e.a().f() != 2 || com.smule.pianoandroid.e.e.a().e() != 0L) && (intent == null || TextUtils.isEmpty(intent.getStringExtra("PRODUCT_UID"))))
            {
                com.smule.android.f.h.a().a("LEVEL_PROGRESS_UPDATED", new Object[0]);
            }
            c = false;
            if (j == 215)
            {
                aa.c(a, String.format("User earned %d XP.", new Object[] {
                    Integer.valueOf(k)
                }));
                w.a(new Runnable(k) {

                    final int a;
                    final a b;

                    public void run()
                    {
                        com.smule.pianoandroid.e.e.a().b(a);
                        if (a > 0)
                        {
                            com.smule.pianoandroid.e.d.a().c();
                        }
                    }

            
            {
                b = a.this;
                a = j;
                super();
            }
                });
                return false;
            }
            if (j == 216 && k == -1)
            {
                return true;
            }
        }
        return false;
    }

    public void b()
    {
        b = false;
    }

    public void c()
    {
        g();
        i();
    }

}
