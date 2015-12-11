// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.facebook.a;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.ac;
import com.smule.android.network.managers.ad;
import com.smule.android.network.managers.ar;
import com.smule.android.network.managers.aw;
import com.smule.pianoandroid.f.b;
import com.smule.pianoandroid.magicpiano.an;
import com.smule.pianoandroid.magicpiano.registration.FacebookEmailActivity;
import com.smule.pianoandroid.magicpiano.registration.NewHandleActivity;

public class e extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/e.getName();
    private Activity b;
    private an c;
    private boolean d;
    private Boolean e;
    private boolean f;
    private String g;
    private boolean h;

    public e(Activity activity, String s, boolean flag)
    {
        e = null;
        h = false;
        b = activity;
        d = flag;
        g = s;
    }

    public e(Activity activity, boolean flag)
    {
        e = null;
        h = false;
        b = activity;
        d = flag;
    }

    static Activity a(e e1)
    {
        return e1.b;
    }

    protected transient aw a(Void avoid[])
    {
        avoid = com.smule.android.facebook.a.a().b(g, d);
        if (avoid == null)
        {
            return null;
        }
        if (((aw) (avoid)).a == null || !((aw) (avoid)).a.a()) goto _L2; else goto _L1
_L1:
        if (!d)
        {
            boolean flag;
            if (!com.smule.pianoandroid.f.b.a() && com.smule.pianoandroid.f.b.a(b))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            if (f)
            {
                int i = ac.a().a(ad.b.c);
                if (i >= 0)
                {
                    if (i == 0)
                    {
                        aa.a(a, "Reward already claimed!");
                        e = Boolean.valueOf(false);
                    } else
                    {
                        aa.a(a, "Reward granted!");
                        e = Boolean.valueOf(true);
                        com.smule.pianoandroid.f.b.a(i);
                    }
                } else
                {
                    aa.a(a, "Unable to claim reward!");
                }
            }
        }
_L4:
        return avoid;
_L2:
        if (((aw) (avoid)).a != null && ((aw) (avoid)).a.b == 72)
        {
            Intent intent = new Intent(b.getApplicationContext(), com/smule/pianoandroid/magicpiano/registration/FacebookEmailActivity);
            b.startActivity(intent);
            b.finish();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(aw aw1)
    {
        int i;
        int j;
        j = 0x7f0c0045;
        i = j;
        if (aw1 == null) goto _L2; else goto _L1
_L1:
        i = j;
        if (aw1.a.a != p.a) goto _L2; else goto _L3
_L3:
        aw1.a.b;
        JVM INSTR lookupswitch 3: default 68
    //                   0: 103
    //                   67: 315
    //                   1009: 309;
           goto _L4 _L5 _L6 _L7
_L4:
        i = 0x7f0c0121;
        com.smule.android.network.core.b.a(aw1.a);
_L2:
        if (c != null)
        {
            c.a(2, b.getString(i), true);
        }
        return;
_L5:
        h = true;
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
        if (!d)
        {
            com.smule.pianoandroid.magicpiano.registration.e.a(aw1.o.booleanValue());
        }
        if (aw1.o.booleanValue())
        {
            Intent intent = new Intent(b, com/smule/pianoandroid/magicpiano/registration/NewHandleActivity);
            intent.putExtra("param_handle", aw1.e);
            if (f)
            {
                intent.putExtra("param_fb_reward", e);
            }
            b.startActivity(intent);
            b.finish();
        } else
        {
            if (!d)
            {
                aw1 = new Runnable() {

                    final e a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.registration.e.a(com.smule.pianoandroid.magicpiano.b.e.a(a));
                    }

            
            {
                a = e.this;
                super();
            }
                };
                if (f)
                {
                    if (e != null)
                    {
                        com.smule.pianoandroid.utils.o.b(b, e.booleanValue(), aw1);
                    }
                } else
                {
                    aw1.run();
                }
            }
            ar.a();
            ar.a(Boolean.valueOf(true), b);
            ar.a().a(b, true);
        }
        com.smule.android.facebook.a.a().a(true);
        i = j;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 0x7f0c0104;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f0c00eb;
        if (true) goto _L2; else goto _L8
_L8:
    }

    public boolean a()
    {
        return h;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((aw)obj);
    }

    protected void onPreExecute()
    {
        c = new an(b, b.getString(0x7f0c00b0));
        c.setCancelable(false);
        c.a(false);
    }

}
