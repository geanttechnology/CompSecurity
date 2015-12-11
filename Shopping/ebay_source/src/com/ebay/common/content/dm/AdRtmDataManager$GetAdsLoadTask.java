// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private final class adType extends AsyncTask
{

    private onPostExecute adType;
    private onPostExecute param;
    final AdRtmDataManager this$0;

    protected transient adType doInBackground(adType aadtype[])
    {
        if (isCancelled())
        {
            return null;
        }
        param = aadtype[0];
        android.content.Context context = getContext();
        Object obj2;
        obj2 = null;
        aadtype = null;
        Object obj = AdvertisingIdClient.getAdvertisingIdInfo(context);
        aadtype = ((etAdvertisingIdInfo []) (obj));
_L8:
        if (aadtype == null) goto _L2; else goto _L1
_L1:
        if (!aadtype.AdTrackingEnabled()) goto _L3; else goto _L2
_L2:
        if (!(param instanceof tContextQuery)) goto _L4; else goto _L3
_L3:
        String s;
        obj2 = param.n;
        s = EbayCguidGetter.get(getEbayContext(), param.rsister, param.param, ((String) (obj2)));
        boolean flag;
        boolean flag1;
        flag1 = false;
        aadtype = s;
        obj = obj2;
        flag = flag1;
        if (!(param instanceof ntextQuery))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        aadtype = s;
        obj = obj2;
        flag = flag1;
        if (((ntextQuery)param).promoPlacementID == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        ((ntextQuery)param).promoCguid = s;
        flag = flag1;
        obj = obj2;
        aadtype = s;
        break MISSING_BLOCK_LABEL_158;
_L4:
        if (AdRtmDataManager.access$900() == null)
        {
            AdRtmDataManager.access$902(EbayCguidGetter.get(getEbayContext(), param.rsister, param.param, null));
        }
        s1 = AdRtmDataManager.access$900();
        flag2 = true;
        aadtype = s1;
        obj = obj2;
        flag = flag2;
        if (!(param instanceof ntextQuery))
        {
            continue; /* Loop/switch isn't completed */
        }
        aadtype = s1;
        obj = obj2;
        flag = flag2;
        if (((ntextQuery)param).promoPlacementID == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ntextQuery)param).promoCguid = EbayCguidGetter.get(getEbayContext(), param.rsister, param.param, param.n);
        aadtype = s1;
        obj = obj2;
        flag = flag2;
        if (true) goto _L6; else goto _L5
_L5:
        aadtype = param.est(context, ((String) (obj)), aadtype);
        if (param.eRequestContextOnly)
        {
            if (param instanceof ntextQuery)
            {
                return new init>(aadtype.xt(flag, context));
            } else
            {
                return new init>(aadtype.Context(context));
            }
        }
        obj = (com.ebay.common.net.api.rtm.Context)AdRtmDataManager.access$1000(AdRtmDataManager.this, aadtype);
        if (((com.ebay.common.net.api.rtm.his._cls0) (obj)).tatus().hasError())
        {
            return null;
        }
        obj = new RtmHelper(((com.ebay.common.net.api.rtm.tatus) (obj)).tatus, null);
        obj2 = ((RtmHelper) (obj)).getAds();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        if (!param.eResult(aadtype, ((java.util.List) (obj2))))
        {
            break MISSING_BLOCK_LABEL_484;
        }
        aadtype = new init>(((RtmHelper) (obj)));
        return aadtype;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
        return null;
_L6:
        Object obj1;
        String s1;
        boolean flag2;
        try
        {
            if (TextUtils.isEmpty(((CharSequence) (obj))) || !TextUtils.isEmpty(aadtype))
            {
                break; /* Loop/switch isn't completed */
            }
            if (AdRtmDataManager.logger.t>)
            {
                AdRtmDataManager.logger.t>("IAF token supplied w/o matching cguid.  Ad retrieval skipped");
            }
            break MISSING_BLOCK_LABEL_471;
        }
        // Misplaced declaration of an exception variable
        catch (adType aadtype[]) { }
        // Misplaced declaration of an exception variable
        catch (adType aadtype[]) { }
        // Misplaced declaration of an exception variable
        catch (adType aadtype[]) { }
        return null;
        return null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        AdRtmDataManager.access$1100(AdRtmDataManager.this, this, null, adType);
    }

    protected void onPostExecute(adType adtype)
    {
        super.onPostExecute(adtype);
        AdRtmDataManager.access$1100(AdRtmDataManager.this, this, adtype, adType);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((onPostExecute)obj);
    }

    public eException(eException eexception)
    {
        this$0 = AdRtmDataManager.this;
        super();
        param = null;
        adType = eexception;
    }
}
