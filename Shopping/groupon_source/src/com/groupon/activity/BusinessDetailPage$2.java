// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class this._cls0
    implements android.view.obalLayoutListener
{

    final BusinessDetailPage this$0;

    public void onGlobalLayout()
    {
        float f = TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
        if (customerRecommend.getVisibility() == 8 && categorizations.getVisibility() == 8 && businessTitle.getX() + (float)businessTitle.getWidth() > openCloseTextView.getX())
        {
            android.widget.rams rams = (android.widget.rams)businessTitle.getLayoutParams();
            rams.setMargins(rams.leftMargin, rams.topMargin, (int)(((float)businessTitle.getWidth() - openCloseTextView.getX()) + f), rams.bottomMargin);
            businessTitle.setLayoutParams(rams);
        }
        if (categorizations.getVisibility() == 0 && categorizations.getX() + (float)categorizations.getWidth() > openCloseTextView.getX())
        {
            android.widget.rams rams1 = (android.widget.rams)categorizations.getLayoutParams();
            rams1.setMargins(rams1.leftMargin, rams1.topMargin, (int)(((float)categorizations.getWidth() - openCloseTextView.getX()) + f), rams1.bottomMargin);
            businessTitle.setLayoutParams(rams1);
        }
        businessHeaderContainer.setVisibility(0);
        businessHeaderParentContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    utListener()
    {
        this$0 = BusinessDetailPage.this;
        super();
    }
}
