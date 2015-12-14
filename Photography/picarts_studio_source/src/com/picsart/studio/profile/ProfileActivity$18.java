// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements d
{

    private ProfileActivity a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        com.picsart.studio.profile.ProfileActivity.d(a, exception);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        ProfileActivity.w(a);
    }

    (ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
