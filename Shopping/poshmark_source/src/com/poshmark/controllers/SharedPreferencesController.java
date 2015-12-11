// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import com.poshmark.application.PMApplication;
import java.util.Set;

public class SharedPreferencesController
{

    private static final String SHARED_PREF_NAME = "poshmark_pref";
    static SharedPreferencesController sharedPreferenceController = null;
    android.content.SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    SharedPreferencesController()
    {
        sharedPreferences = PMApplication.getContext().getSharedPreferences("poshmark_pref", 0);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesController getSharedPreferencesController()
    {
        if (sharedPreferenceController == null)
        {
            sharedPreferenceController = new SharedPreferencesController();
        }
        return sharedPreferenceController;
    }

    public SharedPreferences getSharedPreferences()
    {
        return sharedPreferences;
    }

    public android.content.SharedPreferences.Editor getSharedPreferencesEditor()
    {
        return editor;
    }

    public Set getStringSet(String s)
    {
        return sharedPreferences.getStringSet(s, null);
    }

    public void putStringSet(String s, Set set)
    {
        editor.putStringSet(s, set);
        editor.commit();
    }

    public void removePreference(String s)
    {
        editor.remove(s);
        editor.commit();
    }

}
