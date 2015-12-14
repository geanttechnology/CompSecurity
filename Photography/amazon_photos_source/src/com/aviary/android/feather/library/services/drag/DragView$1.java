// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;

import android.view.View;
import android.view.WindowManager;

// Referenced classes of package com.aviary.android.feather.library.services.drag:
//            DragView

class val.view
    implements Runnable
{

    final DragView this$0;
    final View val$view;

    public void run()
    {
        mWindowManager.removeView(val$view);
    }

    A()
    {
        this$0 = final_dragview;
        val$view = View.this;
        super();
    }
}
