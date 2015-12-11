// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import com.smule.android.b.a.a;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.ar;
import com.smule.android.network.managers.aw;
import com.smule.pianoandroid.magicpiano.an;
import com.smule.pianoandroid.magicpiano.registration.NewHandleActivity;
import com.smule.pianoandroid.magicpiano.registration.e;

public class h extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/h.getName();
    private Activity b;
    private an c;
    private Boolean d;
    private a e;

    public h(Activity activity, a a1, Boolean boolean1)
    {
        b = activity;
        e = a1;
        d = boolean1;
    }

    static Activity a(h h1)
    {
        return h1.b;
    }

    protected transient aw a(Void avoid[])
    {
        return e.a(d.booleanValue());
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
        JVM INSTR lookupswitch 2: default 56
    //                   0: 91
    //                   1009: 213;
           goto _L4 _L5 _L6
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
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
        if (!d.booleanValue())
        {
            com.smule.pianoandroid.magicpiano.registration.e.b(aw1.o.booleanValue());
        }
        if (aw1.o.booleanValue())
        {
            (new Runnable(aw1) {

                final aw a;
                final h b;

                public void run()
                {
                    Intent intent = new Intent(com.smule.pianoandroid.magicpiano.b.h.a(b), com/smule/pianoandroid/magicpiano/registration/NewHandleActivity);
                    intent.putExtra("param_handle", a.e);
                    com.smule.pianoandroid.magicpiano.b.h.a(b).startActivity(intent);
                    com.smule.pianoandroid.magicpiano.b.h.a(b).finish();
                }

            
            {
                b = h.this;
                a = aw1;
                super();
            }
            }).run();
            i = j;
        } else
        {
            if (!d.booleanValue())
            {
                (new Runnable() {

                    final h a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.registration.e.a(com.smule.pianoandroid.magicpiano.b.h.a(a));
                    }

            
            {
                a = h.this;
                super();
            }
                }).run();
            }
            ar.a();
            ar.a(Boolean.valueOf(true), b);
            ar.a().a(b, true);
            i = j;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f0c0104;
        if (true) goto _L2; else goto _L7
_L7:
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
        c = new an(b, b.getString(0x7f0c00b1));
        c.setCancelable(false);
        c.a(false);
    }

}
