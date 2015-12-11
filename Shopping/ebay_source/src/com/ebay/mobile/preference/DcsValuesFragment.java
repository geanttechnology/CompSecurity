// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DcsProperty;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.URL;

public final class DcsValuesFragment extends PreferenceFragment
{
    public static final class TextViewFragment extends Fragment
    {

        public static final String EXTRA_TEXT = "text";

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            Bundle bundle1 = getArguments();
            layoutinflater = layoutinflater.getContext();
            viewgroup = new ScrollView(layoutinflater);
            bundle = new TextView(layoutinflater);
            if (bundle1 != null)
            {
                layoutinflater = bundle1.getString("text");
            } else
            {
                layoutinflater = null;
            }
            bundle.setText(layoutinflater);
            viewgroup.addView(bundle);
            return viewgroup;
        }

        public TextViewFragment()
        {
        }
    }


    private static final String EXTRA_DEFAULT = "Default";
    private static final String EXTRA_DEFAULT_RULES = "Default rules";
    private static final String EXTRA_DEV_OVERRIDE = "Dev override";
    private static final String EXTRA_EVALUATED = "Evaluated";
    private static final String EXTRA_KEY = "Key";
    private static final String EXTRA_LOADED = "Loaded";
    private static final String EXTRA_LOADED_RULES = "Loaded rules";
    private static final String EXTRA_TYPE = "Type";

    public DcsValuesFragment()
    {
    }

    public static Bundle createExtras(DcsProperty dcsproperty)
    {
        Object obj2 = null;
        Object obj = null;
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getNoSync();
        Object obj1;
        String s;
        String s1;
        Object obj3;
        if (dcsproperty instanceof DcsPropBoolean)
        {
            obj1 = (DcsPropBoolean)dcsproperty;
            Object obj5 = "Boolean";
            Object obj4;
            String s6;
            Boolean boolean1;
            if (deviceconfiguration.getDefault(((DcsPropBoolean) (obj1))))
            {
                obj2 = "enabled";
            } else
            {
                obj2 = "disabled";
            }
            if (deviceconfiguration.getLoaded(((DcsPropBoolean) (obj1))))
            {
                obj4 = "enabled";
            } else
            {
                obj4 = "disabled";
            }
            if (deviceconfiguration.get(((DcsPropBoolean) (obj1))))
            {
                s6 = "enabled";
            } else
            {
                s6 = "disabled";
            }
            boolean1 = deviceconfiguration.getDevOverride(((DcsPropBoolean) (obj1)));
            s = ((String) (obj2));
            s1 = s6;
            obj3 = obj4;
            obj1 = obj5;
            if (boolean1 != null)
            {
                if (boolean1.booleanValue())
                {
                    obj = "enabled";
                    obj1 = obj5;
                    obj3 = obj4;
                    s1 = s6;
                    s = ((String) (obj2));
                } else
                {
                    obj = "disabled";
                    s = ((String) (obj2));
                    s1 = s6;
                    obj3 = obj4;
                    obj1 = obj5;
                }
            }
        } else
        if (dcsproperty instanceof DcsPropString)
        {
            obj = (DcsPropString)dcsproperty;
            String s15 = "String";
            String s2 = deviceconfiguration.getDefault(((DcsPropString) (obj)));
            String s7 = deviceconfiguration.getLoaded(((DcsPropString) (obj)));
            String s11 = deviceconfiguration.get(((DcsPropString) (obj)));
            obj = deviceconfiguration.getDevOverride(((DcsPropString) (obj)));
            if (obj != null)
            {
                if (obj == DeviceConfiguration.DEV_OVERRIDE_NULL)
                {
                    obj2 = "null";
                } else
                if ("null".equals(obj))
                {
                    obj2 = "\"null\"";
                } else
                if ("".equals(obj))
                {
                    obj2 = "\"\"";
                } else
                {
                    obj2 = (String)obj;
                }
            }
            s = s2;
            s1 = s11;
            obj3 = s7;
            obj = obj2;
            obj1 = s15;
            if (s2 != null)
            {
                s = s2;
                s1 = s11;
                obj3 = s7;
                obj = obj2;
                obj1 = s15;
                if (s2.startsWith("http"))
                {
                    obj1 = "URI";
                    s = s2;
                    s1 = s11;
                    obj3 = s7;
                    obj = obj2;
                }
            }
        } else
        if (dcsproperty instanceof DcsPropInteger)
        {
            obj1 = (DcsPropInteger)dcsproperty;
            obj2 = "Integer";
            String s3 = String.valueOf(deviceconfiguration.getDefault(((DcsPropInteger) (obj1))));
            String s8 = String.valueOf(deviceconfiguration.getLoaded(((DcsPropInteger) (obj1))));
            String s12 = String.valueOf(deviceconfiguration.get(((DcsPropInteger) (obj1))));
            Integer integer = deviceconfiguration.getDevOverride(((DcsPropInteger) (obj1)));
            s = s3;
            s1 = s12;
            obj3 = s8;
            obj1 = obj2;
            if (integer != null)
            {
                obj = integer.toString();
                s = s3;
                s1 = s12;
                obj3 = s8;
                obj1 = obj2;
            }
        } else
        if (dcsproperty instanceof DcsPropLong)
        {
            obj1 = (DcsPropLong)dcsproperty;
            obj2 = "Long";
            String s4 = String.valueOf(deviceconfiguration.getDefault(((DcsPropLong) (obj1))));
            String s9 = String.valueOf(deviceconfiguration.getLoaded(((DcsPropLong) (obj1))));
            String s13 = String.valueOf(deviceconfiguration.get(((DcsPropLong) (obj1))));
            Long long1 = deviceconfiguration.getDevOverride(((DcsPropLong) (obj1)));
            s = s4;
            s1 = s13;
            obj3 = s9;
            obj1 = obj2;
            if (long1 != null)
            {
                obj = long1.toString();
                s = s4;
                s1 = s13;
                obj3 = s9;
                obj1 = obj2;
            }
        } else
        if (dcsproperty instanceof DcsPropUrl)
        {
            obj1 = (DcsPropUrl)dcsproperty;
            String s5 = "URL";
            String s10 = String.valueOf(deviceconfiguration.getDefault(((DcsPropUrl) (obj1))));
            String s14 = String.valueOf(deviceconfiguration.getLoaded(((DcsPropUrl) (obj1))));
            obj2 = deviceconfiguration.get(((DcsPropUrl) (obj1)));
            Object obj6;
            if (obj2 != null)
            {
                obj2 = ((URL) (obj2)).toString();
            } else
            {
                obj2 = null;
            }
            obj6 = deviceconfiguration.getDevOverride(((DcsPropUrl) (obj1)));
            s = s10;
            s1 = ((String) (obj2));
            obj3 = s14;
            obj1 = s5;
            if (obj6 != null)
            {
                if (obj6 == DeviceConfiguration.DEV_OVERRIDE_NULL)
                {
                    obj = "null";
                    s = s10;
                    s1 = ((String) (obj2));
                    obj3 = s14;
                    obj1 = s5;
                } else
                {
                    obj = obj6.toString();
                    s = s10;
                    s1 = ((String) (obj2));
                    obj3 = s14;
                    obj1 = s5;
                }
            }
        } else
        {
            throw new RuntimeException();
        }
        s6 = dcsproperty.key();
        obj5 = dcsproperty.defaultValue(deviceconfiguration.getState());
        obj4 = String.valueOf(obj5);
        obj2 = obj4;
        if (dcsproperty instanceof DcsPropBoolean)
        {
            obj2 = obj4;
            if (obj5 instanceof Boolean)
            {
                if (((Boolean)obj5).booleanValue())
                {
                    obj2 = "enabled";
                } else
                {
                    obj2 = "disabled";
                }
            }
        }
        dcsproperty = deviceconfiguration.getLoadedRules(dcsproperty);
        obj4 = new Bundle();
        ((Bundle) (obj4)).putString("Key", s6);
        ((Bundle) (obj4)).putString("Type", ((String) (obj1)));
        ((Bundle) (obj4)).putString("Default", s);
        ((Bundle) (obj4)).putString("Loaded", ((String) (obj3)));
        if (s1 != null)
        {
            ((Bundle) (obj4)).putString("Evaluated", s1);
        }
        if (obj != null)
        {
            ((Bundle) (obj4)).putString("Dev override", ((String) (obj)));
        }
        ((Bundle) (obj4)).putString("Default rules", ((String) (obj2)));
        ((Bundle) (obj4)).putString("Loaded rules", dcsproperty);
        return ((Bundle) (obj4));
    }

    private void setup(PreferenceGroup preferencegroup, String s, Bundle bundle)
    {
        bundle = bundle.getString(s);
        Preference preference = new Preference(preferencegroup.getContext());
        PreferenceUtil.setup(preference, null, s, bundle, false);
        preference.setFragment(com/ebay/mobile/preference/DcsValuesFragment$TextViewFragment.getName());
        preference.getExtras().putString("text", bundle);
        preferencegroup.addPreference(preference);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle == null)
        {
            return;
        }
        android.preference.PreferenceScreen preferencescreen = getPreferenceManager().createPreferenceScreen(getActivity());
        setup(preferencescreen, "Key", bundle);
        setup(preferencescreen, "Type", bundle);
        setup(preferencescreen, "Default", bundle);
        setup(preferencescreen, "Loaded", bundle);
        if (bundle.containsKey("Dev override"))
        {
            setup(preferencescreen, "Dev override", bundle);
        }
        setup(preferencescreen, "Default rules", bundle);
        setup(preferencescreen, "Loaded rules", bundle);
        setup(preferencescreen, "Evaluated", bundle);
        setPreferenceScreen(preferencescreen);
    }
}
