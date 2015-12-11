// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.amazon.device.ads:
//            co, cn, ds, dy

class dz
{

    private static final String a = com/amazon/device/ads/dz.getSimpleName();
    private static final cn b = co.a(a);

    dz()
    {
    }

    public static final String a(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            b.b("getURLEncodedString threw: %s", new Object[] {
                unsupportedencodingexception
            });
            return s;
        }
        return s1;
    }

    public static boolean a(String s, Context context)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            s1 = "about:blank";
        }
        b.c((new StringBuilder("Launch Intent: ")).append(s1).toString());
        s = new Intent();
        if (s1.startsWith("intent:"))
        {
            try
            {
                s = Intent.parseUri(s1, 1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        } else
        {
            s.setData(Uri.parse(s1));
        }
        s.setAction("android.intent.action.VIEW");
        s.setFlags(0x10000000);
        try
        {
            context.startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = s.getAction();
            cn cn1 = b;
            StringBuilder stringbuilder = new StringBuilder("Could not handle ");
            if (context.startsWith("market://"))
            {
                s = "market";
            } else
            {
                s = "intent";
            }
            cn1.d(stringbuilder.append(s).append(" action: ").append(context).toString());
            return false;
        }
        return true;
    }

    public static final String b(String s)
    {
        String s1 = Uri.parse(s).getScheme();
        s = s1;
        if (s1 != null)
        {
            s = s1.toLowerCase(Locale.US);
        }
        return s;
    }

    public static final void c(String s)
    {
        ds.a(new Runnable(s) {

            final String a;
            final boolean b = false;

            public final void run()
            {
                dy dy1 = (new dy.d()).a();
                dy1.e();
                dy1.c(a);
                dy1.i = b;
                try
                {
                    dy1.c();
                    return;
                }
                catch (dy.c c1)
                {
                    return;
                }
            }

            
            {
                a = s;
                super();
            }
        });
    }

    static 
    {
        new co();
    }
}
