// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.d:
//            ay, ax, be, gm

public final class bb
{

    BlockingQueue a;
    ExecutorService b;
    public LinkedHashMap c;
    String d;
    final Context e;
    final String f;
    AtomicBoolean g;
    File h;

    public bb(Context context, String s, String s1, Map map)
    {
        c = new LinkedHashMap();
        e = context;
        f = s;
        d = s1;
        g = new AtomicBoolean(false);
        context = g;
        s = ay.I;
        context.set(((Boolean)p.n().a(s)).booleanValue());
        if (g.get())
        {
            context = Environment.getExternalStorageDirectory();
            if (context != null)
            {
                h = new File(context, "sdk_csi_data.txt");
            }
        }
        for (context = map.entrySet().iterator(); context.hasNext(); c.put(s.getKey(), s.getValue()))
        {
            s = (java.util.Map.Entry)context.next();
        }

        a = new ArrayBlockingQueue(30);
        b = Executors.newSingleThreadExecutor();
        b.execute(new Runnable() {

            final bb a;

            public final void run()
            {
                Object obj2 = a;
_L5:
                Object obj;
                Object obj1;
                do
                {
                    obj1 = (be)((bb) (obj2)).a.take();
                    obj = ((be) (obj1)).c();
                } while (TextUtils.isEmpty(((CharSequence) (obj))));
                ((bb) (obj2)).c.putAll(((be) (obj1)).d());
                Object obj3 = ((bb) (obj2)).c;
                obj1 = Uri.parse(((bb) (obj2)).d).buildUpon();
                java.util.Map.Entry entry;
                for (obj3 = ((Map) (obj3)).entrySet().iterator(); ((Iterator) (obj3)).hasNext(); ((android.net.Uri.Builder) (obj1)).appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj3)).next();
                }

                break MISSING_BLOCK_LABEL_129;
                obj;
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
                String s2;
                obj1 = new StringBuilder(((android.net.Uri.Builder) (obj1)).build().toString());
                ((StringBuilder) (obj1)).append("&it=").append(((String) (obj)));
                s2 = ((StringBuilder) (obj1)).toString();
                if (!((bb) (obj2)).g.get()) goto _L2; else goto _L1
_L1:
                obj1 = ((bb) (obj2)).h;
                if (obj1 == null) goto _L4; else goto _L3
_L3:
                obj = null;
                obj1 = new FileOutputStream(((File) (obj1)), true);
                obj = obj1;
                ((FileOutputStream) (obj1)).write(s2.getBytes());
                obj = obj1;
                ((FileOutputStream) (obj1)).write(10);
                try
                {
                    ((FileOutputStream) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                }
                  goto _L5
                obj;
                obj1 = null;
_L7:
                obj = obj1;
                com.google.android.gms.ads.internal.util.client.b.a(5);
                if (obj1 != null)
                {
                    try
                    {
                        ((FileOutputStream) (obj1)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                    }
                }
                  goto _L5
                obj2;
                obj1 = obj;
                obj = obj2;
_L6:
                if (obj1 != null)
                {
                    try
                    {
                        ((FileOutputStream) (obj1)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                    }
                }
                throw obj;
_L4:
                com.google.android.gms.ads.internal.util.client.b.a(5);
                  goto _L5
_L2:
                p.e();
                gm.a(((bb) (obj2)).e, ((bb) (obj2)).f, s2);
                  goto _L5
                Exception exception;
                exception;
                obj1 = obj;
                obj = exception;
                  goto _L6
                IOException ioexception;
                ioexception;
                  goto _L7
            }

            
            {
                a = bb.this;
                super();
            }
        });
    }

    public final boolean a(be be)
    {
        return a.offer(be);
    }
}
