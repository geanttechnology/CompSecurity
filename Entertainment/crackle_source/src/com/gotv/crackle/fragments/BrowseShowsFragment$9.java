// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.gotv.crackle.MainActivity;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseShowsFragment

class val.Message
    implements Runnable
{

    final BrowseShowsFragment this$0;
    final String val$Message;

    public void run()
    {
        BrowseShowsFragment.access$400(BrowseShowsFragment.this).setVisibility(4);
        try
        {
            ((MainActivity)BrowseShowsFragment.access$000(BrowseShowsFragment.this)).mNetworkDialog.setMessage(val$Message);
            ((MainActivity)BrowseShowsFragment.access$000(BrowseShowsFragment.this)).mNetworkDialog.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_browseshowsfragment;
        val$Message = String.this;
        super();
    }
}
