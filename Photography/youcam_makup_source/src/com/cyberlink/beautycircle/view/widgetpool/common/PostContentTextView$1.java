// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            PostContentTextView

final class  extends LinkMovementMethod
{

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent)
    {
        ClickableSpan aclickablespan[];
        int i;
        if (textview == null || !(textview instanceof PostContentTextView))
        {
            return false;
        }
        textview = (PostContentTextView)textview;
        i = motionevent.getAction();
        if (i != 1 && i != 0)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        int l = textview.getTotalPaddingLeft();
        int i1 = textview.getTotalPaddingTop();
        int j1 = textview.getScrollX();
        int k1 = textview.getScrollY();
        Layout layout = textview.getLayout();
        j = layout.getOffsetForHorizontal(layout.getLineForVertical((k - i1) + k1), (j - l) + j1);
        aclickablespan = (ClickableSpan[])spannable.getSpans(j, j, android/text/style/ClickableSpan);
        if (aclickablespan.length == 0) goto _L2; else goto _L1
_L1:
        PostContentTextView.a(textview, true);
        if (i != 1 || ((URLSpan)aclickablespan[0]).getURL() == null) goto _L4; else goto _L3
_L3:
        if ((aclickablespan[0] instanceof URLSpan) && !textview.a(Uri.parse(((URLSpan)aclickablespan[0]).getURL())))
        {
            try
            {
                aclickablespan[0].onClick(textview);
            }
            // Misplaced declaration of an exception variable
            catch (TextView textview)
            {
                e.b(new Object[] {
                    textview
                });
            }
        }
_L5:
        return true;
_L4:
        if (i == 0)
        {
            Selection.setSelection(spannable, spannable.getSpanStart(aclickablespan[0]), spannable.getSpanEnd(aclickablespan[0]));
        }
        if (true) goto _L5; else goto _L2
_L2:
        PostContentTextView.a(textview, false);
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textview, spannable, motionevent);
        return false;
        return Touch.onTouchEvent(textview, spannable, motionevent);
    }

    ()
    {
    }
}
