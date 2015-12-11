// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.os.Debug;
import android.support.v7.widget.RecyclerView;
import com.groupon.util.DialogManager;

// Referenced classes of package com.groupon.v3.util:
//            ViewsPerSecondHelperV3

class llListener extends android.support.v7.widget.ener
{

    final ViewsPerSecondHelperV3 this$0;
    final DialogManager val$dialogManager;
    final boolean val$trace;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        if (i == 0)
        {
            if (val$trace)
            {
                Debug.stopMethodTracing();
            }
            vpsLastViewTime = System.nanoTime();
            ViewsPerSecondHelperV3.access$000(ViewsPerSecondHelperV3.this, val$dialogManager);
        }
    }

    llListener()
    {
        this$0 = final_viewspersecondhelperv3;
        val$trace = flag;
        val$dialogManager = DialogManager.this;
        super();
    }
}
