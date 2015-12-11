// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import com.ebay.nautilus.domain.data.LdsOption;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.sell:
//            ShippingLocationDialogFragment

public static interface 
{

    public abstract void onShipToDialogLocationsResult(int i, ArrayList arraylist);

    public abstract void onShipToDialogRegionResult(int i, LdsOption ldsoption);
}
