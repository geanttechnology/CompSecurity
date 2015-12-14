// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.widget.Toast;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.socialin.android.googledrive:
//            UploadInGoogleDriveActivity

final class a
    implements ResultCallback
{

    private String a;
    private UploadInGoogleDriveActivity b;

    public final void onResult(Result result)
    {
        result = (com.google.android.gms.drive.y)result;
        if (!result.etStatus().isSuccess())
        {
            Toast.makeText(b, result.etStatus().toString(), 1).show();
            return;
        } else
        {
            UploadInGoogleDriveActivity.a(b, result, a);
            return;
        }
    }

    (UploadInGoogleDriveActivity uploadingoogledriveactivity, String s)
    {
        b = uploadingoogledriveactivity;
        a = s;
        super();
    }
}
