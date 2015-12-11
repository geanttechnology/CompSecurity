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

class val.parentChannelID
    implements com.gotv.crackle.data.Listener
{

    final VideoPlayerActivity this$0;
    final String val$parentChannelID;
    final ItemsListRequest val$req;

    public void onDataFailed(String s, String s1)
    {
        Log.w(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), "Failed to get featured movie list for auto-play");
    }

    public void onDataSuccess(final String detailsProvider)
    {
        detailsProvider = null;
        boolean flag = false;
        Iterator iterator = val$req.getItems().iterator();
        do
        {
            String s;
            BrowseModel browsemodel;
label0:
            {
                s = detailsProvider;
                if (iterator.hasNext())
                {
                    browsemodel = (BrowseModel)iterator.next();
                    s = detailsProvider;
                    if (detailsProvider == null)
                    {
                        s = detailsProvider;
                        if (!browsemodel.getID().equals(val$parentChannelID))
                        {
                            s = browsemodel.getID();
                        }
                    }
                    if (!flag)
                    {
                        break label0;
                    }
                    s = browsemodel.getID();
                }
                if (s != null)
                {
                    detailsProvider = new DetailsProvider();
                    detailsProvider.getDataWithChannelId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

                        final VideoPlayerActivity._cls23 this$1;
                        final DetailsProvider val$detailsProvider;

                        public void onDataFailed(String s1, String s2)
                        {
                            Log.w(VideoPlayerActivity.access$1400(this$0), "Failed to get channel details loading next featured movie");
                        }

                        public void onDataSuccess(String s1)
                        {
                            VideoPlayerActivity.access$802(this$0, detailsProvider.getMediaId());
                        }

            
            {
                this$1 = VideoPlayerActivity._cls23.this;
                detailsProvider = detailsprovider;
                super();
            }
                    }, s);
                }
                return;
            }
            detailsProvider = s;
            if (browsemodel.getID().equals(val$parentChannelID))
            {
                flag = true;
                detailsProvider = null;
            }
        } while (true);
    }

    _cls1.val.detailsProvider()
    {
        this$0 = final_videoplayeractivity;
        val$req = itemslistrequest;
        val$parentChannelID = String.this;
        super();
    }
}
