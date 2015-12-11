// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.ads.conversiontracking.a;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi

public class hl
    implements gi
{

    public hl()
    {
    }

    public void a()
    {
    }

    public void a(Activity activity)
    {
    }

    public void a(Application application)
    {
        com.google.ads.conversiontracking.a.a(application.getApplicationContext(), "947998763", "YMMvCKfzgl8Qq6CFxAM", "0.00", false);
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        if ("product-sell-complete".equalsIgnoreCase(s) || "dummy-product-sell-complete".equalsIgnoreCase(s))
        {
            com.google.ads.conversiontracking.a.a(context.getApplicationContext(), "947998763", "icTZCJ356F4Qq6CFxAM", "0", true);
            com.google.ads.conversiontracking.a.a(context.getApplicationContext(), "946264175", "V6cgCL_C7F8Q77CbwwM", "0", true);
        }
    }

    public void a(ParseUser parseuser)
    {
    }

    public void b()
    {
    }

    public void b(Activity activity)
    {
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
    }

    public void c(Activity activity)
    {
    }

    public void d(Activity activity)
    {
    }

    public void e(Activity activity)
    {
    }

    public void f(Activity activity)
    {
    }
}
