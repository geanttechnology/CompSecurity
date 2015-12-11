// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.google.b.p;
import com.target.a.a.b;
import com.target.mothership.util.a;

// Referenced classes of package com.target.mothership.services:
//            a, o, aa, v, 
//            w, x

public class f extends com.target.mothership.services.a
{

    public static final String TAG = com/target/mothership/services/f.getSimpleName();

    public f(w w1, aa aa1)
    {
        super(w1, aa1);
        if (aa1 == null)
        {
            throw new IllegalArgumentException("Transformer may not be null");
        } else
        {
            return;
        }
    }

    public void a(v v1, boolean flag, com.target.mothership.services.f.a.b.b b1)
    {
label0:
        {
            if (a() != null && b() != null)
            {
                if (b1 == null)
                {
                    b1 = null;
                } else
                {
                    b1 = new o(b1, this);
                }
                if (!flag)
                {
                    break label0;
                }
                com.target.mothership.util.a.a(v1, b(), a(), b1);
            }
            return;
        }
        Object obj;
        try
        {
            obj = b().a(v1);
        }
        catch (p p1)
        {
            b.a(TAG, "Exception while parsing response", p1);
            a().onError(com.target.mothership.util.f.a(v1), b1);
            return;
        }
        a().onResult(obj, v1.b(), b1);
    }

    public void a(x x, com.target.mothership.services.f.a.b.b b1)
    {
        w w1;
        if (b1 == null)
        {
            b1 = null;
        } else
        {
            b1 = new o(b1, this);
        }
        w1 = a();
        if (w1 != null)
        {
            w1.onError(x, b1);
        }
    }

}
