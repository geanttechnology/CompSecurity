// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

public class FormField extends EditText
{

    private static final int STATE_EMPTY[] = {
        0x7f010136
    };
    private static final int STATE_VALID[] = {
        0x7f010135
    };
    private boolean valid;

    public FormField(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        valid = false;
    }

    private boolean isEmpty()
    {
        return TextUtils.isEmpty(getText());
    }

    public boolean isValid()
    {
        return valid;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 2);
        if (valid)
        {
            mergeDrawableStates(ai, STATE_VALID);
        }
        if (isEmpty())
        {
            mergeDrawableStates(ai, STATE_EMPTY);
        }
        return ai;
    }

    public void setError(CharSequence charsequence)
    {
        super.setError(charsequence);
        charsequence = getCompoundDrawables();
        android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f02007d);
        setCompoundDrawables(charsequence[0], charsequence[1], drawable, charsequence[3]);
    }

    public void setValid(boolean flag)
    {
        valid = flag;
        refreshDrawableState();
    }

}
