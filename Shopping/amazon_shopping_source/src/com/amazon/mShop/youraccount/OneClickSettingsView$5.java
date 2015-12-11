// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

class val.amazonActivity
    implements android.view.kSettingsView._cls5
{

    final OneClickSettingsView this$0;
    final AmazonActivity val$amazonActivity;

    public void onClick(View view)
    {
        ActivityUtils.startHomeActivity(val$amazonActivity);
    }

    _cls9()
    {
        this$0 = final_oneclicksettingsview;
        val$amazonActivity = AmazonActivity.this;
        super();
    }
}
