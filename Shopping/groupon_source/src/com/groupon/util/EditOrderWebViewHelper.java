// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.service.LoginService;
import java.util.Map;

// Referenced classes of package com.groupon.util:
//            WebViewHelper

public class EditOrderWebViewHelper extends WebViewHelper
{

    private static final String EDIT_ORDER_PATH = "%s/deals/%s/confirmation/%s?user_id=%s";
    private String dealId;
    protected LoginService loginService;
    private String orderId;
    private String xCookies;

    public EditOrderWebViewHelper(Context context, String s, String s1, String s2)
    {
        super(context);
        dealId = s;
        orderId = s1;
        xCookies = s2;
    }

    public Map createWebViewHeaders(String s, String s1)
    {
        s1 = super.createWebViewHeaders(s, s1);
        s1.put("x-cookies", xCookies);
        s1.put("x-auth-token", s);
        return s1;
    }

    public String getUrl()
    {
        return String.format("%s/deals/%s/confirmation/%s?user_id=%s", new Object[] {
            prefs.getString("webview_base_url", "https://www.groupon.com"), dealId, orderId, loginService.getUserId()
        });
    }
}
