// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.a.g;
import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.d;
import com.target.mothership.services.x;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTCompletedSignUp

public class i extends b
{

    private String mAppAccessKey;
    private c mErrorCode;

    public i(String s, d d)
    {
        super(d);
        mAppAccessKey = s;
    }

    protected CompletedSignUp a(com.target.mothership.services.b.a.b.i j)
    {
        if (o.g(mAppAccessKey))
        {
            com.target.mothership.cache.b.getInstance().updateAppAccessKey(mAppAccessKey);
        }
        return new TGTCompletedSignUp();
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.b.a.b.i)obj);
    }

    protected com.target.mothership.model.coupons.interfaces.a.b b(x x)
    {
        return (new g()).a(x);
    }

    protected boolean b(com.target.mothership.services.b.a.b.i j)
    {
        String s1 = "";
        String s = s1;
        if (j != null)
        {
            s = s1;
            if (j.a())
            {
                s = j.b();
            }
        }
        j = new l(s);
        if (j.a())
        {
            mErrorCode = j.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.b c(com.target.mothership.services.b.a.b.i j)
    {
        return (new g()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.b.a.b.i)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.b.a.b.i)obj);
    }
}
