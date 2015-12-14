// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

class aps extends AsyncHttpResponseHandler
{

    final apr a;

    aps(apr apr1)
    {
        a = apr1;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Log.e("GoogleAnalyticsUtil", "postEvent failed");
        if (apr.a(a) != null)
        {
            apr.a(a).a(false);
        }
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Log.e("GoogleAnalyticsUtil", "postEvent success");
        if (apr.a(a) != null)
        {
            apr.a(a).a(true);
        }
    }
}
