// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.VPCatalog;
import com.disney.datg.videoplatforms.sdk.models.api.Channels;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.service.ChannelsAccessor;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPCatalogManager, Configuration

class val.affiliate
    implements Callable
{

    final VPCatalogManager this$0;
    final String val$affiliate;
    final AsyncHandler val$asyncHandler;

    public VPCatalog call()
        throws Exception
    {
        Object obj;
        VPCatalog vpcatalog;
        obj = VPCatalogManager.access$000(VPCatalogManager.this).getCurrentConfig().getURLFromWebServiceName("channels");
        if (TextUtils.isEmpty(((CharSequence) (obj))) && val$asyncHandler != null)
        {
            obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST, "partner channels url could not be resolved from Config");
            if (val$asyncHandler != null)
            {
                val$asyncHandler.onError(((Exception) (obj)));
            }
            throw obj;
        }
        if (!TextUtils.isEmpty(val$affiliate))
        {
            obj = ((String) (obj)).replace("%AFFILIATE%", val$affiliate);
        } else
        {
            obj = ((String) (obj)).replace("%AFFILIATE%", "-1");
        }
        vpcatalog = new VPCatalog();
        obj = new ChannelsAccessor(((String) (obj)), null);
        obj = (ResponseEntity)((ChannelsAccessor) (obj)).getServiceAsync().get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
        if (obj != null) goto _L2; else goto _L1
_L1:
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR);
        obj;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj))));
        }
_L4:
        return vpcatalog;
_L2:
        obj = (Channels)((ResponseEntity) (obj)).getBody();
        if (((Channels) (obj)).getChannel() == null || ((Channels) (obj)).getChannel().size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        vpcatalog.setCollection(VPCatalogManager.access$200(VPCatalogManager.this, ((Channels) (obj)).getChannel(), val$affiliate), com.disney.datg.videoplatforms.sdk.models.pe.CHANNEL);
        if (val$asyncHandler == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        val$asyncHandler.onSuccess(vpcatalog);
        return vpcatalog;
        Object obj1;
        obj1;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
            return vpcatalog;
        }
        continue; /* Loop/switch isn't completed */
        if (val$asyncHandler == null) goto _L4; else goto _L3
_L3:
        val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, "Channel is invalid or does not exist for partner"));
        return vpcatalog;
        obj1;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
            return vpcatalog;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT, ((Throwable) (obj1))));
            return vpcatalog;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(((Exception) (obj1)));
            return vpcatalog;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_CHANNELS_SERVICE_ERROR, ((Throwable) (obj1))));
            return vpcatalog;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_vpcatalogmanager;
        val$asyncHandler = asynchandler;
        val$affiliate = String.this;
        super();
    }
}
