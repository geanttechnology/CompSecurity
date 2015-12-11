// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.Bundle;
import android.util.Log;
import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.StringUtils;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            PinterestHelper, ExtServiceConnectInterface

class this._cls0 extends PDKCallback
{

    final PinterestHelper this$0;

    public void onFailure(PDKException pdkexception)
    {
        Log.e(getClass().getName(), pdkexception.getDetailMessage());
        pdkexception = new PMApiError(null, null, 200, PMErrorType.PINTEREST_LOGIN_ERROR);
        if (connectCallback != null)
        {
            connectCallback.error(pdkexception);
            return;
        } else
        {
            pdkexception = new Bundle();
            callingFragment = PinterestHelper.access$000(PinterestHelper.this);
            pdkexception.putBoolean("HAS_ERROR", true);
            callingFragment.onFragmentResult(pdkexception, 8772);
            return;
        }
    }

    public void onSuccess(PDKResponse pdkresponse)
    {
        Log.d(getClass().getName(), pdkresponse.getData().toString());
        pdkresponse = PDKClient.getInstance().getAccessToken();
        PMNotificationManager.fireNotification("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED");
        callingFragment = PinterestHelper.access$000(PinterestHelper.this);
        if (callingFragment != null)
        {
            callingFragment.showProgressDialogWithMessage(callingFragment.getString(0x7f060190));
        }
        PMApi.pinterestLink(pdkresponse, StringUtils.join(scopes, ","), new PMApiResponseHandler() {

            final PinterestHelper._cls1 this$1;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                Log.d("Pinterest Helper", pmapiresponse.responseString);
                if (callingFragment != null)
                {
                    callingFragment.hideProgressDialog();
                }
                Bundle bundle = new Bundle();
                if (!pmapiresponse.hasError())
                {
                    PMApplicationSession.GetPMSession().updatePinterestData((ExternalServiceInfo)pmapiresponse.data);
                    if (connectCallback != null)
                    {
                        connectCallback.success(0, null);
                        return;
                    } else
                    {
                        callingFragment = PinterestHelper.access$000(this$0);
                        bundle.putBoolean("HAS_ERROR", false);
                        callingFragment.onFragmentResult(bundle, 8772);
                        return;
                    }
                }
                if (connectCallback != null)
                {
                    connectCallback.error(pmapiresponse.apiError);
                    return;
                } else
                {
                    callingFragment = PinterestHelper.access$000(this$0);
                    bundle.putBoolean("HAS_ERROR", true);
                    callingFragment.onFragmentResult(bundle, 8772);
                    return;
                }
            }

            
            {
                this$1 = PinterestHelper._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = PinterestHelper.this;
        super();
    }
}
