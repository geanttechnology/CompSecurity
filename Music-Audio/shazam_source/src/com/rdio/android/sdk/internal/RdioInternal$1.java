// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.sdk.RdioListener;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal

class this._cls0
    implements Runnable
{

    final RdioInternal this$0;

    public void run()
    {
        RdioInternal.access$100(RdioInternal.this).onApiServiceReady(RdioInternal.access$000(RdioInternal.this));
    }

    ()
    {
        this$0 = RdioInternal.this;
        super();
    }
}
