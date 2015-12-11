// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils;

import android.content.Context;
import android.os.AsyncTask;

public abstract class WorkerTask extends AsyncTask
{

    private Context mContext;

    protected WorkerTask(Context context)
    {
        mContext = context;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            doWork(mContext);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            mContext = null;
            return null;
        }
        finally
        {
            mContext = null;
        }
        mContext = null;
        return null;
        throw avoid;
    }

    protected abstract void doWork(Context context)
        throws Exception;
}
