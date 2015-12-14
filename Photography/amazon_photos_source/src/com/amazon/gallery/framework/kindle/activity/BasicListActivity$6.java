// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity

class this._cls0 extends VisibilityAnimator
{

    final BasicListActivity this$0;

    protected long getDuration()
    {
        return !BasicListActivity.access$100(BasicListActivity.this) ? 375L : 0L;
    }

    protected ObjectAnimator getHideAnimator()
    {
        int j = BasicListActivity.access$200(BasicListActivity.this).getHeight();
        int i = j;
        if (j == 0)
        {
            BasicListActivity.access$200(BasicListActivity.this).measure(0, 0);
            i = BasicListActivity.access$200(BasicListActivity.this).getMeasuredHeight();
        }
        View view = BasicListActivity.access$200(BasicListActivity.this);
        float f;
        if (i != 0)
        {
            f = -i;
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
        return ObjectAnimator.ofFloat(BasicListActivity.access$200(BasicListActivity.this), "translationY", new float[] {
            0.0F
        });
    }

    protected volatile ValueAnimator getShowAnimator()
    {
        return getShowAnimator();
    }

    protected void onHidden()
    {
    }

    ()
    {
        this$0 = BasicListActivity.this;
        super();
    }
}
