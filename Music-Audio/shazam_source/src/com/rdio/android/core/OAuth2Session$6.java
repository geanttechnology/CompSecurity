// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;
import com.google.api.a.a.a.s;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

class this._cls0
    implements com.google.api.a.a.a.
{

    final OAuth2Session this$0;

    public void onCredentialCreated(final i newCredential, s s1)
    {
        OAuth2Session.access$002(OAuth2Session.this, s1.accessToken);
        OAuth2Session.access$102(OAuth2Session.this, newCredential);
        if (OAuth2Session.access$800(OAuth2Session.this) != null)
        {
            dispatchAsyncResult(new Runnable() {

                final OAuth2Session._cls6 this$1;
                final i val$newCredential;

                public void run()
                {
                    OAuth2Session.access$800(this$0).onReceivedCredentials(newCredential);
                }

            
            {
                this$1 = OAuth2Session._cls6.this;
                newCredential = i;
                super();
            }
            });
        }
    }

    _cls1.val.newCredential()
    {
        this$0 = OAuth2Session.this;
        super();
    }
}
