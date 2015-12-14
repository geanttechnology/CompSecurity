// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.livemixtapes.database.DBHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;

// Referenced classes of package com.livemixtapes:
//            Mixtape, LazyAdapterTracks

class this._cls0 extends TimerTask
{

    final Mixtape this$0;

    public void run()
    {
        if (!downloadProgressList.isEmpty()) goto _L2; else goto _L1
_L1:
        cancel();
        globalTimer = null;
_L4:
        return;
_L2:
        if (Mixtape.access$42(Mixtape.this) != 0) goto _L4; else goto _L3
_L3:
        Iterator iterator = downloadProgressList.keySet().iterator();
_L8:
        if (!iterator.hasNext()) goto _L4; else goto _L5
_L5:
        final String key;
        int i;
        key = (String)iterator.next();
        i = ((Integer)listPosMap.get(key)).intValue();
        if (i < Mixtape.access$32(Mixtape.this).getFirstVisiblePosition() || i > Mixtape.access$32(Mixtape.this).getLastVisiblePosition()) goto _L4; else goto _L6
_L6:
        final View v = Mixtape.access$32(Mixtape.this).getChildAt(i - Mixtape.access$32(Mixtape.this).getFirstVisiblePosition());
        if (v == null) goto _L4; else goto _L7
_L7:
        handler.post(new Runnable() {

            final Mixtape._cls26 this$1;
            private final String val$key;
            private final View val$v;

            public void run()
            {
                int j = getIndividualFileProgress(key);
                ((ProgressBar)v.findViewById(0x7f080138)).setProgress(j);
                if (j == 100)
                {
                    downloadProgressList.remove(key);
                    dbHelper.markDownloadComplete(key);
                    adapter.notifyDataSetChanged();
                }
            }

            
            {
                this$1 = Mixtape._cls26.this;
                key = s;
                v = view;
                super();
            }
        });
          goto _L8
    }


    _cls1.val.v()
    {
        this$0 = Mixtape.this;
        super();
    }
}
