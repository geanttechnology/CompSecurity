// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class sg
{

    static sg a;
    final BlockingQueue b = new LinkedBlockingQueue();
    private Context c;
    private PendingIntent d;
    private Handler e;
    private Messenger f;

    public sg()
    {
        e = new Handler(Looper.getMainLooper()) {

            final sg a;

            public void handleMessage(Message message)
            {
                message = (Intent)message.obj;
                a.b.add(message);
            }

            
            {
                a = sg.this;
                super(looper);
            }
        };
        f = new Messenger(e);
    }

    public static sg a(Context context)
    {
        sg;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new sg();
            a.c = context.getApplicationContext();
        }
        context = a;
        sg;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private transient void c(String as[])
    {
        as = b(as);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("google.messenger", f);
        a(intent);
        intent.putExtra("sender", as);
        c.startService(intent);
    }

    public transient String a(String as[])
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        b.clear();
        c(as);
        try
        {
            as = (Intent)b.poll(5000L, TimeUnit.MILLISECONDS);
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

    void a(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            Intent intent1 = new Intent();
            intent1.setPackage("com.google.example.invalidpackage");
            d = PendingIntent.getBroadcast(c, 0, intent1, 0);
        }
        intent.putExtra("app", d);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }

    transient String b(String as[])
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
}
