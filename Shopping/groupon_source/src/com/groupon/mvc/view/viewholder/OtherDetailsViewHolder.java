// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.OtherDetails;
import com.groupon.view.NonLeakingNonFlickerWebView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class OtherDetailsViewHolder extends RecyclerItemViewHolder
{

    NonLeakingNonFlickerWebView otherDetailsWebView;

    public OtherDetailsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        otherDetailsWebView.loadDataWithBaseURL(null, (new StringBuilder()).append(((OtherDetails)model).webViewCSSStyling).append(((OtherDetails)model).reservationsHtml).toString(), "text/html", "UTF-8", null);
    }
}
