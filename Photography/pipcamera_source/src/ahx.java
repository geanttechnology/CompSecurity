// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public abstract class ahx
    implements Runnable
{

    protected ahy b;
    protected int c;
    protected String d;
    protected int e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected ahl i;
    protected boolean j;
    protected HttpResponse k;
    protected aia l;
    protected int m;

    public ahx()
    {
        c = 0;
        e = 50000;
        j = false;
        k = null;
        b = new ahy();
        m = 6;
        l = new aia();
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

    private boolean a(ahl ahl1, aho aho)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (ahl1 != null)
        {
            obj = obj1;
            if (aho != null)
            {
                obj = ahl1.a(d(), aho);
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

    public ahx a(String s)
    {
        d = s;
        l.a();
        return this;
    }

    public void a(ahl ahl1)
    {
        i = ahl1;
    }

    public void a(Object obj, String s)
    {
        b.a(new ahz(obj, s));
    }

    protected abstract void a(HttpResponse httpresponse);

    public boolean a(int i1)
    {
        return (m & i1) != 0;
    }

    protected abstract aho b();

    protected abstract void b(Object obj);

    protected abstract Object c();

    public String d()
    {
        return d.replaceAll("[^0-9^a-z^A-Z]", "");
    }

    public ahl e()
    {
        return i;
    }

    public void run()
    {
        if (!h) goto _L2; else goto _L1
_L1:
        return;
_L2:
        aho aho;
        ahl ahl1;
        aho = b();
        ahl1 = e();
        if (!a(2) && a(ahl1, aho)) goto _L1; else goto _L3
_L3:
        DefaultHttpClient defaulthttpclient;
        defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), e);
        a(0, this);
        c;
        JVM INSTR tableswitch 0 0: default 266
    //                   0 126;
           goto _L4 _L5
_L4:
        if (a(1) || ahl1 == null || aho == null) goto _L7; else goto _L6
_L6:
        ahl1.a(d(), c(), aho);
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
        Crashlytics.logException(exception);
        if (a(4) && a(ahl1, aho))
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
