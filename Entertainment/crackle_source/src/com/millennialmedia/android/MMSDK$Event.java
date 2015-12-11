// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, MMAdImpl, MMException, HttpGetRequest, 
//            RequestListener

static class _cls5.val.error
{

    public static final String INTENT_EMAIL = "email";
    public static final String INTENT_EXTERNAL_BROWSER = "browser";
    public static final String INTENT_MAPS = "geo";
    public static final String INTENT_MARKET = "market";
    public static final String INTENT_PHONE_CALL = "tel";
    public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
    public static final String INTENT_TXT_MESSAGE = "sms";
    private static final String KEY_ERROR = "error";
    static final String KEY_INTENT_TYPE = "intentType";
    static final String KEY_INTERNAL_ID = "internalId";
    static final String KEY_PACKAGE_NAME = "packageName";

    static void displayStarted(MMAdImpl mmadimpl)
    {
        if (MMSDK.access$000())
        {
            sendIntent(mmadimpl.getContext(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), mmadimpl.internalId);
        }
        overlayOpened(mmadimpl);
    }

    static void fetchStartedCaching(MMAdImpl mmadimpl)
    {
        MMSDK.runOnUiThread(new Runnable(mmadimpl) {

            final MMAdImpl val$adImpl;

            public void run()
            {
                if (adImpl == null || adImpl.requestListener == null)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
                adImpl.requestListener.MMAdRequestIsCaching(adImpl.getCallingAd());
                return;
                Exception exception;
                exception;
                MMSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] {
                    exception
                });
                return;
            }

            
            {
                adImpl = mmadimpl;
                super();
            }
        });
        if (MMSDK.access$000())
        {
            sendIntent(mmadimpl.getContext(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), mmadimpl.internalId);
        }
    }

    static void intentStarted(Context context, String s, long l)
    {
        if (MMSDK.access$000() && s != null)
        {
            sendIntent(context, (new Intent("millennialmedia.action.ACTION_INTENT_STARTED")).putExtra("intentType", s), l);
        }
    }

    protected static void logEvent(String s)
    {
        sendIntent("Logging event to: %s", new Object[] {
            s
        });
        Utils.execute(new Runnable(s) {

            final String val$logString;

            public void run()
            {
                HttpGetRequest httpgetrequest = new HttpGetRequest();
                try
                {
                    httpgetrequest.get(logString);
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            
            {
                logString = s;
                super();
            }
        });
    }

    static void overlayClosed(Context context, long l)
    {
        if (MMSDK.access$000() && context != null)
        {
            sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), l);
        }
    }

    static void overlayOpened(MMAdImpl mmadimpl)
    {
        MMSDK.runOnUiThread(new Runnable(mmadimpl) {

            final MMAdImpl val$adImpl;

            public void run()
            {
                if (adImpl == null || adImpl.requestListener == null)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
                adImpl.requestListener.MMAdOverlayLaunched(adImpl.getCallingAd());
                return;
                Exception exception;
                exception;
                MMSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] {
                    exception
                });
                return;
            }

            
            {
                adImpl = mmadimpl;
                super();
            }
        });
        overlayOpenedBroadCast(mmadimpl.getContext(), mmadimpl.internalId);
    }

    static void overlayOpenedBroadCast(Context context, long l)
    {
        if (MMSDK.access$000())
        {
            sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), l);
        }
    }

    static void overlayTap(Context context, long l)
    {
        if (MMSDK.access$000())
        {
            sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), l);
        }
    }

    static void requestCompleted(MMAdImpl mmadimpl)
    {
        MMSDK.runOnUiThread(new Runnable(mmadimpl) {

            final MMAdImpl val$adImpl;

            public void run()
            {
                if (adImpl == null || adImpl.requestListener == null)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
                adImpl.requestListener.requestCompleted(adImpl.getCallingAd());
                return;
                Exception exception;
                exception;
                MMSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] {
                    exception
                });
                return;
            }

            
            {
                adImpl = mmadimpl;
                super();
            }
        });
        if (MMSDK.access$000())
        {
            String s = mmadimpl.getRequestCompletedAction();
            sendIntent(mmadimpl.getContext(), new Intent(s), mmadimpl.internalId);
        }
    }

    static void requestFailed(MMAdImpl mmadimpl, MMException mmexception)
    {
        MMSDK.runOnUiThread(new Runnable(mmadimpl, mmexception) {

            final MMAdImpl val$adImpl;
            final MMException val$error;

            public void run()
            {
                if (adImpl == null || adImpl.requestListener == null)
                {
                    break MISSING_BLOCK_LABEL_40;
                }
                adImpl.requestListener.requestFailed(adImpl.getCallingAd(), error);
                return;
                Exception exception;
                exception;
                MMSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] {
                    exception
                });
                return;
            }

            
            {
                adImpl = mmadimpl;
                error = mmexception;
                super();
            }
        });
        if (MMSDK.access$000())
        {
            String s = mmadimpl.getRequestFailedAction();
            sendIntent(mmadimpl.getContext(), (new Intent(s)).putExtra("error", mmexception), mmadimpl.internalId);
        }
    }

    private static final void sendIntent(Context context, Intent intent, long l)
    {
        if (context != null)
        {
            intent.addCategory("millennialmedia.category.CATEGORY_SDK");
            if (l != -4L)
            {
                intent.putExtra("internalId", l);
            }
            intent.putExtra("packageName", context.getPackageName());
            String s = intent.getStringExtra("intentType");
            if (!TextUtils.isEmpty(s))
            {
                s = String.format(" Type[%s]", new Object[] {
                    s
                });
            } else
            {
                s = "";
            }
            ernalId((new StringBuilder()).append(" @@ Intent: ").append(intent.getAction()).append(" ").append(s).append(" for ").append(l).toString());
            context.sendBroadcast(intent);
        }
    }

    _cls5.val.error()
    {
    }
}
