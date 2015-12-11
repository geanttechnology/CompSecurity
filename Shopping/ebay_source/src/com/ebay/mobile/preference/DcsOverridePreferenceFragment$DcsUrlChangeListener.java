// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.widget.EditText;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class owner extends ToValueListener
{

    private final Handler handler = new Handler();
    private final Fragment owner;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        Object obj1;
        String s2;
        s2 = obj.toString();
        Object obj3 = null;
        DcsPropUrl dcspropurl = (DcsPropUrl)valueMap.get(preference.getKey());
        obj1 = dc.getDefault(dcspropurl);
        String s;
        String s1;
        if (obj1 != null)
        {
            s = ((URL) (obj1)).toString();
        } else
        {
            s = null;
        }
        if (s2.length() != 0 && !s2.equals(s)) goto _L2; else goto _L1
_L1:
        s1 = "As configured";
        obj1 = obj3;
        obj = s1;
        if (s != null)
        {
            obj1 = obj3;
            obj = s1;
            if (s2.length() == 0)
            {
                handler.post(new handler((EditTextPreference)preference, s));
                obj = s1;
                obj1 = obj3;
            }
        }
_L4:
        dc.setDevOverride(dcspropurl, obj1);
        return super.onPreferenceChange(preference, obj);
_L2:
        if ("null".equalsIgnoreCase(s2))
        {
            obj1 = DeviceConfiguration.DEV_OVERRIDE_NULL;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = new URL(s2);
        }
        catch (MalformedURLException malformedurlexception)
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("title", preference.getTitle().toString());
            ((Bundle) (obj)).putBoolean("isError", true);
            ((Bundle) (obj)).putString("message", malformedurlexception.getMessage());
            Object obj2 = owner.getFragmentManager();
            preference = ((FragmentManager) (obj2)).beginTransaction();
            obj2 = ((FragmentManager) (obj2)).findFragmentByTag("messageDialog");
            if (obj2 != null)
            {
                preference.remove(((Fragment) (obj2)));
            }
            preference.addToBackStack(null);
            obj2 = new ErrorDialogFragment();
            ((ErrorDialogFragment) (obj2)).setArguments(((Bundle) (obj)));
            ((ErrorDialogFragment) (obj2)).setTargetFragment(owner, 0);
            ((ErrorDialogFragment) (obj2)).show(preference, "messageDialog");
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setup(Context context, PreferenceGroup preferencegroup, DcsPropUrl dcspropurl)
    {
        String s1 = dcspropurl.key();
        valueMap.put(s1, dcspropurl);
        Object obj = dc.getDevOverride(dcspropurl);
        String s = null;
        String s2;
        if (obj == null)
        {
            obj = "As configured";
        } else
        if (obj == DeviceConfiguration.DEV_OVERRIDE_NULL)
        {
            s = "null";
            obj = "null";
        } else
        {
            s = ((URL)obj).toString();
            obj = s;
        }
        s2 = (new StringBuilder()).append(s1).append(" (URL)").toString();
        obj = (EditTextPreference)PreferenceUtil.setup(new EditTextPreference(context), s1, s2, ((CharSequence) (obj)), false);
        ((EditTextPreference) (obj)).setDialogTitle(s1);
        ((EditTextPreference) (obj)).setDialogMessage("Leaving the text field blank removes any override.\nSet to the text null to force override null.");
        context = s;
        if (s == null)
        {
            dcspropurl = dc.getDefault(dcspropurl);
            context = s;
            if (dcspropurl != null)
            {
                context = dcspropurl.toString();
            }
        }
        if (context != null)
        {
            ((EditTextPreference) (obj)).setDefaultValue(context);
        }
        context = ((EditTextPreference) (obj)).getEditText();
        context.setInputType(17);
        context.setSelectAllOnFocus(true);
        context.setMaxLines(1);
        context.setSingleLine(true);
        context.setHint("As configured");
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(this);
        preferencegroup.addPreference(((Preference) (obj)));
    }

    public ToValueListener(Fragment fragment, DeviceConfiguration deviceconfiguration)
    {
        super(deviceconfiguration);
        owner = fragment;
    }
}
