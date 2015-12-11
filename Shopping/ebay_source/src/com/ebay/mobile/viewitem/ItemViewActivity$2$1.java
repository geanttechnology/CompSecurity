// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class val.bottomPadding
    implements Runnable
{

    final val.bottomPadding this$1;
    final int val$bottomPadding;
    final View val$scrollViewContent;

    public void run()
    {
        val$scrollViewContent.setPadding(0, 0, 0, val$bottomPadding);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$scrollViewContent = view;
        val$bottomPadding = I.this;
        super();
    }

    // Unreferenced inner class com/ebay/mobile/viewitem/ItemViewActivity$2

/* anonymous class */
    class ItemViewActivity._cls2
        implements android.view.View.OnLayoutChangeListener
    {

        final ItemViewActivity this$0;

        public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            Activity activity = (Activity)view.getContext();
            if (activity != null)
            {
                i = activity.getResources().getDimensionPixelSize(0x7f090072);
                final View scrollViewContent = activity.findViewById(0x7f1002f6);
                if ((ScrollView)activity.findViewById(0x7f100017) != null && scrollViewContent != null)
                {
                    if (view.isShown())
                    {
                        i = view.getHeight() + i;
                    } else
                    {
                        i = 0;
                    }
                    scrollViewContent.post(i. new ItemViewActivity._cls2._cls1());
                }
            }
        }

            
            {
                this$0 = ItemViewActivity.this;
                super();
            }
    }

}
