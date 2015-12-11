// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.transition.TransitionInflater;
import android.view.Window;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.groupon.activity.transition:
//            AbstractDetailsTransitionController

class this._cls0 extends SharedElementCallback
{

    final AbstractDetailsTransitionController this$0;

    public void onMapSharedElements(List list, Map map)
    {
        if (isReturning)
        {
            map.put("bottom_bar_transition", getViewByViewId(0x7f1000a0));
        }
        super.onMapSharedElements(list, map);
    }

    public void onSharedElementEnd(List list, List list1, List list2)
    {
        super.onSharedElementEnd(list, list1, list2);
    }

    public void onSharedElementStart(List list, List list1, List list2)
    {
        if (!isReturning)
        {
            list = TransitionInflater.from(activity.getApplicationContext()).inflateTransition(0x7f050000);
            activity.getWindow().setEnterTransition(list);
        }
    }

    ()
    {
        this$0 = AbstractDetailsTransitionController.this;
        super();
    }
}
