// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.oauth2.OAuth2BaseActivity;

public class f
{

    public Context a;

    public f(Context context)
    {
        a = null;
        a = context;
    }

    public final void a(int i)
    {
        Intent intent = new Intent(a, com/socialin/android/oauth2/OAuth2BaseActivity);
        intent.putExtra("oauth2AuthorizationEndpoint", "https://api.instagram.com/oauth/authorize/");
        intent.putExtra("oauth2AccessTokenEndpoint", "https://api.instagram.com/oauth/access_token");
        intent.putExtra("oauth2ClientSecret", "56e884c8c2c14146819ce990bf76b070");
        intent.putExtra("oauth2ClientId", "c73708fbbf72408eb6b5dd676da16dba");
        intent.putExtra("oauth2UsePostRequest", true);
        intent.putExtra("oauth2SocialKey", 4);
        ((Activity)a).startActivityForResult(intent, i);
    }

    static 
    {
        (new StringBuilder()).append(com/socialin/android/instagram/f.getSimpleName()).append(" - ");
    }
}
