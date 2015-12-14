// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.Context;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;

// Referenced classes of package com.socialin.android.googledrive:
//            a, UploadInGoogleDriveActivity

final class a extends a
{

    private UploadInGoogleDriveActivity a;

    protected final Object a(Object aobj[])
    {
        aobj = (String[])aobj;
        com.google.android.gms.drive.ener ener = (com.google.android.gms.drive.y)UploadInGoogleDriveActivity.c(a).open(a.a, 0x20000000, null).await();
        if (!ener.etStatus().isSuccess())
        {
            UploadInGoogleDriveActivity.b();
            return ener.etStatus();
        } else
        {
            UploadInGoogleDriveActivity.a(a, ((String) (aobj[0])), ener.etDriveContents());
            return null;
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Status)obj;
        if (obj != null && ((Status) (obj)).isSuccess())
        {
            UploadInGoogleDriveActivity.d(a);
        }
    }

    (UploadInGoogleDriveActivity uploadingoogledriveactivity, String s, Context context)
    {
        a = uploadingoogledriveactivity;
        super(s, context);
    }
}
