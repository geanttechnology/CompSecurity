// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            UgcTipsSection

private class tipText
    implements android.view.ner
{

    final UgcTipsSection this$0;
    private final TextView tipText;

    public void onClick(View view)
    {
        int i = 0x7fffffff;
        if (isExpanding())
        {
            return;
        }
        view = tipText;
        if (tipText.getMaxLines() == 0x7fffffff)
        {
            i = 4;
        }
        view.setMaxLines(i);
        tipText.getViewTreeObserver().addOnGlobalLayoutListener(new (UgcTipsSection.this, tipText, tipText.getHeight()));
    }

    public (TextView textview)
    {
        this$0 = UgcTipsSection.this;
        super();
        tipText = textview;
    }
}
