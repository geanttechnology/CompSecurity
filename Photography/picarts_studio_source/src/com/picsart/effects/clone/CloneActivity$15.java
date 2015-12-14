// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ToggleButton;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity, CloneSurfaceView

final class a
    implements d
{

    private CloneActivity a;

    public final void a()
    {
        ToggleButton togglebutton;
        ToggleButton togglebutton1;
label0:
        {
            if (CloneActivity.b(a) != null && !CloneActivity.b(a).g)
            {
                CloneActivity.b(a).a(-1);
                togglebutton = (ToggleButton)a.findViewById(0x7f100139);
                togglebutton1 = (ToggleButton)a.findViewById(0x7f100138);
                if (!togglebutton.isChecked())
                {
                    break label0;
                }
                togglebutton.setChecked(false);
                togglebutton1.setChecked(true);
            }
            return;
        }
        togglebutton.setChecked(true);
        togglebutton1.setChecked(false);
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        return false;
    }

    (CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
