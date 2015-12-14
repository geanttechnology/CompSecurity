// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googledrive:
//            OpenGoogleDriveActivity

final class a
    implements com.google.android.gms.common.api.Callbacks
{

    private OpenGoogleDriveActivity a;

    public final void onConnected(Bundle bundle)
    {
        if (!a.c)
        {
            bundle = Drive.DriveApi.newOpenFileActivityBuilder().setMimeType(OpenGoogleDriveActivity.a()).setActivityTitle(a.getString(0x7f080322)).build(a.a);
            try
            {
                m.b(a, OpenGoogleDriveActivity.a(a));
                a.startIntentSenderForResult(bundle, 40, null, 0, 0, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.w("UNABLE", "Unable to send intent", bundle);
            }
            a.c = true;
        }
    }

    public final void onConnectionSuspended(int i)
    {
    }

    nCallbacks(OpenGoogleDriveActivity opengoogledriveactivity)
    {
        a = opengoogledriveactivity;
        super();
    }
}
