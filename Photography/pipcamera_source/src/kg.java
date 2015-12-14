// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;

public class kg
{

    private static kg b;
    private kh a;

    public kg()
    {
    }

    private String a(String s)
    {
        String s1 = "";
        if (s.equals("com.pipcamera.activity"))
        {
            s1 = "UA-62205916-8";
        } else
        {
            if (s.equals("com.wantu.activity"))
            {
                return "UA-62205916-6";
            }
            if (s.equals("com.instamag.activity"))
            {
                return "UA-62205916-7";
            }
            if (s.equals("com.fotoable.helpr"))
            {
                return "UA-62205916-10";
            }
            if (s.equals("com.fotoable.fotobeauty"))
            {
                return "UA-62205916-9";
            }
            if (s.equals("com.exmaple.starcamera"))
            {
                return "UA-62205916-11";
            }
        }
        return s1;
    }

    public static kg a()
    {
        if (b == null)
        {
            b = new kg();
        }
        return b;
    }

    static kh a(kg kg1)
    {
        return kg1.a;
    }

    public void a(Context context, String s, String s1, String s2, kh kh)
    {
        AsyncHttpClient asynchttpclient;
        RequestParams requestparams;
        try
        {
            a = kh;
            kh = et.h(context.getApplicationContext());
            context = et.b(context);
            String s3 = a(((String) (context)));
            asynchttpclient = new AsyncHttpClient();
            asynchttpclient.setConnectTimeout(20000);
            asynchttpclient.setTimeout(20000);
            requestparams = new RequestParams();
            requestparams.put("tid", s3);
            requestparams.put("t", "event");
            requestparams.put("cid", kh);
            requestparams.put("ec", s);
            requestparams.put("ea", s1);
            requestparams.put("v", "1");
            requestparams.put("an", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (s2.length() > 0)
        {
            requestparams.put("el", s2);
        }
        asynchttpclient.post("http://www.google-analytics.com/collect", requestparams, new AsyncHttpResponseHandler() {

            final kg a;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                Log.e("GoogleAnalyticsUtil", "postEvent failed");
                if (kg.a(a) != null)
                {
                    kg.a(a).a(false);
                }
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                Log.e("GoogleAnalyticsUtil", "postEvent success");
                if (kg.a(a) != null)
                {
                    kg.a(a).a(true);
                }
            }

            
            {
                a = kg.this;
                super();
            }
        });
        return;
    }
}
