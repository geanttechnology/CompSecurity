// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.aqo;
import android.support.v7.ep;
import android.support.v7.fe;
import android.support.v7.fr;
import android.support.v7.iv;
import com.abtnprojects.ambatana.models.ParseLetgoUser;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.abtnprojects.ambatana.models.product.Product;

// Referenced classes of package com.abtnprojects.ambatana.services:
//            ProductCreationService

public abstract class a extends IntentService
{

    final ParseLetgoUser a = new ParseLetgoUser();
    Messenger b;
    int c;
    protected final Object d = new Object() {

        final a a;

        public void onEvent(ep ep1)
        {
            aqo.b("onEvent", new Object[0]);
            a.b(a).a(a.a(a), ep1.a, false);
            a.c(a).notify(1, a.b(a).a());
            ep1 = Message.obtain(null, 3, ep1.a, 0);
            a.a(a, ep1);
        }

            
            {
                a = a.this;
                super();
            }
    };
    private NotificationManager e;
    private android.support.v4.app.v.d f;
    private volatile int g;

    public a(String s)
    {
        super(s);
    }

    static int a(a a1)
    {
        return a1.g;
    }

    private void a(int i)
    {
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(this, com/abtnprojects/ambatana/services/ProductCreationService), 0);
        e = (NotificationManager)getSystemService("notification");
        f = new android.support.v4.app.v.d(this);
        f.a(getString(0x7f090108)).a(pendingintent).a(0x7f0200ee);
        startForeground(1, f.a());
        f.a(i, 0, false);
        e.notify(1, f.a());
    }

    private void a(Message message)
    {
        try
        {
            if (b != null)
            {
                b.send(message);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            aqo.b(message, "Error sending message to activity", new Object[0]);
        }
    }

    static void a(a a1, Message message)
    {
        a1.a(message);
    }

    static android.support.v4.app.v.d b(a a1)
    {
        return a1.f;
    }

    static NotificationManager c(a a1)
    {
        return a1.e;
    }

    abstract int a(Product product);

    public void onCreate()
    {
        super.onCreate();
        aqo.b("onCreate", new Object[0]);
        iv.a(d);
    }

    public void onDestroy()
    {
        super.onDestroy();
        iv.b(d);
    }

    protected void onHandleIntent(Intent intent)
    {
        aqo.b("onHandleIntent", new Object[0]);
        Object obj = intent.getExtras();
        if (obj != null)
        {
            b = (Messenger)((Bundle) (obj)).get("messenger");
        }
        obj = (Product)intent.getParcelableExtra("productToInsert");
        String s = intent.getStringExtra("address");
        boolean flag;
        if (obj == null)
        {
            flag = false;
        } else
        {
            flag = intent.getBooleanExtra("share_in_fb", false);
        }
        g = a(((Product) (obj)));
        a(g + 1);
        obj = fr.a(c, getApplicationContext(), ((Product) (obj)), a, s).a(flag);
        intent = new Bundle();
        if (obj != null)
        {
            intent.putString("productInserted", ((ProductInserted) (obj)).toJSON());
        }
        obj = Message.obtain(null, 4, 0, 0);
        ((Message) (obj)).setData(intent);
        f.b(getString(0x7f090122)).a(0, 0, false);
        e.notify(1, f.a());
        a(((Message) (obj)));
    }
}
