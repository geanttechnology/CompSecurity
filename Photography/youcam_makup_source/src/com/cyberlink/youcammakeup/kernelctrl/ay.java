// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, aq

public class ay extends AsyncTask
{

    final VenusHelper a;
    private final boolean b;
    private final Float c;
    private final Float d;
    private final aq e;

    public ay(VenusHelper venushelper, boolean flag, Float float1, Float float2, aq aq1)
    {
        a = venushelper;
        super();
        b = flag;
        c = float1;
        d = float2;
        e = aq1;
    }

    protected transient Integer a(Void avoid[])
    {
        return Integer.valueOf(VenusHelper.a(a, b, c, d));
    }

    protected void a(Integer integer)
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().h(Globals.d().t());
        }
        if (integer.intValue() > -1)
        {
            if (e != null)
            {
                e.a(null);
            }
        } else
        if (e != null)
        {
            e.b(integer);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().h(Globals.d().t());
        }
        if (e != null)
        {
            e.c(null);
        }
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onPreExecute()
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().b(Globals.d().t());
        }
    }
}
