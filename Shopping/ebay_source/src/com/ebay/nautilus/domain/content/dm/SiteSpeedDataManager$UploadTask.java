// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.net.api.sitespeed.SiteSpeedRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SiteSpeedDataManager

private final class data extends AsyncTask
{

    private final SiteSpeedData data;
    private final ta meta;
    private final ta observer;
    final SiteSpeedDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        meta.setDeviceId(EbayIdentity.getDeviceIdString(getContext()));
        avoid = new ResultStatusOwner();
        SiteSpeedDataManager.access$100(SiteSpeedDataManager.this, new SiteSpeedRequest(data, SiteSpeedDataManager.access$000(SiteSpeedDataManager.this), meta), avoid);
        avoid = avoid.getResultStatus();
        if (SiteSpeedDataManager.logger.r)
        {
            SiteSpeedDataManager.logger.r((new StringBuilder()).append("Sent site speed data with result: ").append(avoid.toString()).toString());
            SiteSpeedDataManager.logger.r(data.toString());
            SiteSpeedDataManager.logger.r(SiteSpeedDataManager.access$000(SiteSpeedDataManager.this).toString());
            SiteSpeedDataManager.logger.r(meta.toString());
        }
        if (avoid == ResultStatus.CANCELED)
        {
            return null;
        } else
        {
            return new Content(data, avoid);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        while (content == null || observer == null) 
        {
            return;
        }
        observer.UploadCompleted(SiteSpeedDataManager.this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public ta(ta ta, ta ta1, SiteSpeedData sitespeeddata)
    {
        this$0 = SiteSpeedDataManager.this;
        super();
        observer = ta;
        meta = ta1;
        data = sitespeeddata;
    }
}
