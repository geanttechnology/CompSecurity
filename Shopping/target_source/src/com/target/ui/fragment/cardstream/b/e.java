// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.target.a.a.a;
import com.target.a.a.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e
{

    private static final String KEY_DISMISSED_CARDS = "KEY_DISMISSED_CARDS";
    private static final String KEY_SHOPPING_LIST_HAS_BEEN_POPULATED = "KEY_SHOPPING_LIST_HAS_BEEN_POPULATED";
    private static final String LOG_TAG = "CardManagerSimpleStorage";
    private static final String PREFS_BUCKET_NAME = "CARD_MANAGER_SIMPLE_STORAGE";
    private final SharedPreferences mPrefs;

    public e(a a1)
    {
        mPrefs = a1.a().getSharedPreferences("CARD_MANAGER_SIMPLE_STORAGE", 0);
    }

    private void a(String s, boolean flag)
    {
        mPrefs.edit().putBoolean(s, flag).apply();
    }

    Set a()
    {
        Object obj = mPrefs.getStringSet("KEY_DISMISSED_CARDS", new HashSet());
        HashSet hashset = new HashSet();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashset.add(com.target.ui.fragment.cardstream.e.valueOf((String)((Iterator) (obj)).next()))) { }
        b.e("CardManagerSimpleStorage", (new StringBuilder()).append("Returning set of dismissed cards: ").append(hashset).toString());
        return hashset;
    }

    public void a(com.target.ui.fragment.cardstream.e e1)
    {
        Object obj = a();
        ((Set) (obj)).add(e1);
        e1 = new HashSet();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); e1.add(((com.target.ui.fragment.cardstream.e)((Iterator) (obj)).next()).name())) { }
        b.e("CardManagerSimpleStorage", (new StringBuilder()).append("Setting cards as dismissed: ").append(e1).toString());
        mPrefs.edit().putStringSet("KEY_DISMISSED_CARDS", e1).apply();
    }

    void a(boolean flag)
    {
        a("KEY_SHOPPING_LIST_HAS_BEEN_POPULATED", flag);
    }
}
