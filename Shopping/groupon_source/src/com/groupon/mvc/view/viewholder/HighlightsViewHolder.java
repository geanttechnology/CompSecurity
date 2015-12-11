// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.Highlights;
import com.groupon.view.NonLeakingNonFlickerWebView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class HighlightsViewHolder extends RecyclerItemViewHolder
{

    NonLeakingNonFlickerWebView highlightsWebView;

    public HighlightsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        highlightsWebView.loadDataWithBaseURL(null, (new StringBuilder()).append(((Highlights)model).webViewCSSStyling).append(((Highlights)model).highlightsHtml).toString(), "text/html", "UTF-8", null);
    }
}
