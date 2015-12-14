// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import android.os.AsyncTask;
import com.facebook.internal.Utility;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            LoginButton

class a extends AsyncTask
{

    final String a;
    final LoginButton b;

    protected transient com.facebook.internal.dAppSettings a(Void avoid[])
    {
        return Utility.queryAppSettings(a, false);
    }

    protected void a(com.facebook.internal.dAppSettings dappsettings)
    {
        LoginButton.a(b, dappsettings);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((com.facebook.internal.dAppSettings)obj);
    }

    (LoginButton loginbutton, String s)
    {
        b = loginbutton;
        a = s;
        super();
    }
}
