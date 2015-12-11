// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;
import com.aio.downloader.utils.ProgressWheel;
import com.ant.liao.GifView;
import java.io.File;
import java.io.FileNotFoundException;

// Referenced classes of package com.aio.downloader.activity:
//            FunGifActivity

class this._cls0 extends Handler
{

    final FunGifActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.what != 291 && message.what != 1) goto _L2; else goto _L1
_L1:
        FunGifActivity.access$0(FunGifActivity.this).setVisibility(8);
        FunGifActivity.access$1(FunGifActivity.this).setVisibility(8);
        if (message.what != 291) goto _L4; else goto _L3
_L3:
        message = (File)message.obj;
        FunGifActivity.access$2(FunGifActivity.this).setGifImage(message.getAbsolutePath());
        FunGifActivity.access$3(FunGifActivity.this, FunGifActivity.access$2(FunGifActivity.this).getViewTreeObserver());
_L6:
        return;
_L4:
        message = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(FunGifActivity.access$4(FunGifActivity.this)).append(".gif").toString();
        FunGifActivity.access$2(FunGifActivity.this).setGifImage(message);
        FunGifActivity.access$3(FunGifActivity.this, FunGifActivity.access$2(FunGifActivity.this).getViewTreeObserver());
        Toast.makeText(getApplicationContext(), "Download Complete", 0).show();
        try
        {
            android.provider..Media.insertImage(getContentResolver(), (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").toString(), (new StringBuilder(String.valueOf(FunGifActivity.access$4(FunGifActivity.this)))).append(".gif").toString(), null);
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
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(FunGifActivity.access$4(FunGifActivity.this)).append(".gif").toString())));
        return;
_L2:
        if (message.what == 2)
        {
            Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
            return;
        }
        if (message.what == 3)
        {
            Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
            return;
        }
        if (message.what == 4)
        {
            FunGifActivity.access$0(FunGifActivity.this).setVisibility(8);
            FunGifActivity.access$1(FunGifActivity.this).setVisibility(8);
            message = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(FunGifActivity.access$4(FunGifActivity.this)).append(".gif").toString();
            FunGifActivity.access$2(FunGifActivity.this).setGifImage(message);
            FunGifActivity.access$3(FunGifActivity.this, FunGifActivity.access$2(FunGifActivity.this).getViewTreeObserver());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = FunGifActivity.this;
        super();
    }
}
