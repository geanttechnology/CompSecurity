// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPWebViewActivity

class this._cls0
    implements Callback
{

    final MAPWebViewActivity this$0;

    public void onError(Bundle bundle)
    {
        MAPWebViewActivity.access$100(MAPWebViewActivity.this, bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPWebViewActivity.access$000(MAPWebViewActivity.this, bundle);
    }

    ()
    {
        this$0 = MAPWebViewActivity.this;
        super();
    }
}
