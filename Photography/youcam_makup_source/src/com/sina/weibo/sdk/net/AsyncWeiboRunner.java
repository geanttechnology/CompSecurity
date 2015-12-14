// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.Context;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.sina.weibo.sdk.net:
//            WeiboParameters, HttpManager, RequestListener

public class AsyncWeiboRunner
{

    private Context mContext;

    public AsyncWeiboRunner(Context context)
    {
        mContext = context;
    }

    public String request(String s, WeiboParameters weiboparameters, String s1)
    {
        WbAppActivator.getInstance(mContext, weiboparameters.getAppKey()).activateApp();
        return HttpManager.openUrl(mContext, s, s1, weiboparameters);
    }

    public void requestAsync(String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
    {
        WbAppActivator.getInstance(mContext, weiboparameters.getAppKey()).activateApp();
        (new RequestRunner(mContext, s, weiboparameters, s1, requestlistener)).execute(new Void[1]);
    }

    public void requestByThread(final String url, final WeiboParameters params, final String httpMethod, final RequestListener listener)
    {
        (new Thread() {

            final AsyncWeiboRunner this$0;
            private final String val$httpMethod;
            private final RequestListener val$listener;
            private final WeiboParameters val$params;
            private final String val$url;

            public void run()
            {
                String s = HttpManager.openUrl(mContext, url, httpMethod, params);
                if (listener != null)
                {
                    listener.onComplete(s);
                }
_L1:
                return;
                WeiboException weiboexception;
                weiboexception;
                if (listener != null)
                {
                    listener.onWeiboException(weiboexception);
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = AsyncWeiboRunner.this;
                url = s;
                httpMethod = s1;
                params = weiboparameters;
                listener = requestlistener;
                super();
            }
        }).start();
    }


    private class RequestRunner extends AsyncTask
    {

        private final Context mContext;
        private final String mHttpMethod;
        private final RequestListener mListener;
        private final WeiboParameters mParams;
        private final String mUrl;

        protected transient AsyncTaskResult doInBackground(Void avoid[])
        {
            try
            {
                avoid = new AsyncTaskResult(HttpManager.openUrl(mContext, mUrl, mHttpMethod, mParams));
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return new AsyncTaskResult(avoid);
            }
            return avoid;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(AsyncTaskResult asynctaskresult)
        {
            WeiboException weiboexception = asynctaskresult.getError();
            if (weiboexception != null)
            {
                mListener.onWeiboException(weiboexception);
                return;
            } else
            {
                mListener.onComplete((String)asynctaskresult.getResult());
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((AsyncTaskResult)obj);
        }

        protected void onPreExecute()
        {
        }

        public RequestRunner(Context context, String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
        {
            mContext = context;
            mUrl = s;
            mParams = weiboparameters;
            mHttpMethod = s1;
            mListener = requestlistener;
        }

        private class AsyncTaskResult
        {

            private WeiboException error;
            private Object result;

            public WeiboException getError()
            {
                return error;
            }

            public Object getResult()
            {
                return result;
            }

            public AsyncTaskResult(WeiboException weiboexception)
            {
                error = weiboexception;
            }

            public AsyncTaskResult(Object obj)
            {
                result = obj;
            }
        }

    }

}
