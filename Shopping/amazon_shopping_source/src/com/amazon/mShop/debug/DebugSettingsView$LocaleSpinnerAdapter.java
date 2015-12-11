// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.amazon.mShop.platform.AppLocale;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsView

private class add extends ArrayAdapter
{

    final DebugSettingsView this$0;

    public (Context context)
    {
        this$0 = DebugSettingsView.this;
        super(context, 0x1090008);
        setDropDownViewResource(0x1090009);
        debugsettingsview = ((DebugSettingsView) (AppLocale.getInstance().getSupportedLocaleNameArray()));
        for (int i = 0; i < DebugSettingsView.this.length; i++)
        {
            add((String)(String)DebugSettingsView.this[i]);
        }

    }
}
