// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;


// Referenced classes of package com.amazon.now.feature:
//            FeatureController

public static final class mDatastoreKey extends Enum
{

    private static final SHOW_ALL_COUNTRIES $VALUES[];
    public static final SHOW_ALL_COUNTRIES SHOW_ALL_COUNTRIES;
    private int mBoolResId;
    private String mDatastoreKey;

    public static mDatastoreKey valueOf(String s)
    {
        return (mDatastoreKey)Enum.valueOf(com/amazon/now/feature/FeatureController$Feature, s);
    }

    public static mDatastoreKey[] values()
    {
        return (mDatastoreKey[])$VALUES.clone();
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
        SHOW_ALL_COUNTRIES = new <init>("SHOW_ALL_COUNTRIES", 0, 0x7f090006, "keyFeatureShowAllCountries");
        $VALUES = (new .VALUES[] {
            SHOW_ALL_COUNTRIES
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mBoolResId = j;
        mDatastoreKey = s1;
    }
}
