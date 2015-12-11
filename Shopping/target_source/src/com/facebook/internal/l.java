// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

// Referenced classes of package com.facebook.internal:
//            k

public abstract class l
    implements ServiceConnection
{
    public static interface a
    {

        public abstract void a(Bundle bundle);
    }


    private final Context a;
    private final Handler b = new Handler() {

        final l a;

        public void handleMessage(Message message)
        {
            a.a(message);
        }

            
            {
                a = l.this;
                super();
            }
    };
    private a c;
    private boolean d;
    private Messenger e;
    private int f;
    private int g;
    private final String h;
    private final int i;

    public l(Context context, int j, int i1, int j1, String s)
    {
        Context context1 = context.getApplicationContext();
        if (context1 != null)
        {
            context = context1;
        }
        a = context;
        f = j;
        g = i1;
        h = s;
        i = j1;
    }

    private void b(Bundle bundle)
    {
        if (d)
        {
            d = false;
            a a1 = c;
            if (a1 != null)
            {
                a1.a(bundle);
                return;
            }
        }
    }

    private void c()
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", h);
        a(bundle);
        Message message = Message.obtain(null, f);
        message.arg1 = i;
        message.setData(bundle);
        message.replyTo = new Messenger(b);
        try
        {
            e.send(message);
            return;
        }
        catch (RemoteException remoteexception)
        {
            b(null);
        }
    }

    protected abstract void a(Bundle bundle);

    protected void a(Message message)
    {
        if (message.what == g)
        {
            message = message.getData();
            if (message.getString("com.facebook.platform.status.ERROR_TYPE") != null)
            {
                b(null);
            } else
            {
                b(message);
            }
            a.unbindService(this);
        }
    }

    public void a(a a1)
    {
        c = a1;
    }

    public boolean a()
    {
        if (!d && k.b(i) != -1)
        {
            android.content.Intent intent = k.a(a);
            if (intent != null)
            {
                d = true;
                a.bindService(intent, this, 1);
                return true;
            }
        }
        return false;
    }

    public void b()
    {
        d = false;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        e = new Messenger(ibinder);
        c();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        e = null;
        try
        {
            a.unbindService(this);
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname) { }
        b(null);
    }
}
