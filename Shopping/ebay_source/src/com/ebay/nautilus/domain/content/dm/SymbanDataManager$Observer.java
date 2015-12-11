// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager

public static interface 
{

    public abstract void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus);

    public abstract void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i);

    public abstract void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content);

    public abstract void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.um um);
}
