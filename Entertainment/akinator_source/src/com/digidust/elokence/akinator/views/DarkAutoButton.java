// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

public class DarkAutoButton extends Button
{

    public DarkAutoButton(Context context)
    {
        super(context);
    }

    public DarkAutoButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DarkAutoButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setBackground(Drawable drawable)
    {
    /* block-local class not found */
    class DarkAutoButtonBackgroundDrawable {}

        super.setBackground(new DarkAutoButtonBackgroundDrawable(drawable));
    }
}
