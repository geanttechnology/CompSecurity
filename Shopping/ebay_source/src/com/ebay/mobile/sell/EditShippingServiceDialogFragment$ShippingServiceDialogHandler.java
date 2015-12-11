// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.sell:
//            EditShippingServiceDialogFragment

public static interface Y
{

    public abstract boolean isDataAvailable();

    public abstract void onDeleteShippingService(String s, boolean flag);

    public abstract void onSaveDomesticShippingService(String s, String s1, String s2, String s3, String s4);

    public abstract void onSaveInternationalShippingService(String s, String s1, String s2, String s3, String s4, boolean flag, String s5, 
            ArrayList arraylist);
}
