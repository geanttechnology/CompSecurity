// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ExternalAppUtils;
import com.poshmark.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            ExtServiceConnectInterface

public class PinterestHelper
{

    static PinterestHelper INSTANCE = null;
    public static final int PDKCLIENT_EXPLICIT_SHARE_REQUEST_CODE = 9494;
    public static final String PDKCLIENT_EXTRA_RESULT = "PDKCLIENT_EXTRA_RESULT";
    public static final int PDKCLIENT_REQUEST_CODE = 8772;
    public static final String SERVICE_ID = "pn";
    static PMNotificationListener notificationListener = new PMNotificationListener() {

        public void handleNotification(Intent intent)
        {
            intent.putExtra("PDKCLIENT_EXTRA_RESULT", intent.getBundleExtra("RESULT").getString("PDKCLIENT_EXTRA_RESULT"));
            PDKClient.getInstance().onOauthResponse(8772, -1, intent);
        }

    };
    PMFragment callingFragment;
    ExtServiceConnectInterface connectCallback;
    UUID fragmentId;
    String image_url;
    PDKCallback loginCallback;
    String note;
    Bundle savedCallingFragmentBundle;
    List scopes;
    String url;

    public PinterestHelper()
    {
        scopes = new ArrayList();
        loginCallback = new PDKCallback() {

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
                    callingFragment = getCurrentFragmentCaller();
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
                callingFragment = getCurrentFragmentCaller();
                if (callingFragment != null)
                {
                    callingFragment.showProgressDialogWithMessage(callingFragment.getString(0x7f060190));
                }
                PMApi.pinterestLink(pdkresponse, StringUtils.join(scopes, ","), new PMApiResponseHandler() {

                    final _cls1 this$1;

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
                                callingFragment = getCurrentFragmentCaller();
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
                            callingFragment = getCurrentFragmentCaller();
                            bundle.putBoolean("HAS_ERROR", true);
                            callingFragment.onFragmentResult(bundle, 8772);
                            return;
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = PinterestHelper.this;
                super();
            }
        };
        scopes.add("read_public");
        scopes.add("write_public");
        scopes.add("read_relationships");
        PDKClient.configureInstance(PMApplication.getContext(), "4794312476046927699");
    }

    private PMFragment getCurrentFragmentCaller()
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        if (obj != null && savedCallingFragmentBundle != null && fragmentId != null)
        {
            try
            {
                obj = (PMFragment)((PMActivity) (obj)).getSupportFragmentManager().getFragment(savedCallingFragmentBundle, fragmentId.toString());
            }
            catch (IllegalStateException illegalstateexception)
            {
                return null;
            }
            return ((PMFragment) (obj));
        } else
        {
            return null;
        }
    }

    public static PinterestHelper getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PinterestHelper();
            PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PINTEREST_DEEPLINK", notificationListener);
        }
        return INSTANCE;
    }

    public void connect(Context context, ExtServiceConnectInterface extserviceconnectinterface)
    {
        PDKClient.getInstance().onConnect(context);
        callingFragment = null;
        savedCallingFragmentBundle = null;
        fragmentId = null;
        connectCallback = extserviceconnectinterface;
        PDKClient.getInstance().login(context, scopes, loginCallback);
    }

    public void connect(PMFragment pmfragment)
    {
        FragmentActivity fragmentactivity = pmfragment.getActivity();
        PDKClient.getInstance().onConnect(fragmentactivity);
        connectCallback = null;
        callingFragment = pmfragment;
        savedCallingFragmentBundle = new Bundle();
        fragmentId = pmfragment.getFragmentId();
        pmfragment.getActivity().getSupportFragmentManager().putFragment(savedCallingFragmentBundle, fragmentId.toString(), pmfragment);
        PDKClient.getInstance().login(fragmentactivity, scopes, loginCallback);
    }

    public void destroy()
    {
        notificationListener = null;
        connectCallback = null;
        url = null;
        image_url = null;
        note = null;
        INSTANCE = null;
    }

    public void explicitShare(Context context, ExtServiceConnectInterface extserviceconnectinterface)
    {
        connectCallback = extserviceconnectinterface;
        extserviceconnectinterface = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://www.pinterest.com/pin/create/button/?url=%s&media=%s&description=%s", new Object[] {
            StringUtils.urlEncode(url), StringUtils.urlEncode(image_url), StringUtils.urlEncode(note)
        })));
        String s = ExternalAppUtils.filterByPackageName(context, extserviceconnectinterface, "com.pinterest");
        if (s != null)
        {
            extserviceconnectinterface.setPackage(s);
        }
        ((PMActivity)context).startActivityForResult(extserviceconnectinterface, 9494);
    }

    public void explicitShare(Context context, PMFragment pmfragment)
    {
        connectCallback = null;
        callingFragment = pmfragment;
        savedCallingFragmentBundle = new Bundle();
        fragmentId = pmfragment.getFragmentId();
        pmfragment = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://www.pinterest.com/pin/create/button/?url=%s&media=%s&description=%s", new Object[] {
            StringUtils.urlEncode(url), StringUtils.urlEncode(image_url), note
        })));
        String s = ExternalAppUtils.filterByPackageName(context, pmfragment, "com.pinterest");
        if (s != null)
        {
            pmfragment.setPackage(s);
        }
        ((PMActivity)context).startActivityForResult(pmfragment, 9494);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Log.d("Pinterest Helper", "Authenticated Via App");
        if (i == 8772)
        {
            PDKClient.getInstance().onOauthResponse(i, j, intent);
        } else
        if (i == 9494)
        {
            if (connectCallback != null)
            {
                connectCallback.success(0, null);
                return;
            } else
            {
                callingFragment = getCurrentFragmentCaller();
                return;
            }
        }
    }

    public void setData(String s, String s1, String s2)
    {
        note = s;
        url = s1;
        image_url = s2;
    }

    public void unlink()
    {
        PDKClient.getInstance().logout();
    }


}
