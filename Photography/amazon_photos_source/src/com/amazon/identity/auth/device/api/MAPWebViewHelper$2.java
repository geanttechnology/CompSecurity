// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPWebViewHelper, MAPWebViewEventHelper

class this._cls0
    implements Callback
{

    final MAPWebViewHelper this$0;

    public void onError(Bundle bundle)
    {
        MAPWebViewEventHelper.setError(bundle, MAPWebViewHelper.access$400(MAPWebViewHelper.this));
    }

    public void onSuccess(Bundle bundle)
    {
        MAPWebViewHelper.access$300(MAPWebViewHelper.this);
    }

    er()
    {
        this$0 = MAPWebViewHelper.this;
        super();
    }
}
