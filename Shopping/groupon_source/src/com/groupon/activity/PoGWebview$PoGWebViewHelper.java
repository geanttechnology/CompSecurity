// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LoginService;
import com.groupon.util.InternalDeeplink;
import com.groupon.util.WebViewHelper;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.groupon.activity:
//            PoGWebview, IntentFactory

public class this._cls0 extends WebViewHelper
{

    final PoGWebview this$0;

    public Map createWebViewHeaders(String s, String s1)
    {
        s1 = new HashMap();
        s1.put("Authorization", String.format("%s %s", new Object[] {
            "OAuth", s
        }));
        return s1;
    }

    public String getUrl()
    {
        if (prefs.getBoolean("enable_pog_test_webview", false))
        {
            return "file:///android_asset/groupon-links.html";
        } else
        {
            return PoGWebview.access$300(PoGWebview.this, url);
        }
    }

    public boolean shouldOverrideUrlLoading(String s)
    {
        if (!InternalDeeplink.isUrlInternal(s))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        internalDeeplink = new InternalDeeplink(PoGWebview.this, s);
        if (!internalDeeplink.isCameraAction()) goto _L2; else goto _L1
_L1:
        startActivityForResult(intentFactory.newCameraCapture(tempfile), 100);
_L4:
        return true;
_L2:
        if (internalDeeplink.isPhotoAction())
        {
            startActivityForResult(intentFactory.newPhotoPicker(), 200);
            return true;
        }
        if (internalDeeplink.isCloseIntent())
        {
            finish();
            return true;
        }
        if (!internalDeeplink.isLoginIntent())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (PoGWebview.access$000(PoGWebview.this).isLoggedIn()) goto _L4; else goto _L3
_L3:
        startActivity(intentFactory.newLoginIntent(PoGWebview.this));
        return true;
        if (!PoGWebview.access$100(PoGWebview.this).isDeepLink(s))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        com.groupon.deeplink.DeepLinkData deeplinkdata = PoGWebview.access$100(PoGWebview.this).getDeepLink(url);
        PoGWebview.access$200(PoGWebview.this).followDeepLink(context, deeplinkdata);
        return true;
        InvalidDeepLinkException invaliddeeplinkexception;
        invaliddeeplinkexception;
        return super.shouldOverrideUrlLoading(s);
    }

    public (Context context)
    {
        this$0 = PoGWebview.this;
        super(context);
    }
}
