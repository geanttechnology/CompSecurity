// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal.utils:
//            MediaUtils

static final class val.pictureListener
    implements oadListener
{

    final Context val$context;
    final vePictureListener val$pictureListener;

    public void onDownloadFailed(Throwable throwable)
    {
        val$pictureListener.onError("Unable to download file");
    }

    public void onDownloadSucceeded(File file)
    {
        MediaUtils.access$000(val$context, file, val$pictureListener, true);
    }

    vePictureListener(Context context1, vePictureListener vepicturelistener)
    {
        val$context = context1;
        val$pictureListener = vepicturelistener;
        super();
    }
}
