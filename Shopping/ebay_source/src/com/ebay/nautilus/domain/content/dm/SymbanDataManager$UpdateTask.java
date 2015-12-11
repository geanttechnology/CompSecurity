// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager

private class <init> extends AsyncTask
{

    private com.ebay.nautilus.domain.net.symban.onPostExecute params;
    final SymbanDataManager this$0;

    protected transient ResultStatus doInBackground(com.ebay.nautilus.domain.net.symban.<init> a_3C_init>[])
    {
        if (SymbanDataManager.log.ams || SymbanDataManager.logDm. || SymbanDataManager.logDmNetwork.Network)
        {
            SymbanDataManager.logDmNetwork.Network((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        if (a_3C_init> != null && a_3C_init>.length > 0)
        {
            a_3C_init> = a_3C_init>[0];
        } else
        {
            a_3C_init> = (new com.ebay.nautilus.domain.net.symban.nit>(new Date())).tMarkAllRead(true);
        }
        params = a_3C_init>;
        a_3C_init> = new ResultStatusOwner();
        if (SymbanDataManager.access$300(SymbanDataManager.this) == null)
        {
            a_3C_init>.addResultMessage(new com.ebay.nautilus.kernel.content.ssage[] {
                InternalDomainError.getPleaseSignInMessage()
            });
        } else
        if (currentCountry == null)
        {
            a_3C_init>.addResultMessage(new com.ebay.nautilus.kernel.content.ssage[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
        } else
        {
            SymbanUpdateRequest symbanupdaterequest = new SymbanUpdateRequest(SymbanDataManager.access$300(SymbanDataManager.this), currentCountry, params);
            SymbanDataManager.access$800(SymbanDataManager.this, symbanupdaterequest, a_3C_init>);
        }
        return a_3C_init>.getResultStatus();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((com.ebay.nautilus.domain.net.symban.doInBackground[])aobj);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        if (!resultstatus.hasError())
        {
            listLatestTime = params.tDate();
            doInBackground doinbackground = (tDate)SymbanDataManager.access$900(SymbanDataManager.this);
            SymbanDataManager symbandatamanager = SymbanDataManager.this;
            int i;
            if (countData != null)
            {
                i = countData.intValue();
            } else
            {
                i = 0;
            }
            doinbackground.SymbanCountChanged(symbandatamanager, i);
        }
        ((SymbanCountChanged)SymbanDataManager.access$1000(SymbanDataManager.this)).MarkAllReadCompleted(SymbanDataManager.this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public String toString()
    {
        return getClass().getSimpleName();
    }

    private ()
    {
        this$0 = SymbanDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
