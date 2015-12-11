// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.view.View;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment

class val.layout
    implements android.view.ner
{

    final DetailFragment this$0;
    final View val$layout;
    final VideoFacade val$video;

    public void onClick(View view)
    {
        view = downloadManager.findFileWithVideoId(val$video.getVideoId());
        if (view != null)
        {
            try
            {
                downloadManager.deleteFile(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                DetailFragment.access$000(DetailFragment.this).error(view.getMessage(), view);
            }
        }
        DetailFragment.access$100(DetailFragment.this, false, val$layout);
        DetailFragment.access$200(DetailFragment.this, val$video, val$layout);
        return;
    }

    Manager()
    {
        this$0 = final_detailfragment;
        val$video = videofacade;
        val$layout = View.this;
        super();
    }
}
