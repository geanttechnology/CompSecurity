// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Player;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls0 extends Handler
{

    final MyDownloaderList this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 100 101: default 32
    //                   100 33
    //                   101 144;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        MyDownloaderList.access$1(MyDownloaderList.this, MyDownloaderList.access$0(MyDownloaderList.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
        if (MyDownloaderList.access$2(MyDownloaderList.this).size() == 0) goto _L5; else goto _L4
_L4:
        MyDownloaderList.access$3(MyDownloaderList.this).setVisibility(8);
        MyDownloaderList.access$4(MyDownloaderList.this).setVisibility(0);
_L8:
        if (MyDownloaderList.access$5(MyDownloaderList.this).size() <= 0) goto _L7; else goto _L6
_L6:
        MyDownloaderList.access$3(MyDownloaderList.this).setVisibility(8);
        MyDownloaderList.access$6(MyDownloaderList.this).setVisibility(0);
        MyDownloaderList.access$7(MyDownloaderList.this).setVisibility(0);
_L3:
        try
        {
            currenttime.setText((new StringBuilder(String.valueOf(Player.formatTime(MyDownloaderList.access$8(MyDownloaderList.this).mediaPlayer.getCurrentPosition())))).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
_L5:
        MyDownloaderList.access$3(MyDownloaderList.this).setVisibility(0);
        MyDownloaderList.access$4(MyDownloaderList.this).setVisibility(8);
          goto _L8
_L7:
        try
        {
            MyDownloaderList.access$6(MyDownloaderList.this).setVisibility(8);
            MyDownloaderList.access$7(MyDownloaderList.this).setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
          goto _L3
    }

    ()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
