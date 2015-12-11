// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, TrackingDotsGraphic

class val.points
    implements Runnable
{

    final ViewItActivity this$0;
    final ArrayList val$points;

    public void run()
    {
        ViewItActivity.access$900(ViewItActivity.this).put(Integer.valueOf(2), new TrackingDotsGraphic(ViewItActivity.this, val$points));
        ViewItActivity.access$1000(ViewItActivity.this);
    }

    ic()
    {
        this$0 = final_viewitactivity;
        val$points = ArrayList.this;
        super();
    }
}
