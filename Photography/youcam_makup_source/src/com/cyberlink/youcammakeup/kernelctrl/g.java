// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            BeautifierManager

class g extends AsyncTask
{

    final BeautifierManager a;
    private final BeautifierManager.TaskType b;

    public g(BeautifierManager beautifiermanager, BeautifierManager.TaskType tasktype)
    {
        a = beautifiermanager;
        super();
        b = tasktype;
    }

    protected transient Boolean a(Long along[])
    {
        if (b == BeautifierManager.TaskType.a)
        {
            BeautifierManager.a(a, along[0].longValue());
            if (com.cyberlink.youcammakeup.database.g.a(BeautifierManager.a(a)) || i.a(BeautifierManager.a(a)))
            {
                return Boolean.valueOf(BeautifierManager.b(a).a((int)BeautifierManager.a(a)));
            }
        } else
        if (b == BeautifierManager.TaskType.b)
        {
            long l = BeautifierManager.a(a);
            BeautifierManager.a(a, along[0].longValue());
            if (com.cyberlink.youcammakeup.database.g.a(l) || i.a(BeautifierManager.a(a)))
            {
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(a).i();
                return Boolean.valueOf(BeautifierManager.b(a).b((int)l));
            }
        }
        return Boolean.valueOf(false);
    }

    protected void a(Boolean boolean1)
    {
        if (b == BeautifierManager.TaskType.b || b == com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.TaskType.c)
        {
            synchronized (a)
            {
                if (BeautifierManager.d(a) != null)
                {
                    BeautifierManager.d(a).m();
                    BeautifierManager.a(a, null);
                }
                if (BeautifierManager.e(a) != null)
                {
                    BeautifierManager.e(a).m();
                    BeautifierManager.b(a, null);
                }
                if (com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(a) != null)
                {
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(a).m();
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(a, null);
                }
                if (BeautifierManager.g(a) != null)
                {
                    BeautifierManager.g(a).m();
                    BeautifierManager.d(a, null);
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Long[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
