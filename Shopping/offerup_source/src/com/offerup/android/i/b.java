// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.i;

import android.os.AsyncTask;
import com.offerup.android.activities.h;

// Referenced classes of package com.offerup.android.i:
//            c

public final class b extends AsyncTask
{

    private h a;

    public b(h h)
    {
        a = h;
    }

    static h a(b b1)
    {
        return b1.a;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        (new com.b.a.a.b()).a(a, new c(this));
    }
}
