// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.util.Log;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class val.detailsProvider
    implements com.gotv.crackle.data.stener
{

    final ediaId this$1;
    final DetailsProvider val$detailsProvider;

    public void onDataFailed(String s, String s1)
    {
        Log.w(VideoPlayerActivity.access$1400(_fld0), "Failed to get channel details loading next featured movie");
    }

    public void onDataSuccess(String s)
    {
        VideoPlayerActivity.access$802(_fld0, val$detailsProvider.getMediaId());
    }

    l.parentChannelID()
    {
        this$1 = final_parentchannelid;
        val$detailsProvider = DetailsProvider.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$23

/* anonymous class */
    class VideoPlayerActivity._cls23
        implements com.gotv.crackle.data.DataRequest.DataRequestListener
    {

        final VideoPlayerActivity this$0;
        final String val$parentChannelID;
        final ItemsListRequest val$req;

        public void onDataFailed(String s, String s1)
        {
            Log.w(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), "Failed to get featured movie list for auto-play");
        }

        public void onDataSuccess(String s)
        {
            s = null;
            boolean flag = false;
            Iterator iterator = req.getItems().iterator();
            do
            {
                String s1;
                BrowseModel browsemodel;
label0:
                {
                    s1 = s;
                    if (iterator.hasNext())
                    {
                        browsemodel = (BrowseModel)iterator.next();
                        s1 = s;
                        if (s == null)
                        {
                            s1 = s;
                            if (!browsemodel.getID().equals(parentChannelID))
                            {
                                s1 = browsemodel.getID();
                            }
                        }
                        if (!flag)
                        {
                            break label0;
                        }
                        s1 = browsemodel.getID();
                    }
                    if (s1 != null)
                    {
                        s = new DetailsProvider();
                        s.getDataWithChannelId(s. new VideoPlayerActivity._cls23._cls1(), s1);
                    }
                    return;
                }
                s = s1;
                if (browsemodel.getID().equals(parentChannelID))
                {
                    flag = true;
                    s = null;
                }
            } while (true);
        }

            
            {
                this$0 = final_videoplayeractivity;
                req = itemslistrequest;
                parentChannelID = String.this;
                super();
            }
    }

}
