// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.view:
//            UgcTipsSection

private class startingHeight
    implements android.view.ener
{

    private final int startingHeight;
    final UgcTipsSection this$0;
    private final View tipText;

    public void onGlobalLayout()
    {
        contentView.getLayoutParams().ener = contentView.getHeight() + (tipText.getHeight() - startingHeight);
        contentView.setLayoutParams(contentView.getLayoutParams());
        tipText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public (View view, int i)
    {
        this$0 = UgcTipsSection.this;
        super();
        tipText = view;
        startingHeight = i;
    }
}
