// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.android.volley.VolleyError;

// Referenced classes of package com.bitstrips.imoji.services:
//            B4MService

class this._cls0
    implements com.android.volley.rListener
{

    final B4MService this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        B4MService.access$100(B4MService.this, volleyerror.toString());
    }

    ()
    {
        this$0 = B4MService.this;
        super();
    }
}
