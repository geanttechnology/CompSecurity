// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;

// Referenced classes of package com.mopub.common:
//            Preconditions, UrlAction, UrlResolutionTask

public class UrlHandler
{
    public static class Builder
    {

        private MoPubSchemeListener moPubSchemeListener;
        private ResultActions resultActions;
        private boolean skipShowMoPubBrowser;
        private EnumSet supportedUrlActions;

        public UrlHandler build()
        {
            return new UrlHandler(supportedUrlActions, resultActions, moPubSchemeListener, skipShowMoPubBrowser);
        }

        public Builder withMoPubSchemeListener(MoPubSchemeListener mopubschemelistener)
        {
            moPubSchemeListener = mopubschemelistener;
            return this;
        }

        public Builder withResultActions(ResultActions resultactions)
        {
            resultActions = resultactions;
            return this;
        }

        public transient Builder withSupportedUrlActions(UrlAction urlaction, UrlAction aurlaction[])
        {
            supportedUrlActions = EnumSet.of(urlaction, aurlaction);
            return this;
        }

        public Builder withSupportedUrlActions(EnumSet enumset)
        {
            supportedUrlActions = EnumSet.copyOf(enumset);
            return this;
        }

        public Builder withoutMoPubBrowser()
        {
            skipShowMoPubBrowser = true;
            return this;
        }

        public Builder()
        {
            supportedUrlActions = EnumSet.of(UrlAction.NOOP);
            resultActions = UrlHandler.EMPTY_CLICK_LISTENER;
            moPubSchemeListener = UrlHandler.EMPTY_MOPUB_SCHEME_LISTENER;
            skipShowMoPubBrowser = false;
        }
    }

    public static interface MoPubSchemeListener
    {

        public abstract void onClose();

        public abstract void onFailLoad();

        public abstract void onFinishLoad();
    }

    public static interface ResultActions
    {

        public abstract void urlHandlingFailed(String s, UrlAction urlaction);

        public abstract void urlHandlingSucceeded(String s, UrlAction urlaction);
    }


    private static final ResultActions EMPTY_CLICK_LISTENER = new ResultActions() {

        public void urlHandlingFailed(String s, UrlAction urlaction)
        {
        }

        public void urlHandlingSucceeded(String s, UrlAction urlaction)
        {
        }

    };
    private static final MoPubSchemeListener EMPTY_MOPUB_SCHEME_LISTENER = new MoPubSchemeListener() {

        public void onClose()
        {
        }

        public void onFailLoad()
        {
        }

        public void onFinishLoad()
        {
        }

    };
    private boolean mAlreadySucceeded;
    private MoPubSchemeListener mMoPubSchemeListener;
    private ResultActions mResultActions;
    private boolean mSkipShowMoPubBrowser;
    private EnumSet mSupportedUrlActions;
    private boolean mTaskPending;

    private UrlHandler(EnumSet enumset, ResultActions resultactions, MoPubSchemeListener mopubschemelistener, boolean flag)
    {
        mSupportedUrlActions = EnumSet.copyOf(enumset);
        mResultActions = resultactions;
        mMoPubSchemeListener = mopubschemelistener;
        mSkipShowMoPubBrowser = flag;
        mAlreadySucceeded = false;
        mTaskPending = false;
    }


    private void failUrlHandling(String s, UrlAction urlaction, String s1, Throwable throwable)
    {
        Preconditions.checkNotNull(s1);
        UrlAction urlaction1 = urlaction;
        if (urlaction == null)
        {
            urlaction1 = UrlAction.NOOP;
        }
        MoPubLog.d(s1, throwable);
        mResultActions.urlHandlingFailed(s, urlaction1);
    }

    MoPubSchemeListener getMoPubSchemeListener()
    {
        return mMoPubSchemeListener;
    }

    ResultActions getResultActions()
    {
        return mResultActions;
    }

    EnumSet getSupportedUrlActions()
    {
        return EnumSet.copyOf(mSupportedUrlActions);
    }

    public boolean handleResolvedUrl(Context context, String s, boolean flag, Iterable iterable)
    {
        Object obj;
        Uri uri;
        Iterator iterator;
        if (TextUtils.isEmpty(s))
        {
            failUrlHandling(s, null, "Attempted to handle empty url.", null);
            return false;
        }
        obj = UrlAction.NOOP;
        uri = Uri.parse(s);
        iterator = mSupportedUrlActions.iterator();
_L2:
        UrlAction urlaction;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        urlaction = (UrlAction)iterator.next();
        if (!urlaction.shouldTryHandlingUrl(uri))
        {
            continue; /* Loop/switch isn't completed */
        }
        urlaction.handleUrl(this, context, uri, flag);
        if (!mAlreadySucceeded && !mTaskPending && !UrlAction.IGNORE_ABOUT_SCHEME.equals(urlaction) && !UrlAction.HANDLE_MOPUB_SCHEME.equals(urlaction))
        {
            TrackingRequest.makeTrackingHttpRequest(iterable, context, com.mopub.common.event.BaseEvent.Name.CLICK_REQUEST);
            mResultActions.urlHandlingSucceeded(uri.toString(), urlaction);
            mAlreadySucceeded = true;
        }
        return true;
        obj;
        MoPubLog.d(((IntentNotResolvableException) (obj)).getMessage(), ((Throwable) (obj)));
        obj = urlaction;
        if (true) goto _L2; else goto _L1
_L1:
        failUrlHandling(s, ((UrlAction) (obj)), (new StringBuilder()).append("Link ignored. Unable to handle url: ").append(s).toString(), null);
        return false;
    }

    public void handleUrl(Context context, String s)
    {
        Preconditions.checkNotNull(context);
        handleUrl(context, s, true);
    }

    public void handleUrl(Context context, String s, boolean flag)
    {
        Preconditions.checkNotNull(context);
        handleUrl(context, s, flag, null);
    }

    public void handleUrl(final Context context, final String destinationUrl, final boolean fromUserInteraction, final Iterable trackingUrls)
    {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(destinationUrl))
        {
            failUrlHandling(destinationUrl, null, "Attempted to handle empty url.", null);
            return;
        } else
        {
            UrlResolutionTask.getResolvedUrl(destinationUrl, new UrlResolutionTask.UrlResolutionListener() {

                final UrlHandler this$0;
                final Context val$context;
                final String val$destinationUrl;
                final boolean val$fromUserInteraction;
                final Iterable val$trackingUrls;

                public void onFailure(String s, Throwable throwable)
                {
                    mTaskPending = false;
                    failUrlHandling(destinationUrl, null, s, throwable);
                }

                public void onSuccess(String s)
                {
                    mTaskPending = false;
                    handleResolvedUrl(context, s, fromUserInteraction, trackingUrls);
                }

            
            {
                this$0 = UrlHandler.this;
                context = context1;
                fromUserInteraction = flag;
                trackingUrls = iterable;
                destinationUrl = s;
                super();
            }
            });
            mTaskPending = true;
            return;
        }
    }

    boolean shouldSkipShowMoPubBrowser()
    {
        return mSkipShowMoPubBrowser;
    }





/*
    static boolean access$302(UrlHandler urlhandler, boolean flag)
    {
        urlhandler.mTaskPending = flag;
        return flag;
    }

*/

}
