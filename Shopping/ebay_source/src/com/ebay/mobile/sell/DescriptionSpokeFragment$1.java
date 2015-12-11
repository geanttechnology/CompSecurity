// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.sell:
//            DescriptionSpokeFragment

class this._cls0
    implements android.view.gment._cls1
{

    final DescriptionSpokeFragment this$0;

    public void onClick(View view)
    {
        view = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        view.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        startActivityForResult(view, 1234);
    }

    ()
    {
        this$0 = DescriptionSpokeFragment.this;
        super();
    }
}
