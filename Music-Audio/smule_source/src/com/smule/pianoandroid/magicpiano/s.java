// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.q;
import com.smule.pianoandroid.magicpiano.a.e;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity, q, an

class s extends AsyncTask
{

    an a;
    AlertDialog b;
    q c;
    com.smule.pianoandroid.magicpiano.q d;
    final GoodJobActivity e;

    private s(GoodJobActivity goodjobactivity)
    {
        e = goodjobactivity;
        super();
    }

    s(GoodJobActivity goodjobactivity, GoodJobActivity._cls1 _pcls1)
    {
        this(goodjobactivity);
    }

    protected transient Boolean a(com.smule.pianoandroid.magicpiano.q aq[])
    {
        boolean flag1 = false;
        c = GoodJobActivity.i(e);
        d = aq[0];
        boolean flag = flag1;
        if (c != null)
        {
            flag = flag1;
            if (c.a != null)
            {
                flag = flag1;
                if (c.a.a())
                {
                    flag = true;
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        e.c = boolean1.booleanValue();
        if (boolean1.booleanValue())
        {
            com.smule.pianoandroid.magicpiano.a.e.a("shared_song", GoodJobActivity.d(e));
        }
        if (GoodJobActivity.j(e))
        {
            if (boolean1.booleanValue())
            {
                d.a(c);
                a.dismiss();
                return;
            }
            int j = 0x7f0c02cc;
            int i = j;
            if (c != null)
            {
                i = j;
                if (c.a.a == p.c)
                {
                    i = 0x7f0c0045;
                }
            }
            a.dismiss();
            boolean1 = new android.app.AlertDialog.Builder(e, 2);
            boolean1.setMessage(i);
            boolean1.setCancelable(true);
            boolean1.setPositiveButton(0x7f0c01c0, new android.content.DialogInterface.OnClickListener() {

                final s a;

                public void onClick(DialogInterface dialoginterface, int k)
                {
                    a.b.dismiss();
                }

            
            {
                a = s.this;
                super();
            }
            });
            b = boolean1.create();
            b.show();
            return;
        }
        GoodJobActivity.a(e, a);
        if (boolean1.booleanValue())
        {
            d.a(c);
            GoodJobActivity.a(e, 1);
            a.dismiss();
            return;
        } else
        {
            GoodJobActivity.a(e, 2);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((com.smule.pianoandroid.magicpiano.q[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        a = new an(e, e.getString(0x7f0c0241));
        a.setCancelable(false);
        a.a(false);
    }
}
