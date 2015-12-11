// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.WhatYouGet;
import com.groupon.view.NonLeakingNonFlickerWebView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class WhatYouGetViewHolder extends RecyclerItemViewHolder
{

    NonLeakingNonFlickerWebView whatYouGetWebView;

    public WhatYouGetViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        whatYouGetWebView.loadDataWithBaseURL(null, (new StringBuilder()).append(((WhatYouGet)model).webViewCSSStyling).append(((WhatYouGet)model).whatYouGetHtml).toString(), "text/html", "UTF-8", null);
    }
}
