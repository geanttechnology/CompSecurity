// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.socialin.android.googledrive:
//            UploadInGoogleDriveActivity

final class a
    implements ResultCallback
{

    private UploadInGoogleDriveActivity a;

    public final void onResult(Result result)
    {
        result = (Status)result;
        if (result != null && result.isSuccess())
        {
            UploadInGoogleDriveActivity.d(a);
        }
    }

    (UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        a = uploadingoogledriveactivity;
        super();
    }
}
