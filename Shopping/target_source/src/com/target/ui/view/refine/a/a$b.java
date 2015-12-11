// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine.a;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.refine.a:
//            a

private static class count
{

    final TextView count;
    int position;
    final RadioButton radioButton;
    final View rootContainer;

    public (View view)
    {
        position = -1;
        rootContainer = view.findViewById(0x7f100562);
        radioButton = (RadioButton)view.findViewById(0x7f100563);
        count = (TextView)view.findViewById(0x7f100564);
    }
}
