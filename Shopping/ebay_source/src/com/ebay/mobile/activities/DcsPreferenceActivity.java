// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.dcs.Dcs;
import com.ebay.mobile.preference.DcsGeneralPreferenceFragment;
import com.ebay.mobile.preference.DcsOverridePreferenceFragment;
import com.ebay.mobile.preference.DcsValuesFragment;
import com.ebay.nautilus.domain.dcs.DcsDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.activities:
//            CorePreferenceActivity

public class DcsPreferenceActivity extends CorePreferenceActivity
{

    private static final String EXTRA_SHOW_FRAGMENT_TITLE_STR = ":ebay:show_fragment_title_str";
    private boolean isSinglePane;
    private final Set validFragments = new HashSet();

    public DcsPreferenceActivity()
    {
        validFragments.add(com/ebay/mobile/preference/DcsGeneralPreferenceFragment.getName());
        validFragments.add(com/ebay/mobile/preference/DcsOverridePreferenceFragment.getName());
        validFragments.add(com/ebay/mobile/preference/DcsValuesFragment.getName());
        validFragments.add(com/ebay/mobile/preference/DcsValuesFragment$TextViewFragment.getName());
    }

    private android.preference.PreferenceActivity.Header createHeader(String s, Class class1)
    {
        android.preference.PreferenceActivity.Header header = new android.preference.PreferenceActivity.Header();
        header.title = s;
        header.fragment = class1.getName();
        return header;
    }

    private android.preference.PreferenceActivity.Header createOverrideHeader(String s, Collection collection)
    {
        collection = new com.ebay.mobile.preference.DcsOverridePreferenceFragment.DomainCollection(collection);
        s = createHeader(s, com/ebay/mobile/preference/DcsOverridePreferenceFragment);
        s.fragmentArguments = new Bundle();
        ((android.preference.PreferenceActivity.Header) (s)).fragmentArguments.putParcelable("domains", collection);
        return s;
    }

    private void startWithFragment(String s, Bundle bundle, Fragment fragment, int i, CharSequence charsequence, int j)
    {
        s = onBuildStartFragmentIntent(s, bundle, 0, j);
        s.putExtra(":ebay:show_fragment_title_str", charsequence);
        if (fragment == null)
        {
            startActivity(s);
            return;
        } else
        {
            fragment.startActivityForResult(s, i);
            return;
        }
    }

    protected boolean isValidFragment(String s)
    {
        return validFragments.contains(s);
    }

    public void onBuildHeaders(List list)
    {
        super.onBuildHeaders(list);
        list.add(createHeader("General", com/ebay/mobile/preference/DcsGeneralPreferenceFragment));
        TreeMap treemap = new TreeMap();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain[] = DcsDomain.getDomains();
        int k = adomain.length;
        int i = 0;
        while (i < k) 
        {
            com.ebay.nautilus.domain.dcs.DcsDomain.Domain domain = adomain[i];
            if (!domain.getProperties().isEmpty())
            {
                ArrayList arraylist = new ArrayList(2);
                arraylist.add(domain);
                treemap.put(domain.getClass().getSimpleName(), arraylist);
            }
            i++;
        }
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain1[] = Dcs.getDomains();
        k = adomain1.length;
        i = 0;
        while (i < k) 
        {
            com.ebay.nautilus.domain.dcs.DcsDomain.Domain domain1 = adomain1[i];
            if (!domain1.getProperties().isEmpty())
            {
                String s1 = domain1.getClass().getSimpleName();
                Collection collection = (Collection)treemap.get(s1);
                Object obj = collection;
                if (collection == null)
                {
                    obj = new ArrayList(1);
                    treemap.put(s1, obj);
                }
                ((Collection) (obj)).add(domain1);
            }
            i++;
        }
        java.util.Map.Entry entry;
        StringBuilder stringbuilder;
        for (Iterator iterator = treemap.entrySet().iterator(); iterator.hasNext(); list.add(createOverrideHeader(stringbuilder.toString(), (Collection)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            stringbuilder = new StringBuilder(s);
            for (int j = s.length(); j > 0; j--)
            {
                int l = j - 1;
                if (Character.isUpperCase(s.charAt(l)))
                {
                    stringbuilder.setCharAt(l, Character.toLowerCase(s.charAt(l)));
                    stringbuilder.insert(l, ' ');
                }
            }

            stringbuilder.insert(0, "DCS").append(" overrides");
        }

        com.ebay.mobile.dcs.DcsTest.Experiment experiment = new com.ebay.mobile.dcs.DcsTest.Experiment();
        com.ebay.mobile.dcs.DcsTest.Endpoint endpoint = new com.ebay.mobile.dcs.DcsTest.Endpoint();
        list.add(createOverrideHeader("Experiment app overrides", Collections.singleton(experiment)));
        list.add(createOverrideHeader("Endpoint overrides", Collections.singleton(endpoint)));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (onIsHidingHeaders() || !onIsMultiPane())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSinglePane = flag;
        setTitle("Device configuration");
        if (isSinglePane)
        {
            Object obj = getIntent();
            bundle = ((Intent) (obj)).getStringExtra(":android:show_fragment");
            obj = ((Intent) (obj)).getStringExtra(":ebay:show_fragment_title_str");
            if (bundle != null && obj != null)
            {
                showBreadCrumbs(((CharSequence) (obj)), null);
            }
        }
    }

    public void onHeaderClick(android.preference.PreferenceActivity.Header header, int i)
    {
        if (isSinglePane && header.fragment != null && header.breadCrumbTitleRes == 0 && header.titleRes == 0 && (header.breadCrumbTitle != null || header.title != null))
        {
            CharSequence charsequence1 = header.breadCrumbTitle;
            i = header.breadCrumbShortTitleRes;
            CharSequence charsequence = charsequence1;
            if (charsequence1 == null)
            {
                charsequence = header.title;
                i = 0;
            }
            startWithFragment(header.fragment, header.fragmentArguments, null, 0, charsequence, i);
            return;
        } else
        {
            super.onHeaderClick(header, i);
            return;
        }
    }

    public void startPreferencePanel(String s, Bundle bundle, int i, CharSequence charsequence, Fragment fragment, int j)
    {
        if (isSinglePane && i == 0 && !TextUtils.isEmpty(charsequence))
        {
            startWithFragment(s, bundle, fragment, j, charsequence, 0);
            return;
        } else
        {
            super.startPreferencePanel(s, bundle, i, charsequence, fragment, j);
            return;
        }
    }
}
