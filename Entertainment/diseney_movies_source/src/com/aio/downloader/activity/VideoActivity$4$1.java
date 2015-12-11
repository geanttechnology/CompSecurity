// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;
import android.widget.AdapterView;
import com.aio.downloader.dialog.VideoDownloadDialog;
import com.aio.downloader.model.VideoModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class val.position
    implements Runnable
{

    final tem_id this$1;
    private final ArrayList val$list;
    private final int val$position;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=")).append(((VideoModel)val$list.get(val$position)).getVideo_item_id()).toString());
    }

    l.dialog()
    {
        this$1 = final_dialog;
        val$list = arraylist;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/VideoActivity$4

/* anonymous class */
    class VideoActivity._cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final VideoActivity this$0;
        private final VideoDownloadDialog val$dialog;
        private final ArrayList val$list;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            try
            {
                VideoDownload(((VideoModel)list.get(i)).getVideo_item_id(), ((VideoModel)list.get(i)).getVideo_item_title(), ((VideoModel)list.get(i)).getVideo_item_url(), ((VideoModel)list.get(i)).getVideo_item_img());
                (new Thread(i. new VideoActivity._cls4._cls1())).start();
            }
            // Misplaced declaration of an exception variable
            catch (AdapterView adapterview)
            {
                adapterview.printStackTrace();
            }
            dialog.dismiss();
        }

            
            {
                this$0 = final_videoactivity;
                list = arraylist;
                dialog = VideoDownloadDialog.this;
                super();
            }
    }

}
