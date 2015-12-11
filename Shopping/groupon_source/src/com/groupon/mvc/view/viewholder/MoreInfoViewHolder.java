// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.webkit.WebSettings;
import com.groupon.mvc.model.MoreInfo;
import com.groupon.view.NonLeakingNonFlickerWebView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class MoreInfoViewHolder extends RecyclerItemViewHolder
{

    NonLeakingNonFlickerWebView moreInfoWebView;

    public MoreInfoViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        String s2 = ((MoreInfo)model).pitchHtml;
        String s1 = ((MoreInfo)model).profileHtml;
        String s = ((MoreInfo)model).webViewCSSStyling;
        Object obj = moreInfoWebView.getSettings();
        if (obj != null)
        {
            ((WebSettings) (obj)).setJavaScriptEnabled(true);
        }
        obj = s;
        if (Strings.notEmpty(s2))
        {
            s = (new StringBuilder()).append(s).append(s2).toString();
            obj = s;
            if (Strings.notEmpty(s1))
            {
                obj = s;
                if (Strings.notEmpty(((MoreInfo)model).merchantName))
                {
                    obj = (new StringBuilder()).append(s).append("<h4>").append(((MoreInfo)model).merchantName).append("</h4>").append(s1).toString();
                }
            }
        }
        moreInfoWebView.loadDataWithBaseURL(null, ((String) (obj)), "text/html", "UTF-8", null);
    }
}
