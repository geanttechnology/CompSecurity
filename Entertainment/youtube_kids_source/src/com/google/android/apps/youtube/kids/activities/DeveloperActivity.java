// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import a;
import aaa;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.TextUtils;
import android.widget.Toast;
import bgv;
import bmr;
import bye;
import cnq;
import cof;
import coj;
import cok;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import cpi;
import nc;
import ws;
import wt;
import wu;
import wv;
import ww;
import wx;
import wy;
import wz;
import xa;

public class DeveloperActivity extends PreferenceActivity
{

    private SharedPreferences a;
    private KidsApplication b;

    public DeveloperActivity()
    {
    }

    public static Intent a(Activity activity)
    {
        return new Intent(activity, com/google/android/apps/youtube/kids/activities/DeveloperActivity);
    }

    public static String a(String s)
    {
        return b(s);
    }

    private String a(Enum aenum[], int i, ListPreference listpreference, int j)
    {
        String as[] = new String[aenum.length];
        int l = aenum.length;
        for (int k = 0; k < l; k++)
        {
            Enum enum = aenum[k];
            as[enum.ordinal()] = enum.name();
        }

        listpreference.setEntries(as);
        listpreference.setEntryValues(as);
        aenum = a.getString(listpreference.getKey(), as[i]);
        listpreference.setSummary(getString(j, new Object[] {
            aenum
        }));
        listpreference.setValue(aenum);
        return aenum;
    }

    public static void a(DeveloperActivity developeractivity)
    {
        Intent intent = developeractivity.getPackageManager().getLaunchIntentForPackage(developeractivity.getPackageName());
        intent.setFlags(32768);
        intent.addFlags(0x10000000);
        developeractivity.getApplicationContext().startActivity(intent);
    }

    public static boolean a(DeveloperActivity developeractivity, String s)
    {
        boolean flag = true;
        s = Uri.parse(s);
        if (s.getHost() == null || s.getPort() <= 0)
        {
            Toast.makeText(developeractivity.getApplicationContext(), "Enter valid ppg host and port.", 1).show();
            flag = false;
        }
        return flag;
    }

    public static SharedPreferences b(DeveloperActivity developeractivity)
    {
        return developeractivity.a;
    }

    private static String b(String s)
    {
        String s2 = String.valueOf("A comma separated list of experiments: ");
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = "No experiments";
        }
        s = String.valueOf(s1);
        if (s.length() != 0)
        {
            return s2.concat(s);
        } else
        {
            return new String(s2);
        }
    }

    public static void c(DeveloperActivity developeractivity)
    {
        Toast.makeText(developeractivity.getApplicationContext(), "Invalidating DeviceAuth due to apiary host change.", 1).show();
        ((cpi)((KidsApplication)developeractivity.getApplication()).h().q.b_()).a();
    }

    public static KidsApplication d(DeveloperActivity developeractivity)
    {
        return developeractivity.b;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f070000);
        b = (KidsApplication)getApplication();
        a = ((nc) (b)).a.i();
        if (!a.d(b))
        {
            finish();
        }
        findPreference("OnlineAd").setOnPreferenceClickListener(new ws(this));
        findPreference("VisitorID").setSummary(a.getString("visitor_id", null));
        bundle = (EditTextPreference)findPreference("experiment_ids");
        bundle.setTitle("Set Experiment Ids");
        bundle.setSummary(b(bye.b(a)));
        bundle.setOnPreferenceChangeListener(new wv(this));
        bundle = (CheckBoxPreference)findPreference("ApiRequestLogging");
        bundle.setChecked(((nc) (b)).b.d().a());
        bundle.setOnPreferenceChangeListener(new ww(this));
        bundle = (CheckBoxPreference)findPreference("FullApiResponseLogging");
        bundle.setChecked(((nc) (b)).b.d().b());
        bundle.setOnPreferenceChangeListener(new wx(this));
        bundle = (CheckBoxPreference)findPreference("EnableParentalGate");
        bundle.setChecked(a.getBoolean("pref_enable_parental_gate", false));
        bundle.setOnPreferenceChangeListener(new wu(this));
        bundle = (ListPreference)findPreference("ApiaryHostSelection");
        EditTextPreference edittextpreference = (EditTextPreference)findPreference("PPGHost");
        ListPreference listpreference = (ListPreference)findPreference("InnerTubeApiSelection");
        edittextpreference.setEnabled(a(cof.values(), cof.a(), bundle, 0x7f0b01c7).equals(cof.d.name()));
        edittextpreference.setSummary(a.getString(edittextpreference.getKey(), "Not specified."));
        a(coj.values(), coj.a(), listpreference, 0x7f0b01ca);
        listpreference.setOnPreferenceChangeListener(new wy(this, bundle));
        edittextpreference.setOnPreferenceChangeListener(new wz(this, edittextpreference));
        bundle.setOnPreferenceChangeListener(new xa(this, listpreference, edittextpreference));
        findPreference("RestartApp").setOnPreferenceClickListener(new wt(this));
    }
}
