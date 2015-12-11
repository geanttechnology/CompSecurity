// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

class val.has_apk
    implements android.view.iew_Adapter._cls2
{

    final Home_Gridview_Adapter this$0;
    private final String val$has_apk;
    private final int val$position;

    public void onClick(View view)
    {
        WindowManager windowmanager = (WindowManager)Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).getSystemService("window");
        windowmanager.getDefaultDisplay().getWidth();
        int i = windowmanager.getDefaultDisplay().getHeight();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        Home_Gridview_Adapter.access$4(Home_Gridview_Adapter.this, val$position, val$has_apk);
        if (i / 2 < ai[1])
        {
            int j = Home_Gridview_Adapter.dip2px(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), 150F);
            Home_Gridview_Adapter.access$5(Home_Gridview_Adapter.this).showAtLocation(view, 0, ai[0], ai[1] - j);
            return;
        } else
        {
            Home_Gridview_Adapter.access$5(Home_Gridview_Adapter.this).showAtLocation(view, 0, ai[0], ai[1] - Home_Gridview_Adapter.access$5(Home_Gridview_Adapter.this).getHeight());
            return;
        }
    }

    ()
    {
        this$0 = final_home_gridview_adapter;
        val$position = i;
        val$has_apk = String.this;
        super();
    }
}
