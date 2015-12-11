// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android.widget:
//            TypefacesTextView, SpanClickListener

public class StyledTextView extends TypefacesTextView
{

    boolean init;
    private SpanClickListener mListener;
    private String mOriginalText;

    public StyledTextView(Context context)
    {
        this(context, null);
    }

    public StyledTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StyledTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init = false;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    public void setSpanClickListener(SpanClickListener spanclicklistener)
    {
        mListener = spanclicklistener;
    }

    public void setStyledText(String s, StyleSpan astylespan[])
    {
        mOriginalText = s;
        setText(Util.getSpannedText(astylespan, s, '"'), android.widget.TextView.BufferType.SPANNABLE);
    }
}
