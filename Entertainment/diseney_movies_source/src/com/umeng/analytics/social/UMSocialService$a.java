// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

// Referenced classes of package com.umeng.analytics.social:
//            UMSocialService, c, d, UMPlatformData

private static class d extends AsyncTask
{

    String a;
    String b;
    a c;
    UMPlatformData d[];

    protected transient d a(Void avoid[])
    {
        Object obj;
        String s;
        int i;
        if (TextUtils.isEmpty(b))
        {
            avoid = com.umeng.analytics.social.c.a(a);
        } else
        {
            avoid = com.umeng.analytics.social.c.a(a, b);
        }
        try
        {
            obj = new JSONObject(avoid);
            i = ((JSONObject) (obj)).optInt("st");
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return new d(-99, avoid);
        }
        if (i == 0)
        {
            i = -404;
        }
        avoid = new d(i);
        s = ((JSONObject) (obj)).optString("msg");
        if (!TextUtils.isEmpty(s))
        {
            avoid.a(s);
        }
        obj = ((JSONObject) (obj)).optString("data");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            avoid.b(((String) (obj)));
        }
        return avoid;
    }

    protected void a(d d1)
    {
        if (c != null)
        {
            c.a(d1, d);
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((d)obj);
    }

    protected void onPreExecute()
    {
        if (c != null)
        {
            c.a();
        }
    }

    public (String as[],  , UMPlatformData aumplatformdata[])
    {
        a = as[0];
        b = as[1];
        c = ;
        d = aumplatformdata;
    }
}
