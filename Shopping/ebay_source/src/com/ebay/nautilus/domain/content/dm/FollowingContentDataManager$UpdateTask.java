// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.net.api.feed.HiddenFollowsRequest;
import com.ebay.nautilus.domain.net.api.feed.HiddenFollowsResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            FollowingContentDataManager

private final class iafToken extends AsyncTask
{

    private final EbayCountry country;
    final com.ebay.nautilus.domain.data.eTask.onPostExecute entity;
    private final String iafToken;
    final onPostExecute observer;
    final FollowingContentDataManager this$0;

    protected transient Content doInBackground(com.ebay.nautilus.domain.net.api.feed.fToken aftoken[])
    {
        if (FollowingContentDataManager.log.eTask)
        {
            FollowingContentDataManager.log.eTask((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        if (iafToken != null) goto _L2; else goto _L1
_L1:
        aftoken = ResultStatus.create(new com.ebay.nautilus.kernel.content.sk.iafToken[] {
            InternalDomainError.getPleaseSignInMessage()
        });
_L4:
        return new Content(aftoken);
_L2:
        if (country != null)
        {
            break; /* Loop/switch isn't completed */
        }
        aftoken = ResultStatus.create(new com.ebay.nautilus.kernel.content.sk.country[] {
            InternalDomainError.getCountryNotSpecifiedMessage()
        });
        if (true) goto _L4; else goto _L3
_L3:
        if (aftoken == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (aftoken.length <= 0)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        aftoken = aftoken[0];
_L6:
        ResultStatus resultstatus;
        HiddenFollowsResponse hiddenfollowsresponse;
        try
        {
            hiddenfollowsresponse = (HiddenFollowsResponse)FollowingContentDataManager.access$100(FollowingContentDataManager.this, new HiddenFollowsRequest(iafToken, country, aftoken));
            resultstatus = hiddenfollowsresponse.getResultStatus();
        }
        // Misplaced declaration of an exception variable
        catch (com.ebay.nautilus.domain.net.api.feed.fToken aftoken[])
        {
            return null;
        }
        aftoken = resultstatus;
        if (resultstatus.hasError()) goto _L4; else goto _L5
_L5:
        aftoken = new Content(hiddenfollowsresponse.hiddenFollows, resultstatus);
        return aftoken;
        aftoken = null;
          goto _L6
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((com.ebay.nautilus.domain.net.api.feed.InBackground[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleUpdateDataResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleUpdateDataResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public ( , com.ebay.nautilus.domain.data.ver ver, EbayCountry ebaycountry, Authentication authentication)
    {
        this$0 = FollowingContentDataManager.this;
        super();
        observer = ;
        entity = ver;
        country = ebaycountry;
        if (authentication != null)
        {
            followingcontentdatamanager = authentication.iafToken;
        } else
        {
            followingcontentdatamanager = null;
        }
        iafToken = FollowingContentDataManager.this;
    }
}
