// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.socialin.android.googledrive:
//            OpenGoogleDriveActivity

final class a
    implements com.google.android.gms.common.api.Callbacks
{

    private Intent a;
    private OpenGoogleDriveActivity b;

    public final void onConnected(Bundle bundle)
    {
        bundle = b;
        bundle.e = (DriveId)a.getParcelableExtra("response_drive_id");
        bundle.d = true;
        (new <init>(bundle)).start();
    }

    public final void onConnectionSuspended(int i)
    {
    }

    nCallbacks(OpenGoogleDriveActivity opengoogledriveactivity, Intent intent)
    {
        b = opengoogledriveactivity;
        a = intent;
        super();
    }
}
