// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.utils:
//            al, d, i

final class j extends AsyncTask
{

    private final i a;
    private final al b;
    private d c;

    public j(d d1, al al1, i k)
    {
        c = d1;
        super();
        a = k;
        b = al1;
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = new ArrayList();
        if (b.a())
        {
            ((List) (aobj)).add("Please give your item a title.");
        }
        if (b.b())
        {
            ((List) (aobj)).add("Please limit the title to 150 letters.");
        }
        if (!b.b(c.a))
        {
            ((List) (aobj)).add("Please attach a picture of the item.");
        }
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        a.a(((List) (obj)));
    }
}
