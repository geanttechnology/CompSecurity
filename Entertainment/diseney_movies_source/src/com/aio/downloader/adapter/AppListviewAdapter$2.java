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
//            AppListviewAdapter

class val.has_apk
    implements android.view.viewAdapter._cls2
{

    final AppListviewAdapter this$0;
    private final String val$has_apk;
    private final int val$position;

    public void onClick(View view)
    {
        int ai[];
        try
        {
            WindowManager windowmanager = (WindowManager)AppListviewAdapter.access$0(AppListviewAdapter.this).getSystemService("window");
            windowmanager.getDefaultDisplay().getWidth();
            int i = windowmanager.getDefaultDisplay().getHeight();
            ai = new int[2];
            view.getLocationOnScreen(ai);
            AppListviewAdapter.access$6(AppListviewAdapter.this, val$position, val$has_apk);
            if (i / 2 < ai[1])
            {
                int j = AppListviewAdapter.dip2px(AppListviewAdapter.access$0(AppListviewAdapter.this), 150F);
                AppListviewAdapter.access$7(AppListviewAdapter.this).showAtLocation(view, 0, ai[0], ai[1] - j);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        AppListviewAdapter.access$7(AppListviewAdapter.this).showAtLocation(view, 0, ai[0], ai[1] - AppListviewAdapter.access$7(AppListviewAdapter.this).getHeight());
        return;
    }

    ()
    {
        this$0 = final_applistviewadapter;
        val$position = i;
        val$has_apk = String.this;
        super();
    }
}
