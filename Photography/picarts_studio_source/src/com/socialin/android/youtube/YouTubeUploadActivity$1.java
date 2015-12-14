// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.youtube;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.youtube:
//            YouTubeUploadActivity

final class a
    implements android.content.Listener
{

    private YouTubeUploadActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.setResult(1);
        a.finish();
    }

    (YouTubeUploadActivity youtubeuploadactivity)
    {
        a = youtubeuploadactivity;
        super();
    }
}
