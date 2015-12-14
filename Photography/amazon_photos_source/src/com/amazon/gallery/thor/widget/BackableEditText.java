// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class BackableEditText extends EditText
{

    private Context mContext;

    public BackableEditText(Context context)
    {
        super(context);
        mContext = context;
    }

    public BackableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4 && (mContext instanceof Activity))
        {
            ((Activity)mContext).onBackPressed();
            return true;
        } else
        {
            return false;
        }
    }
}
