// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserAvatarUploadActivity

final class a extends Thread
{

    private Intent a;
    private UserAvatarUploadActivity b;

    public final void run()
    {
        UserAvatarUploadActivity.a(b, a.getExtras().getString("path"));
        int i = a.getExtras().getInt("degree");
        UserAvatarUploadActivity.a(b, UserAvatarUploadActivity.b(b), i, a);
    }

    (UserAvatarUploadActivity useravataruploadactivity, Intent intent)
    {
        b = useravataruploadactivity;
        a = intent;
        super();
    }
}
