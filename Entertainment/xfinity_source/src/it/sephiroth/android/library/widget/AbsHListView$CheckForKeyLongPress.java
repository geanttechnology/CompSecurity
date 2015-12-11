// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.View;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

private class <init> extends <init>
    implements Runnable
{

    final AbsHListView this$0;

    public void run()
    {
        if (isPressed() && mSelectedPosition >= 0)
        {
            int i = mSelectedPosition;
            int j = mFirstPosition;
            View view = getChildAt(i - j);
            if (!mDataChanged)
            {
                boolean flag = false;
                if (sameWindow())
                {
                    flag = performLongPress(view, mSelectedPosition, mSelectedColId);
                }
                if (flag)
                {
                    setPressed(false);
                    view.setPressed(false);
                }
            } else
            {
                setPressed(false);
                if (view != null)
                {
                    view.setPressed(false);
                    return;
                }
            }
        }
    }

    private ()
    {
        this$0 = AbsHListView.this;
        super(AbsHListView.this, null);
    }

    >(> >)
    {
        this();
    }
}
