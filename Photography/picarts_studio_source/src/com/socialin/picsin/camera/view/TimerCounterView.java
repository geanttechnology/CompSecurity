// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TimerCounterView extends TextView
{

    public TimerCounterView(Context context)
    {
        super(context);
        a();
    }

    public TimerCounterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        setBackgroundResource(0x7f0200ee);
        setTextSize(40F);
        setPaintFlags(33);
        setGravity(17);
        setTextColor(0xffc5c3c3);
    }
}
