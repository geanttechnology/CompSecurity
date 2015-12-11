// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.facebook.a;
import com.smule.android.facebook.e;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.ac;
import com.smule.android.network.managers.ad;
import com.smule.pianoandroid.magicpiano.an;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            d

public class c extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/c.getName();
    private Activity b;
    private an c;
    private boolean d;
    private Boolean e;
    private d f;

    public c(Activity activity)
    {
        d = false;
        e = null;
        b = activity;
    }

    public c(Activity activity, d d1)
    {
        d = false;
        e = null;
        b = activity;
        f = d1;
    }

    protected transient String a(Void avoid[])
    {
        String s;
        o o1;
        o1 = com.smule.android.facebook.a.a().a(e.b, false);
        s = b.getString(0x7f0c0045);
        avoid = s;
        if (o1 == null) goto _L2; else goto _L1
_L1:
        o1.b;
        JVM INSTR lookupswitch 2: default 56
    //                   0: 93
    //                   1009: 253;
           goto _L3 _L4 _L5
_L3:
        com.smule.android.network.core.b.a(o1);
        s = b.getString(0x7f0c0102);
        avoid = s;
        if (f != null)
        {
            f.a(false);
            avoid = s;
        }
_L2:
        return avoid;
_L4:
        b.setResult(4);
        d = true;
        boolean flag = com.smule.pianoandroid.f.b.a();
        e = Boolean.valueOf(false);
        if (!flag && com.smule.pianoandroid.f.b.a(b))
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
                }
                com.smule.pianoandroid.f.b.a(i);
                b.runOnUiThread(new Runnable() {

                    final c a;

                    public void run()
                    {
                        h.a().a("CLAIMED_FB_REWARD_NOTIFICATION", new Object[0]);
                    }

            
            {
                a = c.this;
                super();
            }
                });
            } else
            {
                aa.a(a, "Unable to claim reward!");
            }
        }
        if (f != null)
        {
            f.a(true);
        }
        com.smule.android.facebook.a.a().a(true);
        return s;
_L5:
        String s1;
        if (o1.f == 40)
        {
            s1 = b.getString(0x7f0c00fd);
        } else
        {
            s1 = b.getString(0x7f0c0104);
        }
        avoid = s1;
        if (f != null)
        {
            f.a(false);
            return s1;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void a(String s)
    {
        if (d && c != null)
        {
            c.dismiss();
            c = null;
        }
        if (e != null)
        {
            com.smule.pianoandroid.utils.o.b(b, e.booleanValue(), null);
        }
        if (!d && c == null)
        {
            c = new an(b, b.getString(0x7f0c00b0));
            c.setCancelable(false);
            c.a(false);
        }
        if (c != null)
        {
            c.a(2, s, true);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    protected void onPreExecute()
    {
        c = new an(b, b.getString(0x7f0c00b0));
        c.setCancelable(false);
        c.a(false);
    }

}
