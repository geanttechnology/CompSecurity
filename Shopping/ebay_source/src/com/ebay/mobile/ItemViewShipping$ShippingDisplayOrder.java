// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;


// Referenced classes of package com.ebay.mobile:
//            ItemViewShipping

public static class eddIncludeDayOfWeek
{

    public int colorId;
    public boolean costShowEachAdditional;
    public boolean eddIncludeDayOfWeek;
    public boolean eddReturnJustDates;
    public num type;

    public num(num num, int i)
    {
        this(num, i, false, false);
    }

    public num(num num, int i, boolean flag)
    {
        this(num, i, false, false);
        costShowEachAdditional = flag;
    }

    public num(num num, int i, boolean flag, boolean flag1)
    {
        colorId = i;
        type = num;
        eddReturnJustDates = flag;
        eddIncludeDayOfWeek = flag1;
    }
}
