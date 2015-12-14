// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.text.TextUtils;
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
        UserAvatarUploadActivity.a(b, w.a(b, a, UserAvatarUploadActivity.c(b)));
        if (TextUtils.isEmpty(UserAvatarUploadActivity.b(b)))
        {
            m.b(b, UserAvatarUploadActivity.d(b));
            b.finish();
            return;
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
