// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity.transition:
//            GoodsMultiOptionTransitionController

class this._cls0 extends SharedElementCallback
{

    final GoodsMultiOptionTransitionController this$0;

    private View getElement(String s, List list, List list1)
    {
        byte byte0 = -1;
        int i = 0;
        do
        {
label0:
            {
                int j = byte0;
                if (i < list.size())
                {
                    if (!Strings.equalsIgnoreCase(s, list.get(i)))
                    {
                        break label0;
                    }
                    j = i;
                }
                if (j > -1)
                {
                    return (View)list1.get(j);
                } else
                {
                    return null;
                }
            }
            i++;
        } while (true);
    }

    public void onMapSharedElements(List list, Map map)
    {
        View view = activity.findViewById(0x1020030);
        View view1 = activity.findViewById(0x102002f);
        if (view != null)
        {
            list.add(view.getTransitionName());
            map.put(view.getTransitionName(), view);
        }
        if (view1 != null)
        {
            list.add(view1.getTransitionName());
            map.put(view1.getTransitionName(), view1);
        }
        if (GoodsMultiOptionTransitionController.access$000(GoodsMultiOptionTransitionController.this))
        {
            list = (View)map.get("option_title_transition");
            if (list != null)
            {
                list.setAlpha(0.0F);
            }
        }
    }

    public void onSharedElementEnd(List list, List list1, List list2)
    {
        super.onSharedElementEnd(list, list1, list2);
        GoodsMultiOptionTransitionController.access$002(GoodsMultiOptionTransitionController.this, false);
    }

    public void onSharedElementStart(List list, List list1, List list2)
    {
        if (GoodsMultiOptionTransitionController.access$000(GoodsMultiOptionTransitionController.this))
        {
            list = getElement("option_title_transition", list, list1);
            if (list != null)
            {
                list.animate().alpha(1.0F).setDuration(300L);
            }
        }
    }

    ()
    {
        this$0 = GoodsMultiOptionTransitionController.this;
        super();
    }
}
