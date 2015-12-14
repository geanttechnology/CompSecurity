// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

class this._cls0
    implements android.view.r
{

    final FeatherActivity this$0;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW");
        view.setData(Uri.parse("http://support.aviary.com/"));
        startActivity(view);
    }

    ()
    {
        this$0 = FeatherActivity.this;
        super();
    }
}
