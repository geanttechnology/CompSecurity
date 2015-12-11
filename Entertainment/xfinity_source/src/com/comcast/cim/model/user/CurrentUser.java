// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import android.content.SharedPreferences;

public class CurrentUser
{

    private SharedPreferences preferences;

    public CurrentUser(SharedPreferences sharedpreferences)
    {
        preferences = sharedpreferences;
    }

    public void forget()
    {
        String s = getKey();
        android.content.SharedPreferences.Editor editor = getEditor();
        editor.remove("currentUser");
        editor.putString("previousUser", s);
        editor.commit();
    }

    protected android.content.SharedPreferences.Editor getEditor()
    {
        return preferences.edit();
    }

    public String getKey()
    {
        return preferences.getString("currentUser", "unknownUser");
    }

    public String getPreviousKey()
    {
        return preferences.getString("previousUser", "unknownUser");
    }

    public String setKey(String s)
    {
        Object obj = getKey();
        String s1 = ((String) (obj));
        if (((String) (obj)).equals("unknownUser"))
        {
            s1 = getPreviousKey();
        }
        obj = getEditor();
        ((android.content.SharedPreferences.Editor) (obj)).putString("currentUser", s);
        ((android.content.SharedPreferences.Editor) (obj)).putString("previousUser", s1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return s1;
    }
}
