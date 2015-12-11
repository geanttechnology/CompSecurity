// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


// Referenced classes of package com.ebay.mobile.search.refine.types:
//            ItemConditionHelper

public class tate
{

    public final String constraintValue;
    public final String displayValue;
    public final tate state;
    final ItemConditionHelper this$0;

    protected tate(tate tate)
    {
        this$0 = ItemConditionHelper.this;
        super();
        state = tate;
        int i = tate.ordinal();
        constraintValue = conditionConstraintValues[i];
        displayValue = conditionDisplayValues[i];
    }

    public tate(String s)
    {
        this(ItemConditionHelper.access$000(ItemConditionHelper.this, s));
    }
}
