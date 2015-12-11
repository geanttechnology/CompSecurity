// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

public class PMHTMLTextView extends TextView
{

    public PMHTMLTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setText(Html.fromHtml(getText().toString()));
    }
}
