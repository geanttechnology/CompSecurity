// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.os.AsyncTask;

// Referenced classes of package io.presage.actions:
//            NewAction

final class b extends AsyncTask
{

    final NewAction a;
    private NewAction b;

    protected final Object doInBackground(Object aobj[])
    {
        return b.execute();
    }

    protected final volatile void onPostExecute(Object obj)
    {
        obj = (String)obj;
        b.onPostExecute(((String) (obj)));
    }

    public (NewAction newaction, NewAction newaction1)
    {
        a = newaction;
        super();
        b = newaction1;
    }
}
