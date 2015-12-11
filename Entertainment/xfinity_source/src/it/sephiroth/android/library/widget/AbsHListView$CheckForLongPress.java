// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

private class <init> extends <init>
    implements Runnable
{

    final AbsHListView this$0;

    public void run()
    {
label0:
        {
            int i = mMotionPosition;
            View view = getChildAt(i - mFirstPosition);
            if (view != null)
            {
                int j = mMotionPosition;
                long l = mAdapter.getItemId(mMotionPosition);
                boolean flag1 = false;
                boolean flag = flag1;
                if (sameWindow())
                {
                    flag = flag1;
                    if (!mDataChanged)
                    {
                        flag = performLongPress(view, j, l);
                    }
                }
                if (!flag)
                {
                    break label0;
                }
                mTouchMode = -1;
                setPressed(false);
                view.setPressed(false);
            }
            return;
        }
        mTouchMode = 2;
    }

    private ()
    {
        this$0 = AbsHListView.this;
        super(AbsHListView.this, null);
    }

    nit>(nit> nit>)
    {
        this();
    }
}
