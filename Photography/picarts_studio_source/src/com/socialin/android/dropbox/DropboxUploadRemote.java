// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.aj;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.dropbox:
//            c

public class DropboxUploadRemote
{

    public static final String TAG = com/socialin/android/dropbox/DropboxUploadRemote.getSimpleName();
    private aj dropboxSessionListener;
    private SharedPreferences settings;
    private String uploadedImgPath;

    public DropboxUploadRemote(Context context, String s)
    {
        uploadedImgPath = null;
        uploadedImgPath = s;
        settings = context.getSharedPreferences("DropboxPrefs", 0);
    }

    public void doDropboxUpload()
    {
        if (!a.b(settings))
        {
            if (dropboxSessionListener != null)
            {
                dropboxSessionListener.b();
            }
            return;
        } else
        {
            m.a(uploadedImgPath, "/", settings.getString("oauth2AccessToken", null), new c(this, dropboxSessionListener));
            return;
        }
    }

    public void setDropboxSessionListener(aj aj1)
    {
        dropboxSessionListener = aj1;
    }


}
