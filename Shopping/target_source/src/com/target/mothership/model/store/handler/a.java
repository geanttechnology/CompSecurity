// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTRelevantStoreSummary

public class a
{

    public a()
    {
    }

    public RelevantStoreSummary a(StoreSummary storesummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        return new TGTRelevantStoreSummary(storesummary, flag, flag1, flag2, flag3);
    }
}
