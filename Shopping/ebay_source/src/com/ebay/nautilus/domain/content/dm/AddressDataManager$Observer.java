// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

public static interface 
{

    public abstract void onAddressDeleted(AddressDataManager addressdatamanager, Content content);

    public abstract void onAddressPrimary(AddressDataManager addressdatamanager, Content content);

    public abstract void onAddressUpdated(AddressDataManager addressdatamanager, Content content);

    public abstract void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag);
}
