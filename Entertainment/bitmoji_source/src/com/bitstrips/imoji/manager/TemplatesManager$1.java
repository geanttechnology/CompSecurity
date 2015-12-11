// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.manager:
//            TemplatesManager

class this._cls0
    implements ilureCallback
{

    final TemplatesManager this$0;

    public void failure(RetrofitError retrofiterror)
    {
        if (retrofiterror.getResponse() != null)
        {
            if (retrofiterror.getResponse().getStatus() != 304);
        }
    }

    ilureCallback()
    {
        this$0 = TemplatesManager.this;
        super();
    }
}
