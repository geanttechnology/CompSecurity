// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a extends AsyncTask
{

    final ProductListFragment a;

    protected transient Integer a(Integer ainteger[])
    {
        return null;
    }

    protected void a(Integer integer)
    {
        a.c(i.d().a());
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Integer[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    (ProductListFragment productlistfragment)
    {
        a = productlistfragment;
        super();
    }
}
