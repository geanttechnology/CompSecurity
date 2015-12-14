// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            FTUEFragmentActivity

class this._cls0 extends VisibilityAnimator
{

    final FTUEFragmentActivity this$0;

    protected long getDuration()
    {
        return !FTUEFragmentActivity.access$000(FTUEFragmentActivity.this) ? 375L : 0L;
    }

    protected ObjectAnimator getHideAnimator()
    {
        float f1 = FTUEFragmentActivity.access$100(FTUEFragmentActivity.this).getHeight();
        float f = f1;
        if (f1 == 0.0F)
        {
            FTUEFragmentActivity.access$100(FTUEFragmentActivity.this).measure(0, 0);
            f = FTUEFragmentActivity.access$100(FTUEFragmentActivity.this).getMeasuredHeight();
        }
        View view = FTUEFragmentActivity.access$100(FTUEFragmentActivity.this);
        if (f != 0.0F)
        {
            f = -f;
        } else
        {
            f = -100F;
        }
        return ObjectAnimator.ofFloat(view, "translationY", new float[] {
            f
        });
    }

    protected volatile ValueAnimator getHideAnimator()
    {
        return getHideAnimator();
    }

    protected ObjectAnimator getShowAnimator()
    {
        FTUEFragmentActivity.access$200(FTUEFragmentActivity.this);
        return ObjectAnimator.ofFloat(FTUEFragmentActivity.access$100(FTUEFragmentActivity.this), "translationY", new float[] {
            0.0F
        });
    }

    protected volatile ValueAnimator getShowAnimator()
    {
        return getShowAnimator();
    }

    protected void onShown()
    {
        FTUEFragmentActivity.access$100(FTUEFragmentActivity.this).postDelayed(FTUEFragmentActivity.access$300(FTUEFragmentActivity.this), 5000L);
    }

    I()
    {
        this$0 = FTUEFragmentActivity.this;
        super();
    }
}
