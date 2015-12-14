// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity, AviaryMainController

class this._cls0
    implements android.view.er
{

    final FeatherActivity this$0;

    public void onClick(View view)
    {
        if (!mMainController.isToolActive() && !mMainController.getBitmapIsChanged())
        {
            showDialog(6);
            return;
        } else
        {
            mMainController.onRestoreOriginal();
            return;
        }
    }

    er()
    {
        this$0 = FeatherActivity.this;
        super();
    }
}
