// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager, d

public class c extends AsyncTask
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/c.getSimpleName();
    private final ax b;
    private final d c;

    public c(ax ax1, d d1)
    {
        b = ax1;
        c = d1;
    }

    protected transient Exception a(Void avoid[])
    {
        if (!NetworkManager.L())
        {
            break MISSING_BLOCK_LABEL_15;
        }
        b.a();
        return null;
        try
        {
            b.a(new bn(null, new Exception(NetworkManager.d)));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return avoid;
        }
        return null;
    }

    protected void a(Exception exception)
    {
        if (exception == null)
        {
            c.a(null);
            return;
        } else
        {
            c.b(exception);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        c.c(null);
    }

    protected void onPostExecute(Object obj)
    {
        a((Exception)obj);
    }

}
