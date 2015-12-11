// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.Amenities;
import com.groupon.view.NonLeakingNonFlickerWebView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class AmenitiesViewHolder extends RecyclerItemViewHolder
{

    NonLeakingNonFlickerWebView amenitiesWebView;

    public AmenitiesViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        amenitiesWebView.loadDataWithBaseURL(null, (new StringBuilder()).append(((Amenities)model).webViewCSSStyling).append(((Amenities)model).amenitiesHtml).toString(), "text/html", "UTF-8", null);
    }
}
