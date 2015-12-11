// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import com.apprupt.sdk.mediation.AdWrapper;
import com.apprupt.sdk.mediation.Adapter;
import com.apprupt.sdk.mediation.Mediator;
import com.apprupt.sdk.mediation.Size;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvAdType, CvMediator, CvContentOptions, 
//            Q, CvSDK, CvContentManager, SimpleJSON

public abstract class CvAdWrapper
    implements AdWrapper
{

    private volatile String adContent;
    private volatile Size adSize;
    private volatile CvAdType adType;
    private final Adapter adapter;
    private volatile long closeButtonTimeout;
    private volatile String errorMessage;
    private volatile String fallbackType;
    private final boolean isValueExchane;
    protected Logger.log log;
    private CvMediator mediator;
    private Q.Task processContent;
    private Q.Task processSize;
    private Q.Task processType;
    private Q.Task readCloseButtonTimeout;

    CvAdWrapper(Adapter adapter1, CvMediator cvmediator)
    {
        log = Logger.get(getClass().getName());
        errorMessage = null;
        fallbackType = null;
        adSize = new Size(320, 50);
        adType = CvAdType.NORMAL;
        adContent = "";
        closeButtonTimeout = 0L;
        processType = new _cls4();
        processSize = new _cls5();
        readCloseButtonTimeout = new _cls6();
        processContent = new _cls7();
        adapter = adapter1;
        mediator = cvmediator;
        isValueExchane = cvmediator.getContentOptions().valueExchange;
    }

    private void processAdResponse(SimpleJSON simplejson)
    {
        Q.when(processType).then(processSize).then(readCloseButtonTimeout).then(processContent).withValue(simplejson).success(new _cls3()).failure(new _cls2());
    }

    abstract void adResponseProcessed();

    String getAdContent()
    {
        return adContent;
    }

    Size getAdSize()
    {
        return adSize;
    }

    CvAdType getAdType()
    {
        return adType;
    }

    public Adapter getAdapter()
    {
        return adapter;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getFallbackToIdentifier()
    {
        return fallbackType;
    }

    CvMediator getMediator()
    {
        return mediator;
    }

    public boolean isError()
    {
        return errorMessage != null;
    }

    public boolean isValueExchangeAd()
    {
        return isValueExchane;
    }

    void load()
    {
        log.v(new Object[] {
            "Loading ad..."
        });
        CvSDK.contentManager.loadAd(mediator.getContext(), mediator.getContentOptions(), new _cls1());
    }

    void setAdSize(Size size)
    {
        adSize = size;
    }

    public void setMediator(Mediator mediator1)
    {
        mediator = (CvMediator)mediator1;
    }

    abstract void setupSize(Size size);

    public boolean shouldRunFallback()
    {
        return fallbackType != null;
    }



/*
    static String access$002(CvAdWrapper cvadwrapper, String s)
    {
        cvadwrapper.errorMessage = s;
        return s;
    }

*/




/*
    static String access$302(CvAdWrapper cvadwrapper, String s)
    {
        cvadwrapper.fallbackType = s;
        return s;
    }

*/


/*
    static CvAdType access$402(CvAdWrapper cvadwrapper, CvAdType cvadtype)
    {
        cvadwrapper.adType = cvadtype;
        return cvadtype;
    }

*/


/*
    static Size access$502(CvAdWrapper cvadwrapper, Size size)
    {
        cvadwrapper.adSize = size;
        return size;
    }

*/



/*
    static long access$602(CvAdWrapper cvadwrapper, long l)
    {
        cvadwrapper.closeButtonTimeout = l;
        return l;
    }

*/


/*
    static String access$702(CvAdWrapper cvadwrapper, String s)
    {
        cvadwrapper.adContent = s;
        return s;
    }

*/

    // Unreferenced inner class com/apprupt/sdk/CvAdWrapper$Error
    /* block-local class not found */
    class Error {}


    // Unreferenced inner class com/apprupt/sdk/CvAdWrapper$Fallback
    /* block-local class not found */
    class Fallback {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
