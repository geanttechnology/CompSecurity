// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.amazon.mas.client.authentication.AuthCookie;
import com.amazon.venezia.web.AuthCookieHelper;
import com.amazon.venezia.web.SSRStack;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.client.ftue:
//            InferCorPfmFragment

class url extends AsyncTask
{

    final InferCorPfmFragment this$0;
    private final String url;

    private void setUpIdentityCookies()
    {
        if (authCookieHelper != null && InferCorPfmFragment.access$100(InferCorPfmFragment.this) != null)
        {
            Object obj = new ArrayList();
            ((List) (obj)).add(AuthCookie.X_MAIN);
            obj = ((AuthCookieHelper)authCookieHelper.get()).getMapCookies(((List) (obj)), InferCorPfmFragment.access$100(InferCorPfmFragment.this).getMapCompliantDomain(), false);
            ((AuthCookieHelper)authCookieHelper.get()).setDomainCompliantCookie(((java.util.Map) (obj)), url, InferCorPfmFragment.access$100(InferCorPfmFragment.this));
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        setUpIdentityCookies();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        InferCorPfmFragment.access$700(InferCorPfmFragment.this).loadUrl(url);
    }

    public A(String s)
    {
        this$0 = InferCorPfmFragment.this;
        super();
        url = s;
    }
}
