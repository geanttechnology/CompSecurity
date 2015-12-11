// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.os.AsyncTask;
import com.smule.android.b.a.a;
import com.smule.android.c.aa;
import com.smule.pianoandroid.magicpiano.an;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            g

public class f extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/f.getName();
    private Activity b;
    private an c;
    private a d;
    private g e;

    public f(Activity activity, a a1, g g1)
    {
        b = activity;
        d = a1;
        e = g1;
    }

    protected transient Boolean a(Void avoid[])
    {
        aa.a(a, "doInBackground");
        return Boolean.valueOf(d.e());
    }

    protected void a(Boolean boolean1)
    {
        com.smule.android.c.a.h();
        if (c != null)
        {
            if (boolean1.booleanValue())
            {
                c.dismiss();
            } else
            {
                c.a(2, b.getString(0x7f0c0107), true);
            }
        }
        if (e != null)
        {
            e.a();
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        aa.a(a, (new StringBuilder()).append("Start disconnect task activity ").append(b).toString());
        c = new an(b, b.getString(0x7f0c00d2));
        c.setCancelable(false);
        c.a(false);
    }

}
