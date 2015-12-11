// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.widget.Switch;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

static abstract class toggleSwitch
    implements android.widget.hController
{

    protected final Switch toggleSwitch;

    public void register()
    {
        toggleSwitch.setOnCheckedChangeListener(this);
    }

    public void unregister()
    {
        toggleSwitch.setOnCheckedChangeListener(null);
    }

    public (Switch switch1)
    {
        toggleSwitch = switch1;
    }
}
