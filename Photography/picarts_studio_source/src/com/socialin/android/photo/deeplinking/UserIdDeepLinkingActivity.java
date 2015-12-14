// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.Utils;
import java.util.regex.Pattern;

public class UserIdDeepLinkingActivity extends BaseActivity
{

    public UserIdDeepLinkingActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getData();
        if (bundle == null || TextUtils.isEmpty(bundle.toString())) goto _L2; else goto _L1
_L1:
        String s2;
        String s3;
        s2 = bundle.toString().replaceAll("\\s", "");
        s3 = s2.toLowerCase();
        if (!s3.contains("users?id".toLowerCase())) goto _L4; else goto _L3
_L3:
        bundle = s2.substring(s2.indexOf("users?id=")).substring(9);
        int i = Utils.a(Pattern.compile("[^0-9]"), bundle);
        long l;
        if (i != -1)
        {
            l = Long.parseLong(bundle.substring(0, i));
        } else
        {
            l = Long.parseLong(bundle);
        }
        bundle = null;
        if (s3.contains("tab="))
        {
            String s = s3.substring(s3.indexOf("tab=") + "tab=".length(), s3.length());
            bundle = s;
            if (s.contains("&"))
            {
                bundle = s.substring(0, s3.indexOf("&"));
            }
        }
        GalleryUtils.a(this, l, bundle, s2);
_L6:
        finish();
_L2:
        return;
_L4:
        if (s3.contains("users?username".toLowerCase()))
        {
            String s1 = s2.substring(s2.indexOf("users?username=")).substring(15);
            int j = Utils.a(Pattern.compile("[^-_a-zA-Z0-9]"), s1);
            bundle = s1;
            if (j != -1)
            {
                bundle = s1.substring(0, j);
            }
            GalleryUtils.a(this, bundle, s2);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
