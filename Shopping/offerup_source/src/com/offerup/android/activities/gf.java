// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.hardware.Camera;
import android.view.View;
import com.b.a.a.g;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            gg, gh, ProfileImageActivity

final class gf
    implements android.view.View.OnClickListener
{

    final ProfileImageActivity a;

    gf(ProfileImageActivity profileimageactivity)
    {
        a = profileimageactivity;
        super();
    }

    public final void onClick(View view)
    {
        int i = 1;
        com.offerup.android.tracker.a.b("MyProfileImage_TakePhoto-Button_click");
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            i = Camera.getNumberOfCameras();
        }
        if (i <= 0)
        {
            view = n.c(a);
            view.setTitle("Camera Not Found");
            view.setMessage("This function is not supported on your device.  Use the Gallery option instead.");
            view.setPositiveButton("Use Gallery", new gg(this));
            view.setNegativeButton("Cancel", new gh(this));
            n.a(view);
            return;
        }
        try
        {
            a.a = a.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
            view = new Intent("android.media.action.IMAGE_CAPTURE");
            view.putExtra("output", a.a);
            view.putExtra("android.intent.extras.CAMERA_FACING", 1);
            a.startActivityForResult(view, 306);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            g.a(super.getClass().getSimpleName(), view);
        }
        a.a("Error", "An error has occurred. If this continues, please contact support.");
    }
}
