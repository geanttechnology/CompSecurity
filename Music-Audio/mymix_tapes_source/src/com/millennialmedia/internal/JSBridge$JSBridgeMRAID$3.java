// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class eParams
    implements Runnable
{

    final val.resizeParams this$1;
    final eParams val$resizeParams;

    public void run()
    {
        if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
        {
            throwMraidError((new StringBuilder()).append("Cannot resize in current state<").append(currentState).append(">").toString(), "resize");
        } else
        if (!JSBridge.access$300(_fld0).resize(val$resizeParams))
        {
            throwMraidError("Unable to resize", "resize");
            return;
        }
    }

    eParams()
    {
        this$1 = final_eparams;
        val$resizeParams = eParams.this;
        super();
    }
}
