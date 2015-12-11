// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

final class this._cls0
    implements Runnable
{

    final HorizontalListView this$0;

    public void run()
    {
        if (HorizontalListView.access$000(HorizontalListView.this) == 0)
        {
            HorizontalListView.access$002(HorizontalListView.this, 1);
            View view = getChildAt(HorizontalListView.access$200(HorizontalListView.this) - HorizontalListView.access$800(HorizontalListView.this));
            if (view != null && !view.hasFocusable())
            {
                if (!HorizontalListView.access$100(HorizontalListView.this))
                {
                    view.setPressed(true);
                    setPressed(true);
                    layoutChildren();
                    refreshDrawableState();
                    boolean flag = isLongClickable();
                    if (HorizontalListView.access$900(HorizontalListView.this) != null)
                    {
                        Drawable drawable = HorizontalListView.access$900(HorizontalListView.this).getCurrent();
                        if (drawable != null && (drawable instanceof TransitionDrawable))
                        {
                            if (flag)
                            {
                                ((TransitionDrawable)drawable).startTransition(HorizontalListView.access$1000(HorizontalListView.this));
                            } else
                            {
                                ((TransitionDrawable)drawable).resetTransition();
                            }
                        }
                    }
                    if (flag)
                    {
                        if (HorizontalListView.access$1100(HorizontalListView.this) == null)
                        {
                            HorizontalListView.access$1102(HorizontalListView.this, new Press(HorizontalListView.this, null));
                        }
                        HorizontalListView.access$1100(HorizontalListView.this).rememberWindowAttachCount();
                        postDelayed(HorizontalListView.access$1100(HorizontalListView.this), HorizontalListView.access$1000(HorizontalListView.this));
                    } else
                    {
                        HorizontalListView.access$002(HorizontalListView.this, 2);
                    }
                    if (HorizontalListView.access$900(HorizontalListView.this) != null)
                    {
                        drawable = HorizontalListView.access$900(HorizontalListView.this).getCurrent();
                        if (drawable != null && (drawable instanceof TransitionDrawable))
                        {
                            ((TransitionDrawable)drawable).resetTransition();
                        }
                    }
                }
                HorizontalListView.access$002(HorizontalListView.this, 2);
            }
        }
    }

    Press()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
