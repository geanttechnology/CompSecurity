// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            DisplayStateChangeListener

public class SuggestionTextView extends TextView
{

    private DisplayStateChangeListener displayStateChangeListener;

    public SuggestionTextView(Context context)
    {
        super(context);
    }

    public SuggestionTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SuggestionTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (displayStateChangeListener != null)
        {
            displayStateChangeListener.onShow();
        }
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (i != 0 && displayStateChangeListener != null)
        {
            displayStateChangeListener.onHide();
        }
    }

    public void setDisplayStateChangeListener(DisplayStateChangeListener displaystatechangelistener)
    {
        displayStateChangeListener = displaystatechangelistener;
    }
}
