// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.http.parentalcontrols.ParentalControlsResponseHandler;

// Referenced classes of package com.comcast.cim.model:
//            ParentalControlsCache

class this._cls0
    implements Provider
{

    final ParentalControlsCache this$0;

    public ParentalControlsResponseHandler get()
    {
        return new ParentalControlsResponseHandler(ParentalControlsCache.access$000(ParentalControlsCache.this));
    }

    public volatile Object get()
    {
        return get();
    }

    ControlsResponseHandler()
    {
        this$0 = ParentalControlsCache.this;
        super();
    }
}
