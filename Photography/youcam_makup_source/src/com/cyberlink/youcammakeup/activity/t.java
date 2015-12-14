// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class t extends AsyncTask
{

    final SplashActivity a;

    private t(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }

    t(SplashActivity splashactivity, SplashActivity._cls1 _pcls1)
    {
        this(splashactivity);
    }

    protected transient Void a(Void avoid[])
    {
        SplashActivity.c();
        SplashActivity.d();
        return null;
    }

    protected void a(Void void1)
    {
        SplashActivity.a(a).c = Boolean.valueOf(true);
        SplashActivity.b(a);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
