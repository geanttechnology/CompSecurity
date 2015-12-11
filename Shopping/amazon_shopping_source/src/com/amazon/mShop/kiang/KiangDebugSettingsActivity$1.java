// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.kiang;

import android.view.View;

// Referenced classes of package com.amazon.mShop.kiang:
//            KiangDebugSettingsActivity

class this._cls0
    implements android.view.ctivity._cls1
{

    final KiangDebugSettingsActivity this$0;

    public void onClick(View view)
    {
        saveDebugSettings();
        finish();
    }

    _cls9()
    {
        this$0 = KiangDebugSettingsActivity.this;
        super();
    }
}
