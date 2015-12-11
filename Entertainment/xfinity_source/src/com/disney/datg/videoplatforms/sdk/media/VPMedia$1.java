// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.VPAuthToken;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Asset;
import com.disney.datg.videoplatforms.sdk.models.api.Assets;
import com.disney.datg.videoplatforms.sdk.models.api.Channel;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.ErrorData;
import com.disney.datg.videoplatforms.sdk.models.api.ErrorMessage;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.models.api.PlayManifest;
import com.disney.datg.videoplatforms.sdk.models.api.ResponseMessage;
import com.disney.datg.videoplatforms.sdk.models.api.User;
import com.disney.datg.videoplatforms.sdk.models.api.Video;
import com.disney.datg.videoplatforms.sdk.service.PlayManifestAccessor;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia, Configuration, VPGeolocation

class ler
    implements Callable
{

    final VPMedia this$0;
    final AsyncHandler val$asyncHandler;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String call()
        throws Exception
    {
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onAsyncTask();
        }
        if (VPMedia.access$000(VPMedia.this) == null)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - configuration was not set up correctly");
        }
        if (VPMedia.access$000(VPMedia.this).getCurrentConfig() == null)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - config was never called");
        }
        if (accessWindow != cessWindow.SUBSCRIPTION)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        authState = thState.WAITING;
        boolean flag;
        signal = new CountDownLatch(1);
        if (getOnAuthorizationListener() != null)
        {
            getOnAuthorizationListener().onAuthorizationTokenRequest(VPMedia.this);
        }
        flag = signal.await(Configuration.AUTHZ_TIMEOUT, TimeUnit.SECONDS);
        if (tokenToAuthorize != null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        if (flag)
        {
            try
            {
                authState = thState.NOT_AUTHORIZED;
                AndroidSDKException androidsdkexception = new AndroidSDKException(ErrorCode.ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION, "invalid VPAuthToken");
                if (val$asyncHandler != null)
                {
                    val$asyncHandler.onError(androidsdkexception);
                }
                throw androidsdkexception;
            }
            catch (Exception exception)
            {
                if (val$asyncHandler != null)
                {
                    val$asyncHandler.onError(exception);
                }
                throw exception;
            }
        }
        authState = thState.TIMEOUT;
        AndroidSDKException androidsdkexception1 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_TIMEOUT_EXCEPTION, "timeout occurred while waiting for AuthToken");
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(androidsdkexception1);
        }
        throw androidsdkexception1;
        Object obj;
        obj = VPMedia.access$000(VPMedia.this).getCurrentConfig().getURLFromWebServiceName("entitlement-manifest");
        if (TextUtils.isEmpty(((CharSequence) (obj))) && val$asyncHandler != null)
        {
            obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST, "entitlement url could not be resolved from Config");
            val$asyncHandler.onError(((Exception) (obj)));
            throw obj;
        }
        LinkedMultiValueMap linkedmultivaluemap = new LinkedMultiValueMap() {

            final VPMedia._cls1 this$1;

            
                throws AndroidSDKException
            {
                this$1 = VPMedia._cls1.this;
                super();
                if (accessWindow == VPMedia.AccessWindow.SUBSCRIPTION && tokenToAuthorize != null)
                {
                    setAll(tokenToAuthorize.getTokenParameters());
                }
                add("brand", VPMedia.access$000(this$0).getCurrentNetwork());
                add("device", VPMedia.access$000(this$0).getCurrentPartnerCode());
                add("video_id", getMediaId());
                add("video_type", getMediaType().getTypes());
                add("affiliate", affiliateId);
                add("mvpd", VPMedia.access$000(this$0).getCurrentPartnerName());
                _pcls1 = VPGeolocation.getGeolocationManager().getCurrentGeolocation();
                if (VPMedia._cls1.this != null && getUser() != null && getUser().getZipCode() != null)
                {
                    add("latitude", "1");
                    add("longitude", "1");
                    add("zipcode", getUser().getZipCode());
                }
            }
        };
        authState = thState.VALIDATE;
        obj = new PlayManifestAccessor(((String) (obj)), linkedmultivaluemap, null);
        obj = (ResponseEntity)((PlayManifestAccessor) (obj)).getServiceAsync().get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
