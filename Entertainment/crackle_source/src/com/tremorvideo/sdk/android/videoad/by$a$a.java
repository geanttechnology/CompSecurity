// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.net.Uri;
import android.os.AsyncTask;
import com.tremorvideo.sdk.android.c.a;
import java.util.HashMap;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            by, aw, ad, an

class a extends AsyncTask
{

    String a;
    final Uri b;
    final a c;

    protected transient Boolean a(Void avoid[])
    {
        Object obj;
        String s;
        avoid = b.getQueryParameter("oauth_verifier");
        obj = new a("zSB18SDCMETDn2BH50xg", "Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&", c.c, "POST", "https://api.twitter.com/oauth/access_token");
        ((a) (obj)).a("oauth_verifier", avoid);
        ((a) (obj)).a();
        avoid = ((a) (obj)).b();
        obj = (String)avoid.get("oauth_token");
        avoid = (String)avoid.get("oauth_token_secret");
        s = (new StringBuilder()).append("Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&").append(avoid).toString();
        if (c.c != 0) goto _L2; else goto _L1
_L1:
        avoid = "https://api.twitter.com/1.1/statuses/update.json";
_L4:
        avoid = new a("zSB18SDCMETDn2BH50xg", s, ((String) (obj)), "POST", avoid);
        if (c.c == 0)
        {
            avoid.a("status", c.c.a("message", "Tweet"));
        }
        boolean flag = avoid.a();
        ad.d(avoid.c());
        return Boolean.valueOf(flag);
_L2:
        avoid = (new StringBuilder()).append("https://api.twitter.com/1.1/statuses/retweet/").append(c.c).append(".json").toString();
        if (true) goto _L4; else goto _L3
_L3:
        avoid;
        com.tremorvideo.sdk.android.videoad.ad.a(avoid);
        return Boolean.valueOf(false);
    }

    protected void a(Boolean boolean1)
    {
        c.c.dismiss();
        if (boolean1.booleanValue())
        {
            c.c.c(1, "");
            return;
        } else
        {
            c.c.c(0, a);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    ( , Uri uri)
    {
        c = ;
        b = uri;
        super();
        a = "";
    }
}
