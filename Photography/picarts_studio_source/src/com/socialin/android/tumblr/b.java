// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.socialin.android.d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class b
{

    private static String c = com/socialin/android/tumblr/b.getSimpleName();
    public Context a;
    public SharedPreferences b;
    private String d;
    private String e;

    public b(Context context)
    {
        a = null;
        b = null;
        a = context;
        b = context.getSharedPreferences("TumblrPrefs", 0);
        d = context.getString(0x7f080973);
        e = context.getString(0x7f080974);
    }

    private String a(String s, List list)
    {
        String s1 = "";
        s = new HttpPost((new StringBuilder("http://api.tumblr.com/v2/blog/")).append(s).append("/post").toString());
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        s.setEntity(new UrlEncodedFormEntity(list));
        list = new CommonsHttpOAuthConsumer(d, e);
        String s2 = b.getString("tumblr_oauth_token", null);
        String s3 = b.getString("tumblr_oauth_token_secret", null);
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            list.setTokenWithSecret(s2, s3);
        }
        list.sign(s);
        s = EntityUtils.toString(defaulthttpclient.execute(s).getEntity());
        com.socialin.android.d.a(c, new Object[] {
            "result >>", s
        });
        list = s1;
_L1:
        com.socialin.android.d.c(new Object[] {
            c, list
        });
        return s;
        list;
        s = null;
_L3:
        com.socialin.android.d.a(c, list);
        list = (new StringBuilder()).append("").append(list.toString()).toString();
          goto _L1
        list;
        s = null;
_L2:
        com.socialin.android.d.a(c, list);
        list = s1;
          goto _L1
        list;
          goto _L2
        list;
          goto _L3
    }

    public final String a(String s, String s1, String s2, String s3, int i, int j)
    {
        Object obj = "";
        if (!TextUtils.isEmpty(s3))
        {
            s3 = (new StringBuilder("\n <a target='_blank' href='")).append(s3).append("'> Photo </a>").toString();
            obj = (new StringBuilder()).append(s3).append("  is taken via <a target='_blank' href='https://market.android.com/details?id=").append(a.getPackageName()).append("&feature=top-free'>  ").append(a.getString(0x7f0808ad)).append(".</a>").toString();
        }
        s3 = ((String) (obj));
        if (s1 != null)
        {
            s3 = (new StringBuilder()).append(s1).append(((String) (obj))).toString();
        }
        obj = b.getString("tumblr_user_name", null);
        s1 = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append(".tumblr.com").toString();
        }
        com.socialin.android.d.a(c, new Object[] {
            "postImage", (new StringBuilder("userName= ")).append(s1).toString()
        });
        obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("api_key", d));
        ((List) (obj)).add(new BasicNameValuePair("type", "photo"));
        ((List) (obj)).add(new BasicNameValuePair("caption", s3));
        ((List) (obj)).add(new BasicNameValuePair("source", s));
        ((List) (obj)).add(new BasicNameValuePair("state", "published"));
        if (s2 == null)
        {
            s2 = "";
        }
        s = s2;
        if (!s2.contains("#picsart"))
        {
            s = (new StringBuilder()).append(s2).append(",#picsart").toString();
        }
        if (!TextUtils.isEmpty(s))
        {
            ((List) (obj)).add(new BasicNameValuePair("tags", s));
        }
        if (i > 0 && j > 0)
        {
            ((List) (obj)).add(new BasicNameValuePair("width", String.valueOf(i)));
            ((List) (obj)).add(new BasicNameValuePair("height", String.valueOf(j)));
        }
        return a(s1, ((List) (obj)));
    }

    public final void a()
    {
        myobfuscated.cy.d.a(a);
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.clear();
        editor.commit();
    }

}
