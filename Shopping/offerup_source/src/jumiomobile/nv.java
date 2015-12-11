// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ObjectAnimator;

// Referenced classes of package jumiomobile:
//            nu

class nv
    implements Runnable
{

    final nu a;

    nv(nu nu1)
    {
        a = nu1;
        super();
    }

    public void run()
    {
        a.d.start();
    }
}
