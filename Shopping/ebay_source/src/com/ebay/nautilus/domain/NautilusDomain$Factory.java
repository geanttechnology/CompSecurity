// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.content.Context;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain:
//            NautilusDomain

public static interface DataManagerBase.Configuration
{

    public abstract String getMachineGroupId(Context context);

    public abstract com.ebay.nautilus.domain.content.dm.Base.Configuration getShoppingCartDataManagerConfiguration(Context context);

    public abstract void initializeDataManager(EbayContext ebaycontext, DataManager datamanager);

    public abstract void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus);
}
