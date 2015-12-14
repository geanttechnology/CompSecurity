// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2.android;

import android.content.Intent;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;

// Referenced classes of package com.dropbox.client2.android:
//            AuthActivity

public final class a extends Session
{

    public a(AppKeyPair appkeypair)
    {
        super(appkeypair);
    }

    public static boolean a()
    {
        Object obj = AuthActivity.a;
        if (obj != null)
        {
            String s = ((Intent) (obj)).getStringExtra("ACCESS_TOKEN");
            String s1 = ((Intent) (obj)).getStringExtra("ACCESS_SECRET");
            obj = ((Intent) (obj)).getStringExtra("UID");
            if (s != null && !s.equals("") && s1 != null && !s1.equals("") && obj != null && !((String) (obj)).equals(""))
            {
                return true;
            }
        }
        return false;
    }

    public final String b()
    {
        Object obj = AuthActivity.a;
        if (obj == null)
        {
            throw new IllegalStateException();
        }
        String s = ((Intent) (obj)).getStringExtra("ACCESS_TOKEN");
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Invalid result intent passed in. Missing access token.");
        }
        String s1 = ((Intent) (obj)).getStringExtra("ACCESS_SECRET");
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("Invalid result intent passed in. Missing access secret.");
        }
        obj = ((Intent) (obj)).getStringExtra("UID");
        if (obj == null || ((String) (obj)).length() == 0)
        {
            throw new IllegalArgumentException("Invalid result intent passed in. Missing uid.");
        }
        if (s.equals("oauth2:"))
        {
            a(s1);
            return ((String) (obj));
        } else
        {
            new AccessTokenPair(s, s1);
            super.b = null;
            return ((String) (obj));
        }
    }
}
