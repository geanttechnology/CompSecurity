// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import com.socialin.android.d;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

// Referenced classes of package com.socialin.android.tumblr:
//            TumblrOAuthActivity

final class a
    implements Runnable
{

    private TumblrOAuthActivity a;

    public final void run()
    {
        TumblrOAuthActivity.b(a).setOAuth10a(true);
        String s = TumblrOAuthActivity.b(a).retrieveRequestToken(TumblrOAuthActivity.c(a), "android-tumblr://success");
        d.a(TumblrOAuthActivity.a(), (new StringBuilder("Auth url:")).append(s).toString());
        TumblrOAuthActivity.a(a, s);
        return;
        Object obj;
        obj;
_L4:
        d.b(TumblrOAuthActivity.a(), "openLogin", ((Throwable) (obj)));
        return;
        obj;
_L2:
        d.a(TumblrOAuthActivity.a(), ((Throwable) (obj)));
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    on(TumblrOAuthActivity tumblroauthactivity)
    {
        a = tumblroauthactivity;
        super();
    }
}
