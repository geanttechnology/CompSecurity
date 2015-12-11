// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.design.widget:
//            aa, a, ag, ah, 
//            ao

class af extends aa
{

    private boolean g;

    af(View view, ao ao)
    {
        super(view, ao);
    }

    static boolean a(af af1, boolean flag)
    {
        af1.g = flag;
        return flag;
    }

    final void b()
    {
        if (g || e.getVisibility() != 0)
        {
            return;
        }
        if (!bi.B(e) || e.isInEditMode())
        {
            e.setVisibility(8);
            return;
        } else
        {
            e.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(a.a).setListener(new ag(this));
            return;
        }
    }

    final void c()
    {
label0:
        {
            if (e.getVisibility() != 0)
            {
                if (!bi.B(e) || e.isInEditMode())
                {
                    break label0;
                }
                e.setAlpha(0.0F);
                e.setScaleY(0.0F);
                e.setScaleX(0.0F);
                e.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(a.a).setListener(new ah(this));
            }
            return;
        }
        e.setVisibility(0);
        e.setAlpha(1.0F);
        e.setScaleY(1.0F);
        e.setScaleX(1.0F);
    }
}
