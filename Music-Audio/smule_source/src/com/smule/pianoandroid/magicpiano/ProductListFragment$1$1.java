// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class b extends AsyncTask
{

    ListingV2 a;
    final a b;

    protected transient Void a(Void avoid[])
    {
        if (ProductListFragment.a(b.b) != null)
        {
            a = i.d().a();
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ( )
    {
        b = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ProductListFragment$1

/* anonymous class */
    class ProductListFragment._cls1
        implements Runnable
    {

        final ProductListFragment a;

        public void run()
        {
            (new ProductListFragment._cls1._cls1(this)).execute((Void[])null);
        }

            
            {
                a = productlistfragment;
                super();
            }
    }

}
