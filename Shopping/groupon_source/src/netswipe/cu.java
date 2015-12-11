// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.os.AsyncTask;
import android.os.Handler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package netswipe:
//            cv, cq

public abstract class cu extends AsyncTask
{

    private Handler a;
    protected HttpRequestBase b;
    private boolean c;
    private Runnable d;

    public cu()
    {
        a = new Handler();
        c = false;
        b = null;
        d = new cv(this);
    }

    static boolean a(cu cu1, boolean flag)
    {
        cu1.c = flag;
        return flag;
    }

    protected void a(int i)
    {
        a.postDelayed(d, i);
    }

    protected void a(HttpResponse httpresponse)
        throws cq
    {
        if (a != null)
        {
            a.removeCallbacks(d);
        }
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i != 200)
        {
            throw new cq(i, (new StringBuilder()).append("HTTP Response was: ").append(i).toString());
        } else
        {
            return;
        }
    }

    public boolean a()
    {
        return c;
    }
}
