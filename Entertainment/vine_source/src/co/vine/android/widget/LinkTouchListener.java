// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package co.vine.android.widget:
//            StyledClickableSpan

public class LinkTouchListener
    implements android.view.View.OnTouchListener
{

    private final Rect mContentRect;
    private int mLastUrlDownX;
    private int mLastUrlDownY;
    private final Layout mLayout;
    private StyledClickableSpan mSpan;
    private Spannable mSpannable;
    private TextView mTextView;
    private final int mTouchSlop;

    public LinkTouchListener(TextView textview, int i, Spannable spannable)
    {
        Log.v("s", (new StringBuilder()).append("rectangle is ").append(textview.getLeft()).append(" | ").append(textview.getTop()).append(" | ").append(textview.getRight()).append(" | ").append(textview.getBottom()).toString());
        mContentRect = new Rect(textview.getLeft(), textview.getTop(), textview.getRight(), textview.getBottom());
        mLayout = textview.getLayout();
        mTextView = textview;
        mTouchSlop = i;
        mSpannable = spannable;
    }

    private void deselectSpan()
    {
        if (mSpan != null && mSpan.isSelected())
        {
            Log.v("s", "deselecting span");
            mSpan.select(false);
            mLastUrlDownX = 0;
            mLastUrlDownY = 0;
            mTextView.invalidate();
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getAction() & 0xff;
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        Log.v("s", (new StringBuilder()).append("on touch, action: ").append(i).append(" |x: ").append(j).append(" |y: ").append(k).toString());
        Log.v("s", (new StringBuilder()).append("on touch, view:  |left: ").append(view.getLeft()).append(" |right: ").append(view.getRight()).toString());
        view = mContentRect;
        motionevent = mLayout;
        int l = ((Rect) (view)).left + j;
        int i1 = ((Rect) (view)).top + k;
        int j1 = motionevent.getLineForVertical(i1);
        Log.v("s", (new StringBuilder()).append("translated x: ").append(l).append(" | ").append(i1).toString());
        if (l > (int)motionevent.getLineMax(j1))
        {
            deselectSpan();
            return false;
        }
        if (i == 0)
        {
            mLastUrlDownX = j;
            mLastUrlDownY = k;
        }
        j1 = motionevent.getOffsetForHorizontal(j1, l);
        motionevent = (StyledClickableSpan[])mSpannable.getSpans(j1, j1, co/vine/android/widget/StyledClickableSpan);
        Log.v("s", (new StringBuilder()).append("size is ").append(motionevent.length).toString());
        StyledClickableSpan styledclickablespan = mSpan;
        TextView textview = mTextView;
        Log.v("s", (new StringBuilder()).append("contains?").append(view.contains(l, i1)).toString());
        if (view.contains(l, i1) && (i == 1 || i == 0))
        {
            if (i == 1)
            {
                if (styledclickablespan != null)
                {
                    styledclickablespan.onClick(textview);
                    deselectSpan();
                }
            } else
            {
                Log.v("s", "selecting span");
                styledclickablespan.select(true);
                mSpan = motionevent[0];
                textview.invalidate();
            }
            return true;
        }
        if (styledclickablespan != null && (Math.abs(j - mLastUrlDownX) > mTouchSlop || Math.abs(k - mLastUrlDownY) > mTouchSlop))
        {
            Log.v("s", "deselecting due to slop");
            deselectSpan();
        }
        return false;
    }
}
