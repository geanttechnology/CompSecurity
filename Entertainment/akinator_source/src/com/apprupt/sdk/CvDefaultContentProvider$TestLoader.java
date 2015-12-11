// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import java.util.Calendar;

// Referenced classes of package com.apprupt.sdk:
//            CvDefaultContentProvider, CvContentOptions, CvFeaturesList, CvSDK, 
//            CvUrl, CvPreloaderResponse

private class listener extends listener
{

    private boolean hasAds;
    private hasAds listener;
    final CvDefaultContentProvider this$0;

    private void callListener(CvPreloaderResponse cvpreloaderresponse, listener listener1)
    {
        this;
        JVM INSTR monitorenter ;
        if (listener1 == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        listener1.nPreloaderFinish(cvpreloaderresponse);
        cancel();
        this;
        JVM INSTR monitorexit ;
        return;
        cvpreloaderresponse;
        throw cvpreloaderresponse;
    }

    String getUri()
    {
        String s1 = options.adSpaceId;
        String s2 = CvFeaturesList.urlHex(context);
        String s3 = CvSDK.getPiKey();
        String s4 = options.categories;
        String s5 = options.keywords;
        long l = Calendar.getInstance().getTimeInMillis();
        String s;
        if (options.interstitial)
        {
            s = "&interstitial=1";
        } else
        {
            s = "";
        }
        return CvUrl.build(String.format("/AdsAvailable/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s", new Object[] {
            s1, "6", s2, s3, s4, s5, Long.valueOf(l), s
        }));
    }

    void onCanceled()
    {
        this;
        JVM INSTR monitorenter ;
        listener = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void onComplete()
    {
    /* block-local class not found */
    class _cls2 {}

        CvPreloaderResponse cvpreloaderresponse;
        listener listener1;
        if (hasAds)
        {
            cvpreloaderresponse = new CvPreloaderResponse();
        } else
        {
            cvpreloaderresponse = new CvPreloaderResponse("Ad space is empty", 0);
        }
        listener1 = listener;
        handler.post(new _cls2(cvpreloaderresponse, listener1));
    }

    void onError(String s, Exception exception, int i)
    {
        s = new CvPreloaderResponse(s, i);
        exception = listener;
    /* block-local class not found */
    class _cls1 {}

        handler.post(new _cls1(s, exception));
    }

    boolean parseContent(String s)
        throws Exception
    {
        boolean flag;
        if (s != null && s.trim().equals("1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasAds = flag;
        return true;
    }


    _cls1(Context context, CvContentOptions cvcontentoptions, _cls1 _pcls1)
    {
        this$0 = CvDefaultContentProvider.this;
        super(CvDefaultContentProvider.this, context, cvcontentoptions);
        listener = null;
        hasAds = false;
        listener = _pcls1;
    }
}
