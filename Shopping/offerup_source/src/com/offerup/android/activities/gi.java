// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            ProfileImageActivity

final class gi
    implements android.view.View.OnClickListener
{

    private ProfileImageActivity a;

    gi(ProfileImageActivity profileimageactivity)
    {
        a = profileimageactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyProfileImage_SelectPhoto-Button_click");
        view = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        a.startActivityForResult(view, 522);
    }
}
