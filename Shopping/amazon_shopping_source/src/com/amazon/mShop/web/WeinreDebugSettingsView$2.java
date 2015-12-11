// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.web:
//            WeinreDebugSettingsView

class e
    implements android.view.sView._cls2
{

    final WeinreDebugSettingsView this$0;
    final DataStore val$dataStore;

    public void onClick(View view)
    {
        val$dataStore.putString("weinreServerHost", WeinreDebugSettingsView.access$000(WeinreDebugSettingsView.this).getText().toString());
        view = val$dataStore;
        int i;
        if (Util.isEmpty(WeinreDebugSettingsView.access$100(WeinreDebugSettingsView.this).getText()))
        {
            i = getResources().getInteger(com.amazon.mShop.android.lib.fault_port);
        } else
        {
            i = Integer.parseInt(WeinreDebugSettingsView.access$100(WeinreDebugSettingsView.this).getText().toString());
        }
        view.putInt("weinreServerPort", i);
        AppUtils.restartApp();
    }

    e()
    {
        this$0 = final_weinredebugsettingsview;
        val$dataStore = DataStore.this;
        super();
    }
}
