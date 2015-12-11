// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

public abstract class ka extends AsyncTask
{

    private final String a;
    protected String b;
    protected String c;
    protected boolean d;
    protected boolean e;
    protected Activity f;
    protected View g;
    protected Exception h;
    protected BBYBaseFragment i;

    public ka()
    {
        a = getClass().getName();
        d = false;
        e = false;
    }

    public ka(Activity activity, BBYBaseFragment bbybasefragment)
    {
        a = getClass().getName();
        a(activity, bbybasefragment);
    }

    public ka(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        a = getClass().getName();
        g = view;
        a(activity, bbybasefragment);
    }

    private void a(Activity activity, BBYBaseFragment bbybasefragment)
    {
        f = activity;
        i = bbybasefragment;
        d = false;
        e = false;
    }

    protected transient Void a(Void avoid[])
    {
        if (f == null || lm.a(f)) goto _L2; else goto _L1
_L1:
        e = true;
_L4:
        if (c != null)
        {
            b = c;
        }
        return null;
_L2:
        try
        {
            a();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            d = true;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            d = true;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            d = true;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            d = true;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            kf.a(a, avoid);
            b = avoid.a().getStatusLine().getReasonPhrase();
            d = true;
            h = avoid;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            kf.a(a, avoid);
            d = true;
            h = avoid;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract void a();

    protected void a_(Void void1)
    {
        super.onPostExecute(void1);
        if (f == null || !f.isFinishing())
        {
            if ((e || d) && f != null && !f.isFinishing())
            {
                if (i != null && i.isVisible())
                {
                    i.d(false);
                    c();
                } else
                if (i != null)
                {
                    i.d(true);
                } else
                {
                    c();
                }
                if (f instanceof HelpMenuActivity)
                {
                    c();
                    return;
                }
            } else
            {
                if (i != null)
                {
                    i.d(false);
                }
                b();
                return;
            }
        }
    }

    public abstract void b();

    public void c()
    {
    }

    public void d()
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void e()
    {
    }

    protected void onPostExecute(Object obj)
    {
        a_((Void)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
        e();
    }
}
