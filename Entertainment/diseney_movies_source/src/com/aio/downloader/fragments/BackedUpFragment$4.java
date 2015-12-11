// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.Environment;
import android.os.Handler;
import java.io.File;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpFragment

class ry
    implements Runnable
{

    String ext[] = {
        ".apk"
    };
    File file;
    final BackedUpFragment this$0;

    public void run()
    {
        BackedUpFragment.access$6(BackedUpFragment.this, file, ext);
        BackedUpFragment.access$7(BackedUpFragment.this).sendEmptyMessage(0);
    }

    ()
    {
        this$0 = BackedUpFragment.this;
        super();
        file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").toString());
    }
}
