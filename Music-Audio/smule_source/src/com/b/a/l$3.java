// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.os.AsyncTask;

// Referenced classes of package com.b.a:
//            l, m

final class syncTask extends AsyncTask
{

    final m a;
    final String b;
    final Runnable c;

    protected transient Void a(Void avoid[])
    {
        a.a(null, null, b);
        return null;
    }

    protected void a(Void void1)
    {
        c.run();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    nnable(m m1, String s, Runnable runnable)
    {
        a = m1;
        b = s;
        c = runnable;
        super();
    }
}
