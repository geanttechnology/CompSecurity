// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.bc;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class a extends AsyncTask
{

    final SplashActivity a;

    protected transient Void a(Void avoid[])
    {
        if (!Globals.d().f().a().booleanValue());
        return null;
    }

    protected void a(Void void1)
    {
        SplashActivity.a(a).d = Boolean.valueOf(true);
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

    (SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }
}
