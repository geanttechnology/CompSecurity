// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.ProgressBar;
import com.gotv.crackle.data.SearchResults;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        if (MainActivity.access$500(MainActivity.this) != null && MainActivity.access$500(MainActivity.this).getRequestState() == com.gotv.crackle.data.uestState.COMPLETE)
        {
            mLoadingProgress.setVisibility(4);
            MainActivity.access$600(MainActivity.this);
        }
    }

    t.RequestState()
    {
        this$0 = MainActivity.this;
        super();
    }
}
