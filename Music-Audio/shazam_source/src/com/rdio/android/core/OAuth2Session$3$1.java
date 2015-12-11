// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.f;
import com.google.api.a.a.a.i;
import com.google.api.a.a.a.m;
import com.google.api.a.a.a.p;
import com.google.api.a.a.a.q;
import com.google.api.a.a.a.r;
import com.google.api.a.a.a.s;
import com.google.api.a.a.a.t;
import com.google.api.a.d.d;
import com.google.api.a.d.h;
import java.io.IOException;

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

    le()
    {
        this$1 = final_le;
        val$newCredential = i.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/OAuth2Session$3

/* anonymous class */
    class OAuth2Session._cls3 extends OAuth2Session.ErrorReportingStringCallable
    {

        final OAuth2Session this$0;
        final OAuth2Session.OAuth2ClientCredentialsListener val$listener;
        final r val$request;
        final String val$userId;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            try
            {
                s s1 = request.b();
                OAuth2Session.access$002(OAuth2Session.this, s1.accessToken);
                Object obj1 = new com.google.api.a.a.a.i.b(f.a());
                obj1.b = getCurrentOrCreateNewHttpTransport();
                obj1.c = createJsonFactory();
                obj1.d = new h(OAuth2Session.access$400(OAuth2Session.this));
                obj1.f = new d(OAuth2Session.access$500(OAuth2Session.this), OAuth2Session.access$600(OAuth2Session.this));
                if (userId != null)
                {
                    ((com.google.api.a.a.a.i.b) (obj1)).a(new m(userId, OAuth2Session.access$700(OAuth2Session.this)));
                }
                ((com.google.api.a.a.a.i.b) (obj1)).a(new OAuth2Session.CredentialListenerForwarder(OAuth2Session.this, null));
                obj1 = ((com.google.api.a.a.a.i.b) (obj1)).a();
                ((i) (obj1)).a(s1);
                OAuth2Session.access$102(OAuth2Session.this, ((i) (obj1)));
                if (OAuth2Session.access$800(OAuth2Session.this) != null)
                {
                    dispatchAsyncResult(((OAuth2Session._cls3._cls1) (obj1)). new OAuth2Session._cls3._cls1());
                }
                p.a(OAuth2Session.access$700(OAuth2Session.this)).a(userId, new p(OAuth2Session.access$100(OAuth2Session.this)));
            }
            catch (Object obj)
            {
                ((t) (obj)).printStackTrace();
                if (((t) (obj)).a != null)
                {
                    obj = ((t) (obj)).a.error;
                } else
                {
                    obj = ((t) (obj)).getMessage();
                }
                dispatchError(((String) (obj)));
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                dispatchError(ioexception.getMessage());
            }
            return OAuth2Session.access$000(OAuth2Session.this);
        }

            
            {
                this$0 = final_oauth2session;
                request = r1;
                userId = s1;
                listener = OAuth2Session.OAuth2ClientCredentialsListener.this;
                super(final_oauth2session, null);
            }
    }

}
