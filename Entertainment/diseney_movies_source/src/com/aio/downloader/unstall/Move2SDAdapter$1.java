// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            Move2SDAdapter, Info

class val.position
    implements android.view.ner
{

    final Move2SDAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse((new StringBuilder("package:")).append(((Info)Move2SDAdapter.access$0(Move2SDAdapter.this).get(val$position)).getPackagename()).toString()));
        Move2SDAdapter.access$1(Move2SDAdapter.this).startActivity(view);
    }

    ()
    {
        this$0 = final_move2sdadapter;
        val$position = I.this;
        super();
    }
}
