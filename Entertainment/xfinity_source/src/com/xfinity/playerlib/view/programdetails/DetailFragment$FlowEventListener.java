// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.view.View;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment

private class <init>
    implements adFlowEventListener
{

    final DetailFragment this$0;

    public void onPreDownloadFlowCompleted(VideoFacade videofacade)
    {
        Object obj = getVideoItemViewContainer();
        if (obj != null)
        {
            obj = ((View) (obj)).findViewWithTag(Long.valueOf(videofacade.getVideoId()));
            DetailFragment.access$100(DetailFragment.this, true, ((View) (obj)));
            DetailFragment.access$400(DetailFragment.this, downloadManager.findFileWithVideoId(videofacade.getVideoId()), ((View) (obj)));
        }
    }

    private adFlowEventListener()
    {
        this$0 = DetailFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
