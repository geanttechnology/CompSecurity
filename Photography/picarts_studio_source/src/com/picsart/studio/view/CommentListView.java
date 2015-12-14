// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;

// Referenced classes of package com.picsart.studio.view:
//            f

public class CommentListView extends ListView
{

    private float a;
    private f b;
    private float c;
    private boolean d;

    public CommentListView(Context context)
    {
        this(context, null);
    }

    public CommentListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = true;
        c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        getParent().requestDisallowInterceptTouchEvent(true);
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 32
    //                   0 38;
           goto _L1 _L2
_L1:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        a = motionevent.getY();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1;
        flag1 = false;
        if (motionevent.getPointerCount() > 1)
        {
            return true;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 40
    //                   1 94
    //                   2 46;
           goto _L1 _L2 _L3
_L1:
        return super.onTouchEvent(motionevent);
_L3:
        if (!b.a() || d && motionevent.getY() - a > c)
        {
            getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        boolean flag;
label0:
        {
            if (getChildAt(0) != null)
            {
                flag = flag1;
                if (getChildAt(0).getTop() != 0)
                {
                    break label0;
                }
                flag = flag1;
                if (getFirstVisiblePosition() != 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        d = flag;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setSliderActionListener(f f1)
    {
        b = f1;
    }
}
