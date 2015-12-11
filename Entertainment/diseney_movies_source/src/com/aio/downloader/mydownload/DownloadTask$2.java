// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadTask, DownloadMovieItem, DownloadFile

class this._cls0 extends BroadcastReceiver
{

    final DownloadTask this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("type");
        Log.v("mjmj", (new StringBuilder("*******")).append(context).toString());
        if (context.equals("pause"))
        {
            if (DownloadTask.access$0(DownloadTask.this) != null)
            {
                context = (TextView)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f070276);
                DownloadTask.access$2(DownloadTask.this).getDownloadFile().stopDownload();
                if (context != null)
                {
                    context.setText("Start");
                }
                DownloadTask.access$0(DownloadTask.this).clickState = true;
            }
        } else
        {
            if (context.equals("resume"))
            {
                context = (TextView)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f070276);
                intent = (TextView)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f07027c);
                if (context != null)
                {
                    context.setText("Pause");
                    context.setVisibility(4);
                    intent.setTextColor(Color.parseColor("#cccccc"));
                    intent.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0020));
                }
                context = DownloadTask.access$2(DownloadTask.this).getDownloadUrl();
                intent = DownloadTask.access$2(DownloadTask.this).getFilePath();
                DownloadTask.access$2(DownloadTask.this).setDownloadFile((new DownloadFile()).startDownloadFileByUrl(context, intent, new llBackFuc(DownloadTask.this, DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this))));
                return;
            }
            if (context.equals("delete"))
            {
                DownloadTask.access$4(DownloadTask.this).onDelete(DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this), Boolean.valueOf(true));
                return;
            }
        }
    }

    DeleteTaskListener()
    {
        this$0 = DownloadTask.this;
        super();
    }
}
