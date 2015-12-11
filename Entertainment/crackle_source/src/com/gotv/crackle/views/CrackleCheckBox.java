// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.gotv.crackle.Application;

public class CrackleCheckBox extends CheckBox
{

    public CrackleCheckBox(Context context)
    {
        super(context);
        setTypeface(Application.getInstance().getTypeFace());
    }

    public CrackleCheckBox(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(Application.getInstance().getTypeFace());
    }

    public CrackleCheckBox(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(Application.getInstance().getTypeFace());
    }
}
