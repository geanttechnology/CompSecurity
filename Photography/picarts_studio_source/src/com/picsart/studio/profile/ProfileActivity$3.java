// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import com.socialin.android.apiv3.model.ViewerUser;
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
        ProfileActivity.l(a);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (ViewerUser)obj;
        ProfileActivity.c(a, ((ViewerUser) (obj)));
    }

    (ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
