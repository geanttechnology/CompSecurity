// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.endpoint.OpenIdRequest;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.framework.AuthenticationWebViewClient;
import com.amazon.identity.auth.device.framework.MAPSmsReceiver;
import com.amazon.identity.auth.device.utils.ResourceHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.Timer;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class val.request
    implements com.amazon.identity.auth.device.framework.ient.AuthenticationWebViewClientCallback
{

    final AuthPortalUIActivity this$0;
    final OpenIdRequest val$request;

    public void onCodeEnterFinished()
    {
        AuthPortalUIActivity.access$2000();
        if (AuthPortalUIActivity.access$1200(AuthPortalUIActivity.this).isMFA() && AuthPortalUIActivity.access$2100(AuthPortalUIActivity.this) != null)
        {
            AuthPortalUIActivity.access$2000();
            AuthPortalUIActivity.access$2100(AuthPortalUIActivity.this).stopAndDiscard();
            PlatformMetricsTimer _tmp = AuthPortalUIActivity.access$2102$707f9f0f(AuthPortalUIActivity.this);
        }
        if (AuthPortalUIActivity.access$1200(AuthPortalUIActivity.this).isDCQ() && AuthPortalUIActivity.access$2200(AuthPortalUIActivity.this) != null)
        {
            AuthPortalUIActivity.access$2000();
            AuthPortalUIActivity.access$2200(AuthPortalUIActivity.this).stopAndDiscard();
            PlatformMetricsTimer _tmp1 = AuthPortalUIActivity.access$2202$707f9f0f(AuthPortalUIActivity.this);
        }
    }

    public void onPageFinished()
    {
        int i = ResourceHelper.getId(AuthPortalUIActivity.this, "apimageview");
        ImageView imageview = (ImageView)findViewById(i);
        WebView webview = AuthPortalUIActivity.access$1600(AuthPortalUIActivity.this);
        if (webview == null)
        {
            AuthPortalUIActivity.access$300(AuthPortalUIActivity.this, AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.trationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
        } else
        {
            if (imageview.getVisibility() == 0)
            {
                imageview.setVisibility(8);
            }
            if (webview.getVisibility() != 0)
            {
                webview.setVisibility(0);
                webview.requestFocusFromTouch();
            }
            AuthPortalUIActivity.access$1700$4a69bd24(AuthPortalUIActivity.this);
            AuthPortalUIActivity.access$400(AuthPortalUIActivity.this);
            if (AuthPortalUIActivity.access$1800(AuthPortalUIActivity.this) != null)
            {
                AuthPortalUIActivity.access$1800(AuthPortalUIActivity.this).stopAndDiscard();
            }
            if (AuthPortalUIActivity.access$1900(AuthPortalUIActivity.this) != null)
            {
                AuthPortalUIActivity.access$1900(AuthPortalUIActivity.this).stopAndDiscard();
                return;
            }
        }
    }

    public void onPageStarted(String s)
    {
        String s1;
        AuthPortalUIActivity.access$1000(AuthPortalUIActivity.this, s);
        if (AuthPortalUIActivity.access$1100(AuthPortalUIActivity.this) != null)
        {
            AuthPortalUIActivity.access$1100(AuthPortalUIActivity.this).stopAndDiscard();
        }
        s1 = (new StringBuilder("AuthPortalPageTimeout:")).append(val$request.getRequestType().name()).toString();
        if (!AuthPortalUIActivity.access$1200(AuthPortalUIActivity.this).isMFA()) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s1).append(":MFA").toString();
_L4:
        AuthPortalUIActivity.access$102(AuthPortalUIActivity.this, s);
        if (AuthPortalUIActivity.access$1300(AuthPortalUIActivity.this) != null)
        {
            AuthPortalUIActivity.access$1300(AuthPortalUIActivity.this).cancel();
        }
        AuthPortalUIActivity.access$1302(AuthPortalUIActivity.this, new Timer());
        AuthPortalUIActivity.access$1300(AuthPortalUIActivity.this).schedule(new meoutTimerTask(AuthPortalUIActivity.this, (byte)0), 0x3d090L);
        AuthPortalUIActivity.access$1500(AuthPortalUIActivity.this);
        return;
_L2:
        s = s1;
        if (AuthPortalUIActivity.access$1200(AuthPortalUIActivity.this).isDCQ())
        {
            s = (new StringBuilder()).append(s1).append(":DCQ").toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setError(Bundle bundle)
    {
        AuthPortalUIActivity.access$900(AuthPortalUIActivity.this);
        AuthPortalUIActivity.access$300(AuthPortalUIActivity.this, bundle);
    }

    public void setResult(OpenIdResponse openidresponse)
    {
        AuthPortalUIActivity.access$700(AuthPortalUIActivity.this).incrementCounterForAutoPhoneVerificationSuccess();
        AuthPortalUIActivity.access$800(AuthPortalUIActivity.this, val$request.getRequestType(), openidresponse);
    }

    ()
    {
        this$0 = final_authportaluiactivity;
        val$request = OpenIdRequest.this;
        super();
    }
}
