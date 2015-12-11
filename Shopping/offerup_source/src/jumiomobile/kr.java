// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            kp, hr, lm

class kr
    implements android.view.View.OnClickListener
{

    final kp a;

    kr(kp kp1)
    {
        a = kp1;
        super();
    }

    public void onClick(View view)
    {
        a.a.showFragment(hr.c);
    }
}
