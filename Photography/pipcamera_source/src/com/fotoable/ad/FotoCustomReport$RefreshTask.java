// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import com.fotoable.comlib.util.AsyncTask;

// Referenced classes of package com.fotoable.ad:
//            FotoCustomReport

class mCtx extends AsyncTask
{

    Context mCtx;

    protected transient Object doInBackground(Object aobj[])
    {
        try
        {
            aobj = mCtx;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            return null;
        }
        if (aobj == null)
        {
            return null;
        }
        FotoCustomReport.SessionStarted(mCtx);
        Thread.sleep(4000L);
        FotoCustomReport.SessionStopped(mCtx);
        return null;
        aobj;
        ((Exception) (aobj)).printStackTrace();
        return null;
    }

    (Context context)
    {
        mCtx = context;
    }
}
