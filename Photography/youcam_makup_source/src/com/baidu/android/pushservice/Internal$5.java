// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgeInternal;

// Referenced classes of package com.baidu.android.pushservice:
//            Internal

class a
    implements Runnable
{

    private final Context a;

    public void run()
    {
        BridgeInternal.createBdussIntent(a);
    }

    idgeInternal(Context context)
    {
        a = context;
        super();
    }
}
