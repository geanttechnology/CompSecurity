// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.ArrayList;

// Referenced classes of package com.apprupt.sdk:
//            CvDefaultContentProvider, CvContentResponse, CvContentOptions, CvPreloaderResponse

class istener
    implements tener
{

    final CvDefaultContentProvider this$0;
    final istener val$listener;
    final CvContentOptions val$options;

    public void onContentLoaded(CvContentResponse cvcontentresponse)
    {
        if (cvcontentresponse.isError)
        {
            CvDefaultContentProvider.access$000()._mth000(cvcontentresponse.error, new Object[] {
                "Error while loading content for", val$options.adSpaceId, ":", cvcontentresponse.message
            });
            if (val$listener != null)
            {
                val$listener.onPreloaderFinish(new CvPreloaderResponse(cvcontentresponse.message, cvcontentresponse.code));
            }
            return;
        }
        synchronized (CvDefaultContentProvider.this)
        {
            ArrayList arraylist = CvDefaultContentProvider.access$300(CvDefaultContentProvider.this, val$options.adSpaceId);
            CvDefaultContentProvider.access$000()._mth000(new Object[] {
                "Got content for", val$options.adSpaceId
            });
            CvDefaultContentProvider.access$000()._mth000(new Object[] {
                "Content", cvcontentresponse.content
            });
            arraylist.add(cvcontentresponse.content);
            if (val$listener != null)
            {
                val$listener.onPreloaderFinish(new CvPreloaderResponse());
            }
        }
        return;
        cvcontentresponse;
        cvdefaultcontentprovider;
        JVM INSTR monitorexit ;
        throw cvcontentresponse;
    }

    istener()
    {
        this$0 = final_cvdefaultcontentprovider;
        val$options = cvcontentoptions;
        val$listener = istener.this;
        super();
    }
}
