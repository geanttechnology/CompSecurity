// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.widget.CompoundButton;
import android.widget.EditText;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.web:
//            WeinreDebugSettingsView

class e
    implements android.widget.angeListener
{

    final WeinreDebugSettingsView this$0;
    final DataStore val$dataStore;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        val$dataStore.putBoolean("weinreServerStatus", flag);
        WeinreDebugSettingsView.access$000(WeinreDebugSettingsView.this).setEnabled(flag);
        WeinreDebugSettingsView.access$100(WeinreDebugSettingsView.this).setEnabled(flag);
    }

    e()
    {
        this$0 = final_weinredebugsettingsview;
        val$dataStore = DataStore.this;
        super();
    }
}
