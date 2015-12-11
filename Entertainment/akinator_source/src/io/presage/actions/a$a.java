// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.os.AsyncTask;

// Referenced classes of package io.presage.actions:
//            a

final class b extends AsyncTask
{

    final a a;
    private a b;

    protected final Object doInBackground(Object aobj[])
    {
        return b.k();
    }

    protected final void onPostExecute(Object obj)
    {
        b.l();
    }

    public (a a1, a a2)
    {
        a = a1;
        super();
        b = a2;
    }
}
