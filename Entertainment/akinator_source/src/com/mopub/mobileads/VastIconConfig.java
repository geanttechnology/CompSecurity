// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            VastResource

class VastIconConfig
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final String mClickThroughUri;
    private final List mClickTrackingUris;
    private final Integer mDurationMS;
    private final int mHeight;
    private final int mOffsetMS;
    private final VastResource mVastResource;
    private final List mViewTrackingUris;
    private final int mWidth;

    VastIconConfig(int i, int j, Integer integer, Integer integer1, VastResource vastresource, List list, String s, 
            List list1)
    {
        Preconditions.checkNotNull(vastresource);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list1);
        mWidth = i;
        mHeight = j;
        if (integer == null)
        {
            i = 0;
        } else
        {
            i = integer.intValue();
        }
        mOffsetMS = i;
        mDurationMS = integer1;
        mVastResource = vastresource;
        mClickTrackingUris = list;
        mClickThroughUri = s;
        mViewTrackingUris = list1;
    }

    String getClickThroughUri()
    {
        return mClickThroughUri;
    }

    List getClickTrackingUris()
    {
        return mClickTrackingUris;
    }

    Integer getDurationMS()
    {
        return mDurationMS;
    }

    int getHeight()
    {
        return mHeight;
    }

    int getOffsetMS()
    {
        return mOffsetMS;
    }

    VastResource getVastResource()
    {
        return mVastResource;
    }

    List getViewTrackingUris()
    {
        return mViewTrackingUris;
    }

    int getWidth()
    {
        return mWidth;
    }

    void handleClick(final Context context, String s)
    {
        Preconditions.checkNotNull(context);
        s = mVastResource.getCorrectClickThroughUrl(mClickThroughUri, s);
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER
            }).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

                final VastIconConfig this$0;
                final Context val$context;

                public void urlHandlingFailed(String s1, UrlAction urlaction)
                {
                }

                public void urlHandlingSucceeded(String s1, UrlAction urlaction)
                {
                    if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
                    {
                        break MISSING_BLOCK_LABEL_41;
                    }
                    urlaction = new Bundle();
                    urlaction.putString("URL", s1);
                    s1 = Intents.getStartActivityIntent(context, com/mopub/common/MoPubBrowser, urlaction);
                    Intents.startActivity(context, s1);
                    return;
                    s1;
                    MoPubLog.d(s1.getMessage());
                    return;
                }

            
            {
                this$0 = VastIconConfig.this;
                context = context1;
                super();
            }
            }).withoutMoPubBrowser().build().handleUrl(context, s);
            return;
        }
    }

    void handleImpression(Context context, int i, String s)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(s);
        TrackingRequest.makeVastTrackingHttpRequest(mViewTrackingUris, null, Integer.valueOf(i), s, context);
    }
}
