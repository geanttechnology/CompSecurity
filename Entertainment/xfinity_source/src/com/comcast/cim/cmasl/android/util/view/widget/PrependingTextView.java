// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.widget.TextView;

public class PrependingTextView extends TextView
{

    private CharSequence prependText;

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        if (charsequence != null && charsequence.length() > 0 && prependText != null && prependText.length() > 0)
        {
            super.setText((new StringBuilder()).append(prependText.toString()).append(" ").append(charsequence.toString().trim()).toString(), buffertype);
            return;
        } else
        {
            super.setText(charsequence, buffertype);
            return;
        }
    }
}
