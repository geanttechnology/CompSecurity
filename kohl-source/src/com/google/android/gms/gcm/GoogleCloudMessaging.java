// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging
{

    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging Up;
    private PendingIntent Uq;
    final BlockingQueue Ur = new LinkedBlockingQueue();
    private Handler Us;
    private Messenger Ut;
    private Context kM;

    public GoogleCloudMessaging()
    {
        Us = new Handler(Looper.getMainLooper()) {

            final GoogleCloudMessaging Uu;

            public void handleMessage(Message message)
            {
                message = (Intent)message.obj;
                Uu.Ur.add(message);
            }

            
            {
                Uu = GoogleCloudMessaging.this;
                super(looper);
            }
        };
        Ut = new Messenger(Us);
    }

    private void a(String s, String s1, long l, int i, Bundle bundle)
        throws IOException
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("Missing 'to'");
        } else
        {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            intent.putExtras(bundle);
            h(intent);
            intent.setPackage("com.google.android.gms");
            intent.putExtra("google.to", s);
            intent.putExtra("google.message_id", s1);
            intent.putExtra("google.ttl", Long.toString(l));
            intent.putExtra("google.delay", Integer.toString(i));
            kM.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
    }

    private transient void c(String as[])
    {
        as = d(as);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("google.messenger", Ut);
        h(intent);
        intent.putExtra("sender", as);
        kM.startService(intent);
    }

    public static GoogleCloudMessaging getInstance(Context context)
    {
        com/google/android/gms/gcm/GoogleCloudMessaging;
        JVM INSTR monitorenter ;
        if (Up == null)
        {
            Up = new GoogleCloudMessaging();
            Up.kM = context;
        }
        context = Up;
        com/google/android/gms/gcm/GoogleCloudMessaging;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void iJ()
    {
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gms");
        Ur.clear();
        intent.putExtra("google.messenger", Ut);
        h(intent);
        kM.startService(intent);
    }

    public void close()
    {
        iK();
    }

    transient String d(String as[])
    {
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringbuilder = new StringBuilder(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            stringbuilder.append(',').append(as[i]);
        }

        return stringbuilder.toString();
    }

    public String getMessageType(Intent intent)
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

    void h(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (Uq == null)
        {
            Intent intent1 = new Intent();
            intent1.setPackage("com.google.example.invalidpackage");
            Uq = PendingIntent.getBroadcast(kM, 0, intent1, 0);
        }
        intent.putExtra("app", Uq);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }

    void iK()
    {
        this;
        JVM INSTR monitorenter ;
        if (Uq != null)
        {
            Uq.cancel();
            Uq = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public transient String register(String as[])
        throws IOException
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        Ur.clear();
        c(as);
        try
        {
            as = (Intent)Ur.poll(5000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw new IOException(as.getMessage());
        }
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
        String s = as.getStringExtra("registration_id");
        if (s != null)
        {
            return s;
        }
        as.getStringExtra("error");
        as = as.getStringExtra("error");
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        throw new IOException(as);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public void send(String s, String s1, long l, Bundle bundle)
        throws IOException
    {
        a(s, s1, l, -1, bundle);
    }

    public void send(String s, String s1, Bundle bundle)
        throws IOException
    {
        send(s, s1, -1L, bundle);
    }

    public void unregister()
        throws IOException
    {
        Object obj;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        iJ();
        try
        {
            obj = (Intent)Ur.poll(5000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IOException(((InterruptedException) (obj)).getMessage());
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
        if (((Intent) (obj)).getStringExtra("unregistered") != null)
        {
            return;
        }
        obj = ((Intent) (obj)).getStringExtra("error");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        throw new IOException(((String) (obj)));
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
