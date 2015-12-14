// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.text.TextUtils;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements d
{

    private ProfileActivity a;

    private a(ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }

    a(ProfileActivity profileactivity, byte byte0)
    {
        this(profileactivity);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        DialogUtils.dismissDialog(a, ProfileActivity.z(a));
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        DialogUtils.dismissDialog(a, ProfileActivity.z(a));
        if (!TextUtils.isEmpty(ProfileActivity.y(a).photo))
        {
            SocialinV3.getInstance().getUser().setPhoto(ProfileActivity.y(a).photo);
            ProfileActivity.c(a).photo = ProfileActivity.y(a).photo;
        }
        if (!TextUtils.isEmpty(ProfileActivity.y(a).cover) || ProfileActivity.y(a).cover != null && " ".equals(ProfileActivity.y(a).cover))
        {
            SocialinV3.getInstance().getUser().cover = ProfileActivity.y(a).cover;
            SocialinV3.getInstance().writeUser();
            ProfileActivity.c(a).cover = ProfileActivity.y(a).cover;
            ProfileActivity.B(a);
        }
        ProfileActivity.C(a);
    }
}
