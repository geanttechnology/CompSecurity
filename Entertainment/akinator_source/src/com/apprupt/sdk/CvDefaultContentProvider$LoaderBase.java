// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.apprupt.sdk:
//            CvDefaultContentProvider, CvContentOptions, URLRequest, CvUnderscore, 
//            CvAudience

private abstract class context
    implements context
{

    protected boolean canceled;
    protected final Context context;
    protected final Handler handler = new Handler();
    protected final CvContentOptions options;
    final CvDefaultContentProvider this$0;

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        canceled = true;
        onCanceled();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void error(String s, Exception exception, int i)
    {
        CvDefaultContentProvider.access$000().onCanceled(exception, new Object[] {
            "Error while loading content:", s
        });
        onError(s, exception, i);
        cancel();
    }

    abstract String getUri();

    void handleResponse(cancel cancel1)
    {
        CvDefaultContentProvider.access$000().cancel(new Object[] {
            "URLResponse:", Boolean.valueOf(cancel1.cancel), Integer.valueOf(cancel1.cancel), cancel1.cancel
        });
        if (!cancel1.cancel) goto _L2; else goto _L1
_L1:
        CvDefaultContentProvider.access$000().cancel(new Object[] {
            "URLResponse with error", Integer.valueOf(cancel1.cancel), cancel1.cancel
        });
        error(cancel1.error, cancel1.error, cancel1.error);
_L4:
        return;
_L2:
        if (!parseContent(cancel1.parseContent)) goto _L4; else goto _L3
_L3:
        CvDefaultContentProvider.access$000().parseContent(new Object[] {
            "URLResponse content parsed"
        });
        onComplete();
        return;
        Exception exception;
        exception;
        CvDefaultContentProvider.access$000().onComplete(new Object[] {
            "URLResponse data is not parsable", cancel1.onComplete
        });
        error("Cannot parse content", exception, -2);
        return;
    }

    void load(String s)
    {
        CvDefaultContentProvider.access$000().error(new Object[] {
            "Building request /", options.adSpaceId
        });
        URLRequest urlrequest = URLRequest.post(getUri()).addPostParam("_", CvUnderscore.create().extend(CvAudience.getInstance().getJSON()).toString());
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
    /* block-local class not found */
    class _cls2 {}

        urlrequest.addPostParam("pyld", s1).addPostParam("sdkVersion", "android_4.0.4").setListener(new _cls2()).send();
    }

    abstract void onCanceled();

    abstract void onComplete();

    abstract void onError(String s, Exception exception, int i);

    abstract boolean parseContent(String s)
        throws Exception;

    _cls2 run()
    {
    /* block-local class not found */
    class _cls1 {}

        (new Handler(Looper.getMainLooper())).post(new _cls1());
        return this;
    }

    _cls1(Context context1, CvContentOptions cvcontentoptions)
    {
        this$0 = CvDefaultContentProvider.this;
        super();
        canceled = false;
        options = cvcontentoptions;
        context = context1;
    }
}
