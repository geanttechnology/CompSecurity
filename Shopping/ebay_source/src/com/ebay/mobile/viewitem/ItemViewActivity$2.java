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

class this._cls0
    implements android.view.Listener
{

    final ItemViewActivity this$0;

    public void onLayoutChange(View view, final int bottomPadding, int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        Activity activity = (Activity)view.getContext();
        if (activity != null)
        {
            bottomPadding = activity.getResources().getDimensionPixelSize(0x7f090072);
            final View scrollViewContent = activity.findViewById(0x7f1002f6);
            if ((ScrollView)activity.findViewById(0x7f100017) != null && scrollViewContent != null)
            {
                if (view.isShown())
                {
                    bottomPadding = view.getHeight() + bottomPadding;
                } else
                {
                    bottomPadding = 0;
                }
                scrollViewContent.post(new Runnable() {

                    final ItemViewActivity._cls2 this$1;
                    final int val$bottomPadding;
                    final View val$scrollViewContent;

                    public void run()
                    {
                        scrollViewContent.setPadding(0, 0, 0, bottomPadding);
                    }

            
            {
                this$1 = ItemViewActivity._cls2.this;
                scrollViewContent = view;
                bottomPadding = i;
                super();
            }
                });
            }
        }
    }

    _cls1.val.bottomPadding()
    {
        this$0 = ItemViewActivity.this;
        super();
    }
}
