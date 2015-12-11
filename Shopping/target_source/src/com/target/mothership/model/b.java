// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model;

import com.target.mothership.services.o;
import com.target.mothership.services.r;
import com.target.mothership.services.x;
import com.target.mothership.services.z;

// Referenced classes of package com.target.mothership.model:
//            d

public abstract class b
{

    private d mReceiver;
    private r mRetryPolicy;

    public b(d d1)
    {
        mReceiver = d1;
    }

    private boolean a(o o1, z z)
    {
        if (mRetryPolicy == null)
        {
            mRetryPolicy = mReceiver.b();
        }
        if (o1 != null && mRetryPolicy.a(o1, z))
        {
            o1.a();
            return true;
        } else
        {
            return false;
        }
    }

    protected abstract Object a(x x1);

    protected abstract Object a(Object obj);

    String a()
    {
        return mReceiver.a();
    }

    void a(x x1, o o1)
    {
        if (a(o1, x1.b()))
        {
            return;
        } else
        {
            x1 = ((x) (a(x1)));
            mReceiver.b(x1, o1);
            return;
        }
    }

    void a(Object obj, z z, o o1)
    {
        if (a(o1, z))
        {
            return;
        }
        if (!e(obj))
        {
            obj = c(obj);
            mReceiver.b(obj, o1);
            return;
        }
        obj = a(obj);
        if (d(obj))
        {
            mReceiver.a(obj, o1);
            return;
        } else
        {
            obj = b(obj);
            mReceiver.b(obj, o1);
            return;
        }
    }

    protected Object b(Object obj)
    {
        return null;
    }

    protected Object c(Object obj)
    {
        return null;
    }

    protected boolean d(Object obj)
    {
        return true;
    }

    protected boolean e(Object obj)
    {
        return true;
    }
}
