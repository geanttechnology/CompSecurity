// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.StaticFlurryEvent;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class aon
{

    private static String a = (new StringBuilder()).append(a()).append("pushregist/").toString();
    private static String b = (new StringBuilder()).append(a()).append("regist/").toString();

    public static String a()
    {
        String s = "http://regist.fotoable.net/";
        if (if.b().equalsIgnoreCase("CN"))
        {
            s = "http://regist.fotoable.com/";
        }
        return s;
    }

    public static void a(Context context)
    {
        String s = String.format("%s&vernum=%s", new Object[] {
            b(context), if.f(context)
        });
        b(context, b, s);
    }

    public static void a(Context context, String s, String s1)
    {
        s = String.format("%s&token=%s&xgtoken=%s&vernum=%s", new Object[] {
            b(context), s, s1, if.f(context)
        });
        if (200 == b(context, a, s))
        {
            StaticFlurryEvent.logGCMEventWithKV("pushkey", "push_upload_token_success");
            StaticFlurryEvent.logGCMEventUnique(context, "pushkey_Unique", "push_upload_success_Unique");
        }
    }

    public static int b(Context context, String s, String s1)
    {
        Log.e("BaseRecordData", (new StringBuilder()).append("host : ").append(s).toString());
        Log.e("BaseRecordData", (new StringBuilder()).append("entity : ").append(s1).toString());
        int i;
        context = new DefaultHttpClient();
        s = new HttpPost(s);
        Log.v("baohuo params:", (new StringBuilder()).append("baohuo params:").append(s1).toString());
        s1 = new StringEntity(s1, "UTF-8");
        s1.setContentType("application/x-www-form-urlencoded");
        s.setEntity(s1);
        i = context.execute(s).getStatusLine().getStatusCode();
        return i;
        context;
        context.printStackTrace();
        Crashlytics.logException(context);
_L2:
        return -1;
        context;
        Crashlytics.logException(context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String b(Context context)
    {
        return String.format("os=android&osver=%s&appid=%s&ver=%s&countrycode=%s&langcode=%s&prelang=%s&fotouuid=%s&devicetype=%s&deviceName=%s&screenWidth=%d&screenHeight=%d", new Object[] {
            if.a(), if.b(context), if.e(context), if.b(), if.c(), if.d(), if.i(context), if.f(), if.e(), Integer.valueOf(if.j(context)), 
            Integer.valueOf(if.k(context))
        });
    }

}
