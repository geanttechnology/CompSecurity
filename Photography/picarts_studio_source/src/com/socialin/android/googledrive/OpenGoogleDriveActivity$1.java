// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.googledrive:
//            OpenGoogleDriveActivity

final class a
    implements android.content.stener
{

    private OpenGoogleDriveActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.setResult(0);
        a.finish();
    }

    (OpenGoogleDriveActivity opengoogledriveactivity)
    {
        a = opengoogledriveactivity;
        super();
    }
}
