// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.Intent;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.drive.DriveContents;
import com.socialin.android.util.FileUtils;
import java.io.File;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googledrive:
//            OpenGoogleDriveActivity

final class a
    implements ResultCallback
{

    private OpenGoogleDriveActivity a;

    public final void onResult(Result result)
    {
        result = ((com.google.android.gms.drive.lt)result).getDriveContents();
        if (result != null)
        {
            result = result.getInputStream();
            String s = (new StringBuilder("PicsArt_")).append(System.currentTimeMillis()).toString();
            result = FileUtils.a((new StringBuilder()).append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f08096a)).toString(), s, result).getPath();
            OpenGoogleDriveActivity.c(a).putExtra("path", result);
            m.b(a, OpenGoogleDriveActivity.a(a));
            a.setResult(-1, OpenGoogleDriveActivity.c(a));
            a.finish();
        }
    }

    (OpenGoogleDriveActivity opengoogledriveactivity)
    {
        a = opengoogledriveactivity;
        super();
    }
}
