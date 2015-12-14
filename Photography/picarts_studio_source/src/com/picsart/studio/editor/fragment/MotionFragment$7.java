// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.editor.view.MotionView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.widget.mSelectedListener
{

    private MotionFragment a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        MotionFragment.b(a, i);
        MotionFragment.c(a).invalidate();
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    _cls9(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
