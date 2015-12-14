// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public abstract class cfe
    implements Runnable
{

    protected cff b;
    protected int c;
    protected String d;
    protected int e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected cem i;
    protected boolean j;
    protected HttpResponse k;
    protected cfh l;
    protected int m;

    public cfe()
    {
        c = 0;
        e = 50000;
        j = false;
        k = null;
        b = new cff();
        m = 6;
        l = new cfh();
    }

    private void a(int i1, Object obj)
    {
        if (b == null)
        {
            return;
        } else
        {
            obj = Message.obtain(b, i1, obj);
            b.sendMessage(((Message) (obj)));
            return;
        }
    }

    private boolean a(cem cem1, cep cep)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (cem1 != null)
        {
            obj = obj1;
            if (cep != null)
            {
                obj = cem1.a(d(), cep);
            }
        }
        if (obj != null)
        {
            j = true;
            b(obj);
            g = true;
            a(2, this);
            return true;
        } else
        {
            return false;
        }
    }

    public cfe a(String s)
    {
        d = s;
        l.a();
        return this;
    }

    public void a(cem cem1)
    {
        i = cem1;
    }

    public void a(Object obj, String s)
    {
        b.a(new cfg(obj, s));
    }

    protected abstract void a(HttpResponse httpresponse);

    public boolean a(int i1)
    {
        return (m & i1) != 0;
    }

    protected abstract cep b();

    protected abstract void b(Object obj);

    protected abstract Object c();

    public String d()
    {
        return d.replaceAll("[^0-9^a-z^A-Z]", "");
    }

    public cem e()
    {
        return i;
    }

    public void run()
    {
        if (!h) goto _L2; else goto _L1
_L1:
        return;
_L2:
        cep cep;
        cem cem1;
        cep = b();
        cem1 = e();
        if (!a(2) && a(cem1, cep)) goto _L1; else goto _L3
_L3:
        DefaultHttpClient defaulthttpclient;
        defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), e);
        a(0, this);
        c;
        JVM INSTR tableswitch 0 0: default 262
    //                   0 126;
           goto _L4 _L5
_L4:
        if (a(1) || cem1 == null || cep == null) goto _L7; else goto _L6
_L6:
        cem1.a(d(), c(), cep);
_L7:
        a(2, this);
_L8:
        a(1, this);
        return;
_L5:
        k = defaulthttpclient.execute(new HttpGet((new StringBuilder()).append(d).append(l.b()).toString()));
        Log.v("Mehtod_Get url:", (new StringBuilder()).append(d).append(l.b()).toString());
        a(k);
          goto _L4
        Exception exception;
        exception;
        exception.printStackTrace();
        if (a(4) && a(cem1, cep))
        {
            a(1, this);
            return;
        }
        g = true;
        f = true;
        a(3, this);
          goto _L8
    }
}
