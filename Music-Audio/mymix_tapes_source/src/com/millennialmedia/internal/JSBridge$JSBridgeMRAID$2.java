// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class dParams
    implements Runnable
{

    final val.expandParams this$1;
    final dParams val$expandParams;

    public void run()
    {
        if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
        {
            throwMraidError((new StringBuilder()).append("Cannot expand in current state<").append(currentState).append(">").toString(), "expand");
        } else
        if (!JSBridge.access$300(_fld0).expand(val$expandParams))
        {
            throwMraidError("Unable to expand", "expand");
            return;
        }
    }

    dParams()
    {
        this$1 = final_dparams;
        val$expandParams = dParams.this;
        super();
    }
}
