// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.bestbuy.android.bbyobjects.BBYTextView;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryPrivacySetting

class a
    implements android.widget.hangeListener
{

    final RegistryPrivacySetting a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            RegistryPrivacySetting.c(a).setText("Yes");
            RegistryPrivacySetting.b(a, true);
            RegistryPrivacySetting.c(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
            RegistryPrivacySetting.d(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
            return;
        } else
        {
            RegistryPrivacySetting.c(a).setText("No");
            RegistryPrivacySetting.b(a, false);
            RegistryPrivacySetting.c(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
            RegistryPrivacySetting.d(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
            return;
        }
    }

    (RegistryPrivacySetting registryprivacysetting)
    {
        a = registryprivacysetting;
        super();
    }
}
