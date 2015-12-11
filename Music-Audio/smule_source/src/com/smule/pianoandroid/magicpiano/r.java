// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.q;
import com.smule.android.network.models.PerformanceV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.f.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity, an, ao

class r extends AsyncTask
{

    an a;
    String b;
    String c;
    String d;
    String e;
    final GoodJobActivity f;

    public r(GoodJobActivity goodjobactivity, String s, String s1)
    {
        f = goodjobactivity;
        super();
        b = s1;
        c = s;
    }

    protected transient Boolean a(String as[])
    {
        boolean flag = true;
        as = as[0];
        if (c.equals("play_android"))
        {
            SongV2 songv2 = GoodJobActivity.d(f);
            if (songv2 != null && songv2.webUrl != null && songv2.webUrl.length() > 0)
            {
                d = songv2.webUrl;
                e = as;
                return Boolean.valueOf(true);
            } else
            {
                return Boolean.valueOf(false);
            }
        }
        q q1 = GoodJobActivity.i(f);
        if (q1 == null || q1.a == null || !q1.a.a())
        {
            flag = false;
        }
        if (flag)
        {
            d = q1.mPerformance.webUrl;
            e = as;
        }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        if (!c.equals("perform_android")) goto _L2; else goto _L1
_L1:
        f.c = true;
        if (!GoodJobActivity.j(f)) goto _L4; else goto _L3
_L3:
        if (!boolean1.booleanValue()) goto _L6; else goto _L5
_L5:
        com.smule.pianoandroid.f.a.a(f).a(f, c, b, e, d, GoodJobActivity.k(f));
        a.dismiss();
_L8:
        return;
_L6:
        a.a(2, (String)f.getText(0x7f0c023d), true);
        return;
_L4:
        com.smule.pianoandroid.magicpiano.GoodJobActivity.a(f, a);
        if (boolean1.booleanValue())
        {
            com.smule.pianoandroid.magicpiano.GoodJobActivity.a(f, 1);
            return;
        } else
        {
            com.smule.pianoandroid.magicpiano.GoodJobActivity.a(f, 2);
            return;
        }
_L2:
        if (boolean1.booleanValue())
        {
            com.smule.pianoandroid.f.a.a(f).a(f, c, b, e, d, GoodJobActivity.k(f));
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        if (c.equals("perform_android"))
        {
            a = new an(f, f.getString(0x7f0c0240));
            a.setCancelable(true);
            a.a(new ao() {

                final r a;

                public void c_()
                {
                    a.cancel(true);
                }

            
            {
                a = r.this;
                super();
            }
            });
            a.a(true);
        }
    }
}
