// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsView

class this._cls0
    implements android.view.
{

    final DebugSettingsView this$0;

    public void onClick(View view)
    {
        view = DebugSettingsView.access$100(DebugSettingsView.this).getSelectedItem().toString();
        reloadDefaultUrlToDisplay(view);
        recordEditedSettings(DebugSettingsView.access$100(DebugSettingsView.this).getSelectedItem().toString());
    }

    ()
    {
        this$0 = DebugSettingsView.this;
        super();
    }
}
