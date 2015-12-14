// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import cg;
import cj;

public class TintRadioButton extends RadioButton
{

    private static final int TINT_ATTRS[] = {
        0x1010107
    };
    private final cg mTintManager;

    public TintRadioButton(Context context)
    {
        this(context, null);
    }

    public TintRadioButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101007e);
    }

    public TintRadioButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = cj.a(context, attributeset, TINT_ATTRS, i, 0);
        setButtonDrawable(context.a(0));
        context.b();
        mTintManager = context.c();
    }

    public void setButtonDrawable(int i)
    {
        setButtonDrawable(mTintManager.a(i));
    }

}
