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

class this._cls1
    implements android.view.edAdapter._cls1._cls5
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        RingtoneDownloadedAdapter.access$4(_fld0).dismiss();
    }

    l.in_fo()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/RingtoneDownloadedAdapter$1

/* anonymous class */
    class RingtoneDownloadedAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final RingtoneDownloadedAdapter this$0;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            RingtoneDownloadedAdapter.access$0(RingtoneDownloadedAdapter.this, view);
            RingtoneDownloadedAdapter.access$1(RingtoneDownloadedAdapter.this, (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone/").append(in_fo.getFile_id()).append(".mp3").toString());
            publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone").toString());
            try
            {
                publicTools.copyFile(in_fo.getFilePath(), RingtoneDownloadedAdapter.access$2(RingtoneDownloadedAdapter.this));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            sp.edit().putString("movivename", in_fo.getMovieName()).commit();
            RingtoneDownloadedAdapter.access$3(RingtoneDownloadedAdapter.this).setOnClickListener(new RingtoneDownloadedAdapter._cls1._cls1());
            RingtoneDownloadedAdapter.access$5(RingtoneDownloadedAdapter.this).setOnClickListener(new RingtoneDownloadedAdapter._cls1._cls2());
            RingtoneDownloadedAdapter.access$6(RingtoneDownloadedAdapter.this).setOnClickListener(new RingtoneDownloadedAdapter._cls1._cls3());
            RingtoneDownloadedAdapter.access$7(RingtoneDownloadedAdapter.this).setOnClickListener(new RingtoneDownloadedAdapter._cls1._cls4());
            RingtoneDownloadedAdapter.access$8(RingtoneDownloadedAdapter.this).setOnClickListener(new RingtoneDownloadedAdapter._cls1._cls5());
        }


            
            {
                this$0 = final_ringtonedownloadedadapter;
                in_fo = DownloadMovieItem.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1

/* anonymous class */
        class RingtoneDownloadedAdapter._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view)
            {
                setRingtone(7, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

                    
                    {
                        this$1 = RingtoneDownloadedAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/adapter/RingtoneDownloadedAdapter$1$2

/* anonymous class */
        class RingtoneDownloadedAdapter._cls1._cls2
            implements android.view.View.OnClickListener
        {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view)
            {
                setRingtone(1, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

                    
                    {
                        this$1 = RingtoneDownloadedAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/adapter/RingtoneDownloadedAdapter$1$3

/* anonymous class */
        class RingtoneDownloadedAdapter._cls1._cls3
            implements android.view.View.OnClickListener
        {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view)
            {
                setRingtone(2, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

                    
                    {
                        this$1 = RingtoneDownloadedAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/adapter/RingtoneDownloadedAdapter$1$4

/* anonymous class */
        class RingtoneDownloadedAdapter._cls1._cls4
            implements android.view.View.OnClickListener
        {

            final RingtoneDownloadedAdapter._cls1 this$1;

            public void onClick(View view)
            {
                setRingtone(4, RingtoneDownloadedAdapter.access$2(this$0));
                RingtoneDownloadedAdapter.access$4(this$0).dismiss();
            }

                    
                    {
                        this$1 = RingtoneDownloadedAdapter._cls1.this;
                        super();
                    }
        }

    }

}
