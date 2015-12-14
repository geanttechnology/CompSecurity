// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.view.MotionEvent;
import android.view.View;

final class by
    implements android.view.TouchListener
{

    final View bx;
    final View by;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            bx.setSelected(true);
            return false;

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
            bx.setSelected(false);
            return false;

        case 2: // '\002'
            bx.setSelected(by.isPressed());
            break;
        }
        return false;
    }

    (View view, View view1)
    {
        bx = view;
        by = view1;
        super();
    }
}
