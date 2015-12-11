// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.AsyncTask;
import android.os.Handler;
import java.net.HttpURLConnection;

// Referenced classes of package jumiomobile:
//            aj, ah, ak

public abstract class ai extends AsyncTask
{

    protected HttpURLConnection a;
    protected final String b = "--";
    protected final String c = "\r\n";
    protected String d;
    private Handler e;
    private boolean f;
    private Runnable g;

    public ai()
    {
        e = new Handler();
        f = false;
        d = (new StringBuilder("+++Android_JMSDK_mobile_")).append(System.currentTimeMillis()).append("+++").toString();
        g = new aj(this);
    }

    static boolean a(ai ai1, boolean flag)
    {
        ai1.f = flag;
        return flag;
    }

    protected void a()
    {
        if (e != null)
        {
            e.removeCallbacks(g);
        }
    }

    protected void a(int i)
    {
        if (e != null)
        {
            e.removeCallbacks(g);
        }
        if (b())
        {
            throw new ah(0, "Timed out");
        }
        if (isCancelled())
        {
            throw new ah(0, "Cancelled");
        }
        if (i != 200)
        {
            throw new ah(i, a.getResponseMessage());
        } else
        {
            return;
        }
    }

    protected void b(int i)
    {
        e.postDelayed(g, i);
    }

    public boolean b()
    {
        return f;
    }

    public void c()
    {
        (new Thread(new ak(this))).start();
    }

    protected void onCancelled(Object obj)
    {
        onPostExecute(obj);
    }
}
