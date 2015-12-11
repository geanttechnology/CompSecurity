// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            MyAdapter, Info

class val.position
    implements android.view.Listener
{

    final MyAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.DELETE", Uri.parse((new StringBuilder("package:")).append(((Info)MyAdapter.access$0(MyAdapter.this).get(val$position)).getPackagename()).toString()));
        MyAdapter.access$1(MyAdapter.this).getContext().startActivity(view);
    }

    ()
    {
        this$0 = final_myadapter;
        val$position = I.this;
        super();
    }
}
