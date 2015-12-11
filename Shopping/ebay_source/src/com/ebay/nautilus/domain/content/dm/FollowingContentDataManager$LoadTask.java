// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.domain.net.api.feed.FeedRequest;
import com.ebay.nautilus.domain.net.api.feed.FeedResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            FollowingContentDataManager

private final class iafToken extends AsyncTask
{

    private final EbayCountry country;
    private final String iafToken;
    final FollowingContentDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        if (FollowingContentDataManager.log.)
        {
            FollowingContentDataManager.log.((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        if (iafToken != null) goto _L2; else goto _L1
_L1:
        avoid = ResultStatus.create(new com.ebay.nautilus.kernel.content.sk.iafToken[] {
            InternalDomainError.getPleaseSignInMessage()
        });
_L4:
        return new Content(avoid);
_L2:
        if (country != null)
        {
            break; /* Loop/switch isn't completed */
        }
        avoid = ResultStatus.create(new com.ebay.nautilus.kernel.content.sk.country[] {
            InternalDomainError.getCountryNotSpecifiedMessage()
        });
        if (true) goto _L4; else goto _L3
_L3:
        ResultStatus resultstatus;
        FeedResponse feedresponse;
        try
        {
            feedresponse = (FeedResponse)FollowingContentDataManager.access$000(FollowingContentDataManager.this, new FeedRequest(iafToken, country));
            resultstatus = feedresponse.getResultStatus();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        avoid = resultstatus;
        if (resultstatus.hasError()) goto _L4; else goto _L5
_L5:
        avoid = new Content(new FollowingContent(feedresponse.feed), resultstatus);
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayCountry ebaycountry, String s)
    {
        this$0 = FollowingContentDataManager.this;
        super();
        country = ebaycountry;
        iafToken = s;
    }
}
