// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import com.appnexus.opensdk.b.b;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk:
//            m

final class am
{

    private static final Uri a = Uri.parse("appnexuspb://app?");
    private static LinkedHashMap b = new LinkedHashMap();

    static Bitmap a(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    static void a(Context context, String s, byte abyte0[])
    {
        s = new Intent("com.appnexus.opensdk.BROADCAST", Uri.parse((new StringBuilder("appnexuspb://app?auction_info=")).append(Uri.encode(s)).toString()));
        s.putExtra("image", abyte0);
        context.sendBroadcast(s);
    }

    static void a(m m1, String s)
    {
        if (m1 != null && m1.getContext() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String s1;
        obj = m1.getContext();
        s = Uri.parse(s);
        s1 = s.getHost();
        if (!"web".equals(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (m1.l)
        {
            m1 = new Intent("android.intent.action.VIEW", a);
            m1.setFlags(0x10000000);
            try
            {
                ((Context) (obj)).startActivity(m1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (m m1)
            {
                com.appnexus.opensdk.b.b.d(b.b, com.appnexus.opensdk.b.b.a(an.d.opening_url_failed, a.toString()));
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if ("app".equals(s1))
        {
            m1 = s.getQueryParameter("auction_info");
            try
            {
                s = (new JSONObject(m1)).getString("auction_id");
                if (b.size() > 10)
                {
                    obj = (String)b.keySet().iterator().next();
                    b.remove(obj);
                }
                b.put(s, m1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (m m1)
            {
                return;
            }
        }
        if ("capture".equals(s1))
        {
            s = s.getQueryParameter("auction_id");
            s = (String)b.get(s);
            if (s != null)
            {
                Executors.newSingleThreadScheduledExecutor().schedule(new Runnable(m1, ((Context) (obj)), s) {

                    final View a;
                    final Context b;
                    final String c;

                    public final void run()
                    {
                        byte abyte0[] = am.a(am.a(a));
                        com.appnexus.opensdk.b.b.b(b.b, (new StringBuilder("PITBULL image size: ")).append(abyte0.length).append(" bytes").toString());
                        am.a(b, c, abyte0);
                    }

            
            {
                a = view;
                b = context;
                c = s;
                super();
            }
                }, 1000L, TimeUnit.MILLISECONDS);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static byte[] a(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, bytearrayoutputstream))
        {
            return bytearrayoutputstream.toByteArray();
        } else
        {
            return null;
        }
    }

}
