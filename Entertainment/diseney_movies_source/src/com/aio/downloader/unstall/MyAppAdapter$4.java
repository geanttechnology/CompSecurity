// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
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
        view = new Intent("android.intent.action.DELETE", Uri.parse((new StringBuilder("package:")).append(val$myPackageNmae).toString()));
        MyAppAdapter.access$9(MyAppAdapter.this).getContext().startActivity(view);
        MyAppAdapter.access$8(MyAppAdapter.this).dismiss();
    }

    ()
    {
        this$0 = final_myappadapter;
        val$myPackageNmae = String.this;
        super();
    }
}
