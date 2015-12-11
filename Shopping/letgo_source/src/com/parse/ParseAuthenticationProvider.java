// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

abstract class ParseAuthenticationProvider
{
    static interface ParseAuthenticationCallback
    {

        public abstract void onCancel();

        public abstract void onError(Throwable throwable);

        public abstract void onSuccess(Map map);
    }


    ParseAuthenticationProvider()
    {
    }

    public abstract cu authenticateAsync();

    public abstract void cancel();

    public abstract void deauthenticate();

    public abstract String getAuthType();

    public cu linkAsync(final ParseUser user)
    {
        return authenticateAsync().d(new ct() {

            final ParseAuthenticationProvider this$0;
            final ParseUser val$user;

            public cu then(cu cu1)
                throws Exception
            {
                return linkAsync(user, (Map)cu1.e());
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseAuthenticationProvider.this;
                user = parseuser;
                super();
            }
        });
    }

    public cu linkAsync(ParseUser parseuser, Map map)
    {
        return parseuser.linkWithAsync(getAuthType(), map, parseuser.getSessionToken());
    }

    public cu logInAsync()
    {
        return authenticateAsync().d(new ct() {

            final ParseAuthenticationProvider this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return logInAsync((Map)cu1.e());
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseAuthenticationProvider.this;
                super();
            }
        });
    }

    public cu logInAsync(Map map)
    {
        return ParseUser.logInWithAsync(getAuthType(), map);
    }

    public abstract boolean restoreAuthentication(Map map);

    public cu unlinkAsync(ParseUser parseuser)
    {
        return parseuser.unlinkFromAsync(getAuthType());
    }
}
