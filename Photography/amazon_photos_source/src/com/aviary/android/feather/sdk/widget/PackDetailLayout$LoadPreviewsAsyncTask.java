// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.text.TextUtils;
import com.aviary.android.feather.cds.AviaryCdsValidatorFactory;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.utils.SystemUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import java.io.File;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

static class callback extends AviaryAsyncTask
{

    public static final int STATUS_ERROR = 2;
    public static final int STATUS_OK = 0;
    public static final int STATUS_REMOTE_DOWNLOAD = 1;
    private final PackDetailLayout callback;
    private final long delay;
    private final com.aviary.android.feather.cds.tarted pack;
    private final long packId;
    private int status;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected transient String doInBackground(Context acontext[])
    {
        com.aviary.android.feather.cds.ncTask nctask;
        Object obj;
        PackDetailLayout.logger.doInBackground("LoadPreviewsAsyncTask::doInBackground");
        acontext = acontext[0];
        if (!callback.isValidContext() || acontext == null || packId != callback.getPackId())
        {
            return null;
        }
        if (delay > 0L)
        {
            SystemUtils.trySleep(delay);
        }
        nctask = CdsUtils.getPackFullInfoById(acontext, packId);
        if (nctask == null || nctask.nt() == null)
        {
            status = 2;
            return null;
        }
        obj = nctask.nt().getPreviewPath();
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        com.aviary.android.feather.cds.ncTask nctask1;
        obj = new File(((String) (obj)));
        nctask1 = AviaryCdsValidatorFactory.create(com.aviary.android.feather.cds.r.getPreviewPath, com.aviary.android.feather.cds.r.getPreviewPath(nctask.ype()));
        nctask1.idate(acontext, nctask.nt().getId(), ((File) (obj)), false);
        acontext = nctask.nt().getPreviewPath();
        return acontext;
        acontext;
        status = 1;
_L4:
        return null;
_L2:
        status = 1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((String)obj);
    }

    protected void doPostExecute(String s)
    {
        PackDetailLayout.logger.doPostExecute("LoadPreviewsAsyncTask::doPostExecute: %s, %d", new Object[] {
            s, Integer.valueOf(status)
        });
        if (callback != null)
        {
            callback.onLoadPreviewsCompleted(status, s, pack);
        }
    }

    protected void doPreExecute()
    {
        if (callback != null)
        {
            callback.onLoadPreviewsStarted();
        }
    }

    (PackDetailLayout packdetaillayout, com.aviary.android.feather.cds.ncTask nctask, long l)
    {
        delay = l;
        pack = nctask;
        packId = nctask.packId();
        callback = packdetaillayout;
    }
}
