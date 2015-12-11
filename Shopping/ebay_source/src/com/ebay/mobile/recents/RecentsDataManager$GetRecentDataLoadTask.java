// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsGetAttributesRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsGetAttributesResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

final class wantRecentSearches extends wantRecentSearches
{

    final RecentsDataManager this$0;
    private final boolean wantRecentSearches;
    private final boolean wantRecentlyViewed;

    protected volatile EbayRequest getRequest()
    {
        return getRequest();
    }

    protected PdsGetAttributesRequest getRequest()
    {
        return new PdsGetAttributesRequest(iafToken, site, cguid, wantRecentlyViewed, wantRecentSearches);
    }

    protected void onCancelled(wantRecentSearches wantrecentsearches)
    {
        super.ed(wantrecentsearches);
        RecentsDataManager.access$1100(RecentsDataManager.this, null);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((onCancelled)obj);
    }

    protected void onPostExecute(onCancelled oncancelled)
    {
        super.cute(oncancelled);
        RecentsDataManager.access$1100(RecentsDataManager.this, oncancelled);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((onPostExecute)obj);
    }

    protected transient onPostExecute startBackgroundTask(Object aobj[])
    {
        onPostExecute onpostexecute;
        try
        {
            aobj = (PdsGetAttributesResponse)RecentsDataManager.access$900(RecentsDataManager.this, getRequest());
            onpostexecute = new getRequest(RecentsDataManager.this, null);
            (onpostexecute, ((PdsGetAttributesResponse) (aobj)).getResultStatus());
            if (!((PdsGetAttributesResponse) (aobj)).getResultStatus().hasError())
            {
                (onpostexecute, ((PdsGetAttributesResponse) (aobj)).recentSearches);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            return null;
        }
        return onpostexecute;
    }

    protected volatile Object startBackgroundTask(Object aobj[])
    {
        return startBackgroundTask(aobj);
    }

    (String s, boolean flag, boolean flag1)
    {
        this$0 = RecentsDataManager.this;
        super(RecentsDataManager.this, s);
        wantRecentlyViewed = flag;
        wantRecentSearches = flag1;
    }
}
