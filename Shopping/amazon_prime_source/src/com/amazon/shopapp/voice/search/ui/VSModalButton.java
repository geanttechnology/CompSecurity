// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class VSModalButton extends Button
{

    public VSModalButton(Context context)
    {
        super(context);
        init();
    }

    public VSModalButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public VSModalButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        setClickable(true);
    }
}
