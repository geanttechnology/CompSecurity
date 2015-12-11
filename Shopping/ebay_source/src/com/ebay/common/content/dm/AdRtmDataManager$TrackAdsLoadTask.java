// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import com.ebay.common.util.TrackableDictionary;
import com.ebay.nautilus.domain.net.DataRequest;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

private final class <init> extends AsyncTask
{

    final AdRtmDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((arams[])aobj);
    }

    protected transient Void doInBackground(arams aarams[])
    {
        aarams = aarams[0];
        com.ebay.common.rtm.adTaskParams adtaskparams = ((arams) (aarams)).ad;
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
        try
        {
            DataRequest datarequest = new DataRequest(adtaskparams.text);
            AdRtmDataManager.access$800(AdRtmDataManager.this, datarequest);
            ((arams) (aarams)).trackableDictionary.addKeyValuePair("trkp", adtaskparams.ir);
            ((arams) (aarams)).trackableDictionary.send(ebaycontext);
        }
        // Misplaced declaration of an exception variable
        catch (arams aarams[])
        {
            aarams.printStackTrace();
        }
        return null;
    }

    private arams()
    {
        this$0 = AdRtmDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
