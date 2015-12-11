// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.db.c;
import com.smule.pianoandroid.search.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ProductListFragment, MagicApplication

class c
    implements Runnable
{

    final com.smule.pianoandroid.search.archResult a[];
    final long b;
    final long c;
    final Result d;

    public void run()
    {
        byte byte2 = 8;
        long l = System.currentTimeMillis();
        ProductListActivity.d(d.d).a().a(a);
        TextView textview;
        byte byte0;
        byte byte1;
        if (a.length > 0)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        textview = ProductListActivity.i(d.d);
        if (byte0 != 0)
        {
            byte1 = 8;
        } else
        {
            byte1 = 0;
        }
        textview.setVisibility(byte1);
        if (byte0 != 0)
        {
            ProductListActivity.d(d.d).b();
        }
        if (r.a(MagicApplication.getContext()))
        {
            View view = ProductListActivity.j(d.d);
            if (ProductListActivity.d(d.d).a().e().booleanValue())
            {
                byte0 = byte2;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        } else
        {
            ProductListActivity.j(d.d).setVisibility(8);
        }
        aa.a(ProductListActivity.a, (new StringBuilder()).append("Callback executed for ").append(System.currentTimeMillis() - l).append("ms. Sorting for ").append(b - c).append("ms.").toString());
    }

    Result(Result result, com.smule.pianoandroid.search.archResult aarchresult[], long l, long l1)
    {
        d = result;
        a = aarchresult;
        b = l;
        c = l1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ProductListActivity$9

/* anonymous class */
    class ProductListActivity._cls9
        implements b
    {

        final ProductListActivity a;

        public void a(com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult afuzzysearchresult[])
        {
            long l = System.currentTimeMillis();
            HashMap hashmap = new HashMap(afuzzysearchresult.length);
            int j = afuzzysearchresult.length;
            for (int i = 0; i < j; i++)
            {
                com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult = afuzzysearchresult[i];
                hashmap.put(fuzzysearchresult.mKey, ak.a().a(fuzzysearchresult.mKey).title);
            }

            Arrays.sort(afuzzysearchresult, new ProductListActivity._cls9._cls1(hashmap));
            long l1 = System.currentTimeMillis();
            a.runOnUiThread(new ProductListActivity._cls9._cls2(this, afuzzysearchresult, l1, l));
        }

            
            {
                a = productlistactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/ProductListActivity$9$1

/* anonymous class */
        class ProductListActivity._cls9._cls1
            implements Comparator
        {

            final Map a;
            final ProductListActivity._cls9 b;

            public int a(com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult, com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult1)
            {
                if (fuzzysearchresult.mScore < fuzzysearchresult1.mScore)
                {
                    return 1;
                }
                if (fuzzysearchresult.mScore > fuzzysearchresult1.mScore)
                {
                    return -1;
                } else
                {
                    return ((String)a.get(fuzzysearchresult.mKey)).compareTo((String)a.get(fuzzysearchresult1.mKey));
                }
            }

            public int compare(Object obj, Object obj1)
            {
                return a((com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult)obj, (com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult)obj1);
            }

                    
                    {
                        b = ProductListActivity._cls9.this;
                        a = map;
                        super();
                    }
        }

    }

}
