// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.aio.downloader.adapter.RingtoneDownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            RingtoneDownloadedActivity

class this._cls1
    implements android.content.
{

    final DataSetChanged this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RingtoneDownloadedActivity.access$1(_fld0).deletefile(((DownloadMovieItem)RingtoneDownloadedActivity.access$0(_fld0).get(s)).getFile_id());
        dialoginterface = new File(((DownloadMovieItem)RingtoneDownloadedActivity.access$0(_fld0).get(s)).getFilePath());
        if (dialoginterface.exists())
        {
            dialoginterface.delete();
        }
        RingtoneDownloadedActivity.access$0(_fld0).remove(s);
        RingtoneDownloadedActivity.access$2(_fld0).notifyDataSetChanged();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/RingtoneDownloadedActivity$1

/* anonymous class */
    class RingtoneDownloadedActivity._cls1 extends BroadcastReceiver
    {

        private int pos;
        final RingtoneDownloadedActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            pos = intent.getIntExtra("position", 0);
            (new android.app.AlertDialog.Builder(RingtoneDownloadedActivity.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)RingtoneDownloadedActivity.access$0(RingtoneDownloadedActivity.this).get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new RingtoneDownloadedActivity._cls1._cls1()).setPositiveButton(getString(0x7f0b003c), new RingtoneDownloadedActivity._cls1._cls2()).show();
        }



            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/activity/RingtoneDownloadedActivity$1$1

/* anonymous class */
        class RingtoneDownloadedActivity._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RingtoneDownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RingtoneDownloadedActivity._cls1.this;
                        super();
                    }
        }

    }

}
