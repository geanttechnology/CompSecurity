// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BSAuthResponse;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BSLoginActivity

class this._cls0
    implements Callback
{

    final BSLoginActivity this$0;

    public void failure(RetrofitError retrofiterror)
    {
        retrofiterror = retrofiterror.getResponse();
        if (retrofiterror != null && retrofiterror.getStatus() == 400)
        {
            BSLoginActivity.access$100(BSLoginActivity.this);
        } else
        {
            BSLoginActivity.access$200(BSLoginActivity.this);
        }
        enableButtons();
    }

    public void success(BSAuthResponse bsauthresponse, Response response)
    {
        bsauthresponse = bsauthresponse.getAccessToken();
        preferenceUtils.putString(0x7f06003a, bsauthresponse);
        preferenceUtils.putBoolean(0x7f06008a, true);
        analytics.sendEvent(Category.AUTH, Action.LOGIN, "BSAuth login");
        BSLoginActivity.access$000(BSLoginActivity.this, bsauthresponse);
    }

    public volatile void success(Object obj, Response response)
    {
        success((BSAuthResponse)obj, response);
    }

    rvice()
    {
        this$0 = BSLoginActivity.this;
        super();
    }
}
