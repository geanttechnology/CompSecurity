// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultModel, RequestListener, ResultStreamListener

class  extends ResultModel
{

    final RequestListener this$0;

    public void send(ResultStreamListener resultstreamlistener)
    {
        resultstreamlistener.trackingInfo((TrackingInfo)get());
    }

    er(TrackingInfo trackinginfo)
    {
        this$0 = RequestListener.this;
        super(trackinginfo);
    }
}
