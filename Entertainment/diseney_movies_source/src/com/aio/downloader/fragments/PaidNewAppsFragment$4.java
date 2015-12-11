// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.fragments:
//            PaidNewAppsFragment

class this._cls0
    implements android.widget.kListener
{

    final PaidNewAppsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/aio/downloader/activity/AppDetailsActivity);
        if (!PaidNewAppsFragment.access$4(PaidNewAppsFragment.this))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        adapterview.putExtra("myid", ((DownloadMovieItem)PaidNewAppsFragment.access$5(PaidNewAppsFragment.this).get(i - 1)).getId());
_L1:
        startActivity(adapterview);
        return;
        try
        {
            adapterview.putExtra("myid", ((DownloadMovieItem)PaidNewAppsFragment.access$5(PaidNewAppsFragment.this).get(i)).getId());
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            return;
        }
          goto _L1
    }

    ()
    {
        this$0 = PaidNewAppsFragment.this;
        super();
    }
}
