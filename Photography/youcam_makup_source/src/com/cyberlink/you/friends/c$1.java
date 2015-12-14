// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.you.friends:
//            c, e, i, j

class a extends AsyncTask
{

    final c a;

    protected transient Object a(String as[])
    {
        return a.a(as);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        super.onPostExecute(obj);
        c.a(a, obj);
        if (obj != null)
        {
            c.b(a).a(obj);
            return;
        } else
        {
            c.c(a).a("result is null.");
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        c.a(a).a();
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
