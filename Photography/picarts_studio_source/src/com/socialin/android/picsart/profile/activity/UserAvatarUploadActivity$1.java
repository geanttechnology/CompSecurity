// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserAvatarUploadActivity

final class a
    implements android.content.tener
{

    private UserAvatarUploadActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
        a.setResult(0);
        a.finish();
    }

    (UserAvatarUploadActivity useravataruploadactivity)
    {
        a = useravataruploadactivity;
        super();
    }
}
