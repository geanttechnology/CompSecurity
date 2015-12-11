// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

final class this._cls0
    implements Runnable
{

    final AbsHListView this$0;

    public void run()
    {
label0:
        {
label1:
            {
                if (mTouchMode == 0)
                {
                    mTouchMode = 1;
                    View view = getChildAt(mMotionPosition - mFirstPosition);
                    if (view != null && !view.hasFocusable())
                    {
                        mLayoutMode = 0;
                        if (mDataChanged)
                        {
                            break label0;
                        }
                        view.setPressed(true);
                        setPressed(true);
                        layoutChildren();
                        positionSelector(mMotionPosition, view);
                        refreshDrawableState();
                        int i = ViewConfiguration.getLongPressTimeout();
                        boolean flag = isLongClickable();
                        if (mSelector != null)
                        {
                            Drawable drawable = mSelector.getCurrent();
                            if (drawable != null && (drawable instanceof TransitionDrawable))
                            {
                                if (flag)
                                {
                                    ((TransitionDrawable)drawable).startTransition(i);
                                } else
                                {
                                    ((TransitionDrawable)drawable).resetTransition();
                                }
                            }
                        }
                        if (!flag)
                        {
                            break label1;
                        }
                        if (AbsHListView.access$500(AbsHListView.this) == null)
                        {
                            AbsHListView.access$502(AbsHListView.this, new Press(AbsHListView.this, null));
                        }
                        AbsHListView.access$500(AbsHListView.this).rememberWindowAttachCount();
                        postDelayed(AbsHListView.access$500(AbsHListView.this), i);
                    }
                }
                return;
            }
            mTouchMode = 2;
            return;
        }
        mTouchMode = 2;
    }

    Press()
    {
        this$0 = AbsHListView.this;
        super();
    }
}
