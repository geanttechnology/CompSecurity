// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import java.io.Serializable;
import java.util.ArrayList;

public class DNMSortOption
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String value;

    public DNMSortOption()
    {
    }

    public static ArrayList loadSortOptions()
    {
        ArrayList arraylist = new ArrayList();
        DNMSortOption dnmsortoption = new DNMSortOption();
        dnmsortoption.displayName = "Customer Rating";
        dnmsortoption.value = "rating";
        arraylist.add(dnmsortoption);
        dnmsortoption = new DNMSortOption();
        dnmsortoption.displayName = "Price Low to High";
        dnmsortoption.value = "clearancePrice";
        arraylist.add(dnmsortoption);
        return arraylist;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getValue()
    {
        return value;
    }
}
