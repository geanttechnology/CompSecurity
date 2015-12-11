// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import com.jumio.netverify.sdk.core.ModelTemplate;

// Referenced classes of package jumiomobile:
//            kp, lm, hr, mf, 
//            ha

class kq
    implements android.view.View.OnClickListener
{

    final kp a;

    kq(kp kp1)
    {
        a = kp1;
        super();
    }

    public void onClick(View view)
    {
        if (a.a.getModel().w == -1)
        {
            a.a.showFragment(hr.c);
            return;
        } else
        {
            a.a.getController().a(view, mf.j, a, a.a.isScanViewNext(hr.d));
            return;
        }
    }
}
