// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import com.socialin.android.util.w;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserAvatarUploadActivity

final class a extends Thread
{

    private Intent a;
    private UserAvatarUploadActivity b;

    public final void run()
    {
        UserAvatarUploadActivity.a(b, w.a(UserAvatarUploadActivity.a(b), a));
        if (UserAvatarUploadActivity.b(b).contains("."))
        {
            UserAvatarUploadActivity.b(b, UserAvatarUploadActivity.b(b).substring(UserAvatarUploadActivity.b(b).lastIndexOf(".") + 1, UserAvatarUploadActivity.b(b).length()));
        }
        int i;
        if (a == null)
        {
            i = m.d(UserAvatarUploadActivity.b(b));
        } else
        {
            i = w.a(b, a, UserAvatarUploadActivity.b(b));
        }
        UserAvatarUploadActivity.a(b, UserAvatarUploadActivity.b(b), i, a);
    }

    (UserAvatarUploadActivity useravataruploadactivity, Intent intent)
    {
        b = useravataruploadactivity;
        a = intent;
        super();
    }
}
