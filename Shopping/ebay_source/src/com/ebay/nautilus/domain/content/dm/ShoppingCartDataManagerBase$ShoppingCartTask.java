// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public abstract class caller extends AsyncTask
{

    public final action action;
    protected final action caller;
    protected final String itemId;
    protected final String siteId;
    final ShoppingCartDataManagerBase this$0;
    protected final String userId;

    protected void onCancelled()
    {
        super.onCancelled();
        outstandingTasks.remove(this);
        if (caller != null)
        {
            caller.ngCartChanged(ShoppingCartDataManagerBase.this, action, new Content(ResultStatus.CANCELED));
            return;
        } else
        {
            ((action)ShoppingCartDataManagerBase.access$000(ShoppingCartDataManagerBase.this)).ngCartChanged(ShoppingCartDataManagerBase.this, action, new Content(ResultStatus.CANCELED));
            return;
        }
    }

    protected ( , String s, String s1, String s2,  1)
    {
        this$0 = ShoppingCartDataManagerBase.this;
        super();
        action = ;
        siteId = s;
        itemId = s1;
        userId = s2;
        caller = 1;
    }
}
