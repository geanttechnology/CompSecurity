// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.f;
import com.google.api.a.a.a.g;
import com.google.api.a.a.a.i;
import com.google.api.a.a.a.s;
import java.io.IOException;
import java.util.concurrent.Callable;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

class val.newCredential
    implements Runnable
{

    final val.newCredential this$1;
    final i val$newCredential;

    public void run()
    {
        listener.onReceivedCredentials(val$newCredential);
    }

    tener()
    {
        this$1 = final_tener;
        val$newCredential = i.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/OAuth2Session$1

/* anonymous class */
    class OAuth2Session._cls1
        implements Callable
    {

        final OAuth2Session this$0;
        final OAuth2Session.OAuth2ClientCredentialsListener val$listener;
        final g val$request;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            try
            {
                Object obj = request.b();
                OAuth2Session.access$002(OAuth2Session.this, ((s) (obj)).accessToken);
                obj = (new com.google.api.a.a.a.i.b(f.a())).a().a(((s) (obj)));
                OAuth2Session.access$102(OAuth2Session.this, ((i) (obj)));
                dispatchAsyncResult(((OAuth2Session._cls1._cls1) (obj)). new OAuth2Session._cls1._cls1());
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            return OAuth2Session.access$000(OAuth2Session.this);
        }

            
            {
                this$0 = final_oauth2session;
                request = g1;
                listener = OAuth2Session.OAuth2ClientCredentialsListener.this;
                super();
            }
    }

}
