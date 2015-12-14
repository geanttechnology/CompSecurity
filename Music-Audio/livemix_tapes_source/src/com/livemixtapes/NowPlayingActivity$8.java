// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.ui.FadeImageButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity, Utils

class this._cls0
    implements android.view.y._cls8
{

    final NowPlayingActivity this$0;

    public void onClick(View view)
    {
        view = (HashMap)NowPlayingActivity.tracksList.get(NowPlayingActivity.position);
        android.app.st st = new android.app.st(Uri.parse(((String)view.get("download_url")).toString()));
        st.setDescription(((String)view.get("track_title")).toString());
        st.setTitle(((String)view.get("track_title")).toString());
        if (android.os. >= 11)
        {
            st.allowScanningByMediaScanner();
            st.setNotificationVisibility(0);
        }
        st.setAllowedNetworkTypes(3);
        DBHelper.sharedInstance(NowPlayingActivity.mContext).insertDownload((String)view.get("track_id"), (String)view.get("track_title"), NowPlayingActivity.mixtape.get("id").toString(), (String)NowPlayingActivity.mixtape.get("title"), NowPlayingActivity.mixtape.get("cover").toString(), (String)view.get("track_duration"), 1);
        st.setDestinationUri(Uri.fromFile(Utils.getLivemixtapesFolder(NowPlayingActivity.mContext, ((String)view.get("track_id")).toString())));
        ((DownloadManager)NowPlayingActivity.mContext.getSystemService("download")).enqueue(st);
        NowPlayingActivity.download.setVisibility(4);
    }

    ()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
