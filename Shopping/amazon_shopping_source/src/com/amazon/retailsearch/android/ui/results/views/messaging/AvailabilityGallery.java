// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            Availability

public class AvailabilityGallery extends Availability
{

    public AvailabilityGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void postInflate()
    {
        lowStock = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_availability_low_stock);
    }
}
