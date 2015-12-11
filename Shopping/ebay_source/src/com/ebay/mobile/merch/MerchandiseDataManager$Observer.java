// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseDataManager

public static interface 
{

    public abstract void onMerchandiseLoaded(MerchandiseDataManager merchandisedatamanager, Content content);

    public abstract void onMerchandiseLoading(MerchandiseDataManager merchandisedatamanager);
}
