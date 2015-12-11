// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.view.View;
import com.offerup.android.network.UserService;
import com.offerup.android.network.o;
import com.offerup.android.tracker.a;
import java.io.File;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import retrofit.mime.TypedFile;

// Referenced classes of package com.offerup.android.activities:
//            ProfileImageActivity, gm

final class gl
    implements android.view.View.OnClickListener
{

    private ProfileImageActivity a;

    gl(ProfileImageActivity profileimageactivity)
    {
        a = profileimageactivity;
        super();
    }

    public final void onClick(View view)
    {
        ProfileImageActivity profileimageactivity;
        retrofit.RestAdapter restadapter;
        com.offerup.android.tracker.a.b("MyProfileImage_UsePhoto-Button_click");
        profileimageactivity = a;
        profileimageactivity.b = Executors.newCachedThreadPool();
        restadapter = o.a(profileimageactivity.b);
        view = null;
        if (profileimageactivity.d == null) goto _L2; else goto _L1
_L1:
        view = new TypedFile("application/octet-stream", new File(profileimageactivity.c));
_L4:
        if (view != null)
        {
            profileimageactivity.g = ProgressDialog.show(profileimageactivity, "", "Sending image...");
            o.e(restadapter).updateProfilePicture(view, new gm(profileimageactivity));
        }
        return;
_L2:
        if (StringUtils.isNotEmpty(profileimageactivity.c))
        {
            view = new TypedFile("application/octet-stream", new File(profileimageactivity.c));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
