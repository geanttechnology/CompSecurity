// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

private abstract class > extends >
{

    final RecentsDataManager this$0;

    protected transient ResultStatus startBackgroundTask(Void avoid[])
    {
        try
        {
            avoid = ((EbayResponse)RecentsDataManager.access$400(RecentsDataManager.this, getRequest())).getResultStatus();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        return avoid;
    }

    protected volatile Object startBackgroundTask(Object aobj[])
    {
        return startBackgroundTask((Void[])aobj);
    }

    (String s)
    {
        this$0 = RecentsDataManager.this;
        super(RecentsDataManager.this, s);
    }
}
