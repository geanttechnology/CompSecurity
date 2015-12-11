// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.AsyncTask;
import com.b.a.a.g;
import java.util.Calendar;

// Referenced classes of package com.offerup.android.activities:
//            k

final class w extends AsyncTask
{

    private k a;
    private k b;

    public w(k k1, k k2)
    {
        b = k1;
        super();
        a = k2;
    }

    private transient Boolean a()
    {
        boolean flag;
        try
        {
            flag = k.a(b, a);
        }
        catch (Exception exception)
        {
            g.a(this, exception);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(flag);
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        if (((Boolean) (obj)).booleanValue())
        {
            k.a(Calendar.getInstance());
            a.a(((Boolean) (obj)).booleanValue());
            return;
        } else
        {
            g.c(a.getClass().getSimpleName(), "unable to initialize libraries for activity");
            return;
        }
    }
}
