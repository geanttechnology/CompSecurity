// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivityForIntent, SplashActivity

class a extends AsyncTask
{

    final LibraryPickerActivityForIntent a;

    protected transient Void a(Void avoid[])
    {
        SplashActivity.c();
        SplashActivity.d();
        return null;
    }

    protected void a(Void void1)
    {
        a.b = true;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (LibraryPickerActivityForIntent librarypickeractivityforintent)
    {
        a = librarypickeractivityforintent;
        super();
    }
}
