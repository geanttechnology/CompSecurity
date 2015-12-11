// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            PendingRequestCallbackHolder

private class mId
    implements Callback
{

    private final String mId;
    final PendingRequestCallbackHolder this$0;

    public void onError(Bundle bundle)
    {
        PendingRequestCallbackHolder.access$100(PendingRequestCallbackHolder.this, mId, bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        PendingRequestCallbackHolder.access$000(PendingRequestCallbackHolder.this, mId, bundle);
    }

    public (String s)
    {
        this$0 = PendingRequestCallbackHolder.this;
        super();
        mId = s;
    }
}
