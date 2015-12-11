// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;

// Referenced classes of package com.groupon.util:
//            WebViewHelper

public class GeneralThirdPartyDealWebViewHelper extends WebViewHelper
{

    private String url;

    public GeneralThirdPartyDealWebViewHelper(Context context, String s)
    {
        super(context);
        url = s;
    }

    public String getUrl()
    {
        return url;
    }
}
