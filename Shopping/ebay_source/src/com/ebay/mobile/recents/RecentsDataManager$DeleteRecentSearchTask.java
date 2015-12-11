// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsSetAttrClearRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

private final class this._cls0 extends this._cls0
{

    final RecentsDataManager this$0;

    protected volatile EbayRequest getRequest()
    {
        return getRequest();
    }

    protected PdsSetAttrClearRequest getRequest()
    {
        return new PdsSetAttrClearRequest(iafToken, site, cguid, "10203");
    }

    protected void onCancelled(ResultStatus resultstatus)
    {
        super.led(resultstatus);
        RecentsDataManager.access$600(RecentsDataManager.this, null);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((ResultStatus)obj);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.ecute(resultstatus);
        RecentsDataManager.access$600(RecentsDataManager.this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    ()
    {
        this$0 = RecentsDataManager.this;
        super(RecentsDataManager.this, RecentsDataManager.access$200(RecentsDataManager.this)._fld0);
    }
}
