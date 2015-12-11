// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.support.v7.widget.d;
import android.util.AttributeSet;
import com.target.ui.util.ah;

public class TargetCheckBox extends d
{

    public TargetCheckBox(Context context)
    {
        super(context);
        a(context, null);
    }

    public TargetCheckBox(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public TargetCheckBox(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        setTypeface(ah.a(context, attributeset));
    }
}
