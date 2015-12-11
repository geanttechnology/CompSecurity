// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.gotv.crackle.MainActivity;

// Referenced classes of package com.gotv.crackle.fragments:
//            WatchlistsFragment

class val.Message
    implements Runnable
{

    final WatchlistsFragment this$0;
    final String val$Message;

    public void run()
    {
        WatchlistsFragment.access$200(WatchlistsFragment.this).setVisibility(4);
        try
        {
            ((MainActivity)WatchlistsFragment.access$400(WatchlistsFragment.this)).mNetworkDialog.setMessage(val$Message);
            ((MainActivity)WatchlistsFragment.access$400(WatchlistsFragment.this)).mNetworkDialog.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_watchlistsfragment;
        val$Message = String.this;
        super();
    }
}
