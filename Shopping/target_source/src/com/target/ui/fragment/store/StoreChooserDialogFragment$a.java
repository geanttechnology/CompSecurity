// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.content.Intent;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreChooserDialogFragment

private class <init>
    implements com.target.ui.view.store.vicesView.a
{

    final StoreChooserDialogFragment this$0;

    public void a()
    {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        startActivity(intent);
        dismiss();
    }

    public void b()
    {
        StoreChooserDialogFragment.a(StoreChooserDialogFragment.this);
    }

    private sView.a()
    {
        this$0 = StoreChooserDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
