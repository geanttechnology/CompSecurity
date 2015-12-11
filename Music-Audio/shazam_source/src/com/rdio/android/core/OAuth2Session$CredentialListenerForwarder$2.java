// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.q;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

class val.tokenErrorResponse
    implements Runnable
{

    final val.tokenErrorResponse this$1;
    final q val$tokenErrorResponse;

    public void run()
    {
        if (OAuth2Session.access$800(_fld0) != null)
        {
            OAuth2Session.access$800(_fld0).onError(val$tokenErrorResponse.error);
        }
    }

    r()
    {
        this$1 = final_r;
        val$tokenErrorResponse = q.this;
        super();
    }
}
