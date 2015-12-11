// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class NoScrollScrollView extends ScrollView
{

    public NoScrollScrollView(Context context)
    {
        super(context);
    }

    public NoScrollScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public NoScrollScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return super.onTouchEvent(motionevent);

        case 0: // '\0'
            return false;
        }
    }
}
