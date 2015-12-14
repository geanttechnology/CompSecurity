// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class this._cls0
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;

    public void run()
    {
        TimelineNavigatorListImpl.access$000(TimelineNavigatorListImpl.this).hide();
        TimelineNavigatorListImpl.access$102(TimelineNavigatorListImpl.this, false);
    }

    ()
    {
        this$0 = TimelineNavigatorListImpl.this;
        super();
    }
}
