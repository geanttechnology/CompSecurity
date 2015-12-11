// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.os.AsyncTask;
import com.arellomobile.android.push.exception.PushWooshException;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push:
//            SendPushTagsCallBack, PushManager

abstract class SendPushTagsAbstractAsyncTask extends AsyncTask
    implements SendPushTagsCallBack
{

    private Context mContext;
    private PushWooshException mError;

    public SendPushTagsAbstractAsyncTask(Context context)
    {
        mContext = context;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Map[])aobj);
    }

    protected transient Map doInBackground(Map amap[])
    {
        try
        {
            if (amap.length != 1)
            {
                throw new PushWooshException("Wrong parameters");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Map amap[])
        {
            mError = amap;
            mContext = null;
            return null;
        }
        amap = PushManager.sendTagsFromBG(mContext, amap[0]);
        mContext = null;
        return amap;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Map)obj);
    }

    protected void onPostExecute(Map map)
    {
        super.onPostExecute(map);
        if (mError != null)
        {
            onSentTagsError(mError);
            return;
        } else
        {
            onSentTagsSuccess(map);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        taskStarted();
    }
}
