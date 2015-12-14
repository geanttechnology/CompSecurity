// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.Intent;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal.utils:
//            MediaUtils

static final class val.photoListener
    implements com.millennialmedia.internal.erActivity.MMIntentWrapperListener
{

    final File val$file;
    final otoListener val$photoListener;

    public void onData(Intent intent)
    {
        if (val$file != null && val$file.exists())
        {
            val$photoListener.onPhoto(val$file);
            return;
        } else
        {
            val$photoListener.onError("Unable to get image from camera");
            return;
        }
    }

    public void onError(String s)
    {
        val$photoListener.onError(s);
    }

    otoListener(File file1, otoListener otolistener)
    {
        val$file = file1;
        val$photoListener = otolistener;
        super();
    }
}
