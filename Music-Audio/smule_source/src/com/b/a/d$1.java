// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.os.AsyncTask;
import java.io.File;
import java.net.URI;

// Referenced classes of package com.b.a:
//            d, j

class syncTask extends AsyncTask
{

    final j a;
    final String b;
    final Runnable c;
    final d d;

    protected transient Void a(Void avoid[])
    {
        try
        {
            a.a(d, null, (new File(new URI(b))).getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        return null;
    }

    protected void a(Void void1)
    {
        c.run();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    nnable(d d1, j j1, String s, Runnable runnable)
    {
        d = d1;
        a = j1;
        b = s;
        c = runnable;
        super();
    }
}
