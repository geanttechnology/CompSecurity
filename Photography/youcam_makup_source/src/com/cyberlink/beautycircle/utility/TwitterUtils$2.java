// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.http.HttpParameters;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            TwitterUtils

class a extends j
{

    final String a;
    final TwitterUtils b;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected OAuthConsumer a(Void void1)
    {
        try
        {
            TwitterUtils.b(b).b(TwitterUtils.a(b), a, new String[0]);
            TwitterUtils.a(b, TwitterUtils.b(b).a());
            b.a = TwitterUtils.c(b).b("user_id");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            e.e(new Object[] {
                void1
            });
        }
        return TwitterUtils.a(b);
    }

    (TwitterUtils twitterutils, String s)
    {
        b = twitterutils;
        a = s;
        super();
    }
}
