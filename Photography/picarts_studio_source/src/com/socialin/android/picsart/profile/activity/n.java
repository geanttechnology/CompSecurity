// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import com.socialin.android.apiv3.model.AvatarResponse;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            p, UserAvatarUploadActivity

final class n extends p
{

    private UserAvatarUploadActivity a;

    private n(UserAvatarUploadActivity useravataruploadactivity)
    {
        a = useravataruploadactivity;
        super(useravataruploadactivity, (byte)0);
    }

    n(UserAvatarUploadActivity useravataruploadactivity, byte byte0)
    {
        this(useravataruploadactivity);
    }

    public final void a(AvatarResponse avatarresponse)
    {
        Intent intent = a.getIntent();
        intent.removeExtra("path");
        intent.putExtra("url", avatarresponse.url);
        UserAvatarUploadActivity.a(a, intent);
    }

    public final void onSuccess(Object obj, Request request)
    {
        a((AvatarResponse)obj);
    }
}
