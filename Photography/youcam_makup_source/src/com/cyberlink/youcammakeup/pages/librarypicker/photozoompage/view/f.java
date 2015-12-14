// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view:
//            a

public class f
{

    protected MotionEvent a;

    protected f(MotionEvent motionevent)
    {
        a = motionevent;
    }

    public static f a(MotionEvent motionevent)
    {
        a a1;
        try
        {
            a1 = new a(motionevent);
        }
        catch (VerifyError verifyerror)
        {
            return new f(motionevent);
        }
        return a1;
    }

    private void c(int i)
    {
        if (i > 0)
        {
            throw new IllegalArgumentException("Invalid pointer index for Donut/Cupcake");
        } else
        {
            return;
        }
    }

    public float a(int i)
    {
        c(i);
        return b();
    }

    public int a()
    {
        return a.getAction();
    }

    public float b()
    {
        return a.getX();
    }

    public float b(int i)
    {
        c(i);
        return c();
    }

    public float c()
    {
        return a.getY();
    }
}
