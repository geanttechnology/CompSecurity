// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.AlertDialog;
import android.widget.ProgressBar;
import com.gotv.crackle.MainActivity;

// Referenced classes of package com.gotv.crackle.fragments:
//            HomeFragment

class val.Message
    implements Runnable
{

    final HomeFragment this$0;
    final String val$Message;

    public void run()
    {
        HomeFragment.access$600(HomeFragment.this).setVisibility(4);
        try
        {
            ((MainActivity)HomeFragment.access$300(HomeFragment.this)).mNetworkDialog.setMessage(val$Message);
            ((MainActivity)HomeFragment.access$300(HomeFragment.this)).mNetworkDialog.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_homefragment;
        val$Message = String.this;
        super();
    }
}
