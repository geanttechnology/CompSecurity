// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.cookies.CookieFactory;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.EditOrderWebViewHelper;
import com.groupon.util.WebViewHelper;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity

public class EditOrder extends BaseWebViewActivity
{

    private static final String X_COOKIES_FORMAT = "s=%1$s;b=%2$s;division=%3$s";
    private CookieFactory cookieFactory;
    private CurrentDivisionManager currentDivisionManager;
    protected String dealId;
    protected String orderId;

    public EditOrder()
    {
    }

    public WebViewHelper createHelper()
    {
        String s = String.format("s=%1$s;b=%2$s;division=%3$s", new Object[] {
            cookieFactory.getSessionCookie(), cookieFactory.getBrowserCookie(), currentDivisionManager.getCurrentDivision().id
        });
        return new EditOrderWebViewHelper(this, dealId, orderId, s);
    }
}
