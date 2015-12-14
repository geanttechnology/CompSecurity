// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.ProgressBar;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.view.ner
{

    private MotionFragment a;

    public final void onClick(View view)
    {
        if (!MotionFragment.e(a))
        {
            MotionFragment.f(a);
            MotionFragment.g(a).setVisibility(0);
            MotionFragment.h(a);
        }
    }

    _cls9(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
