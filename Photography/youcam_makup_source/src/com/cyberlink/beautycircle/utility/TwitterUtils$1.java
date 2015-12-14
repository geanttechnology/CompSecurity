// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import com.cyberlink.beautycircle.c;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            TwitterUtils

class a extends j
{

    final Activity a;
    final TwitterUtils b;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected String a(Void void1)
    {
        try
        {
            TwitterUtils.a(b, new CommonsHttpOAuthConsumer(TwitterUtils.a(), TwitterUtils.b()));
            TwitterUtils.a(b, new DefaultOAuthProvider("https://twitter.com/oauth/request_token", "https://twitter.com/oauth/access_token", "https://twitter.com/oauth/authenticate"));
            void1 = TwitterUtils.b(b).a(TwitterUtils.a(b), "http://www.perfectcorp.com/ybc/twitter/callback", new String[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            e.e(new Object[] {
                void1
            });
            return null;
        }
        return void1;
    }

    protected void a(String s)
    {
        if (s != null)
        {
            c.a(a, s, 0, 48162);
        }
        super.a_(s);
    }

    protected void a_(Object obj)
    {
        a((String)obj);
    }

    r(TwitterUtils twitterutils, Activity activity)
    {
        b = twitterutils;
        a = activity;
        super();
    }
}
