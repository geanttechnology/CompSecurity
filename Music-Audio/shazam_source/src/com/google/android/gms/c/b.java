// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.a;
import com.google.android.gms.iid.e;
import com.google.android.gms.iid.f;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{

    public static int a = 0x4c4b40;
    public static int b = 0x632ea0;
    public static int c = 0x6acfc0;
    static b d;
    private static final AtomicInteger i = new AtomicInteger(1);
    final Messenger e = new Messenger(new Handler(Looper.getMainLooper()) {

        final b a;

        public final void handleMessage(Message message)
        {
            Object obj;
            if (message != null)
            {
                obj = message.obj;
            }
            message = (Intent)message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(message.getAction()))
            {
                com.google.android.gms.c.b.a(a).add(message);
            } else
            if (!com.google.android.gms.c.b.a(a, message))
            {
                message.setPackage(b.b(a).getPackageName());
                b.b(a).sendBroadcast(message);
                return;
            }
        }

            
            {
                a = b.this;
                super(looper);
            }
    });
    private Context f;
    private PendingIntent g;
    private Map h;
    private final BlockingQueue j = new LinkedBlockingQueue();

    public b()
    {
        h = Collections.synchronizedMap(new HashMap());
    }

    private Intent a(Bundle bundle)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        if (b(f) < 0)
        {
            throw new IOException("Google Play Services missing");
        }
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(com.google.android.gms.iid.e.a(f));
        b(intent);
        intent.putExtra("google.message_id", (new StringBuilder("google.rpc")).append(String.valueOf(i.getAndIncrement())).toString());
        intent.putExtras(bundle);
        intent.putExtra("google.messenger", e);
        f.startService(intent);
        try
        {
            bundle = (Intent)j.poll(30000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new IOException(bundle.getMessage());
        }
        return bundle;
    }

    public static b a(Context context)
    {
        com/google/android/gms/c/b;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            b b1 = new b();
            d = b1;
            b1.f = context.getApplicationContext();
        }
        context = d;
        com/google/android/gms/c/b;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String a(Intent intent)
    {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()))
        {
            intent = null;
        } else
        {
            String s = intent.getStringExtra("message_type");
            intent = s;
            if (s == null)
            {
                return "gcm";
            }
        }
        return intent;
    }

    static BlockingQueue a(b b1)
    {
        return b1.j;
    }

    static boolean a(b b1, Intent intent)
    {
        String s1 = intent.getStringExtra("In-Reply-To");
        String s = s1;
        if (s1 == null)
        {
            s = s1;
            if (intent.hasExtra("error"))
            {
                s = intent.getStringExtra("google.message_id");
            }
        }
        if (s != null)
        {
            b1 = (Handler)b1.h.remove(s);
            if (b1 != null)
            {
                Message message = Message.obtain();
                message.obj = intent;
                return b1.sendMessage(message);
            }
        }
        return false;
    }

    public static int b(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int k;
        try
        {
            k = packagemanager.getPackageInfo(com.google.android.gms.iid.e.a(context), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -1;
        }
        return k;
    }

    static Context b(b b1)
    {
        return b1.f;
    }

    private void b(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (g == null)
        {
            Intent intent1 = new Intent();
            intent1.setPackage("com.google.example.invalidpackage");
            g = PendingIntent.getBroadcast(f, 0, intent1, 0);
        }
        intent.putExtra("app", g);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }

    public final transient String a(String as[])
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Bundle bundle;
        obj = (new StringBuilder(as[0])).toString();
        bundle = new Bundle();
        if (!com.google.android.gms.iid.e.a(f).contains(".gsf")) goto _L2; else goto _L1
_L1:
        a a1;
        bundle.putString("legacy.sender", ((String) (obj)));
        a1 = com.google.android.gms.iid.a.b(f);
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
          goto _L3
        as;
        this;
        JVM INSTR monitorexit ;
        throw as;
_L3:
        boolean flag = true;
        if (!com.google.android.gms.iid.a.c()) goto _L5; else goto _L4
_L4:
        String s = null;
_L6:
        as = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (bundle.getString("ttl") != null)
        {
            flag = false;
        }
        if ("jwt".equals(bundle.getString("type")))
        {
            flag = flag1;
        }
        s = a1.a(((String) (obj)), "GCM", bundle);
        as = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        as = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        a.c.a(a1.e, ((String) (obj)), "GCM", s, a.g);
        as = s;
_L8:
        this;
        JVM INSTR monitorexit ;
        return as;
_L5:
        s = a.c.a(a1.e, ((String) (obj)), "GCM");
          goto _L6
_L2:
        bundle.putString("sender", ((String) (obj)));
        obj = a(bundle);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
        s = ((Intent) (obj)).getStringExtra("registration_id");
        as = s;
        if (s != null) goto _L8; else goto _L7
_L7:
        as = ((Intent) (obj)).getStringExtra("error");
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        throw new IOException(as);
        throw new IOException("SERVICE_NOT_AVAILABLE");
          goto _L6
    }

    public final void a(String s, String s1, Bundle bundle)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Object obj = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null)
        {
            ((Intent) (obj)).putExtras(bundle);
        }
        b(((Intent) (obj)));
        ((Intent) (obj)).setPackage(com.google.android.gms.iid.e.a(f));
        ((Intent) (obj)).putExtra("google.to", s);
        ((Intent) (obj)).putExtra("google.message_id", s1);
        ((Intent) (obj)).putExtra("google.ttl", Long.toString(0L));
        ((Intent) (obj)).putExtra("google.delay", Integer.toString(-1));
        if (com.google.android.gms.iid.e.a(f).contains(".gsf"))
        {
            obj = new Bundle();
            Iterator iterator = bundle.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s2 = (String)iterator.next();
                Object obj1 = bundle.get(s2);
                if (obj1 instanceof String)
                {
                    ((Bundle) (obj)).putString((new StringBuilder("gcm.")).append(s2).toString(), (String)obj1);
                }
            } while (true);
            ((Bundle) (obj)).putString("google.to", s);
            ((Bundle) (obj)).putString("google.message_id", s1);
            com.google.android.gms.iid.a.b(f).a("GCM", "upstream", ((Bundle) (obj)));
            return;
        } else
        {
            f.sendOrderedBroadcast(((Intent) (obj)), "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
    }

}
