// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.net.Uri;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal.utils:
//            MediaUtils

static final class val.pictureListener
    implements android.media.onnection.OnScanCompletedListener
{

    final boolean val$deleteOnFailure;
    final File val$file;
    final vePictureListener val$pictureListener;

    public void onScanCompleted(String s, Uri uri)
    {
        if (uri == null)
        {
            if (val$deleteOnFailure)
            {
                val$file.delete();
            }
            val$pictureListener.onError((new StringBuilder()).append("Failed to scan file ").append(s).toString());
            return;
        } else
        {
            val$pictureListener.onPictureSaved(val$file);
            return;
        }
    }

    vePictureListener(boolean flag, File file1, vePictureListener vepicturelistener)
    {
        val$deleteOnFailure = flag;
        val$file = file1;
        val$pictureListener = vepicturelistener;
        super();
    }
}
