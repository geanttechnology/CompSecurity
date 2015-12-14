// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.googledrive:
//            UploadInGoogleDriveActivity

final class a
    implements android.content.er
{

    private UploadInGoogleDriveActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        UploadInGoogleDriveActivity.a(false);
        a.setResult(0);
        a.finish();
    }

    (UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        a = uploadingoogledriveactivity;
        super();
    }
}
