// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.os.AsyncTask;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.aw;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            k

public class j extends AsyncTask
{

    private Activity a;
    private String b;
    private String c;
    private k d;

    public j(Activity activity, k k1, String s, String s1)
    {
        a = activity;
        d = k1;
        b = s;
        c = s1;
    }

    protected transient aw a(Void avoid[])
    {
        return UserManager.n().b(b, c);
    }

    protected void a(aw aw1)
    {
        if (d != null)
        {
            d.a(aw1);
        }
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
    }
}
