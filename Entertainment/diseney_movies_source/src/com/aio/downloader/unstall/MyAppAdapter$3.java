// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

// Referenced classes of package com.aio.downloader.unstall:
//            MyAppAdapter

class val.myPackageNmae
    implements android.view.tener
{

    final MyAppAdapter this$0;
    private final String val$myPackageNmae;

    public void onClick(View view)
    {
        try
        {
            view = MyAppAdapter.access$5(MyAppAdapter.this).getPackageManager().getLaunchIntentForPackage(val$myPackageNmae);
            view.addFlags(0x10000000);
            MyAppAdapter.access$5(MyAppAdapter.this).startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Toast.makeText(MyAppAdapter.access$5(MyAppAdapter.this), "This program is protected", 0).show();
        }
        MyAppAdapter.access$8(MyAppAdapter.this).dismiss();
    }

    ()
    {
        this$0 = final_myappadapter;
        val$myPackageNmae = String.this;
        super();
    }
}
