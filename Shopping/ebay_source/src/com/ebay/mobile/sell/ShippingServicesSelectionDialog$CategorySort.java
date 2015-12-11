// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import java.util.Comparator;

// Referenced classes of package com.ebay.mobile.sell:
//            ShippingServicesSelectionDialog

private class <init>
    implements Comparator
{

    final ShippingServicesSelectionDialog this$0;

    public int compare(viceCategoryType vicecategorytype, viceCategoryType vicecategorytype1)
    {
        return vicecategorytype.getCategoryIdentifier().compareTo(vicecategorytype1.getCategoryIdentifier());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((viceCategoryType)obj, (viceCategoryType)obj1);
    }

    private viceCategoryType()
    {
        this$0 = ShippingServicesSelectionDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
