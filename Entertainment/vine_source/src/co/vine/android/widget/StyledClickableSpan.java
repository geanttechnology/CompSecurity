// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package co.vine.android.widget:
//            SpanClickListener

public class StyledClickableSpan extends ClickableSpan
{

    private int mColor;
    private final SpanClickListener mListener;
    private boolean mSelected;
    private boolean mSetColor;
    private final Object mTag;
    private final int mType;

    public StyledClickableSpan(int i, Object obj, SpanClickListener spanclicklistener)
    {
        mType = i;
        mTag = obj;
        mListener = spanclicklistener;
    }

    public boolean isSelected()
    {
        return mSelected;
    }

    public void onClick(View view)
    {
        if (mListener != null)
        {
            mListener.onSpanClicked(view, mType, mTag);
        }
    }

    public void select(boolean flag)
    {
        mSelected = flag;
    }

    public void setColor(int i)
    {
        mColor = i;
        mSetColor = true;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        if (mSetColor)
        {
            textpaint.setColor(mColor);
        }
        textpaint.setUnderlineText(false);
    }
}
