// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.SharedPreferences;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.adapter:
//            RingtoneDownloadedAdapter

class val.in_fo
    implements android.view.adedAdapter._cls1
{

    final RingtoneDownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        RingtoneDownloadedAdapter.access$0(RingtoneDownloadedAdapter.this, view);
        RingtoneDownloadedAdapter.access$1(RingtoneDownloadedAdapter.this, (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone/").append(val$in_fo.getFile_id()).append(".mp3").toString());
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone").toString());
        try
        {
            publicTools.copyFile(val$in_fo.getFilePath(), RingtoneDownloadedAdapter.access$2(RingtoneDownloadedAdapter.this));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        sp.edit().String("movivename", val$in_fo.getMovieName()).mit();
        RingtoneDownloadedAdapter.access$3(RingtoneDownloadedAdapter.this).setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view1)
            {
                setRingtone(7, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

            
            {
                this$1 = RingtoneDownloadedAdapter._cls1.this;
                super();
            }
        });
        RingtoneDownloadedAdapter.access$5(RingtoneDownloadedAdapter.this).setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view1)
            {
                setRingtone(1, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

            
            {
                this$1 = RingtoneDownloadedAdapter._cls1.this;
                super();
            }
        });
        RingtoneDownloadedAdapter.access$6(RingtoneDownloadedAdapter.this).setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view1)
            {
                setRingtone(2, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

            
            {
                this$1 = RingtoneDownloadedAdapter._cls1.this;
                super();
            }
        });
        RingtoneDownloadedAdapter.access$7(RingtoneDownloadedAdapter.this).setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view1)
            {
                setRingtone(4, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

            
            {
                this$1 = RingtoneDownloadedAdapter._cls1.this;
                super();
            }
        });
        RingtoneDownloadedAdapter.access$8(RingtoneDownloadedAdapter.this).setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view1)
            {
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

            
            {
                this$1 = RingtoneDownloadedAdapter._cls1.this;
                super();
            }
        });
    }


    _cls5.this._cls1()
    {
        this$0 = final_ringtonedownloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
