// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.ui.UIUtils;

public class NowSlidingPaneLayout extends SlidingPaneLayout
{

    private static final String TAG = com/amazon/now/nav/NowSlidingPaneLayout.getSimpleName();
    private boolean mDraggingOpen;
    private boolean mPaneOpen;

    public NowSlidingPaneLayout(Context context)
    {
        super(context);
        mDraggingOpen = false;
        mPaneOpen = false;
        init();
    }

    public NowSlidingPaneLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mDraggingOpen = false;
        mPaneOpen = false;
        init();
    }

    public NowSlidingPaneLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDraggingOpen = false;
        mPaneOpen = false;
        init();
    }

    private void init()
    {
        setPanelSlideListener(new android.support.v4.widget.SlidingPaneLayout.PanelSlideListener() {

            final NowSlidingPaneLayout this$0;

            public void onPanelClosed(View view)
            {
                if (!mPaneOpen)
                {
                    return;
                } else
                {
                    mPaneOpen = false;
                    return;
                }
            }

            public void onPanelOpened(View view)
            {
                UIUtils.closeSoftKeyboard(view);
            }

            public void onPanelSlide(View view, float f)
            {
                if (mPaneOpen)
                {
                    return;
                } else
                {
                    mPaneOpen = true;
                    return;
                }
            }

            
            {
                this$0 = NowSlidingPaneLayout.this;
                super();
            }
        });
    }

    private static boolean withinView(MotionEvent motionevent, View view)
    {
        boolean flag = true;
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = ai[1];
        int k = view.getWidth();
        int l = view.getHeight();
        if (motionevent.getX() < (float)i || motionevent.getX() > (float)(i + k) || motionevent.getY() < (float)j || motionevent.getY() > (float)(j + l))
        {
            flag = false;
        }
        return flag;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (!mDraggingOpen && !isOpen() && motionevent.getActionMasked() == 0 && motionevent.getX() < 20F)
        {
            mDraggingOpen = true;
        }
        if (isOpen())
        {
            if (withinView(motionevent, (ViewGroup)findViewById(0x7f0e006d)))
            {
                try
                {
                    flag = super.onInterceptTouchEvent(motionevent);
                }
                // Misplaced declaration of an exception variable
                catch (MotionEvent motionevent)
                {
                    Log.e(TAG, motionevent.toString(), motionevent);
                    return true;
                }
            }
            return flag;
        } else
        {
            return mDraggingOpen;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!mDraggingOpen || motionevent.getAction() != 1 && motionevent.getAction() != 3) goto _L2; else goto _L1
_L1:
        mDraggingOpen = false;
_L4:
        boolean flag;
        try
        {
            flag = super.onTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            Log.e(TAG, motionevent.toString(), motionevent);
            return true;
        }
        return flag;
_L2:
        if (!isOpen())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!withinView(motionevent, (ViewGroup)findViewById(0x7f0e006d)))
        {
            closePane();
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mDraggingOpen || motionevent.getAction() != 2) goto _L4; else goto _L5
_L5:
        return false;
    }




/*
    static boolean access$002(NowSlidingPaneLayout nowslidingpanelayout, boolean flag)
    {
        nowslidingpanelayout.mPaneOpen = flag;
        return flag;
    }

*/
}
