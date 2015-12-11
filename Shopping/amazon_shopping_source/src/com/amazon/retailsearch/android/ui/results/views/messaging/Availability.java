// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            AvailabilityModel

public abstract class Availability extends LinearLayout
    implements RetailSearchResultView
{

    protected TextView generalAvailability;
    protected TextView lowStock;

    public Availability(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private boolean setMessage(TextView textview, String s)
    {
        if (textview == null)
        {
            return false;
        }
        if (TextUtils.isEmpty(s))
        {
            textview.setVisibility(8);
            return false;
        } else
        {
            textview.setText(s);
            textview.setVisibility(0);
            return true;
        }
    }

    public void buildView(AvailabilityModel availabilitymodel, ViewType viewtype)
    {
        int j = 1;
        if (availabilitymodel == null || availabilitymodel.isEmpty())
        {
            setVisibility(8);
            return;
        }
        int i;
        if (setMessage(generalAvailability, availabilitymodel.getGeneralMessage()))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!setMessage(lowStock, availabilitymodel.getLowStockMessage()))
        {
            j = 0;
        }
        if (0 + i + j == 0)
        {
            setVisibility(8);
            return;
        } else
        {
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((AvailabilityModel)obj, viewtype);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        postInflate();
    }

    protected abstract void postInflate();
}
