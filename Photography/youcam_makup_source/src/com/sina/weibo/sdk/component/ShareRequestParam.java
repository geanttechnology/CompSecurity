// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.Base64;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestParamBase, BrowserLauncher, WeiboSdkBrowser, WeiboCallbackManager

public class ShareRequestParam extends BrowserRequestParamBase
{

    public static final String REQ_PARAM_AID = "aid";
    public static final String REQ_PARAM_KEY_HASH = "key_hash";
    public static final String REQ_PARAM_PACKAGENAME = "packagename";
    public static final String REQ_PARAM_PICINFO = "picinfo";
    public static final String REQ_PARAM_SOURCE = "source";
    public static final String REQ_PARAM_TITLE = "title";
    public static final String REQ_PARAM_TOKEN = "access_token";
    public static final String REQ_PARAM_VERSION = "version";
    public static final String REQ_UPLOAD_PIC_PARAM_IMG = "img";
    public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
    public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
    public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
    private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
    public static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
    private String mAppKey;
    private String mAppPackage;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private byte mBase64ImgData[];
    private BaseRequest mBaseRequest;
    private String mHashKey;
    private String mShareContent;
    private String mToken;

    public ShareRequestParam(Context context)
    {
        super(context);
        mLaucher = BrowserLauncher.SHARE;
    }

