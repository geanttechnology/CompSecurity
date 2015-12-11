// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.view.View;
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
        MyAppAdapter.access$10(MyAppAdapter.this, (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(val$myPackageNmae).toString());
        MyAppAdapter.access$11(MyAppAdapter.this, val$myPackageNmae);
        (new a1(MyAppAdapter.this)).execute(new Void[0]);
        MyAppAdapter.access$8(MyAppAdapter.this).dismiss();
    }

    a1()
    {
        this$0 = final_myappadapter;
        val$myPackageNmae = String.this;
        super();
    }
}
