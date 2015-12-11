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

public class DealListTransitionController
{

    Activity activity;
    private boolean isReentering;

    public DealListTransitionController()
    {
    }

    public SharedElementCallback getSharedElementCallback()
    {
        return new SharedElementCallback() {

            final DealListTransitionController this$0;

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
                if (isReentering)
                {
                    list = (View)map.get("sold_out_banner_transition");
                    if (list != null)
                    {
                        list.setAlpha(0.0F);
                    }
                }
            }

            public void onSharedElementEnd(List list, List list1, List list2)
            {
                super.onSharedElementEnd(list, list1, list2);
                isReentering = false;
            }

            public void onSharedElementStart(List list, List list1, List list2)
            {
                if (isReentering)
                {
                    list = getElement("sold_out_banner_transition", list, list1);
                    if (list != null)
                    {
                        list.animate().alpha(1.0F).setDuration(600L);
                    }
                }
            }

            
            {
                this$0 = DealListTransitionController.this;
                super();
            }
        };
    }

    public void setExitSharedElementCallback()
    {
        activity.setExitSharedElementCallback(getSharedElementCallback());
    }

    public void setReentering(boolean flag)
    {
        isReentering = flag;
    }



/*
    static boolean access$002(DealListTransitionController deallisttransitioncontroller, boolean flag)
    {
        deallisttransitioncontroller.isReentering = flag;
        return flag;
    }

*/
}
