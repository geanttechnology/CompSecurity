// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action.wallpaper;

import android.widget.Toast;

// Referenced classes of package com.amazon.gallery.framework.kindle.action.wallpaper:
//            LockscreenTask

class this._cls0
    implements Runnable
{

    final LockscreenTask this$0;

    public void run()
    {
        Toast.makeText(LockscreenTask.access$000(LockscreenTask.this), 0x7f0e018d, 0).show();
    }

    ()
    {
        this$0 = LockscreenTask.this;
        super();
    }
}
