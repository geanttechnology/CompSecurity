// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class CustomLinkMovementMethod extends ScrollingMovementMethod
{
    public static interface TextClickedListener
    {

        public abstract void onTextClicked(int i, int j);
    }


    private static final int CLICK = 1;
    private static final int DOWN = 3;
    private static Object FROM_BELOW = new android.text.NoCopySpan.Concrete();
    private static final int UP = 2;
    private static CustomLinkMovementMethod sInstance;
    TextClickedListener listener;
    private boolean tappedOnNonLinkText;

    public CustomLinkMovementMethod()
    {
        tappedOnNonLinkText = false;
        listener = null;
    }

    private boolean action(int i, TextView textview, Spannable spannable)
    {
        ClickableSpan aclickablespan[];
        int j;
        int i1;
        Layout layout = textview.getLayout();
        int k = textview.getTotalPaddingTop();
        i1 = textview.getTotalPaddingBottom();
        int j1 = textview.getScrollY();
        int l1 = textview.getHeight();
        j = layout.getLineForVertical(j1);
        k = layout.getLineForVertical((l1 + j1) - (k + i1));
        l1 = layout.getLineStart(j);
        int j2 = layout.getLineEnd(k);
        aclickablespan = (ClickableSpan[])spannable.getSpans(l1, j2, android/text/style/ClickableSpan);
        j = Selection.getSelectionStart(spannable);
        k = Selection.getSelectionEnd(spannable);
        i1 = Math.min(j, k);
        j1 = Math.max(j, k);
        k = j1;
        j = i1;
        if (i1 < 0)
        {
            k = j1;
            j = i1;
            if (spannable.getSpanStart(FROM_BELOW) >= 0)
            {
                k = spannable.length();
                j = k;
            }
        }
        i1 = j;
        if (j > j2)
        {
            k = 0x7fffffff;
            i1 = 0x7fffffff;
        }
        j = k;
        if (k < l1)
        {
            j = -1;
            i1 = -1;
        }
        i;
        JVM INSTR tableswitch 1 3: default 232
    //                   1 234
    //                   2 277
    //                   3 387;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        if (i1 == j)
        {
            return false;
        }
        spannable = (ClickableSpan[])spannable.getSpans(i1, j, android/text/style/ClickableSpan);
        if (spannable.length != 1)
        {
            return false;
        }
        spannable[0].onClick(textview);
        continue; /* Loop/switch isn't completed */
_L3:
        int l;
        int i2;
        l = -1;
        i2 = -1;
        i = 0;
_L10:
        if (i >= aclickablespan.length) goto _L6; else goto _L5
_L5:
        int l2 = spannable.getSpanEnd(aclickablespan[i]);
        if (l2 < j) goto _L8; else goto _L7
_L7:
        int k1;
        int k2;
        k2 = i2;
        k1 = l;
        if (i1 != j) goto _L9; else goto _L8
_L8:
        k2 = i2;
        k1 = l;
        if (l2 > i2)
        {
            k1 = spannable.getSpanStart(aclickablespan[i]);
            k2 = l2;
        }
_L9:
        i++;
        i2 = k2;
        l = k1;
          goto _L10
_L6:
        if (l >= 0)
        {
            Selection.setSelection(spannable, i2, l);
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        l = 0x7fffffff;
        i2 = 0x7fffffff;
        i = 0;
_L16:
        if (i >= aclickablespan.length) goto _L12; else goto _L11
_L11:
        l2 = spannable.getSpanStart(aclickablespan[i]);
        if (l2 > i1) goto _L14; else goto _L13
_L13:
        k2 = i2;
        k1 = l;
        if (i1 != j) goto _L15; else goto _L14
_L14:
        k2 = i2;
        k1 = l;
        if (l2 < l)
        {
            k1 = l2;
            k2 = spannable.getSpanEnd(aclickablespan[i]);
        }
_L15:
        i++;
        i2 = k2;
        l = k1;
          goto _L16
_L12:
        if (i2 < 0x7fffffff)
        {
            Selection.setSelection(spannable, l, i2);
            return true;
        }
        if (true) goto _L1; else goto _L17
_L17:
    }

    public static MovementMethod getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new CustomLinkMovementMethod();
        }
        return sInstance;
    }

    public boolean didUserTapOnNonLinkSpan()
    {
        return tappedOnNonLinkText;
    }

    protected boolean down(TextView textview, Spannable spannable)
    {
        if (action(3, textview, spannable))
        {
            return true;
        } else
        {
            return super.down(textview, spannable);
        }
    }

    public void initialize(TextView textview, Spannable spannable)
    {
        Selection.removeSelection(spannable);
        spannable.removeSpan(FROM_BELOW);
    }

    protected boolean left(TextView textview, Spannable spannable)
    {
        if (action(2, textview, spannable))
        {
            return true;
        } else
        {
            return super.left(textview, spannable);
        }
    }

    public boolean onKeyDown(TextView textview, Spannable spannable, int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 38
    //                   66: 38;
           goto _L1 _L2 _L2
_L1:
        return super.onKeyDown(textview, spannable, i, keyevent);
_L2:
        if (keyevent.getRepeatCount() == 0 && action(1, textview, spannable))
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyUp(TextView textview, Spannable spannable, int i, KeyEvent keyevent)
    {
        return false;
    }

    public void onTakeFocus(TextView textview, Spannable spannable, int i)
    {
        Selection.removeSelection(spannable);
        if ((i & 1) != 0)
        {
            spannable.setSpan(FROM_BELOW, 0, 0, 34);
            return;
        } else
        {
            spannable.removeSpan(FROM_BELOW);
            return;
        }
    }

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent)
    {
        int i;
        boolean flag;
        flag = false;
        i = motionevent.getAction();
        if (i == 0)
        {
            tappedOnNonLinkText = false;
        }
        if (i != 1 && i != 0) goto _L2; else goto _L1
_L1:
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        int l = textview.getTotalPaddingLeft();
        int i1 = textview.getTotalPaddingTop();
        int j1 = textview.getScrollX();
        int k1 = textview.getScrollY();
        motionevent = textview.getLayout();
        j = motionevent.getOffsetForHorizontal(motionevent.getLineForVertical((k - i1) + k1), (j - l) + j1);
        motionevent = (ClickableSpan[])spannable.getSpans(j, j, android/text/style/ClickableSpan);
        if (motionevent.length == 0) goto _L4; else goto _L3
_L3:
        if (i != 1) goto _L6; else goto _L5
_L5:
        motionevent[0].onClick(textview);
_L7:
        flag = true;
_L2:
        return flag;
_L6:
        if (i == 0)
        {
            Selection.setSelection(spannable, spannable.getSpanStart(motionevent[0]), spannable.getSpanEnd(motionevent[0]));
        }
        if (true) goto _L7; else goto _L4
_L4:
        Selection.removeSelection(spannable);
        tappedOnNonLinkText = true;
        return false;
    }

    protected boolean right(TextView textview, Spannable spannable)
    {
        if (action(3, textview, spannable))
        {
            return true;
        } else
        {
            return super.right(textview, spannable);
        }
    }

    public void setOnTextClickListener(TextClickedListener textclickedlistener)
    {
        listener = textclickedlistener;
    }

    protected boolean up(TextView textview, Spannable spannable)
    {
        if (action(2, textview, spannable))
        {
            return true;
        } else
        {
            return super.up(textview, spannable);
        }
    }

}
