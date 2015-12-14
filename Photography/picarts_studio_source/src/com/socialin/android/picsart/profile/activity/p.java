// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.apiv3.model.AvatarResponse;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserAvatarUploadActivity

class p
    implements d
{

    private UserAvatarUploadActivity a;

    private p(UserAvatarUploadActivity useravataruploadactivity)
    {
        a = useravataruploadactivity;
        super();
    }

    p(UserAvatarUploadActivity useravataruploadactivity, byte byte0)
    {
        this(useravataruploadactivity);
    }

    public void a(AvatarResponse avatarresponse)
    {
        m.b(a, com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.d(a));
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public void onFailure(Exception exception, Request request)
    {
        m.b(a, com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity.d(a));
        UserAvatarUploadActivity.e(a, exception.getMessage());
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(Object obj, Request request)
    {
        a((AvatarResponse)obj);
    }
}
