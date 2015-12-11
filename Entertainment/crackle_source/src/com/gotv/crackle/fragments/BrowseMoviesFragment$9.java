// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.gotv.crackle.MainActivity;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseMoviesFragment

class val.Message
    implements Runnable
{

    final BrowseMoviesFragment this$0;
    final String val$Message;

    public void run()
    {
        BrowseMoviesFragment.access$400(BrowseMoviesFragment.this).setVisibility(4);
        try
        {
            ((MainActivity)BrowseMoviesFragment.access$000(BrowseMoviesFragment.this)).mNetworkDialog.setMessage(val$Message);
            ((MainActivity)BrowseMoviesFragment.access$000(BrowseMoviesFragment.this)).mNetworkDialog.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_browsemoviesfragment;
        val$Message = String.this;
        super();
    }
}
