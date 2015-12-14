// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.view..OnClickListener
{

    private android.animation.ator.AnimatorListener a;
    private s b;

    public final void onClick(View view)
    {
        int i = s.a(b).getVisibility();
        if (i == 8 || i == 4)
        {
            s.a(b).setScaleX(0.0F);
            s.a(b).setScaleY(0.0F);
            s.a(b).setVisibility(0);
            s.a(b).setPivotX(((float)s.a(b).getWidth() * 3F) / 4F);
            s.a(b).setPivotY(0.0F);
            s.a(b).animate().setListener(null).setDuration(200L).scaleX(1.0F).scaleY(1.0F).start();
            return;
        } else
        {
            s.a(b).setScaleX(1.0F);
            s.a(b).setScaleY(1.0F);
            s.a(b).setPivotX(((float)s.a(b).getWidth() * 3F) / 4F);
            s.a(b).setPivotY(0.0F);
            s.a(b).animate().setListener(a).setDuration(200L).scaleX(0.0F).scaleY(0.0F).start();
            return;
        }
    }

    (s s1, android.animation.ator.AnimatorListener animatorlistener)
    {
        b = s1;
        a = animatorlistener;
        super();
    }
}
