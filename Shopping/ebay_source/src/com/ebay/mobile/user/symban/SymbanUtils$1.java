// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanUtils

static final class DataManager extends com.ebay.nautilus.domain.content.dm.ger.SimpleObserver
{

    public void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i)
    {
        MyApp.setAppBadgeCount(i);
    }

    DataManager()
    {
    }
}
