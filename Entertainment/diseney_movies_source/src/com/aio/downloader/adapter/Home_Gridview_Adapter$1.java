// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

class this._cls0 extends Handler
{

    final Home_Gridview_Adapter this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            try
            {
                Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "It has been in downloading list already.", 1).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                return;
            }

        case 3: // '\003'
            Home_Gridview_Adapter.access$1(Home_Gridview_Adapter.this, Boolean.valueOf(true));
            Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), (new StringBuilder("'")).append(Home_Gridview_Adapter.access$2(Home_Gridview_Adapter.this).getString("appname", "this app")).append("' is added to download queue.").toString(), 0).show();
            message = new Intent();
            break;
        }
        if (!Home_Gridview_Adapter.access$3(Home_Gridview_Adapter.this).equals("appfeatured")) goto _L2; else goto _L1
_L1:
        message.setAction("appfeatured");
        message.setAction("app");
_L4:
        Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).sendBroadcast(message);
        return;
_L2:
        if (Home_Gridview_Adapter.access$3(Home_Gridview_Adapter.this).equals("homefeatured"))
        {
            message.setAction("homeapp");
        } else
        if (Home_Gridview_Adapter.access$3(Home_Gridview_Adapter.this).equals("gamefeatured"))
        {
            message.setAction("gamefeatured");
            message.setAction("game");
        } else
        if (Home_Gridview_Adapter.access$3(Home_Gridview_Adapter.this).equals("homefeatured"))
        {
            message.setAction("homefeatured");
        } else
        if (Home_Gridview_Adapter.access$3(Home_Gridview_Adapter.this).equals("appdetail"))
        {
            message.setAction("appdetail");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = Home_Gridview_Adapter.this;
        super();
    }
}