    private void handleMblogPic(String s, byte abyte0[])
    {
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = new File(s);
        if (!s.exists() || !s.canRead() || s.length() <= 0L) goto _L2; else goto _L3
_L3:
        byte abyte1[] = new byte[(int)s.length()];
        Object obj = null;
        s = new FileInputStream(s);
        s.read(abyte1);
        mBase64ImgData = Base64.encodebyte(abyte1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        s.close();
_L5:
        return;
        s;
        s = null;
_L8:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
_L2:
        if (abyte0 == null || abyte0.length <= 0) goto _L5; else goto _L4
_L4:
        mBase64ImgData = Base64.encodebyte(abyte0);
        return;
        s;
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        throw s;
        s;
        return;
        Exception exception;
        exception;
        obj = s;
        s = exception;
        if (true) goto _L7; else goto _L6
_L6:
        IOException ioexception;
        ioexception;
          goto _L8
    }

    private void handleSharedMessage(Bundle bundle)
    {
        Object obj = new WeiboMultiMessage();
        ((WeiboMultiMessage) (obj)).toObject(bundle);
        bundle = new StringBuilder();
        if (((WeiboMultiMessage) (obj)).textObject instanceof TextObject)
        {
            bundle.append(((WeiboMultiMessage) (obj)).textObject.text);
        }
        if (((WeiboMultiMessage) (obj)).imageObject instanceof ImageObject)
        {
            ImageObject imageobject = ((WeiboMultiMessage) (obj)).imageObject;
            handleMblogPic(imageobject.imagePath, imageobject.imageData);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof TextObject)
        {
            bundle.append(((TextObject)((WeiboMultiMessage) (obj)).mediaObject).text);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof ImageObject)
        {
            ImageObject imageobject1 = (ImageObject)((WeiboMultiMessage) (obj)).mediaObject;
            handleMblogPic(imageobject1.imagePath, imageobject1.imageData);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof WebpageObject)
        {
            WebpageObject webpageobject = (WebpageObject)((WeiboMultiMessage) (obj)).mediaObject;
            bundle.append(" ").append(webpageobject.actionUrl);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof MusicObject)
        {
            MusicObject musicobject = (MusicObject)((WeiboMultiMessage) (obj)).mediaObject;
            bundle.append(" ").append(musicobject.actionUrl);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof VideoObject)
        {
            VideoObject videoobject = (VideoObject)((WeiboMultiMessage) (obj)).mediaObject;
            bundle.append(" ").append(videoobject.actionUrl);
        }
        if (((WeiboMultiMessage) (obj)).mediaObject instanceof VoiceObject)
        {
            obj = (VoiceObject)((WeiboMultiMessage) (obj)).mediaObject;
            bundle.append(" ").append(((VoiceObject) (obj)).actionUrl);
        }
        mShareContent = bundle.toString();
    }

    private void sendSdkResponse(Activity activity, int i, String s)
    {
        Bundle bundle = activity.getIntent().getExtras();
        if (bundle == null)
        {
            return;
        }
        Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.setFlags(0x20000);
        intent.setPackage(bundle.getString("_weibo_appPackage"));
        intent.putExtras(bundle);
        intent.putExtra("_weibo_appPackage", activity.getPackageName());
        intent.putExtra("_weibo_resp_errcode", i);
        intent.putExtra("_weibo_resp_errstr", s);
        try
        {
            activity.startActivityForResult(intent, 765);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
    }

    public WeiboParameters buildUploadPicParam(WeiboParameters weiboparameters)
    {
        if (!hasImage())
        {
            return weiboparameters;
        } else
        {
            weiboparameters.put("img", new String(mBase64ImgData));
            return weiboparameters;
        }
    }

    public String buildUrl(String s)
    {
        android.net.Uri.Builder builder = Uri.parse("http://service.weibo.com/share/mobilesdk.php").buildUpon();
        builder.appendQueryParameter("title", mShareContent);
        builder.appendQueryParameter("version", "0031205000");
        if (!TextUtils.isEmpty(mAppKey))
        {
            builder.appendQueryParameter("source", mAppKey);
        }
        if (!TextUtils.isEmpty(mToken))
        {
            builder.appendQueryParameter("access_token", mToken);
        }
        String s1 = Utility.getAid(mContext, mAppKey);
        if (!TextUtils.isEmpty(s1))
        {
            builder.appendQueryParameter("aid", s1);
        }
        if (!TextUtils.isEmpty(mAppPackage))
        {
            builder.appendQueryParameter("packagename", mAppPackage);
        }
        if (!TextUtils.isEmpty(mHashKey))
        {
            builder.appendQueryParameter("key_hash", mHashKey);
        }
        if (!TextUtils.isEmpty(s))
        {
            builder.appendQueryParameter("picinfo", s);
        }
        return builder.build().toString();
    }

    public void execRequest(Activity activity, int i)
    {
        if (i == 3)
        {
            sendSdkCancleResponse(activity);
            WeiboSdkBrowser.closeBrowser(activity, mAuthListenerKey, null);
        }
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public String getAppPackage()
    {
        return mAppPackage;
    }

    public WeiboAuthListener getAuthListener()
    {
        return mAuthListener;
    }

    public String getAuthListenerKey()
    {
        return mAuthListenerKey;
    }

    public byte[] getBase64ImgData()
    {
        return mBase64ImgData;
    }

    public String getHashKey()
    {
        return mHashKey;
    }

    public String getShareContent()
    {
        return mShareContent;
    }

    public String getToken()
    {
        return mToken;
    }

    public boolean hasImage()
    {
        return mBase64ImgData != null && mBase64ImgData.length > 0;
    }

    public void onCreateRequestParamBundle(Bundle bundle)
    {
        if (mBaseRequest != null)
        {
            mBaseRequest.toBundle(bundle);
        }
        if (!TextUtils.isEmpty(mAppPackage))
        {
            mHashKey = MD5.hexdigest(Utility.getSign(mContext, mAppPackage));
        }
        bundle.putString("access_token", mToken);
        bundle.putString("source", mAppKey);
        bundle.putString("packagename", mAppPackage);
        bundle.putString("key_hash", mHashKey);
        bundle.putString("_weibo_appPackage", mAppPackage);
        bundle.putString("_weibo_appKey", mAppKey);
        bundle.putInt("_weibo_flag", 0x20130329);
        bundle.putString("_weibo_sign", mHashKey);
        if (mAuthListener != null)
        {
            WeiboCallbackManager weibocallbackmanager = WeiboCallbackManager.getInstance(mContext);
            mAuthListenerKey = weibocallbackmanager.genCallbackKey();
            weibocallbackmanager.setWeiboAuthListener(mAuthListenerKey, mAuthListener);
            bundle.putString("key_listener", mAuthListenerKey);
        }
    }

    protected void onSetupRequestParam(Bundle bundle)
    {
        mAppKey = bundle.getString("source");
        mAppPackage = bundle.getString("packagename");
        mHashKey = bundle.getString("key_hash");
        mToken = bundle.getString("access_token");
        mAuthListenerKey = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(mAuthListenerKey))
        {
            mAuthListener = WeiboCallbackManager.getInstance(mContext).getWeiboAuthListener(mAuthListenerKey);
        }
        handleSharedMessage(bundle);
        mUrl = buildUrl("");
    }

    public void sendSdkCancleResponse(Activity activity)
    {
        sendSdkResponse(activity, 1, "send cancel!!!");
    }

    public void sendSdkErrorResponse(Activity activity, String s)
    {
        sendSdkResponse(activity, 2, s);
    }

    public void sendSdkOkResponse(Activity activity)
    {
        sendSdkResponse(activity, 0, "send ok!!!");
    }

    public void setAppKey(String s)
    {
        mAppKey = s;
    }

    public void setAppPackage(String s)
    {
        mAppPackage = s;
    }

    public void setAuthListener(WeiboAuthListener weiboauthlistener)
    {
        mAuthListener = weiboauthlistener;
    }

    public void setBaseRequest(BaseRequest baserequest)
    {
        mBaseRequest = baserequest;
    }

    public void setToken(String s)
    {
        mToken = s;
    }
}
