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
import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class lueListener extends lueListener
{

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        Object obj1 = null;
        Integer integer = Integer.valueOf(obj.toString());
        obj1 = obj;
        obj = integer;
_L2:
        DcsPropInteger dcspropinteger = (DcsPropInteger)valueMap.get(preference.getKey());
        dc.setDevOverride(dcspropinteger, ((Integer) (obj)));
        return super.onPreferenceChange(preference, obj1);
        obj;
        String s = "As configured";
        obj = obj1;
        obj1 = s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setup(Context context, PreferenceGroup preferencegroup, DcsPropInteger dcspropinteger)
    {
        String s = dcspropinteger.key();
        valueMap.put(s, dcspropinteger);
        Integer integer = dc.getDevOverride(dcspropinteger);
        if (integer == null)
        {
            dcspropinteger = "As configured";
        } else
        {
            dcspropinteger = integer.toString();
        }
        context = (EditTextPreference)PreferenceUtil.setup(new EditTextPreference(context), s, (new StringBuilder()).append(s).append(" (Integer)").toString(), dcspropinteger, false);
        context.setDialogTitle(s);
        if (integer != null)
        {
            context.setDefaultValue(integer.toString());
        }
        dcspropinteger = context.getEditText();
        dcspropinteger.setInputType(4098);
        dcspropinteger.setSelectAllOnFocus(true);
        dcspropinteger.setMaxLines(1);
        dcspropinteger.setSingleLine(true);
        dcspropinteger.setHint("As configured");
        context.setOnPreferenceChangeListener(this);
        preferencegroup.addPreference(context);
    }

    public lueListener(DeviceConfiguration deviceconfiguration)
    {
        super(deviceconfiguration);
    }
}
