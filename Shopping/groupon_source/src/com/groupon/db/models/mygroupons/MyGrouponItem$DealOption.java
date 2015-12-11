// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import com.groupon.db.models.Price;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            MyGrouponItem

protected static class value
{

    public static final tions DefaultSchedulerOptions = new tions();
    public boolean bookable;
    public List details;
    public String id;
    public String instructions;
    public Price price;
    public String redeemInstructions;
    public List redemptionLocations;
    public tions schedulerOptions;
    public ributes specificAttributes;
    public String subTitle;
    public String title;
    public Price value;


    protected ributes()
    {
        title = "";
        subTitle = "";
        instructions = "";
        redeemInstructions = "";
        id = "";
        bookable = false;
        schedulerOptions = DefaultSchedulerOptions;
        details = Collections.emptyList();
        redemptionLocations = Collections.emptyList();
        specificAttributes = new ributes();
        price = new Price();
        value = new Price();
    }
}
