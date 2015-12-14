// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.TextView;
import com.picsart.studio.editor.view.MotionView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a extends c
{

    private MotionFragment a;

    public final void a(FloatSeekBar floatseekbar)
    {
    }

    public final void a(FloatSeekBar floatseekbar, float f, boolean flag)
    {
        MotionFragment.a(a, (int)f);
        MotionFragment.b(a).setText(String.valueOf(MotionFragment.a(a)));
        com.picsart.studio.editor.fragment.MotionFragment.c(a).setMotionShadowsCount(MotionFragment.a(a));
        com.picsart.studio.editor.fragment.MotionFragment.c(a).invalidate();
    }

    _cls9(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
