// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

public static class mListener extends AsyncTask
{

    private ner mListener;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = SSOUtil.getCurrentAccount((Context)com.amazon.mShop.platform.ackground().getApplicationContext());
        if (TextUtils.isEmpty(avoid))
        {
            return "";
        } else
        {
            return SSOUtil.getFullNameFromCustomerAttribute(avoid);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        mListener.afterFullnameFetched(s);
    }

    protected void onPreExecute()
    {
        mListener.beforeFetchingFullname();
    }

    public ner(ner ner)
    {
        mListener = ner;
    }
}
