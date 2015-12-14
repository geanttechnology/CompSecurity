// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.sina.weibo.sdk.net:
//            HttpManager, RequestListener, WeiboParameters

class mListener extends AsyncTask
{

    private final Context mContext;
    private final String mHttpMethod;
    private final RequestListener mListener;
    private final WeiboParameters mParams;
    private final String mUrl;

    protected transient t doInBackground(Void avoid[])
    {
        try
        {
            avoid = new t(HttpManager.openUrl(mContext, mUrl, mHttpMethod, mParams));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return new t(avoid);
        }
        return avoid;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(t t)
    {
        WeiboException weiboexception = t.getError();
        if (weiboexception != null)
        {
            mListener.onWeiboException(weiboexception);
            return;
        } else
        {
            mListener.onComplete((String)t.getResult());
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((t)obj);
    }

    protected void onPreExecute()
    {
    }

    public t(Context context, String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
    {
        mContext = context;
        mUrl = s;
        mParams = weiboparameters;
        mHttpMethod = s1;
        mListener = requestlistener;
    }
}
