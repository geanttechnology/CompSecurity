// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.os.Bundle;

// Referenced classes of package com.socialin.android.googledrive:
//            UploadInGoogleDriveActivity

final class a
    implements com.google.android.gms.common.api.backs
{

    private UploadInGoogleDriveActivity a;

    public final void onConnected(Bundle bundle)
    {
        if (!UploadInGoogleDriveActivity.a())
        {
            UploadInGoogleDriveActivity.b(a);
            UploadInGoogleDriveActivity.a(true);
        }
    }

    public final void onConnectionSuspended(int i)
    {
    }

    lbacks(UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        a = uploadingoogledriveactivity;
        super();
    }
}
