// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            d, a, c

public class SessionManagerLocal
{

    private ArrayList a;
    private ConcurrentHashMap b;
    private LocalSessionType c;

    public SessionManagerLocal(LocalSessionType localsessiontype)
    {
        a = null;
        b = null;
        a = new ArrayList();
        b = new ConcurrentHashMap();
        c = localsessiontype;
    }

    public com.cyberlink.youcammakeup.kernelctrl.status.d a(long l)
    {
        if (!b.containsKey(Long.valueOf(l)))
        {
            if (c == LocalSessionType.b)
            {
                b.put(Long.valueOf(l), new com.cyberlink.youcammakeup.kernelctrl.status.d(l, "_fine_tune"));
            } else
            {
                b.put(Long.valueOf(l), new com.cyberlink.youcammakeup.kernelctrl.status.d(l, "_local"));
            }
        }
        return (com.cyberlink.youcammakeup.kernelctrl.status.d)b.get(Long.valueOf(l));
    }

    public void a()
    {
        if (b.size() == 0)
        {
            return;
        }
        for (Iterator iterator = b.values().iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.status.d)iterator.next()).a()) { }
        b = new ConcurrentHashMap();
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper)
    {
        a(a1.a).a(a1, imagebufferwrapper);
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper, d d1)
    {
        com.cyberlink.youcammakeup.kernelctrl.status.d d2 = a(a1.a);
        (new c(d2, a1, imagebufferwrapper, new d(d1) {

            final d b;
            final SessionManagerLocal c;

            public void a()
            {
                if (b != null)
                {
                    b.a();
                }
            }

            public void b()
            {
                if (b != null)
                {
                    b.b();
                }
            }

            public void c()
            {
                if (b != null)
                {
                    b.c();
                }
            }

            
            {
                c = SessionManagerLocal.this;
                b = d1;
                super();
            }
        })).executeOnExecutor(d2.c(), new Void[0]);
    }

    public void a(a a1, ImageBufferWrapper imagebufferwrapper, ImageBufferWrapper imagebufferwrapper1)
    {
        a(a1.a).a(a1, imagebufferwrapper, imagebufferwrapper1);
    }

    public boolean b(long l)
    {
        while (!b.containsKey(Long.valueOf(l)) || a(l).e() == null) 
        {
            return false;
        }
        return true;
    }

    public a c(long l)
    {
        return a(l).e();
    }

    private class LocalSessionType extends Enum
    {

        public static final LocalSessionType a;
        public static final LocalSessionType b;
        private static final LocalSessionType c[];

        public static LocalSessionType valueOf(String s)
        {
            return (LocalSessionType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/status/SessionManagerLocal$LocalSessionType, s);
        }

        public static LocalSessionType[] values()
        {
            return (LocalSessionType[])c.clone();
        }

        static 
        {
            a = new LocalSessionType("LOCAL", 0);
            b = new LocalSessionType("FINE_TUNE", 1);
            c = (new LocalSessionType[] {
                a, b
            });
        }

        private LocalSessionType(String s, int i)
        {
            super(s, i);
        }
    }

}