label0:
        {
            {
                if (obj != null)
                {
                    break label0;
                }
                Object obj1;
                try
                {
                    throw new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, ((Throwable) (obj)));
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(((Exception) (obj)));
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, ((Throwable) (obj)));
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(((Exception) (obj)));
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, ((Throwable) (obj)));
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(((Exception) (obj)));
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
                catch (TimeoutException timeoutexception)
                {
                    AndroidSDKException androidsdkexception2 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_TIMEOUT_EXCEPTION, timeoutexception);
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(androidsdkexception2);
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception2.getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
                catch (AndroidSDKException androidsdkexception3)
                {
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(androidsdkexception3);
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception3.getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
                catch (Exception exception1)
                {
                    AndroidSDKException androidsdkexception4 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, exception1);
                    if (val$asyncHandler != null)
                    {
                        val$asyncHandler.onError(androidsdkexception4);
                    }
                    if (getOnAuthorizationListener() != null)
                    {
                        getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception4.getErrorCode().getReason());
                    }
                    authState = thState.NOT_AUTHORIZED;
                }
            }
            tokenToAuthorize = null;
            return getAssetUrl();
        }
        obj = (PlayManifest)((ResponseEntity) (obj)).getBody();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        obj1 = ((PlayManifest) (obj)).getEntitlmentResponse();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        if (((ResponseMessage) (obj1)).getErrors() == null)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        obj1 = ((ResponseMessage) (obj1)).getErrors();
        obj = new StringBuffer();
        for (obj1 = ((ErrorData) (obj1)).getErrors().iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuffer) (obj)).append(Integer.toString(((ErrorMessage)((Iterator) (obj1)).next()).getCode())).append(",")) { }
        if (((StringBuffer) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_836;
        }
        obj = ((StringBuffer) (obj)).substring(0, ((StringBuffer) (obj)).length() - 1);
_L2:
        obj = ((String) (obj)).toString();
        obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, String.format("%s-errorCodes:%s", new Object[] {
            ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION.toString(), obj
        }));
        authState = thState.NOT_AUTHORIZED;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(((Exception) (obj)));
        }
        if (getOnAuthorizationListener() != null)
        {
            getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
        }
        break MISSING_BLOCK_LABEL_458;
        obj = "";
        if (true) goto _L2; else goto _L1
_L1:
        if (((PlayManifest) (obj)).getVideo() == null || ((PlayManifest) (obj)).getVideo().getAssets() == null || ((PlayManifest) (obj)).getVideo().getAssets().getAsset() == null || ((PlayManifest) (obj)).getVideo().getAssets().getAsset().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_989;
        }
        LogUtils.LOGD(VPMedia.access$100(), "getVideo()");
        obj1 = (Asset)((PlayManifest) (obj)).getVideo().getAssets().getAsset().get(0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_989;
        }
        if (!TextUtils.isEmpty(((Asset) (obj1)).getValue()))
        {
            LogUtils.LOGD(VPMedia.access$100(), "videoAsset");
            authState = thState.AUTHORIZED;
            LogUtils.LOGD(VPMedia.access$100(), (new StringBuilder()).append("videoAsset.getValue() ").append(((Asset) (obj1)).getValue()).toString());
            VPMedia.access$200(VPMedia.this, ((Asset) (obj1)).getValue());
        }
        if (((PlayManifest) (obj)).getChannel() == null || ((PlayManifest) (obj)).getChannel().getAssets() == null || ((PlayManifest) (obj)).getChannel().getAssets().getAsset() == null || ((PlayManifest) (obj)).getChannel().getAssets().getAsset().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1135;
        }
        LogUtils.LOGD(VPMedia.access$100(), "getChannel()");
        obj1 = (Asset)((PlayManifest) (obj)).getChannel().getAssets().getAsset().get(0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1135;
        }
        if (!TextUtils.isEmpty(((Asset) (obj1)).getValue()))
        {
            LogUtils.LOGD(VPMedia.access$100(), "channelAsset");
            authState = thState.AUTHORIZED;
            LogUtils.LOGD(VPMedia.access$100(), (new StringBuilder()).append("channelAsset.getValue() ").append(((Asset) (obj1)).getValue()).toString());
            VPMedia.access$200(VPMedia.this, ((Asset) (obj1)).getValue());
        }
        VPMedia.access$300(VPMedia.this, ((PlayManifest) (obj)));
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onSuccess(getAssetUrl());
        }
        if (getOnAuthorizationListener() != null)
        {
            getOnAuthorizationListener().onAuthorizationSuccess(VPMedia.this);
        }
        break MISSING_BLOCK_LABEL_458;
    }

    ler()
    {
        this$0 = final_vpmedia;
        val$asyncHandler = AsyncHandler.this;
        super();
    }
}
