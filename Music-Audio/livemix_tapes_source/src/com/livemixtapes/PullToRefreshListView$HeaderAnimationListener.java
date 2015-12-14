// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.animation.Animation;
import android.widget.LinearLayout;

// Referenced classes of package com.livemixtapes:
//            PullToRefreshListView

private class translation
    implements android.view.animation.ation
{

    private int height;
    private led stateAtAnimationStart;
    final PullToRefreshListView this$0;
    private int translation;

    public void onAnimationEnd(Animation animation)
    {
        animation = PullToRefreshListView.this;
        int i;
        if (stateAtAnimationStart == stateAtAnimationStart)
        {
            i = 0;
        } else
        {
            i = -PullToRefreshListView.access$2() - PullToRefreshListView.access$3(PullToRefreshListView.this).getTop();
        }
        PullToRefreshListView.access$4(animation, i);
        setSelection(0);
        animation = getLayoutParams();
        animation._fld0 = height;
        setLayoutParams(animation);
        if (PullToRefreshListView.access$1(PullToRefreshListView.this))
        {
            setVerticalScrollBarEnabled(true);
        }
        if (PullToRefreshListView.access$5(PullToRefreshListView.this))
        {
            PullToRefreshListView.access$6(PullToRefreshListView.this, false);
            postDelayed(new Runnable() {

                final PullToRefreshListView.HeaderAnimationListener this$1;

                public void run()
                {
                    PullToRefreshListView.access$7(this$0);
                }

            
            {
                this$1 = PullToRefreshListView.HeaderAnimationListener.this;
                super();
            }
            }, 100L);
        } else
        if (stateAtAnimationStart != stateAtAnimationStart)
        {
            PullToRefreshListView.access$8(PullToRefreshListView.this, this._fld0);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        stateAtAnimationStart = PullToRefreshListView.access$0(PullToRefreshListView.this);
        animation = getLayoutParams();
        height = ((android.view.ner.height) (animation)).height;
        animation.height = getHeight() - translation;
        setLayoutParams(animation);
        if (PullToRefreshListView.access$1(PullToRefreshListView.this))
        {
            setVerticalScrollBarEnabled(false);
        }
    }


    public _cls1.this._cls1(int i)
    {
        this$0 = PullToRefreshListView.this;
        super();
        translation = i;
    }
}
