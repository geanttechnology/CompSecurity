// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.widget.ListView;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class this._cls0
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;

    public void run()
    {
        float f = TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getTranslationX();
        if (f > 0.0F && f <= (float)(TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getWidth() / 2) && !TimelineNavigatorListImpl.access$100(TimelineNavigatorListImpl.this))
        {
            TimelineNavigatorListImpl.access$000(TimelineNavigatorListImpl.this).cancel();
            showTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.ent.SWIPE_OPEN);
        } else
        if (f < (float)TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getWidth() && f > (float)(TimelineNavigatorListImpl.access$500(TimelineNavigatorListImpl.this).getWidth() / 2) && TimelineNavigatorListImpl.access$100(TimelineNavigatorListImpl.this))
        {
            TimelineNavigatorListImpl.access$000(TimelineNavigatorListImpl.this).cancel();
            hideTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.ent.SWIPE_CLOSE);
            return;
        }
    }

    vent()
    {
        this$0 = TimelineNavigatorListImpl.this;
        super();
    }
}
