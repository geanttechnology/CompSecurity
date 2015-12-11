// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.content.Context;
import android.view.View;

// Referenced classes of package com.aio.downloader.floatwindow:
//            FloatWindowBigView, MyWindowManager

class val.context
    implements android.view.atWindowBigView._cls2
{

    final FloatWindowBigView this$0;
    private final Context val$context;

    public void onClick(View view)
    {
        MyWindowManager.removeBigWindow(val$context);
        MyWindowManager.createSmallWindow(val$context);
    }

    _cls9()
    {
        this$0 = final_floatwindowbigview;
        val$context = Context.this;
        super();
    }
}
