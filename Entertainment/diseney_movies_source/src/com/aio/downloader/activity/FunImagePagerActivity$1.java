// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.io.FileNotFoundException;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

class this._cls0 extends Handler
{

    final FunImagePagerActivity this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 194
    //                   3 211;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        Toast.makeText(getApplicationContext(), "Download Complete", 0).show();
        try
        {
            android.provider.insertImage(getContentResolver(), (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").toString(), (new StringBuilder(String.valueOf(FunImagePagerActivity.access$0(FunImagePagerActivity.this)))).append(".jpg").toString(), null);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            try
            {
                message.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
                return;
            }
        }
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").append("/").append(FunImagePagerActivity.access$0(FunImagePagerActivity.this)).append(".jpg").toString())));
        return;
_L3:
        Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
        return;
_L4:
        Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
        return;
    }

    _cls9()
    {
        this$0 = FunImagePagerActivity.this;
        super();
    }
}
