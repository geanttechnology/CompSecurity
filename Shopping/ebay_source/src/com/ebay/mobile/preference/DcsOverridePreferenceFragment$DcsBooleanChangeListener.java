// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class lueListener extends lueListener
{

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        Boolean boolean1 = null;
        if (!"enabled".equals(obj)) goto _L2; else goto _L1
_L1:
        boolean1 = Boolean.TRUE;
_L4:
        DcsPropBoolean dcspropboolean = (DcsPropBoolean)valueMap.get(preference.getKey());
        dc.setDevOverride(dcspropboolean, boolean1);
        return super.onPreferenceChange(preference, obj);
_L2:
        if ("disabled".equals(obj))
        {
            boolean1 = Boolean.FALSE;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setup(Context context, PreferenceGroup preferencegroup, DcsPropBoolean dcspropboolean)
    {
        String s = dcspropboolean.key();
        valueMap.put(s, dcspropboolean);
        Object obj = dc.getDevOverride(dcspropboolean);
        dcspropboolean = new CharSequence[3];
        dcspropboolean[0] = "As configured";
        dcspropboolean[1] = "disabled";
        dcspropboolean[2] = "enabled";
        int i = 0;
        if (obj != null)
        {
            int j = 0 + 1;
            i = j;
            if (((Boolean) (obj)).booleanValue())
            {
                i = j + 1;
            }
        }
        obj = dcspropboolean[i];
        context = (ListPreference)PreferenceUtil.setup(new ListPreference(context), s, (new StringBuilder()).append(s).append(" (Boolean)").toString(), ((CharSequence) (obj)), false);
        context.setDialogTitle(s);
        context.setEntries(dcspropboolean);
        context.setEntryValues(dcspropboolean);
        context.setValueIndex(i);
        context.setPositiveButtonText(null);
        context.setNegativeButtonText(null);
        context.setOnPreferenceChangeListener(this);
        preferencegroup.addPreference(context);
    }

    public lueListener(DeviceConfiguration deviceconfiguration)
    {
        super(deviceconfiguration);
    }
}
