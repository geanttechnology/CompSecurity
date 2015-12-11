// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a
    implements Runnable
{

    final ProductListFragment a;

    public void run()
    {
        (new AsyncTask() {

            ListingV2 a;
            final ProductListFragment._cls1 b;

            protected transient Void a(Void avoid[])
            {
                if (ProductListFragment.a(b.a) != null)
                {
                    a = i.d().a();
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                b = ProductListFragment._cls1.this;
                super();
            }
        }).execute((Void[])null);
    }

    _cls1.b(ProductListFragment productlistfragment)
    {
        a = productlistfragment;
        super();
    }
}
