// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.sdk.OAuth2Credential;
import com.rdio.android.sdk.RdioListener;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal

class val.credential
    implements Runnable
{

    final RdioInternal this$0;
    final OAuth2Credential val$credential;

    public void run()
    {
        RdioInternal.access$100(RdioInternal.this).onRdioAuthorised(val$credential);
    }

    ()
    {
        this$0 = final_rdiointernal;
        val$credential = OAuth2Credential.this;
        super();
    }
}
