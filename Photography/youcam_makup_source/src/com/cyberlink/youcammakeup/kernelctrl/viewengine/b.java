// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import java.lang.ref.WeakReference;
import java.util.Vector;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            ImageBufferWrapper, k, ViewEngine, m

class b
{

    private Vector a;
    private ViewEngine b;
    private long c;
    private Thread d;
    private volatile boolean e;

    public b(ViewEngine viewengine, boolean flag)
    {
        c = 15000L;
        e = false;
        a = new Vector();
        b = viewengine;
        d = new Thread(new Runnable() {

            final b a;

            public void run()
            {
                while (!b.a(a)) 
                {
                    try
                    {
                        Thread.sleep(b.b(a));
                        a.b();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        if (flag)
        {
            c();
        }
    }

    private void a(String s)
    {
    }

    static boolean a(b b1)
    {
        return b1.e;
    }

    static long b(b b1)
    {
        return b1.c;
    }

    public void a()
    {
        e = true;
        d.interrupt();
    }

    public void a(ImageBufferWrapper imagebufferwrapper)
    {
        if (imagebufferwrapper == null)
        {
            a("[ImageBufferWrapperMonitor][addMonitorBuffer] Unexpected Error: bufferWrapper is null. Skip it.");
            return;
        } else
        {
            a.add(new WeakReference(imagebufferwrapper));
            return;
        }
    }

    public void b()
    {
        double d2 = 0.0D;
        a("======== Start to Dump Buffer Alive Statue ========");
        int i = 0;
        double d1 = 0.0D;
        int j = 0;
        while (i < a.size()) 
        {
            ImageBufferWrapper imagebufferwrapper = (ImageBufferWrapper)((WeakReference)a.get(i)).get();
            double d4 = d2;
            double d3 = d1;
            int l = j;
            if (imagebufferwrapper != null)
            {
                String s = imagebufferwrapper.e();
                d4 = d2;
                d3 = d1;
                l = j;
                if (imagebufferwrapper.d > 0L)
                {
                    a(s);
                    if (imagebufferwrapper.isImageBufferAttachedFromBitmap)
                    {
                        d2 += imagebufferwrapper.h();
                    } else
                    {
                        d1 += imagebufferwrapper.h();
                    }
                    l = j + 1;
                    d3 = d1;
                    d4 = d2;
                }
            }
            i++;
            d2 = d4;
            d1 = d3;
            j = l;
        }
        a((new StringBuilder()).append("Total Buffer Count:").append(a.size()).append(" Alive Buffer Count:").append(j).append(" Total Mem Size: (native) ").append(k.a(d1, 3)).append(" MB, (bitmap) ").append(k.a(d2, 3)).append(" MB").toString());
        a("======== End to Dump Buffer Alive Statue ========");
        if (b != null)
        {
            a("======== Start to ViewEngineCacheMgr ========");
            b.c().d();
            a("======== End to Dump ViewEngineCacheMgr ========");
        }
    }

    public void c()
    {
        d.start();
    }
}
