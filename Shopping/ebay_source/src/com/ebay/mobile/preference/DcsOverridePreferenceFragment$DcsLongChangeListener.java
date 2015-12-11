// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.widget.EditText;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class oValueListener extends oValueListener
{

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        Object obj1 = null;
        Long long1 = Long.valueOf(obj.toString());
        obj1 = obj;
        obj = long1;
_L2:
        DcsPropLong dcsproplong = (DcsPropLong)valueMap.get(preference.getKey());
        dc.setDevOverride(dcsproplong, ((Long) (obj)));
        return super.onPreferenceChange(preference, obj1);
        obj;
        String s = "As configured";
        obj = obj1;
        obj1 = s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setup(Context context, PreferenceGroup preferencegroup, DcsPropLong dcsproplong)
    {
        String s = dcsproplong.key();
        valueMap.put(s, dcsproplong);
        Long long1 = dc.getDevOverride(dcsproplong);
        if (long1 == null)
        {
            dcsproplong = "As configured";
        } else
        {
            dcsproplong = long1.toString();
        }
        context = (EditTextPreference)PreferenceUtil.setup(new EditTextPreference(context), s, (new StringBuilder()).append(s).append(" (Long)").toString(), dcsproplong, false);
        context.setDialogTitle(s);
        if (long1 != null)
        {
            context.setDefaultValue(long1.toString());
        }
        dcsproplong = context.getEditText();
        dcsproplong.setInputType(4098);
        dcsproplong.setSelectAllOnFocus(true);
        dcsproplong.setMaxLines(1);
        dcsproplong.setSingleLine(true);
        dcsproplong.setHint("As configured");
        context.setOnPreferenceChangeListener(this);
        preferencegroup.addPreference(context);
    }

    public oValueListener(DeviceConfiguration deviceconfiguration)
    {
        super(deviceconfiguration);
    }
}
