// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.app.Dialog;
import android.content.Context;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksFavoritesFragment

class this._cls0 extends Dialog
{

    final GivingWorksFavoritesFragment this$0;

    public void onBackPressed()
    {
        if (GivingWorksFavoritesFragment.access$000(GivingWorksFavoritesFragment.this))
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    (Context context, int i)
    {
        this$0 = GivingWorksFavoritesFragment.this;
        super(context, i);
    }
}
