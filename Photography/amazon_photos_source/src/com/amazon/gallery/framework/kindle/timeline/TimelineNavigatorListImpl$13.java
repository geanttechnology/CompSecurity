// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.ListView;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class this._cls0 extends VisibilityAnimator
{

    final TimelineNavigatorListImpl this$0;

    protected long getDuration()
    {
        return 375L;
    }

    protected ObjectAnimator getHideAnimator()
    {
        int j = TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getWidth();
        int i = j;
        if (j == 0)
        {
            TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).measure(0, 0);
            i = TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getMeasuredWidth();
        }
        ListView listview = TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this);
        float f;
        if (i != 0)
        {
            f = i;
        } else
        {
            f = 100F;
        }
        return ObjectAnimator.ofFloat(listview, "translationX", new float[] {
            f
        });
    }

    protected volatile ValueAnimator getHideAnimator()
    {
        return getHideAnimator();
    }

    protected ObjectAnimator getShowAnimator()
    {
        return ObjectAnimator.ofFloat(TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this), "translationX", new float[] {
            0.0F
        });
    }

    protected volatile ValueAnimator getShowAnimator()
    {
        return getShowAnimator();
    }

    protected void onHidden()
    {
        super.onHidden();
        TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).setVisibility(8);
        if (TimelineNavigatorListImpl.access$700(TimelineNavigatorListImpl.this) != null)
        {
            TimelineNavigatorListImpl.access$700(TimelineNavigatorListImpl.this).stop();
            TimelineNavigatorListImpl.access$702(TimelineNavigatorListImpl.this, null);
        }
        switch (.SwitchMap.com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent[TimelineNavigatorListImpl.access$1600(TimelineNavigatorListImpl.this).ordinal()])
        {
        default:
            return;

        case 4: // '\004'
            TimelineNavigatorListImpl.access$800(TimelineNavigatorListImpl.this).trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineSwipeClose);
            return;

        case 5: // '\005'
            TimelineNavigatorListImpl.access$800(TimelineNavigatorListImpl.this).trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineTapClose);
            return;

        case 6: // '\006'
            TimelineNavigatorListImpl.access$800(TimelineNavigatorListImpl.this).trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.TimelineAutoClose);
            break;
        }
    }

    protected void onShown()
    {
        super.onShown();
        if (TimelineNavigatorListImpl.access$700(TimelineNavigatorListImpl.this) != null)
        {
            TimelineNavigatorListImpl.access$700(TimelineNavigatorListImpl.this).start();
        }
    }

    csEvent()
    {
        this$0 = TimelineNavigatorListImpl.this;
        super();
    }
}
