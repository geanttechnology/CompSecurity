// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aio.downloader.activity.FunActivity1;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class this._cls0
    implements android.view.iew_Adapter._cls2
{

    final Home_app_Listview_Adapter this$0;

    public void onClick(View view)
    {
        Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/FunActivity1));
    }

    ()
    {
        this$0 = Home_app_Listview_Adapter.this;
        super();
    }
}
