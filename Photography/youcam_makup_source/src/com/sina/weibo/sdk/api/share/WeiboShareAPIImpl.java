// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.ShareRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IWeiboShareAPI, WeiboDownloader, ProvideMessageForWeiboRequest, SendMessageToWeiboResponse, 
//            VersionCheckHandler, BaseRequest, SendMultiMessageToWeiboRequest, SendMessageToWeiboRequest, 
//            BaseResponse, IWeiboDownloadListener

class WeiboShareAPIImpl
    implements IWeiboShareAPI
{

    private static final String TAG = com/sina/weibo/sdk/api/share/WeiboShareAPIImpl.getName();
    private String mAppKey;
    private Context mContext;
    private Dialog mDownloadConfirmDialog;
    private IWeiboDownloadListener mDownloadListener;
    private boolean mNeedDownloadWeibo;
    private com.sina.weibo.sdk.WeiboAppManager.WeiboInfo mWeiboInfo;

    public WeiboShareAPIImpl(Context context, String s, boolean flag)
    {
        mWeiboInfo = null;
        mNeedDownloadWeibo = true;
        mDownloadConfirmDialog = null;
        mContext = context;
        mAppKey = s;
        mNeedDownloadWeibo = flag;
        mWeiboInfo = WeiboAppManager.getInstance(context).getWeiboInfo();
        if (mWeiboInfo != null)
        {
            LogUtil.d(TAG, mWeiboInfo.toString());
        } else
        {
            LogUtil.d(TAG, "WeiboInfo is null");
        }
        AidTask.getInstance(context).aidTaskInit(s);
    }

    private WeiboMessage adapterMultiMessage2SingleMessage(WeiboMultiMessage weibomultimessage)
    {
        if (weibomultimessage == null)
        {
            return new WeiboMessage();
        } else
        {
            Bundle bundle = new Bundle();
            weibomultimessage.toBundle(bundle);
            return new WeiboMessage(bundle);
        }
    }

    private boolean checkEnvironment(boolean flag)
    {
        if (isWeiboAppInstalled())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mDownloadConfirmDialog != null) goto _L4; else goto _L3
_L3:
        mDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(mContext, mDownloadListener);
        mDownloadConfirmDialog.show();
_L5:
        return false;
_L4:
        if (!mDownloadConfirmDialog.isShowing())
        {
            mDownloadConfirmDialog.show();
        }
        if (true) goto _L5; else goto _L2
_L2:
        throw new WeiboShareException("Weibo is not installed!");
        if (!isWeiboAppSupportAPI())
        {
            throw new WeiboShareException("Weibo do not support share api!");
        }
        if (!ApiUtils.validateWeiboSign(mContext, mWeiboInfo.getPackageName()))
        {
            throw new WeiboShareException("Weibo signature is incorrect!");
        } else
        {
            return true;
        }
    }

    private boolean launchWeiboActivity(Activity activity, String s, String s1, String s2, Bundle bundle)
    {
        if (activity == null || TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
            return false;
        }
        Intent intent = new Intent();
        intent.setPackage(s1);
        intent.setAction(s);
        s = activity.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031205000");
        intent.putExtra("_weibo_appPackage", s);
        intent.putExtra("_weibo_appKey", s2);
        intent.putExtra("_weibo_flag", 0x20130329);
        intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(activity, s)));
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        try
        {
            LogUtil.d(TAG, (new StringBuilder("launchWeiboActivity intent=")).append(intent).append(", extra=").append(intent.getExtras()).toString());
            activity.startActivityForResult(intent, 765);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            LogUtil.e(TAG, activity.getMessage());
            return false;
        }
        return true;
    }

    private void registerWeiboDownloadListener(IWeiboDownloadListener iweibodownloadlistener)
    {
        mDownloadListener = iweibodownloadlistener;
    }

    private void sendBroadcast(Context context, String s, String s1, String s2, Bundle bundle)
    {
        s = new Intent(s);
        String s3 = context.getPackageName();
        s.putExtra("_weibo_sdkVersion", "0031205000");
        s.putExtra("_weibo_appPackage", s3);
        s.putExtra("_weibo_appKey", s1);
        s.putExtra("_weibo_flag", 0x20130329);
        s.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(context, s3)));
        if (!TextUtils.isEmpty(s2))
        {
            s.setPackage(s2);
        }
        if (bundle != null)
        {
            s.putExtras(bundle);
        }
        LogUtil.d(TAG, (new StringBuilder("intent=")).append(s).append(", extra=").append(s.getExtras()).toString());
        context.sendBroadcast(s, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
    }

    private boolean startShareWeiboActivity(Activity activity, String s, BaseRequest baserequest, WeiboAuthListener weiboauthlistener)
    {
        try
        {
            WbAppActivator.getInstance(mContext, mAppKey).activateApp();
            new Bundle();
            String s1 = activity.getPackageName();
            ShareRequestParam sharerequestparam = new ShareRequestParam(activity);
            sharerequestparam.setToken(s);
            sharerequestparam.setAppKey(mAppKey);
            sharerequestparam.setAppPackage(s1);
            sharerequestparam.setBaseRequest(baserequest);
            sharerequestparam.setSpecifyTitle("\u5FAE\u535A\u5206\u4EAB");
            sharerequestparam.setAuthListener(weiboauthlistener);
            s = new Intent(activity, com/sina/weibo/sdk/component/WeiboSdkBrowser);
            s.putExtras(sharerequestparam.createRequestParamBundle());
            activity.startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public int getWeiboAppSupportAPI()
    {
        if (mWeiboInfo == null || !mWeiboInfo.isLegal())
        {
            return -1;
        } else
        {
            return mWeiboInfo.getSupportApi();
        }
    }

    public boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request)
    {
        if (intent == null || request == null)
        {
            return false;
        }
        String s = intent.getStringExtra("_weibo_appPackage");
        String s1 = intent.getStringExtra("_weibo_transaction");
        if (TextUtils.isEmpty(s))
        {
            LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        }
        if (TextUtils.isEmpty(s1))
        {
            LogUtil.e(TAG, "handleWeiboRequest faild intent _weibo_transaction is null");
            request.onRequest(null);
            return false;
        }
        if (!ApiUtils.validateWeiboSign(mContext, s))
        {
            LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        } else
        {
            request.onRequest(new ProvideMessageForWeiboRequest(intent.getExtras()));
            return true;
        }
    }

    public boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response)
    {
        String s = intent.getStringExtra("_weibo_appPackage");
        String s1 = intent.getStringExtra("_weibo_transaction");
        if (TextUtils.isEmpty(s))
        {
            LogUtil.e(TAG, "handleWeiboResponse faild appPackage is null");
            return false;
        }
        if (!(response instanceof Activity))
        {
            LogUtil.e(TAG, "handleWeiboResponse faild handler is not Activity");
            return false;
        }
        Activity activity = (Activity)response;
        String s2 = activity.getCallingPackage();
        LogUtil.d(TAG, (new StringBuilder("handleWeiboResponse getCallingPackage : ")).append(s2).toString());
        if (TextUtils.isEmpty(s1))
        {
            LogUtil.e(TAG, "handleWeiboResponse faild intent _weibo_transaction is null");
            return false;
        }
        if (!ApiUtils.validateWeiboSign(mContext, s) && !s.equals(activity.getPackageName()))
        {
            LogUtil.e(TAG, "handleWeiboResponse faild appPackage validateSign faild");
            return false;
        } else
        {
            response.onResponse(new SendMessageToWeiboResponse(intent.getExtras()));
            return true;
        }
    }

    public boolean isSupportWeiboPay()
    {
        return getWeiboAppSupportAPI() >= 10353;
    }

    public boolean isWeiboAppInstalled()
    {
        return mWeiboInfo != null && mWeiboInfo.isLegal();
    }

    public boolean isWeiboAppSupportAPI()
    {
        return getWeiboAppSupportAPI() >= 10350;
    }

    public boolean launchWeibo(Activity activity)
    {
        if (!isWeiboAppInstalled())
        {
            LogUtil.e(TAG, "launchWeibo faild WeiboInfo is null");
            return false;
        }
        try
        {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(mWeiboInfo.getPackageName()));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            LogUtil.e(TAG, activity.getMessage());
            return false;
        }
        return true;
    }

    public boolean launchWeiboPay(Activity activity, String s)
    {
        boolean flag;
        try
        {
            flag = checkEnvironment(true);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            LogUtil.e(TAG, activity.getMessage());
            return false;
        }
        if (!flag)
        {
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("rawdata", s);
            bundle.putInt("_weibo_command_type", 4);
            bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
            return launchWeiboActivity(activity, "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY", mWeiboInfo.getPackageName(), mAppKey, bundle);
        }
    }

    public boolean registerApp()
    {
        sendBroadcast(mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", mAppKey, null, null);
        return true;
    }

    public boolean sendRequest(Activity activity, BaseRequest baserequest)
    {
        if (baserequest == null)
        {
            LogUtil.e(TAG, "sendRequest faild request is null");
        } else
        {
            boolean flag;
            try
            {
                flag = checkEnvironment(mNeedDownloadWeibo);
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                LogUtil.e(TAG, activity.getMessage());
                return false;
            }
            if (flag)
            {
                if (!baserequest.check(mContext, mWeiboInfo, new VersionCheckHandler()))
                {
                    LogUtil.e(TAG, "sendRequest faild request check faild");
                    return false;
                } else
                {
                    WbAppActivator.getInstance(mContext, mAppKey).activateApp();
                    Bundle bundle = new Bundle();
                    baserequest.toBundle(bundle);
                    return launchWeiboActivity(activity, "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY", mWeiboInfo.getPackageName(), mAppKey, bundle);
                }
            }
        }
        return false;
    }

    public boolean sendRequest(Activity activity, BaseRequest baserequest, AuthInfo authinfo, String s, WeiboAuthListener weiboauthlistener)
    {
        if (baserequest == null)
        {
            LogUtil.e(TAG, "sendRequest faild request is null !");
            return false;
        }
        if (isWeiboAppInstalled() && isWeiboAppSupportAPI())
        {
            if (getWeiboAppSupportAPI() >= 10351)
            {
                return sendRequest(activity, baserequest);
            }
            if (baserequest instanceof SendMultiMessageToWeiboRequest)
            {
                baserequest = (SendMultiMessageToWeiboRequest)baserequest;
                authinfo = new SendMessageToWeiboRequest();
                authinfo.packageName = ((SendMultiMessageToWeiboRequest) (baserequest)).packageName;
                authinfo.transaction = ((SendMultiMessageToWeiboRequest) (baserequest)).transaction;
                authinfo.message = adapterMultiMessage2SingleMessage(((SendMultiMessageToWeiboRequest) (baserequest)).multiMessage);
                return sendRequest(activity, ((BaseRequest) (authinfo)));
            } else
            {
                return sendRequest(activity, baserequest);
            }
        } else
        {
            return startShareWeiboActivity(activity, s, baserequest, weiboauthlistener);
        }
    }

    public boolean sendResponse(BaseResponse baseresponse)
    {
        if (baseresponse == null)
        {
            LogUtil.e(TAG, "sendResponse failed response null");
            return false;
        }
        if (!baseresponse.check(mContext, new VersionCheckHandler()))
        {
            LogUtil.e(TAG, "sendResponse check fail");
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            baseresponse.toBundle(bundle);
            sendBroadcast(mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_RESPONSE", mAppKey, baseresponse.reqPackageName, bundle);
            return true;
        }
    }

}
