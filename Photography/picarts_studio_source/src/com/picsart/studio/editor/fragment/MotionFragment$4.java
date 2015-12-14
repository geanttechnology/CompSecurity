// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.picsart.studio.editor.view.MotionView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.widget.kedChangeListener
{

    private MotionFragment a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (i != 0x7f1005d5 || !((RadioButton)radiogroup.findViewById(0x7f1005d5)).isChecked()) goto _L2; else goto _L1
_L1:
        MotionFragment.c(a).setMotionDrawType(0);
_L4:
        MotionFragment.c(a).invalidate();
        return;
_L2:
        if (i == 0x7f1005d6)
        {
            MotionFragment.c(a).setMotionDrawType(1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls9(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
