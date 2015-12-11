// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public class LocaleDialog extends DialogFragment
    implements android.widget.AdapterView.OnItemSelectedListener
{
    private class LocaleComparator
        implements Comparator
    {

        final LocaleDialog this$0;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Locale)obj, (Locale)obj1);
        }

        public int compare(Locale locale, Locale locale1)
        {
            return (new StringBuilder()).append(locale.getLanguage()).append("-").append(locale.getCountry()).toString().compareTo((new StringBuilder()).append(locale1.getLanguage()).append("-").append(locale1.getCountry()).toString());
        }

        private LocaleComparator()
        {
            this$0 = LocaleDialog.this;
            super();
        }

    }


    private boolean mChanges;
    private int mLastSelected;
    private RadioGroup mLocaleOptions;
    private Spinner mLocales;
    private ArrayAdapter mLocalesAdapter;
    private ArrayList mLocalesCodes;

    public LocaleDialog()
    {
    }

    private static Boolean isValidLocale(Locale locale)
    {
        boolean flag;
        if (!TextUtils.isEmpty(locale.getLanguage()) && !TextUtils.isEmpty(locale.getCountry()) && TextUtils.isEmpty(locale.getVariant()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    static LocaleDialog newInstance()
    {
        return new LocaleDialog();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        getDialog().dismiss();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new ArrayList();
        ArrayList arraylist = new ArrayList();
        Locale alocale[] = Locale.getAvailableLocales();
        if (alocale != null)
        {
            Arrays.sort(alocale, new LocaleComparator());
            int j = alocale.length;
            for (int i = 0; i < j; i++)
            {
                Locale locale1 = alocale[i];
                if (isValidLocale(locale1).booleanValue())
                {
                    String s = locale1.getDisplayName(Locale.ENGLISH);
                    arraylist.add(locale1);
                    bundle.add((new StringBuilder()).append(locale1.getLanguage()).append(" - ").append(s).toString());
                }
            }

        }
        Locale locale = new Locale("en", "ss");
        bundle.add((new StringBuilder()).append("DEBUG - ").append(locale.getLanguage()).append(" - ").append(locale.getDisplayName(Locale.ENGLISH)).toString());
        arraylist.add(locale);
        mLocalesCodes = arraylist;
        bundle = new ArrayAdapter(getActivity(), 0x1090008, bundle);
        bundle.setDropDownViewResource(0x1090009);
        mLocalesAdapter = bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i;
        layoutinflater = layoutinflater.inflate(0x7f030050, viewgroup, false);
        viewgroup = (RadioButton)layoutinflater.findViewById(0x7f0a0112);
        bundle = (RadioButton)layoutinflater.findViewById(0x7f0a0113);
        Object obj = Util.getDefaultSharedPrefs(getActivity());
        boolean flag1 = ((SharedPreferences) (obj)).getBoolean("pref_custom_locale_enabled", false);
        Iterator iterator;
        Locale locale;
        boolean flag;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.setChecked(flag);
        bundle.setChecked(flag1);
        viewgroup = (Spinner)layoutinflater.findViewById(0x7f0a0114);
        viewgroup.setAdapter(mLocalesAdapter);
        if (!((SharedPreferences) (obj)).contains("pref_custom_locale")) goto _L2; else goto _L1
_L1:
        bundle = ((SharedPreferences) (obj)).getString("pref_custom_locale", "");
        obj = ((SharedPreferences) (obj)).getString("pref_custom_locale_country", "");
        if (TextUtils.isEmpty(bundle)) goto _L2; else goto _L3
_L3:
        i = 0;
        iterator = mLocalesCodes.iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L4
_L4:
        locale = (Locale)iterator.next();
        if (!bundle.equals(locale.getLanguage()) || !((String) (obj)).equals(locale.getCountry())) goto _L6; else goto _L5
_L5:
        viewgroup.setSelection(i);
        mLastSelected = i;
_L2:
        bundle = (RadioGroup)layoutinflater.findViewById(0x7f0a0111);
        if (flag1)
        {
            bundle.check(0x7f0a0113);
        } else
        {
            bundle.check(0x7f0a0112);
        }
        bundle.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final LocaleDialog this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int j)
            {
                radiogroup = mLocales;
                boolean flag2;
                if (j == 0x7f0a0113)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                radiogroup.setEnabled(flag2);
                mChanges = true;
            }

            
            {
                this$0 = LocaleDialog.this;
                super();
            }
        });
        viewgroup.setEnabled(flag1);
        viewgroup.setOnItemSelectedListener(this);
        mLocales = viewgroup;
        mLocaleOptions = bundle;
        getDialog().setTitle("Custom locales");
        return layoutinflater;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (!mChanges) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        Object obj;
        Iterator iterator;
        int j;
        if (mLocaleOptions.getCheckedRadioButtonId() == 0x7f0a0113)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = mLocales.getSelectedItemPosition();
        i = 0;
        obj = null;
        iterator = mLocalesCodes.iterator();
_L9:
        dialoginterface = obj;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        dialoginterface = (Locale)iterator.next();
        if (i != j) goto _L5; else goto _L4
_L4:
        if (dialoginterface != null) goto _L6; else goto _L2
_L2:
        return;
_L5:
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        String s = dialoginterface.getLanguage();
        dialoginterface = dialoginterface.getCountry();
        Util.getDefaultSharedPrefs(getActivity()).edit().putBoolean("pref_custom_locale_enabled", flag).putString("pref_custom_locale", s).putString("pref_custom_locale_country", dialoginterface).commit();
        if (i == mLastSelected) goto _L2; else goto _L7
_L7:
        Util.restartApp(getActivity());
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        mChanges = true;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }



/*
    static boolean access$202(LocaleDialog localedialog, boolean flag)
    {
        localedialog.mChanges = flag;
        return flag;
    }

*/
}
