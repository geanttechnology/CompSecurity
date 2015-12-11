// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.d;

import com.google.api.a.d.n;
import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.d.w;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.c.d:
//            b

class c
    implements n, w
{

    static final Logger a = Logger.getLogger(com/google/api/a/c/d/c.getName());
    private final b b;
    private final n c;
    private final w d;

    public c(b b1, p p1)
    {
        b = (b)com.google.api.a.f.a.a.a.a.c.a(b1);
        c = p1.k;
        d = p1.j;
        p1.k = this;
        p1.j = this;
    }

    public final boolean a(p p1, s s1, boolean flag)
    {
        boolean flag1;
        if (d != null && d.a(p1, s1, flag))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && flag && s1.c / 100 == 5)
        {
            try
            {
                b.a();
            }
            // Misplaced declaration of an exception variable
            catch (p p1)
            {
                a.log(Level.WARNING, "exception thrown while calling server callback", p1);
                return flag1;
            }
        }
        return flag1;
    }

    public final boolean a(p p1, boolean flag)
    {
        if (c != null && c.a(p1, flag))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            try
            {
                b.a();
            }
            // Misplaced declaration of an exception variable
            catch (p p1)
            {
                a.log(Level.WARNING, "exception thrown while calling server callback", p1);
                return flag;
            }
        }
        return flag;
    }

}
