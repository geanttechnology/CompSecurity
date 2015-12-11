// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.res.Resources;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.gotv.crackle.adapters.HistoryListAdapter;
import com.gotv.crackle.data.QueueManager;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleHistoryActivity

class this._cls0
    implements Runnable
{

    final MyCrackleHistoryActivity this$0;

    public void run()
    {
        MyCrackleHistoryActivity.access$300(MyCrackleHistoryActivity.this).setAdapter(new HistoryListAdapter(MyCrackleHistoryActivity.this, MyCrackleHistoryActivity.access$000(MyCrackleHistoryActivity.this).getItems(), MyCrackleHistoryActivity.access$100(MyCrackleHistoryActivity.this), MyCrackleHistoryActivity.access$200(MyCrackleHistoryActivity.this)));
        MyCrackleHistoryActivity.access$400(MyCrackleHistoryActivity.this).setVisibility(4);
        if (MyCrackleHistoryActivity.access$000(MyCrackleHistoryActivity.this).getItems().size() == 0)
        {
            Toast.makeText(MyCrackleHistoryActivity.this, getResources().getString(0x7f0b0103), 0).show();
        }
    }

    ()
    {
        this$0 = MyCrackleHistoryActivity.this;
        super();
    }
}
