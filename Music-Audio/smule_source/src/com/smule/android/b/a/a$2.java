// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.b.a;

import android.os.AsyncTask;

// Referenced classes of package com.smule.android.b.a:
//            a

class > extends AsyncTask
{

    final a a;

    protected Boolean a(Object aobj[])
    {
        return Boolean.valueOf(com.smule.android.b.a.a.b(a));
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            com.smule.android.b.a.a.c(a);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
