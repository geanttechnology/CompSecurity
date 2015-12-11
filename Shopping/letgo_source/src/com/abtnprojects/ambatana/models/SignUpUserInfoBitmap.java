// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.graphics.Bitmap;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            SignUpUserInfo

public class SignUpUserInfoBitmap extends SignUpUserInfo
{

    private final Bitmap userAvatar;
    private final String userPassword;

    public SignUpUserInfoBitmap(String s, String s1, String s2, Bitmap bitmap)
    {
        super(s, s2);
        userPassword = s1;
        userAvatar = bitmap;
    }

    public Bitmap getUserAvatar()
    {
        return userAvatar;
    }

    public String getUserPassword()
    {
        return userPassword;
    }
}
