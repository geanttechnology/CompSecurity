// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;

// Referenced classes of package com.offerup.android.utils:
//            d, h

final class g extends AsyncTask
{

    private final Uri a;
    private final h b;
    private final int c;
    private final int d;
    private d e;

    public g(d d1, Uri uri, int i, int j, h h1)
    {
        e = d1;
        super();
        a = uri;
        b = h1;
        c = i;
        d = j;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return com.offerup.android.utils.d.a(e, a, c, d);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (obj == null)
        {
            b.a();
            return;
        } else
        {
            b.a(((Bitmap) (obj)));
            return;
        }
    }
}
