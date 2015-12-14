// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.e;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            d, StatusManager, ImageStateChangedEvent

public class b extends AsyncTask
{

    private final d a;
    private final e b;
    private ImageStateChangedEvent c;

    public b(d d1, e e1)
    {
        a = d1;
        b = e1;
    }

    protected transient Boolean a(Void avoid[])
    {
        c = a.k();
        return Boolean.valueOf(true);
    }

    public void a(Boolean boolean1)
    {
        if (b == null)
        {
            return;
        } else
        {
            b.c(null);
            return;
        }
    }

    public void b(Boolean boolean1)
    {
        if (b == null)
        {
            return;
        }
        StatusManager.j().a(c);
        if (c != null)
        {
            b.a(c);
            return;
        } else
        {
            b.b(null);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onCancelled(Object obj)
    {
        a((Boolean)obj);
    }

    public void onPostExecute(Object obj)
    {
        b((Boolean)obj);
    }
}
