// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsView

private class <init>
    implements android.widget.istener
{

    final DebugSettingsView this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        recordEditedSettings(DebugSettingsView.access$200(DebugSettingsView.this));
        DebugSettingsView.access$202(DebugSettingsView.this, adapterview.getItemAtPosition(i).toString());
        loadToDisplay(DebugSettingsView.access$200(DebugSettingsView.this));
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    private ()
    {
        this$0 = DebugSettingsView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
