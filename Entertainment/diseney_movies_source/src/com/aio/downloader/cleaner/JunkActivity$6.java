// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Environment;
import android.os.Handler;
import java.io.File;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class irectory
    implements Runnable
{

    String ext[] = {
        ".apk"
    };
    File fi;
    final JunkActivity this$0;

    public void run()
    {
        JunkActivity.access$58(JunkActivity.this, fi, ext);
        JunkActivity.access$55(JunkActivity.this).sendEmptyMessage(954);
    }

    ()
    {
        this$0 = JunkActivity.this;
        super();
        fi = Environment.getExternalStorageDirectory();
    }
}
