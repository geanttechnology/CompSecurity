// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            VastResource

public class VastCompanionAdConfig
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final String mClickThroughUrl;
    private final List mClickTrackers;
    private final List mCreativeViewTrackers;
    private final int mHeight;
    private final VastResource mVastResource;
    private final int mWidth;

    public VastCompanionAdConfig(int i, int j, VastResource vastresource, String s, List list, List list1)
    {
        Preconditions.checkNotNull(vastresource);
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        Preconditions.checkNotNull(list1, "creativeViewTrackers cannot be null");
        mWidth = i;
        mHeight = j;
        mVastResource = vastresource;
        mClickThroughUrl = s;
        mClickTrackers = list;
        mCreativeViewTrackers = list1;
    }

    public void addClickTrackers(List list)
    {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        mClickTrackers.addAll(list);
    }

    public void addCreativeViewTrackers(List list)
    {
        Preconditions.checkNotNull(list, "creativeViewTrackers cannot be null");
        mCreativeViewTrackers.addAll(list);
    }

    public String getClickThroughUrl()
    {
        return mClickThroughUrl;
    }

    public List getClickTrackers()
    {
        return mClickTrackers;
    }

    public List getCreativeViewTrackers()
    {
        return mCreativeViewTrackers;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public VastResource getVastResource()
    {
        return mVastResource;
    }

    public int getWidth()
    {
        return mWidth;
    }

    void handleClick(final Context context, final int requestCode, String s)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(context instanceof Activity, "context must be an activity");
        s = mVastResource.getCorrectClickThroughUrl(mClickThroughUrl, s);
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
            }).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

                final VastCompanionAdConfig this$0;
                final Context val$context;
                final int val$requestCode;

                public void urlHandlingFailed(String s1, UrlAction urlaction)
                {
                }

                public void urlHandlingSucceeded(String s1, UrlAction urlaction)
                {
                    if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
                    {
                        break MISSING_BLOCK_LABEL_48;
                    }
                    urlaction = new Bundle();
                    urlaction.putString("URL", s1);
                    s1 = Intents.getStartActivityIntent(context, com/mopub/common/MoPubBrowser, urlaction);
                    ((Activity)context).startActivityForResult(s1, requestCode);
                    return;
                    s1;
                    MoPubLog.d((new StringBuilder()).append("Activity ").append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you ").append("declare it in your AndroidManifest.xml?").toString());
                    return;
                }

            
            {
                this$0 = VastCompanionAdConfig.this;
                context = context1;
                requestCode = i;
                super();
            }
            }).withoutMoPubBrowser().build().handleUrl(context, s);
            return;
        }
    }

    void handleImpression(Context context, int i)
    {
        Preconditions.checkNotNull(context);
        TrackingRequest.makeVastTrackingHttpRequest(mCreativeViewTrackers, null, Integer.valueOf(i), null, context);
    }
}
