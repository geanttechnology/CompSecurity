// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

public class apr
{

    private static apr b;
    private apt a;

    public apr()
    {
    }

    public static apr a()
    {
        if (b == null)
        {
            b = new apr();
        }
        return b;
    }

    static apt a(apr apr1)
    {
        return apr1.a;
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

    public void a(Context context, apt apt)
    {
        try
        {
            a = apt;
            apt = if.i(context.getApplicationContext());
            String s = if.b(context);
            String s1 = a(s);
            context = if.c(context);
            AsyncHttpClient asynchttpclient = new AsyncHttpClient();
            asynchttpclient.setConnectTimeout(20000);
            asynchttpclient.setTimeout(20000);
            RequestParams requestparams = new RequestParams();
            requestparams.put("v", "1");
            requestparams.put("tid", s1);
            requestparams.put("cid", apt);
            requestparams.put("t", "screenview");
            requestparams.put("an", s);
            requestparams.put("aid", s);
            requestparams.put("aiid", context);
            requestparams.put("cd", "Home");
            asynchttpclient.post("http://www.google-analytics.com/collect", requestparams, new aps(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
        }
    }
}
