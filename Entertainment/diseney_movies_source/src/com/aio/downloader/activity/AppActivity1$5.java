// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            AppActivity1, AppRecommendKeywordsActivity

class this._cls0
    implements android.view.tener
{

    final AppActivity1 this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(AppActivity1.this, com/aio/downloader/activity/AppRecommendKeywordsActivity));
    }

    wordsActivity()
    {
        this$0 = AppActivity1.this;
        super();
    }
}
