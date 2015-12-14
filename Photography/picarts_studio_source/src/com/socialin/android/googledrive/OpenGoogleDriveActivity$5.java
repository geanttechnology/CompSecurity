// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;


// Referenced classes of package com.socialin.android.googledrive:
//            OpenGoogleDriveActivity

final class a extends Thread
{

    private OpenGoogleDriveActivity a;

    public final void run()
    {
        if (a.d)
        {
            OpenGoogleDriveActivity.b(a);
        }
    }

    (OpenGoogleDriveActivity opengoogledriveactivity)
    {
        a = opengoogledriveactivity;
        super();
    }
}
