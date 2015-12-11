// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextDataManager

public static interface I
{

    public abstract void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry);

    public abstract void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag);

    public abstract void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2);
}
