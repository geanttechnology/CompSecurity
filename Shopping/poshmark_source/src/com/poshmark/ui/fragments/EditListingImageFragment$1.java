// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditListingImageFragment

class this._cls0
    implements android.view.geFragment._cls1
{

    final EditListingImageFragment this$0;

    public void onClick(View view)
    {
        view = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("EDITMODE", 0);
        view.putExtras(bundle);
        finishActivityWithResult(-1, view);
    }

    ()
    {
        this$0 = EditListingImageFragment.this;
        super();
    }
}
