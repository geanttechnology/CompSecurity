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
//            AppGridviewAdapter

class this._cls0 extends Handler
{

    final AppGridviewAdapter this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(AppGridviewAdapter.access$0(AppGridviewAdapter.this), "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            try
            {
                Toast.makeText(AppGridviewAdapter.access$0(AppGridviewAdapter.this), "It has been in downloading list already.", 1).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                return;
            }

        case 3: // '\003'
            AppGridviewAdapter.access$1(AppGridviewAdapter.this, Boolean.valueOf(true));
            Toast.makeText(AppGridviewAdapter.access$0(AppGridviewAdapter.this), (new StringBuilder("'")).append(AppGridviewAdapter.access$2(AppGridviewAdapter.this).getString("appname", "this app")).append("' is added to download queue.").toString(), 0).show();
            message = new Intent();
            break;
        }
        if (!AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvdetail")) goto _L2; else goto _L1
_L1:
        message.setAction("appdetail");
_L4:
        AppGridviewAdapter.access$0(AppGridviewAdapter.this).sendBroadcast(message);
        return;
_L2:
        if (AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvhome"))
        {
            message.setAction("homeapp");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = AppGridviewAdapter.this;
        super();
    }
}
