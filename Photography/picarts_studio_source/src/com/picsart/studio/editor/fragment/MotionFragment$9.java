// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.view.ner
{

    private FrameLayout a;
    private MotionFragment b;

    public final void onClick(View view)
    {
        a.removeView(MotionFragment.j(b));
        MotionFragment.k(b);
    }

    _cls9(MotionFragment motionfragment, FrameLayout framelayout)
    {
        b = motionfragment;
        a = framelayout;
        super();
    }
}
