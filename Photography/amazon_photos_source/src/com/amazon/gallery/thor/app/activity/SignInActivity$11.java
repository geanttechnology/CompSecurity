// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.identity.auth.device.api.MAPAccountManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.view.er
{

    final SignInActivity this$0;

    public void onClick(View view)
    {
        SignInActivity.access$1300(SignInActivity.this).deregisterAccount(SignInActivity.access$1300(SignInActivity.this).getAccount(), null);
        SignInActivity.access$1400(SignInActivity.this).trackEvent(ricEvent.UseDifferentAccount);
        SignInActivity.access$1500(SignInActivity.this);
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
