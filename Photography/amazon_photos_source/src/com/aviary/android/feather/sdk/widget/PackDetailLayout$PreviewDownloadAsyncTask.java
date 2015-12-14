// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import com.aviary.android.feather.cds.AviaryCdsDownloaderFactory;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

class packId extends AviaryAsyncTask
{

    private Throwable error;
    private final com.aviary.android.feather.cds.ncTask.this._cls0 pack;
    private final long packId;
    final PackDetailLayout this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected transient String doInBackground(Context acontext[])
    {
        PackDetailLayout.logger.doInBackground("PreviewDownloadAsyncTask::doInBackground");
        acontext = acontext[0];
        if (!isValidContext() || getPack() == null || acontext == null || packId != getPackId())
        {
            return null;
        }
        com.aviary.android.feather.cds.ncTask nctask = AviaryCdsDownloaderFactory.create(com.aviary.android.feather.cds.ncTask.packId);
        try
        {
            acontext = nctask.load(acontext, packId);
        }
        // Misplaced declaration of an exception variable
        catch (Context acontext[])
        {
            acontext.printStackTrace();
            error = acontext;
            return null;
        }
        return acontext;
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((String)obj);
    }

    protected void doPostExecute(String s)
    {
        PackDetailLayout.logger.doPostExecute("PreviewDownloadAsyncTask::doPostExecute: %s", new Object[] {
            s
        });
        if (isCancelled() || !isValidContext() || getPack() == null || packId != getPackId())
        {
            return;
        }
        if (s != null)
        {
            PackDetailLayout.access$300(PackDetailLayout.this, pack, s);
        }
        if (error != null)
        {
            PackDetailLayout.access$400(PackDetailLayout.this);
        }
        downloadDetailImage(pack);
    }

    protected void doPreExecute()
    {
        PackDetailLayout.access$500(PackDetailLayout.this, true);
    }

    (com.aviary.android.feather.cds.ncTask nctask)
    {
        this$0 = PackDetailLayout.this;
        super();
        pack = nctask;
        packId = nctask.packId();
    }
}
