// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            d, a

public class c extends AsyncTask
{

    private final com.cyberlink.youcammakeup.kernelctrl.status.d a;
    private final a b;
    private final ImageBufferWrapper c;
    private final d d;

    public c(com.cyberlink.youcammakeup.kernelctrl.status.d d1, a a1, ImageBufferWrapper imagebufferwrapper, d d2)
    {
        a = d1;
        b = a1;
        c = imagebufferwrapper;
        d = d2;
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.valueOf(a.b(b, c));
    }

    public void a(Boolean boolean1)
    {
        if (d == null)
        {
            return;
        } else
        {
            d.c();
            return;
        }
    }

    public void b(Boolean boolean1)
    {
        if (d == null)
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            d.a();
            return;
        } else
        {
            d.b();
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
