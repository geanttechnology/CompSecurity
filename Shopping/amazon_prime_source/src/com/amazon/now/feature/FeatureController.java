// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;

import com.amazon.now.location.LocaleManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;

public class FeatureController
{
    public static final class Feature extends Enum
    {

        private static final Feature $VALUES[];
        public static final Feature SHOW_ALL_COUNTRIES;
        private int mBoolResId;
        private String mDatastoreKey;

        public static Feature valueOf(String s)
        {
            return (Feature)Enum.valueOf(com/amazon/now/feature/FeatureController$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])$VALUES.clone();
        }

        public int getBooleanResourceId()
        {
            return mBoolResId;
        }

        public String getDatastoreKey()
        {
            return mDatastoreKey;
        }

        static 
        {
            SHOW_ALL_COUNTRIES = new Feature("SHOW_ALL_COUNTRIES", 0, 0x7f090006, "keyFeatureShowAllCountries");
            $VALUES = (new Feature[] {
                SHOW_ALL_COUNTRIES
            });
        }

        private Feature(String s, int i, int j, String s1)
        {
            super(s, i);
            mBoolResId = j;
            mDatastoreKey = s1;
        }
    }


    private static FeatureController sInstance;

    private FeatureController()
    {
    }

    public static FeatureController getInstance()
    {
        com/amazon/now/feature/FeatureController;
        JVM INSTR monitorenter ;
        FeatureController featurecontroller;
        if (sInstance == null)
        {
            sInstance = new FeatureController();
        }
        featurecontroller = sInstance;
        com/amazon/now/feature/FeatureController;
        JVM INSTR monitorexit ;
        return featurecontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearFeatureOverride(Feature feature)
    {
        DataStore.removeKey(feature.getDatastoreKey());
        LocaleManager.resetAvailableLocales();
    }

    public boolean isFeatureEnabled(Feature feature)
    {
        if (isFeatureOverriden(feature))
        {
            return DataStore.getBoolean(feature.getDatastoreKey());
        } else
        {
            return AppUtils.getConfigBoolean(feature.getBooleanResourceId());
        }
    }

    public boolean isFeatureOverriden(Feature feature)
    {
        return DataStore.hasKey(feature.getDatastoreKey());
    }

    public void setFeatureOverride(Feature feature, boolean flag)
    {
        DataStore.putBoolean(feature.getDatastoreKey(), flag);
        LocaleManager.resetAvailableLocales();
    }
}
