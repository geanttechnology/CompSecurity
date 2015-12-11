// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import java.util.Set;

public interface EbayPreferences
{
    public static interface Editor
    {

        public abstract void apply();

        public abstract Editor clear();

        public abstract boolean commit();

        public abstract Editor putBoolean(boolean flag, String s, boolean flag1);

        public abstract Editor putFloat(boolean flag, String s, float f);

        public abstract Editor putInt(boolean flag, String s, int i);

        public abstract Editor putLong(boolean flag, String s, long l);

        public abstract Editor putString(boolean flag, String s, String s1);

        public abstract Editor putStringSet(boolean flag, String s, Set set);

        public abstract Editor remove(boolean flag, String s);
    }


    public abstract boolean contains(boolean flag, String s);

    public abstract Editor edit();

    public abstract Authentication getAuthentication();

    public abstract boolean getBoolean(boolean flag, String s, boolean flag1);

    public abstract EbayCountry getCurrentCountry();

    public abstract String getCurrentUser();

    public abstract float getFloat(boolean flag, String s, float f);

    public abstract int getInt(boolean flag, String s, int i);

    public abstract long getLong(boolean flag, String s, long l);

    public abstract String getString(boolean flag, String s, String s1);

    public abstract Set getStringSet(boolean flag, String s, Set set);
}
