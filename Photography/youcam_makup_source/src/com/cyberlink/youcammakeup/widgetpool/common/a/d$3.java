// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            d

class a extends AsyncTask
{

    final d a;
    private BeautyMode b;

    protected transient Void a(Void avoid[])
    {
        d.a(a, a.a(b));
        return null;
    }

    protected void a(Void void1)
    {
        a.b(b);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        b = StatusManager.j().s();
        a.c(b);
    }

    Manager(d d1)
    {
        a = d1;
        super();
    }
}
