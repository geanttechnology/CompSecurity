// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

class val.credential
    implements Runnable
{

    final val.credential this$1;
    final i val$credential;

    public void run()
    {
        if (OAuth2Session.access$800(_fld0) != null)
        {
            OAuth2Session.access$800(_fld0).onCredentialRefreshed(val$credential);
        }
    }

    r()
    {
        this$1 = final_r;
        val$credential = i.this;
        super();
    }
}
