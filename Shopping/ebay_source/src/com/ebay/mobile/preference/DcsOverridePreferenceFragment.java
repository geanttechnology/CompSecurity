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
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.dcs.DcsTest;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DcsProperty;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsValuesFragment

public final class DcsOverridePreferenceFragment extends PreferenceFragment
    implements android.widget.AdapterView.OnItemLongClickListener
{
    private static abstract class BindPreferenceSummaryToValueListener
        implements android.preference.Preference.OnPreferenceChangeListener, OnPreferenceLongClickListener
    {

        protected final DeviceConfiguration dc;
        protected final Map valueMap = new HashMap();

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            obj = obj.toString();
            if (preference instanceof ListPreference)
            {
                ListPreference listpreference = (ListPreference)preference;
                int i = listpreference.findIndexOfValue(((String) (obj)));
                if (i >= 0)
                {
                    obj = listpreference.getEntries()[i];
                } else
                {
                    obj = null;
                }
                preference.setSummary(((CharSequence) (obj)));
            } else
            {
                preference.setSummary(((CharSequence) (obj)));
            }
            return true;
        }

        public boolean onPreferenceLongClick(PreferenceActivity preferenceactivity, Preference preference)
        {
            Object obj = (DcsProperty)valueMap.get(preference.getKey());
            preference = preference.getTitle();
            obj = DcsValuesFragment.createExtras(((DcsProperty) (obj)));
            preferenceactivity.startPreferencePanel(com/ebay/mobile/preference/DcsValuesFragment.getName(), ((Bundle) (obj)), 0, preference, null, 0);
            return true;
        }

        protected BindPreferenceSummaryToValueListener(DeviceConfiguration deviceconfiguration)
        {
            dc = deviceconfiguration;
        }
    }

    private static final class DcsBooleanChangeListener extends BindPreferenceSummaryToValueListener
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

        public DcsBooleanChangeListener(DeviceConfiguration deviceconfiguration)
        {
            super(deviceconfiguration);
        }
    }

    private static final class DcsIntegerChangeListener extends BindPreferenceSummaryToValueListener
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

        public DcsIntegerChangeListener(DeviceConfiguration deviceconfiguration)
        {
            super(deviceconfiguration);
        }
    }

    private static final class DcsLongChangeListener extends BindPreferenceSummaryToValueListener
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

        public DcsLongChangeListener(DeviceConfiguration deviceconfiguration)
        {
            super(deviceconfiguration);
        }
    }

    private static final class DcsStringChangeListener extends BindPreferenceSummaryToValueListener
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

        public DcsStringChangeListener(DeviceConfiguration deviceconfiguration)
        {
            super(deviceconfiguration);
        }
    }

    private static final class DcsUrlChangeListener extends BindPreferenceSummaryToValueListener
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
                    handler.post(new DelayedSet((EditTextPreference)preference, s));
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

        public DcsUrlChangeListener(Fragment fragment, DeviceConfiguration deviceconfiguration)
        {
            super(deviceconfiguration);
            owner = fragment;
        }
    }

    private static final class DelayedSet
        implements Runnable
    {

        private final EditTextPreference pref;
        private final String text;

        public void run()
        {
            pref.setText(text);
        }

        public DelayedSet(EditTextPreference edittextpreference, String s)
        {
            pref = edittextpreference;
            text = s;
        }
    }

    public static final class DomainCollection
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public DomainCollection createFromParcel(Parcel parcel)
            {
                int j = parcel.readInt();
                ArrayList arraylist = new ArrayList(j);
                int i = 0;
                do
                {
                    if (i >= j)
                    {
                        break;
                    }
                    Class class1 = (Class)parcel.readSerializable();
                    try
                    {
                        arraylist.add(class1.newInstance());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Parcel parcel)
                    {
                        parcel.printStackTrace();
                        throw new RuntimeException(parcel);
                    }
                    i++;
                } while (true);
                return new DomainCollection(arraylist);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public DomainCollection[] newArray(int i)
            {
                return new DomainCollection[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final Collection domains;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(domains.size());
            for (Iterator iterator = domains.iterator(); iterator.hasNext(); parcel.writeSerializable(((com.ebay.nautilus.domain.dcs.DcsDomain.Domain)iterator.next()).getClass())) { }
        }


        public DomainCollection(Collection collection)
        {
            domains = collection;
        }
    }

    private static interface OnPreferenceLongClickListener
    {

        public abstract boolean onPreferenceLongClick(PreferenceActivity preferenceactivity, Preference preference);
    }


    public static final String EXTRA_DOMAINS = "domains";
    static final String STR_AS_CONFIGURED = "As configured";
    final DeviceConfiguration dc = DeviceConfiguration.getAsync();

    public DcsOverridePreferenceFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = getArguments();
        bundle = null;
        if (obj != null)
        {
            bundle = (DomainCollection)((Bundle) (obj)).getParcelable("domains");
        }
        obj = bundle;
        if (bundle == null)
        {
            obj = new DomainCollection(Arrays.asList(DcsTest.getDomains()));
        }
        bundle = getActivity();
        PreferenceScreen preferencescreen = getPreferenceManager().createPreferenceScreen(bundle);
        DcsBooleanChangeListener dcsbooleanchangelistener = new DcsBooleanChangeListener(dc);
        DcsStringChangeListener dcsstringchangelistener = new DcsStringChangeListener(dc);
        DcsIntegerChangeListener dcsintegerchangelistener = new DcsIntegerChangeListener(dc);
        DcsLongChangeListener dcslongchangelistener = new DcsLongChangeListener(dc);
        DcsUrlChangeListener dcsurlchangelistener = new DcsUrlChangeListener(this, dc);
        preferencescreen.setOrderingAsAdded(false);
        for (obj = ((DomainCollection) (obj)).domains.iterator(); ((Iterator) (obj)).hasNext();)
        {
            Iterator iterator = ((com.ebay.nautilus.domain.dcs.DcsDomain.Domain)((Iterator) (obj)).next()).getProperties().iterator();
            while (iterator.hasNext()) 
            {
                DcsProperty dcsproperty = (DcsProperty)iterator.next();
                if ((dcsproperty instanceof DcsPropBoolean) && dcsproperty != DcsNautilusBoolean.QA_ENABLED)
                {
                    dcsbooleanchangelistener.setup(bundle, preferencescreen, (DcsPropBoolean)dcsproperty);
                } else
                if (dcsproperty instanceof DcsPropInteger)
                {
                    dcsintegerchangelistener.setup(bundle, preferencescreen, (DcsPropInteger)dcsproperty);
                } else
                if (dcsproperty instanceof DcsPropLong)
                {
                    dcslongchangelistener.setup(bundle, preferencescreen, (DcsPropLong)dcsproperty);
                } else
                if (dcsproperty instanceof DcsPropString)
                {
                    dcsstringchangelistener.setup(bundle, preferencescreen, (DcsPropString)dcsproperty);
                } else
                if (dcsproperty instanceof DcsPropUrl)
                {
                    dcsurlchangelistener.setup(bundle, preferencescreen, (DcsPropUrl)dcsproperty);
                }
            }
        }

        setPreferenceScreen(preferencescreen);
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (PreferenceActivity)getActivity();
        adapterview = (Preference)((ListView)adapterview).getAdapter().getItem(i);
        android.preference.Preference.OnPreferenceChangeListener onpreferencechangelistener = adapterview.getOnPreferenceChangeListener();
        return (onpreferencechangelistener instanceof OnPreferenceLongClickListener) && ((OnPreferenceLongClickListener)onpreferencechangelistener).onPreferenceLongClick(view, adapterview);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = (ListView)view.findViewById(0x102000a);
        view.setOnItemLongClickListener(this);
        view.setFastScrollEnabled(true);
    }
}
