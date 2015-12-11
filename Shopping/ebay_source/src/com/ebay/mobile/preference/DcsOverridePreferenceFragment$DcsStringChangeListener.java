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
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class alueListener extends alueListener
{

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        Object obj2 = obj.toString();
        Object obj1 = null;
        if (((String) (obj2)).length() == 0)
        {
            obj = "As configured";
        } else
        if ("null".equalsIgnoreCase(((String) (obj2))))
        {
            obj1 = DeviceConfiguration.DEV_OVERRIDE_NULL;
        } else
        if ("\"null\"".equalsIgnoreCase(((String) (obj2))))
        {
            obj1 = "null";
        } else
        if (((String) (obj2)).length() > 1 && ((String) (obj2)).charAt(0) == '"' && ((String) (obj2)).charAt(((String) (obj2)).length() - 1) == '"')
        {
            obj1 = ((String) (obj2)).substring(1, ((String) (obj2)).length() - 1);
        } else
        {
            obj1 = obj2;
        }
        obj2 = (DcsPropString)valueMap.get(preference.getKey());
        dc.setDevOverride(((DcsPropString) (obj2)), obj1);
        return super.onPreferenceChange(preference, obj);
    }

    public void setup(Context context, PreferenceGroup preferencegroup, DcsPropString dcspropstring)
    {
        String s1 = dcspropstring.key();
        valueMap.put(s1, dcspropstring);
        String s = dc.getDefault(dcspropstring);
        Object obj = dc.getDevOverride(dcspropstring);
        dcspropstring = null;
        int i;
        if (obj == null)
        {
            obj = "As configured";
        } else
        if (obj == DeviceConfiguration.DEV_OVERRIDE_NULL)
        {
            dcspropstring = "null";
            obj = "null";
        } else
        {
            dcspropstring = (String)obj;
            if (dcspropstring.length() == 0 || "null".equals(dcspropstring))
            {
                dcspropstring = (new StringBuilder()).append("\"").append(dcspropstring).append('"').toString();
                obj = dcspropstring;
            } else
            {
                obj = dcspropstring;
            }
        }
        if (s != null && s.startsWith("http"))
        {
            i = 1 | 0x10;
            s = (new StringBuilder()).append(s1).append(" (URI)").toString();
        } else
        {
            i = 1 | 0x80000;
            s = (new StringBuilder()).append(s1).append(" (String)").toString();
        }
        context = (EditTextPreference)PreferenceUtil.setup(new EditTextPreference(context), s1, s, ((CharSequence) (obj)), false);
        context.setDialogTitle(s1);
        context.setDialogMessage("Leaving the text field blank removes any override.\nSet to the text null to force override null.\nIf for some reason you want an empty string or the string \"null\", surround it with quotes.");
        context.setDefaultValue(dcspropstring);
        dcspropstring = context.getEditText();
        dcspropstring.setInputType(i);
        dcspropstring.setSelectAllOnFocus(true);
        dcspropstring.setMaxLines(1);
        dcspropstring.setSingleLine(true);
        dcspropstring.setHint("As configured");
        context.setOnPreferenceChangeListener(this);
        preferencegroup.addPreference(context);
    }

    public alueListener(DeviceConfiguration deviceconfiguration)
    {
        super(deviceconfiguration);
    }
}
