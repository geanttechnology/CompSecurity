// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager

class val.checkedCount
    implements Runnable
{

    final SymbanDataManager this$0;
    final int val$checkedCount;

    public void run()
    {
        invalidateList();
        countData = Integer.valueOf(val$checkedCount);
        ((server)SymbanDataManager.access$100(SymbanDataManager.this)).onSymbanCountChanged(SymbanDataManager.this, countData.intValue());
    }

    server()
    {
        this$0 = final_symbandatamanager;
        val$checkedCount = I.this;
        super();
    }
}
