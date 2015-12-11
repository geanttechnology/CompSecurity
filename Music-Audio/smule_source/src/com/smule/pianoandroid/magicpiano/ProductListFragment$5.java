// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a extends AsyncTask
{

    final String a;
    final ProductListFragment b;

    protected transient Integer a(Integer ainteger[])
    {
        return null;
    }

    protected void a(Integer integer)
    {
        integer = ak.a().i(a);
        aa.c(ProductListFragment.d(), (new StringBuilder()).append("Resuming user purchase flow of listing with uid: ").append(((ListingV2) (integer)).productId).toString());
        i.d().a(integer, false);
        ProductListFragment.b(b);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Integer[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    (ProductListFragment productlistfragment, String s)
    {
        b = productlistfragment;
        a = s;
        super();
    }
}
