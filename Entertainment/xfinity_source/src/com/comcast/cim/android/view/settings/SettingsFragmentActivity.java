// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.ListAdapter;
import com.comcast.cim.android.view.launch.AuthenticatingPreferenceActivity;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.UserManager;
import java.util.List;

public class SettingsFragmentActivity extends AuthenticatingPreferenceActivity
{

    UserManager userManager;

    public SettingsFragmentActivity()
    {
        userManager = CALContainer.getInstance().getUserManager();
    }

    private Pair getHeaderPairForResource(String s)
    {
        ListAdapter listadapter = getListAdapter();
        int j = listadapter.getCount();
        for (int i = 0; j > i; i++)
        {
            android.preference.PreferenceActivity.Header header = (android.preference.PreferenceActivity.Header)listadapter.getItem(i);
            if (header.fragmentArguments == null)
            {
                continue;
            }
            String s1 = header.fragmentArguments.getString("resource");
            if (s1 != null && s1.equals(s))
            {
                return new Pair(header, Integer.valueOf(i));
            }
        }

        return null;
    }

    public UserManager getUserManager()
    {
        return userManager;
    }

    public void onBuildHeaders(List list)
    {
        loadHeadersFromResource(com.comcast.cim.android.R.xml.preference_headers, list);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getStringExtra("resource");
        if (bundle != null)
        {
            bundle = getHeaderPairForResource(bundle);
            if (bundle != null)
            {
                onHeaderClick((android.preference.PreferenceActivity.Header)((Pair) (bundle)).first, ((Integer)((Pair) (bundle)).second).intValue());
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            finish();
            break;
        }
        return true;
    }
}
