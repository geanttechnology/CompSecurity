// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import com.apprupt.sdk.mediation.AdWrapper;

// Referenced classes of package com.apprupt.sdk:
//            CvMediation, CvViewHelper, CvContentOptions

class ns
    implements pletion
{

    final CvMediation this$0;
    final CvContentOptions val$contentOptions;
    final er.PreloaderListener val$listener;

    public void onFailure(String s)
    {
    /* block-local class not found */
    class _cls1 {}

        CvViewHelper.runOnUIThread(new _cls1(s), true);
    }

    public void onSuccess(AdWrapper adwrapper)
    {
    /* block-local class not found */
    class _cls2 {}

        CvViewHelper.runOnUIThread(new _cls2(adwrapper), true);
    }

    ns()
    {
        this$0 = final_cvmediation;
        val$listener = preloaderlistener;
        val$contentOptions = CvContentOptions.this;
        super();
    }
}
