// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.aio.downloader.adapter.Mp3DownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            Mp3DownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    private int pos;
    final Mp3DownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        pos = intent.getIntExtra("position", 0);
        (new android.app.t>(Mp3DownloadedActivity.this)).itle(getString(0x7f0b0034)).essage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)Mp3DownloadedActivity.access$0(Mp3DownloadedActivity.this).get(pos)).getFilePath()).append("?").toString()).egativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

            final Mp3DownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = Mp3DownloadedActivity._cls1.this;
                super();
            }
        }).ositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

            final Mp3DownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Mp3DownloadedActivity.access$1(this$0).deletefile(((DownloadMovieItem)Mp3DownloadedActivity.access$0(this$0).get(pos)).getFile_id());
                dialoginterface = new File(((DownloadMovieItem)Mp3DownloadedActivity.access$0(this$0).get(pos)).getFilePath());
                if (dialoginterface.exists())
                {
                    dialoginterface.delete();
                }
                Mp3DownloadedActivity.access$0(this$0).remove(pos);
                Mp3DownloadedActivity.access$2(this$0).notifyDataSetChanged();
            }

            
            {
                this$1 = Mp3DownloadedActivity._cls1.this;
                super();
            }
        }).();
    }



    _cls2.this._cls1()
    {
        this$0 = Mp3DownloadedActivity.this;
        super();
    }
}
