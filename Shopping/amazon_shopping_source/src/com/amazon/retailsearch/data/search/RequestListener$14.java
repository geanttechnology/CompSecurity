// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.searchapp.retailsearch.model.FKMR;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultModel, RequestListener, ResultStreamListener

class this._cls0 extends ResultModel
{

    final RequestListener this$0;

    public void send(ResultStreamListener resultstreamlistener)
    {
        resultstreamlistener.fkmr((FKMR)get());
    }

    r(FKMR fkmr)
    {
        this$0 = RequestListener.this;
        super(fkmr);
    }
}
