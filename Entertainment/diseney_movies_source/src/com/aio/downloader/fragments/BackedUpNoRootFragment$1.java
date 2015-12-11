// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.aio.downloader.db.TypeDbUtilsBackup;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpNoRootFragment

class this._cls0 extends Handler
{

    final BackedUpNoRootFragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (message.what != 100)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        BackedUpNoRootFragment.access$1(BackedUpNoRootFragment.this, BackedUpNoRootFragment.access$0(BackedUpNoRootFragment.this).queryApk("game_app", "timesort"));
        if (BackedUpNoRootFragment.access$2(BackedUpNoRootFragment.this) == null)
        {
            BackedUpNoRootFragment.access$1(BackedUpNoRootFragment.this, new ArrayList());
        }
        BackedUpNoRootFragment.access$3(BackedUpNoRootFragment.this, new sicListAdapter(BackedUpNoRootFragment.this));
        BackedUpNoRootFragment.access$4(BackedUpNoRootFragment.this).setAdapter(BackedUpNoRootFragment.access$5(BackedUpNoRootFragment.this));
        if (BackedUpNoRootFragment.access$2(BackedUpNoRootFragment.this).size() == 0)
        {
            BackedUpNoRootFragment.access$6(BackedUpNoRootFragment.this).setVisibility(0);
            BackedUpNoRootFragment.access$4(BackedUpNoRootFragment.this).setVisibility(8);
            return;
        }
        try
        {
            BackedUpNoRootFragment.access$6(BackedUpNoRootFragment.this).setVisibility(8);
            BackedUpNoRootFragment.access$4(BackedUpNoRootFragment.this).setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
    }

    sicListAdapter()
    {
        this$0 = BackedUpNoRootFragment.this;
        super();
    }
}
