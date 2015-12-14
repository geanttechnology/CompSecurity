// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.view.View;
import android.widget.ToggleButton;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class a
    implements Runnable
{

    private boolean a;
    private CloneActivity b;

    public final void run()
    {
        b.findViewById(0x7f10012f).setEnabled(a);
        ToggleButton togglebutton = (ToggleButton)b.findViewById(0x7f100139);
        ToggleButton togglebutton1 = (ToggleButton)b.findViewById(0x7f100138);
        togglebutton.setEnabled(true);
        togglebutton1.setEnabled(true);
        b.findViewById(0x7f100130).setBackgroundResource(0x7f0205a1);
        b.findViewById(0x7f100131).setBackgroundResource(0x7f02068f);
    }

    (CloneActivity cloneactivity, boolean flag)
    {
        b = cloneactivity;
        a = true;
        super();
    }
}
