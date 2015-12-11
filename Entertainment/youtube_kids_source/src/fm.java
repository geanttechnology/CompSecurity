// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.AnimationUtils;

final class fm
    implements Runnable
{

    private fk a;

    fm(fk fk1)
    {
        a = fk1;
        super();
    }

    public final void run()
    {
        if (!fk.a(a))
        {
            return;
        }
        if (fk.b(a))
        {
            fk.a(a, false);
            fl fl1 = fk.c(a);
            fl1.e = AnimationUtils.currentAnimationTimeMillis();
            fl1.i = -1L;
            fl1.f = fl1.e;
            fl1.j = 0.5F;
            fl1.g = 0;
            fl1.h = 0;
        }
        fl fl2 = fk.c(a);
        boolean flag;
        if (fl2.i > 0L && AnimationUtils.currentAnimationTimeMillis() > fl2.i + (long)fl2.k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || !fk.d(a))
        {
            fk.b(a, false);
            return;
        }
        if (fk.e(a))
        {
            fk.c(a, false);
            fk.f(a);
        }
        if (fl2.f == 0L)
        {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        } else
        {
            long l = AnimationUtils.currentAnimationTimeMillis();
            float f = fl2.a(l);
            f = f * 4F + -4F * f * f;
            long l1 = l - fl2.f;
            fl2.f = l;
            fl2.g = (int)((float)l1 * f * fl2.c);
            fl2.h = (int)((float)l1 * f * fl2.d);
            int i = fl2.g;
            i = fl2.h;
            a.a(i);
            dz.a(fk.g(a), this);
            return;
        }
    }
}
