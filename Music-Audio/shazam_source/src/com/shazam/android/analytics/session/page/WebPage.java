// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import android.text.TextUtils;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            DetailsPage

public class WebPage extends DetailsPage
{

    private static final String DEFAULT_PAGE_NAME = "miscwebview";

    public WebPage()
    {
    }

    public String getPageName()
    {
        String s1 = super.getPageName();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = "miscwebview";
        }
        return s;
    }
}
