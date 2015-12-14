// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import ib;

public class fontEditText extends EditText
{

    private ib mListener;

    public fontEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void setListener(ib ib)
    {
        mListener = ib;
    }
}
