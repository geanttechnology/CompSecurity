// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.ActivityManager;
import android.content.Context;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity

public class this._cls0
{

    final RubActivity this$0;

    public long getmem_UNUSED(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ryInfo ryinfo = new android.app.ryInfo();
        context.getMemoryInfo(ryinfo);
        return ryinfo.availMem / 1024L;
    }

    public ()
    {
        this$0 = RubActivity.this;
        super();
    }
}
