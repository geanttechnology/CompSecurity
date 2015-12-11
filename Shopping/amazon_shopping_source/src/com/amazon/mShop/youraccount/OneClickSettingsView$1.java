// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.view.View;
import com.amazon.mShop.control.account.OneClickController;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

class this._cls0
    implements android.view.kSettingsView._cls1
{

    final OneClickSettingsView this$0;

    public void onClick(View view)
    {
        view = OneClickSettingsView.this;
        boolean flag;
        if (!OneClickSettingsView.access$000(OneClickSettingsView.this).isOneClickStatusEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        OneClickSettingsView.access$100(view, flag);
    }

    _cls9()
    {
        this$0 = OneClickSettingsView.this;
        super();
    }
}
