// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity

class this._cls0
    implements android.view.y._cls5
{

    final BaseMediaDetailsActivity this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            view.scrollBy(0, 1);
            view.scrollBy(0, -1);
        }
    }

    ()
    {
        this$0 = BaseMediaDetailsActivity.this;
        super();
    }
}
