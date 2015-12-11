// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.transition.TransitionInflater;
import android.view.Window;
import com.groupon.util.LayoutUtil;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.groupon.activity.transition:
//            HotelDetailsTransitionController

class this._cls0 extends SharedElementCallback
{

    final HotelDetailsTransitionController this$0;

    public void onMapSharedElements(List list, Map map)
    {
        if (isReturning)
        {
            android.view.View view;
            if (layoutUtil.isLandscape())
            {
                view = getViewByViewId(0x7f100222);
            } else
            {
                view = getViewByViewId(0x7f100384);
            }
            map.remove("deal_image_transition");
            map.put("deal_image_transition", view);
        }
        super.onMapSharedElements(list, map);
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
        this$0 = HotelDetailsTransitionController.this;
        super();
    }
}
