// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.ViewPropertyAnimator;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.picsart.effectnew.e;
import com.picsart.studio.editor.custommasks.MaskStateHolder;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.widget.oGroup.OnCheckedChangeListener
{

    private android.animation.ator.AnimatorListener a;
    private s b;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (i == 0x7f1006f9)
        {
            s.q(b).h = false;
            s.f(b).c = false;
        } else
        {
            s.q(b).h = true;
            s.f(b).c = true;
            if (s.a(b).getVisibility() == 0)
            {
                s.a(b).setScaleX(1.0F);
                s.a(b).setScaleY(1.0F);
                s.a(b).setPivotX(((float)s.a(b).getWidth() * 3F) / 4F);
                s.a(b).setPivotY(0.0F);
                s.a(b).animate().setListener(a).setDuration(200L).scaleX(0.0F).scaleY(0.0F).start();
                return;
            }
        }
    }

    (s s1, android.animation.ator.AnimatorListener animatorlistener)
    {
        b = s1;
        a = animatorlistener;
        super();
    }
}
