// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;
import com.google.api.a.a.a.s;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

class val.newCredential
    implements Runnable
{

    final val.newCredential this$1;
    final i val$newCredential;

    public void run()
    {
        OAuth2Session.access$800(_fld0).onReceivedCredentials(val$newCredential);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$newCredential = i.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/OAuth2Session$6

/* anonymous class */
    class OAuth2Session._cls6
        implements com.google.api.a.a.a.a.b
    {

        final OAuth2Session this$0;

        public void onCredentialCreated(i i, s s1)
        {
            OAuth2Session.access$002(OAuth2Session.this, s1.accessToken);
            OAuth2Session.access$102(OAuth2Session.this, i);
            if (OAuth2Session.access$800(OAuth2Session.this) != null)
            {
                dispatchAsyncResult(i. new OAuth2Session._cls6._cls1());
            }
        }

            
            {
                this$0 = OAuth2Session.this;
                super();
            }
    }

}
