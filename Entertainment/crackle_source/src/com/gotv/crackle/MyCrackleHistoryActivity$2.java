// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import com.gotv.crackle.model.BrowseModel;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleHistoryActivity

class this._cls0
    implements android.view.y._cls2
{

    final MyCrackleHistoryActivity this$0;

    public void onClick(View view)
    {
        view = (BrowseModel)view.getTag();
        playMediaItem(view.getID());
    }

    ()
    {
        this$0 = MyCrackleHistoryActivity.this;
        super();
    }
}
