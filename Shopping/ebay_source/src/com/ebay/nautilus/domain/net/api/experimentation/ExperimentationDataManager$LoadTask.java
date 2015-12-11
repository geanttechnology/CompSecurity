// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager, Experiment, GetTreatmentsRequest, GetTreatmentsResponse, 
//            Qualification

private final class <init> extends AsyncTask
{

    final ExperimentationDataManager this$0;

    protected transient Qualification doInBackground(arams aarams[])
    {
        Object obj;
        if (isCancelled())
        {
            return null;
        }
        if (aarams.length != 1)
        {
            throw new InvalidParameterException("LoadTask expects exactly one 'params' element");
        }
        aarams = aarams[0];
        obj = new ArrayList();
        Object obj1 = ((arams) (aarams)).experiments.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Experiment experiment = (Experiment)((Iterator) (obj1)).next();
            String s = experiment.getName();
            if (!ExperimentationDataManager.access$1200(ExperimentationDataManager.this, s))
            {
                ((List) (obj)).add(experiment);
            }
        } while (true);
        obj1 = new ArrayList();
        Object obj2 = getContext();
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((List) (obj1)).addAll(((Experiment)iterator.next()).getContextDictionary(((android.content.Context) (obj2))))) { }
        ((List) (obj1)).addAll(ExperimentationDataManager.access$1300(ExperimentationDataManager.this).getContextDictionary(((android.content.Context) (obj2))));
        obj = ExperimentationDataManager.access$1400(ExperimentationDataManager.this, ((List) (obj)));
        obj2 = new HashMap();
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Pair pair = (Pair)((Iterator) (obj1)).next();
            if (!((Map) (obj2)).containsKey(pair.first))
            {
                ((Map) (obj2)).put(pair.first, pair.second);
            }
        } while (true);
        obj1 = ExperimentationDataManager.access$1500(ExperimentationDataManager.this).getChannelId();
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((Map) (obj2)).put("channelId", obj1);
        }
        aarams = new GetTreatmentsRequest(((arams) (aarams)).iafToken, ((Map) (obj2)));
        aarams.optIn = ExperimentationDataManager.access$1600(ExperimentationDataManager.this).optIn;
        aarams = (GetTreatmentsResponse)com.ebay.nautilus.kernel.net.ponse(getEbayContext(), aarams);
        if (isCancelled())
        {
            return null;
        }
        if (!aarams.isSuccessful() || ((GetTreatmentsResponse) (aarams)).qualification == null)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        ((GetTreatmentsResponse) (aarams)).qualification.metadata.knownExperimentsToContextHash = ((Map) (obj));
        ((GetTreatmentsResponse) (aarams)).qualification.expirationTimestampMillis = ((GetTreatmentsResponse) (aarams)).qualification.qualificationTimestampMillis + ExperimentationDataManager.access$1700(ExperimentationDataManager.this);
        aarams = ((GetTreatmentsResponse) (aarams)).qualification;
        return aarams;
        aarams;
        ExperimentationDataManager.logger.logger("Non-fatal exception encountered while making qualification request", aarams);
_L2:
        return null;
        aarams;
        ExperimentationDataManager.logger.logger("Non-fatal exception encountered while processing qualification response", aarams);
        continue; /* Loop/switch isn't completed */
        aarams;
        ExperimentationDataManager.logger.logger("Stale request was cancelled");
        continue; /* Loop/switch isn't completed */
        aarams;
        ExperimentationDataManager.logger.logger("Non-fatal exception encountered while making qualification request", aarams);
        continue; /* Loop/switch isn't completed */
        aarams;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((arams[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        ExperimentationDataManager.access$1800(ExperimentationDataManager.this, this, null);
    }

    protected void onPostExecute(Qualification qualification)
    {
        super.onPostExecute(qualification);
        ExperimentationDataManager.access$1800(ExperimentationDataManager.this, this, qualification);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Qualification)obj);
    }

    private arams()
    {
        this$0 = ExperimentationDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
