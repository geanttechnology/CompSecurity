// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import android.os.AsyncTask;

// Referenced classes of package com.facebook.ads.internal.thirdparty.http:
//            c, a, l, b, 
//            n

public class h extends AsyncTask
    implements c
{

    private a a;
    private b b;
    private Exception c;

    public h(a a1, b b1)
    {
        a = a1;
        b = b1;
    }

    protected transient n a(l al[])
    {
        if (al == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        try
        {
            if (al.length <= 0)
            {
                break MISSING_BLOCK_LABEL_22;
            }
        }
        // Misplaced declaration of an exception variable
        catch (l al[])
        {
            c = al;
            cancel(true);
            return null;
        }
        al = al[0];
        return a.a(al);
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void a(l l1)
    {
        super.execute(new l[] {
            l1
        });
    }

    protected void a(n n1)
    {
        b.a(n1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((l[])aobj);
    }

    protected void onCancelled()
    {
        b.a(c);
    }

    protected void onPostExecute(Object obj)
    {
        a((n)obj);
    }
}
