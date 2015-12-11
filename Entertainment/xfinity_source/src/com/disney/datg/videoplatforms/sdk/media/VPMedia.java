// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
//            VPMediaMetadata, Configuration, VPGeolocation

public abstract class VPMedia
{
    public static final class AccessWindow extends Enum
    {

        private static final AccessWindow $VALUES[];
        public static final AccessWindow FREE;
        public static final AccessWindow MARKET;
        public static final AccessWindow SUBSCRIPTION;
        public static final AccessWindow UNDEFINED;

        public static AccessWindow valueOf(String s)
        {
            return (AccessWindow)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow, s);
        }

        public static AccessWindow[] values()
        {
            return (AccessWindow[])$VALUES.clone();
        }

        static 
        {
            SUBSCRIPTION = new AccessWindow("SUBSCRIPTION", 0);
            FREE = new AccessWindow("FREE", 1);
            MARKET = new AccessWindow("MARKET", 2);
            UNDEFINED = new AccessWindow("UNDEFINED", 3);
            $VALUES = (new AccessWindow[] {
                SUBSCRIPTION, FREE, MARKET, UNDEFINED
            });
        }

        private AccessWindow(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AssetType extends Enum
    {

        private static final AssetType $VALUES[];
        public static final AssetType MOV;
        public static final AssetType ULNK;
        public static final AssetType UNDEFINED;

        public static AssetType valueOf(String s)
        {
            return (AssetType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType, s);
        }

        public static AssetType[] values()
        {
            return (AssetType[])$VALUES.clone();
        }

        static 
        {
            ULNK = new AssetType("ULNK", 0);
            MOV = new AssetType("MOV", 1);
            UNDEFINED = new AssetType("UNDEFINED", 2);
            $VALUES = (new AssetType[] {
                ULNK, MOV, UNDEFINED
            });
        }

        private AssetType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AuthState extends Enum
    {

        private static final AuthState $VALUES[];
        public static final AuthState AUTHORIZED;
        public static final AuthState NOT_AUTHORIZED;
        public static final AuthState RECEIVED;
        public static final AuthState TIMEOUT;
        public static final AuthState VALIDATE;
        public static final AuthState WAITING;

        public static AuthState valueOf(String s)
        {
            return (AuthState)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState, s);
        }

        public static AuthState[] values()
        {
            return (AuthState[])$VALUES.clone();
        }

        static 
        {
            NOT_AUTHORIZED = new AuthState("NOT_AUTHORIZED", 0);
            WAITING = new AuthState("WAITING", 1);
            RECEIVED = new AuthState("RECEIVED", 2);
            VALIDATE = new AuthState("VALIDATE", 3);
            TIMEOUT = new AuthState("TIMEOUT", 4);
            AUTHORIZED = new AuthState("AUTHORIZED", 5);
            $VALUES = (new AuthState[] {
                NOT_AUTHORIZED, WAITING, RECEIVED, VALIDATE, TIMEOUT, AUTHORIZED
            });
        }

        private AuthState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MediaType extends Enum
    {

        private static final MediaType $VALUES[];
        public static final MediaType LIVE;
        public static final MediaType VOD;
        private String label;
        private String types;

        public static MediaType valueOf(String s)
        {
            return (MediaType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType, s);
        }

        public static MediaType[] values()
        {
            return (MediaType[])$VALUES.clone();
        }

        public String getTypes()
        {
            return types;
        }

        static 
        {
            VOD = new MediaType("VOD", 0, "VOD", "lf,es,mp");
            LIVE = new MediaType("LIVE", 1, "LIVE", "lv");
            $VALUES = (new MediaType[] {
                VOD, LIVE
            });
        }

        private MediaType(String s, int i, String s1, String s2)
        {
            super(s, i);
            label = s1;
            types = s2;
        }
    }

    public static final class ThumbnailType extends Enum
    {

        private static final ThumbnailType $VALUES[];
        public static final ThumbnailType EPISODE;
        public static final ThumbnailType SHOW;

        public static ThumbnailType valueOf(String s)
        {
            return (ThumbnailType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType, s);
        }

        public static ThumbnailType[] values()
        {
            return (ThumbnailType[])$VALUES.clone();
        }

        static 
        {
            SHOW = new ThumbnailType("SHOW", 0);
            EPISODE = new ThumbnailType("EPISODE", 1);
            $VALUES = (new ThumbnailType[] {
                SHOW, EPISODE
            });
        }

        private ThumbnailType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface VPMediaAuthorizationListener
    {

        public abstract void onAuthorizationFailure(VPMedia vpmedia, String s);

        public abstract void onAuthorizationSuccess(VPMedia vpmedia);

        public abstract void onAuthorizationTokenRequest(VPMedia vpmedia);
    }


    public static String LIVE = "LIVE";
    private static String TAG = "VPMedia";
    public static String VOD = "VOD";
    protected AccessWindow accessWindow;
    protected String affiliateId;
    protected String assetUrl;
    protected AuthState authState;
    protected String brandId;
    protected boolean ccEnabled;
    private Configuration configuration;
    protected String contentUrl;
    protected VPMediaMetadata currentMetadata;
    protected Future currentRequest;
    protected String currentToken;
    protected String mediaDesc;
    protected String mediaId;
    protected String mediaRating;
    protected String mediaTitle;
    private VPMediaAuthorizationListener onAuthZListener;
    protected PlayManifest playManifest;
    protected CountDownLatch signal;
    protected Map thumbnails;
    protected VPAuthToken tokenToAuthorize;
    protected String utcOffset;
    protected String workflowId;

    public VPMedia()
    {
        mediaId = "";
        brandId = "";
        contentUrl = "";
        currentToken = "";
        assetUrl = "";
        accessWindow = AccessWindow.UNDEFINED;
        mediaTitle = "";
        mediaDesc = "";
        mediaRating = "";
        affiliateId = "";
        utcOffset = "";
        playManifest = null;
        ccEnabled = false;
        thumbnails = new HashMap();
        authState = AuthState.NOT_AUTHORIZED;
        currentMetadata = new VPMediaMetadata(this);
    }

    private void setAssetUrl(String s)
    {
        assetUrl = s;
    }

    private void setPlayManifest(PlayManifest playmanifest)
    {
        playManifest = playmanifest;
    }

    public void addThumbnail(ThumbnailType thumbnailtype, List list)
    {
        thumbnails.put(thumbnailtype, list);
    }

    public void authorizeMediaWithAuthToken(VPAuthToken vpauthtoken)
    {
        tokenToAuthorize = vpauthtoken;
        authState = AuthState.RECEIVED;
        if (signal != null)
        {
            signal.countDown();
        }
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
    }

    public AccessWindow getAccessWindow()
    {
        return accessWindow;
    }

    public String getAssetUrl()
    {
        if (TextUtils.isEmpty(assetUrl))
        {
            String s;
            String s1;
            if (!TextUtils.isEmpty(getContentUrl()) && authState == AuthState.AUTHORIZED)
            {
                s = getContentUrl();
            } else
            {
                s = "";
            }
            if (!TextUtils.isEmpty(getCurrentToken()) && authState == AuthState.AUTHORIZED)
            {
                s1 = getCurrentToken();
            } else
            {
                s1 = "";
            }
            assetUrl = String.format("%s?%s", new Object[] {
                s, s1
            });
        }
        return assetUrl;
    }

    public String getContentUrl()
    {
        return contentUrl;
    }

    public VPMediaMetadata getCurrentMetadata()
    {
        return currentMetadata;
    }

    public String getCurrentToken()
    {
        return currentToken;
    }

    public String getMediaDesc()
    {
        return mediaDesc;
    }

    public String getMediaId()
    {
        return mediaId;
    }

    public String getMediaTitle()
    {
        return mediaTitle;
    }

    public abstract MediaType getMediaType();

    public VPMediaAuthorizationListener getOnAuthorizationListener()
    {
        return onAuthZListener;
    }

    public PlayManifest getPlayManifest()
    {
        return playManifest;
    }

    public Future getPlayableAssetUrl(final AsyncHandler asyncHandler)
    {
        currentRequest = ThreadPoolAccessor.getManager().execute(new Callable() {

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
                if (asyncHandler != null)
                {
                    asyncHandler.onAsyncTask();
                }
                if (configuration == null)
                {
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - configuration was not set up correctly");
                }
                if (configuration.getCurrentConfig() == null)
                {
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - config was never called");
                }
                if (accessWindow != AccessWindow.SUBSCRIPTION)
                {
                    break MISSING_BLOCK_LABEL_265;
                }
                authState = AuthState.WAITING;
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
                        authState = AuthState.NOT_AUTHORIZED;
                        AndroidSDKException androidsdkexception = new AndroidSDKException(ErrorCode.ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION, "invalid VPAuthToken");
                        if (asyncHandler != null)
                        {
                            asyncHandler.onError(androidsdkexception);
                        }
                        throw androidsdkexception;
                    }
                    catch (Exception exception)
                    {
                        if (asyncHandler != null)
                        {
                            asyncHandler.onError(exception);
                        }
                        throw exception;
                    }
                }
                authState = AuthState.TIMEOUT;
                AndroidSDKException androidsdkexception1 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_TIMEOUT_EXCEPTION, "timeout occurred while waiting for AuthToken");
                if (asyncHandler != null)
                {
                    asyncHandler.onError(androidsdkexception1);
                }
                throw androidsdkexception1;
                Object obj;
                obj = configuration.getCurrentConfig().getURLFromWebServiceName("entitlement-manifest");
                if (TextUtils.isEmpty(((CharSequence) (obj))) && asyncHandler != null)
                {
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST, "entitlement url could not be resolved from Config");
                    asyncHandler.onError(((Exception) (obj)));
                    throw obj;
                }
                LinkedMultiValueMap linkedmultivaluemap = new LinkedMultiValueMap() {

                    final _cls1 this$1;

            
                throws AndroidSDKException
            {
                this$1 = _cls1.this;
                super();
                if (accessWindow == AccessWindow.SUBSCRIPTION && tokenToAuthorize != null)
                {
                    setAll(tokenToAuthorize.getTokenParameters());
                }
                add("brand", configuration.getCurrentNetwork());
                add("device", configuration.getCurrentPartnerCode());
                add("video_id", getMediaId());
                add("video_type", getMediaType().getTypes());
                add("affiliate", affiliateId);
                add("mvpd", configuration.getCurrentPartnerName());
                _pcls1 = VPGeolocation.getGeolocationManager().getCurrentGeolocation();
                if (_cls1.this != null && getUser() != null && getUser().getZipCode() != null)
                {
                    add("latitude", "1");
                    add("longitude", "1");
                    add("zipcode", getUser().getZipCode());
                }
            }
                };
                authState = AuthState.VALIDATE;
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
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(((Exception) (obj)));
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, ((Throwable) (obj)));
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(((Exception) (obj)));
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            obj = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, ((Throwable) (obj)));
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(((Exception) (obj)));
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, ((AndroidSDKException) (obj)).getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
                        }
                        catch (TimeoutException timeoutexception)
                        {
                            AndroidSDKException androidsdkexception2 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_TIMEOUT_EXCEPTION, timeoutexception);
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(androidsdkexception2);
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception2.getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
                        }
                        catch (AndroidSDKException androidsdkexception3)
                        {
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(androidsdkexception3);
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception3.getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
                        }
                        catch (Exception exception1)
                        {
                            AndroidSDKException androidsdkexception4 = new AndroidSDKException(ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION, exception1);
                            if (asyncHandler != null)
                            {
                                asyncHandler.onError(androidsdkexception4);
                            }
                            if (getOnAuthorizationListener() != null)
                            {
                                getOnAuthorizationListener().onAuthorizationFailure(VPMedia.this, androidsdkexception4.getErrorCode().getReason());
                            }
                            authState = AuthState.NOT_AUTHORIZED;
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
                authState = AuthState.NOT_AUTHORIZED;
                if (asyncHandler != null)
                {
                    asyncHandler.onError(((Exception) (obj)));
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
                LogUtils.LOGD(VPMedia.TAG, "getVideo()");
                obj1 = (Asset)((PlayManifest) (obj)).getVideo().getAssets().getAsset().get(0);
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_989;
                }
                if (!TextUtils.isEmpty(((Asset) (obj1)).getValue()))
                {
                    LogUtils.LOGD(VPMedia.TAG, "videoAsset");
                    authState = AuthState.AUTHORIZED;
                    LogUtils.LOGD(VPMedia.TAG, (new StringBuilder()).append("videoAsset.getValue() ").append(((Asset) (obj1)).getValue()).toString());
                    setAssetUrl(((Asset) (obj1)).getValue());
                }
                if (((PlayManifest) (obj)).getChannel() == null || ((PlayManifest) (obj)).getChannel().getAssets() == null || ((PlayManifest) (obj)).getChannel().getAssets().getAsset() == null || ((PlayManifest) (obj)).getChannel().getAssets().getAsset().size() <= 0)
                {
                    break MISSING_BLOCK_LABEL_1135;
                }
                LogUtils.LOGD(VPMedia.TAG, "getChannel()");
                obj1 = (Asset)((PlayManifest) (obj)).getChannel().getAssets().getAsset().get(0);
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_1135;
                }
                if (!TextUtils.isEmpty(((Asset) (obj1)).getValue()))
                {
                    LogUtils.LOGD(VPMedia.TAG, "channelAsset");
                    authState = AuthState.AUTHORIZED;
                    LogUtils.LOGD(VPMedia.TAG, (new StringBuilder()).append("channelAsset.getValue() ").append(((Asset) (obj1)).getValue()).toString());
                    setAssetUrl(((Asset) (obj1)).getValue());
                }
                setPlayManifest(((PlayManifest) (obj)));
                if (asyncHandler != null)
                {
                    asyncHandler.onSuccess(getAssetUrl());
                }
                if (getOnAuthorizationListener() != null)
                {
                    getOnAuthorizationListener().onAuthorizationSuccess(VPMedia.this);
                }
                break MISSING_BLOCK_LABEL_458;
            }

            
            {
                this$0 = VPMedia.this;
                asyncHandler = asynchandler;
                super();
            }
        });
        return currentRequest;
    }

    public void setAccessWindow(int i)
    {
        switch (i)
        {
        default:
            accessWindow = AccessWindow.UNDEFINED;
            authState = AuthState.NOT_AUTHORIZED;
            return;

        case 0: // '\0'
            accessWindow = AccessWindow.FREE;
            authState = AuthState.AUTHORIZED;
            return;

        case 1: // '\001'
            accessWindow = AccessWindow.SUBSCRIPTION;
            authState = AuthState.NOT_AUTHORIZED;
            return;

        case 2: // '\002'
            accessWindow = AccessWindow.MARKET;
            break;
        }
        authState = AuthState.AUTHORIZED;
    }

    public void setAffiliateId(String s)
    {
        affiliateId = s;
    }

    protected void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
        if (configuration != null)
        {
            brandId = configuration.getCurrentNetwork();
        }
    }

    public void setContentUrl(String s)
    {
        contentUrl = s;
    }

    public void setMediaDesc(String s)
    {
        mediaDesc = s;
    }

    public void setMediaId(String s)
    {
        mediaId = s;
    }

    public void setMediaRating(String s)
    {
        mediaRating = s;
    }

    public void setMediaTitle(String s)
    {
        mediaTitle = s;
    }

    public void setOnAuthorizationListener(VPMediaAuthorizationListener vpmediaauthorizationlistener)
    {
        onAuthZListener = vpmediaauthorizationlistener;
    }

    public void setWorkflowId(String s)
    {
        workflowId = s;
    }





}
