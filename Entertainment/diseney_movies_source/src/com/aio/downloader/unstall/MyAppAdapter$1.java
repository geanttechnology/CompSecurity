// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

// Referenced classes of package com.aio.downloader.unstall:
//            MyAppAdapter

class val.myPackageNmae
    implements android.view.tener
{

    final MyAppAdapter this$0;
    private final String val$myPackageNmae;

    public void onClick(View view)
    {
        WindowManager windowmanager = (WindowManager)MyAppAdapter.access$5(MyAppAdapter.this).getSystemService("window");
        windowmanager.getDefaultDisplay().getWidth();
        int i = windowmanager.getDefaultDisplay().getHeight();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        MyAppAdapter.access$7(MyAppAdapter.this, val$myPackageNmae);
        if (i / 2 < ai[1])
        {
            int j = MyAppAdapter.dip2px(MyAppAdapter.access$5(MyAppAdapter.this), 200F);
            MyAppAdapter.access$8(MyAppAdapter.this).showAtLocation(view, 0, ai[0], ai[1] - j);
            return;
        } else
        {
            MyAppAdapter.access$8(MyAppAdapter.this).showAtLocation(view, 0, ai[0], ai[1] - MyAppAdapter.access$8(MyAppAdapter.this).getHeight());
            return;
        }
    }

    ()
    {
        this$0 = final_myappadapter;
        val$myPackageNmae = String.this;
        super();
    }
}
