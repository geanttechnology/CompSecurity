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

class g
    implements android.widget.emClickListener
{

    final VideoActivity this$0;
    private final VideoDownloadDialog val$dialog;
    private final ArrayList val$list;

    public void onItemClick(AdapterView adapterview, View view, final int position, long l)
    {
        try
        {
            VideoDownload(((VideoModel)val$list.get(position)).getVideo_item_id(), ((VideoModel)val$list.get(position)).getVideo_item_title(), ((VideoModel)val$list.get(position)).getVideo_item_url(), ((VideoModel)val$list.get(position)).getVideo_item_img());
            (new Thread(new Runnable() {

                final VideoActivity._cls4 this$1;
                private final ArrayList val$list;
                private final int val$position;

                public void run()
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=")).append(((VideoModel)list.get(position)).getVideo_item_id()).toString());
                }

            
            {
                this$1 = VideoActivity._cls4.this;
                list = arraylist;
                position = i;
                super();
            }
            })).start();
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            adapterview.printStackTrace();
        }
        val$dialog.dismiss();
    }

    g()
    {
        this$0 = final_videoactivity;
        val$list = arraylist;
        val$dialog = VideoDownloadDialog.this;
        super();
    }
}
