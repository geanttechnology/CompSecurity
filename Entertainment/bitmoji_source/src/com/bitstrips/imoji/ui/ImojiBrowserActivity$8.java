// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.text.TextUtils;
import com.bitstrips.imoji.api.BSAuthExchangeTokensResponse;
import com.bitstrips.imoji.services.CrashlyticsService;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity

class this._cls0
    implements Callback
{

    final ImojiBrowserActivity this$0;

    public void failure(RetrofitError retrofiterror)
    {
        if (retrofiterror != null && retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 404)
        {
            ImojiBrowserActivity.access$600(ImojiBrowserActivity.this);
            return;
        } else
        {
            ImojiBrowserActivity.access$500(ImojiBrowserActivity.this);
            return;
        }
    }

    public void success(BSAuthExchangeTokensResponse bsauthexchangetokensresponse, Response response)
    {
        bsauthexchangetokensresponse = bsauthexchangetokensresponse.getAccessToken();
        if (TextUtils.isEmpty(bsauthexchangetokensresponse))
        {
            crashlyticsService.log("BSAuth returning empty tokens for users/exchange_tokens");
            logout();
            return;
        } else
        {
            preferenceUtils.putString(0x7f06003a, bsauthexchangetokensresponse);
            preferenceUtils.putBoolean(0x7f06008a, true);
            ImojiBrowserActivity.access$500(ImojiBrowserActivity.this);
            return;
        }
    }

    public volatile void success(Object obj, Response response)
    {
        success((BSAuthExchangeTokensResponse)obj, response);
    }

    sponse()
    {
        this$0 = ImojiBrowserActivity.this;
        super();
    }
}
