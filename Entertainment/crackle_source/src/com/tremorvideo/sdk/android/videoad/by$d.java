// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.os.AsyncTask;
import com.tremorvideo.sdk.android.c.a;
import java.util.HashMap;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            by, ad, an, aw

class h extends AsyncTask
{

    String a;
    String b;
    final Activity c;
    final aw d;
    final an e;
    final a f;
    final int g;
    final String h;

    protected transient Boolean a(Void avoid[])
    {
        boolean flag;
        try
        {
            avoid = new a("zSB18SDCMETDn2BH50xg", "Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&", "POST", "https://api.twitter.com/oauth/request_token");
            avoid.a("oauth_callback", "oauth://twitter.com");
            flag = avoid.a();
            a = (String)avoid.b().get("oauth_token");
            b = (new StringBuilder()).append("https://api.twitter.com/oauth/authorize?oauth_token=").append(a).toString();
            if (a == null || b == null)
            {
                return Boolean.valueOf(false);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            com.tremorvideo.sdk.android.videoad.ad.a(avoid);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            com.tremorvideo.sdk.android.videoad.by.a(c, d, b, e, a, f, g, h);
            return;
        } else
        {
            e.dismiss();
            f.a(0, "");
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

    (Activity activity, aw aw, an an1,  , int i, String s)
    {
        c = activity;
        d = aw;
        e = an1;
        f = ;
        g = i;
        h = s;
        super();
    }
}
