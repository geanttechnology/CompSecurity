// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.smule.android.c.aa;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ay;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            m

public class l extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/l.getName();
    private Activity b;
    private String c;
    private String d;
    private m e;

    public l(Activity activity, String s, String s1, m m1)
    {
        b = activity;
        d = s;
        c = s1;
        e = m1;
    }

    protected transient ay a(Void avoid[])
    {
        UserManager usermanager = UserManager.n();
        if (c == null || TextUtils.isEmpty(c))
        {
            avoid = usermanager.a(d);
        } else
        {
            ay ay1 = usermanager.a(d, c);
            avoid = ay1;
            if (ay1.a.a == p.a)
            {
                avoid = ay1;
                if (ay1.a.b == 1008)
                {
                    aa.c(a, "Password set by user was NOT accepted by server. Generating a new one.");
                    return usermanager.a(d);
                }
            }
        }
        return avoid;
    }

    protected void a(ay ay1)
    {
        if (e != null)
        {
            e.a(ay1);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ay)obj);
    }

    protected void onPreExecute()
    {
    }

}
