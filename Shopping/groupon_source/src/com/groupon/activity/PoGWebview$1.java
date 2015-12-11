// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            PoGWebview

class this._cls0
    implements android.view.istener
{

    final PoGWebview this$0;

    public void onClick(View view)
    {
        if (isDeepLinked)
        {
            view = getDeepLinkUpIntent();
            view.setFlags(view.getFlags() | 0x10000000 | 0x8000);
            startActivity(view);
            return;
        } else
        {
            finish();
            return;
        }
    }

    ()
    {
        this$0 = PoGWebview.this;
        super();
    }
}
