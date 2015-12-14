// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.c;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.c:
//            a, b

public class d
{

    public WeakReference a;

    public d()
    {
        a = null;
    }

    public void a()
    {
        a = null;
    }

    public void a(a a1)
    {
        if (a != null)
        {
            a = null;
        }
        a = new WeakReference(a1);
    }

    public void a(UUID uuid, UUID uuid1)
    {
        if (a != null)
        {
            if ((uuid = ((a)a.get()).a()) != null)
            {
                uuid = uuid.iterator();
                while (uuid.hasNext()) 
                {
                    b b1 = (b)((WeakReference)uuid.next()).get();
                    if (b1 != null)
                    {
                        b1.a(uuid1);
                    }
                }
            }
        }
    }

    public WeakReference b()
    {
        return a;
    }

    public void c()
    {
        Object obj;
        if (a != null)
        {
            if ((obj = (a)a.get()) != null && (obj = ((a) (obj)).a()) != null)
            {
                obj = ((ArrayList) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    b b1 = (b)((WeakReference)((Iterator) (obj)).next()).get();
                    if (b1 != null)
                    {
                        b1.a();
                    }
                }
            }
        }
    }
}
