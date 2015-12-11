// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingsFilterWidget, PMTextView

class mClickListener
{

    Button button;
    PMTextView buttonText;
    ON buttonType;
    String label;
    LinearLayout layout;
    android.view.get.FILTER_BUTTON mClickListener;
    PMTextView textView;
    final ListingsFilterWidget this$0;

    ON(String s, ON on, final int filter_action, int i, int j, int k)
    {
        this.this$0 = ListingsFilterWidget.this;
        super();
        label = s;
        buttonType = on;
        mClickListener = new android.view.View.OnClickListener() {

            final ListingsFilterWidget.ButtonInfo this$1;
            final int val$filter_action;
            final ListingsFilterWidget val$this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putInt("FILTER_ACTION", filter_action);
                PMNotificationManager.fireNotification("com.poshmark.intents.FILTER_SELECTION_ACTION", view);
            }

            
            {
                this$1 = ListingsFilterWidget.ButtonInfo.this;
                this$0 = listingsfilterwidget;
                filter_action = i;
                super();
            }
        };
        if (isG2FiltersEnabled)
        {
            buttonText = (PMTextView)findViewById(j);
            textView = (PMTextView)findViewById(k);
            buttonText.setText(s);
            layout = (LinearLayout)findViewById(i);
            layout.setOnClickListener(mClickListener);
            return;
        } else
        {
            button = (Button)findViewById(j);
            button.setText(s);
            button.setOnClickListener(mClickListener);
            return;
        }
    }
}
