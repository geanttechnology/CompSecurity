// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import android.widget.ProgressBar;

// Referenced classes of package com.gotv.crackle:
//            MainActivity, Application

class this._cls0
    implements android.view.tener
{

    final MainActivity this$0;

    public void onClick(View view)
    {
        mLoadingProgress.setVisibility(0);
        view = getIntent();
        Application.selectedTab = 3;
        finish();
        startActivity(view);
    }

    r()
    {
        this$0 = MainActivity.this;
        super();
    }
}
