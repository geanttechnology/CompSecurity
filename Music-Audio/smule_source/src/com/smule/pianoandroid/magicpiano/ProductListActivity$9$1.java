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

class a
    implements Comparator
{

    final Map a;
    final Result b;

    public int a(com.smule.pianoandroid.search.archResult archresult, com.smule.pianoandroid.search.archResult archresult1)
    {
        if (archresult.mScore < archresult1.mScore)
        {
            return 1;
        }
        if (archresult.mScore > archresult1.mScore)
        {
            return -1;
        } else
        {
            return ((String)a.get(archresult.mKey)).compareTo((String)a.get(archresult1.mKey));
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((com.smule.pianoandroid.search.archResult)obj, (com.smule.pianoandroid.search.archResult)obj1);
    }

    c(c c, Map map)
    {
        b = c;
        a = map;
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

            Arrays.sort(afuzzysearchresult, new ProductListActivity._cls9._cls1(this, hashmap));
            long l1 = System.currentTimeMillis();
            a.runOnUiThread(new ProductListActivity._cls9._cls2(afuzzysearchresult, l1, l));
        }

            
            {
                a = productlistactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/ProductListActivity$9$2

/* anonymous class */
        class ProductListActivity._cls9._cls2
            implements Runnable
        {

            final com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult a[];
            final long b;
            final long c;
            final ProductListActivity._cls9 d;

            public void run()
            {
                byte byte2 = 8;
                long l = System.currentTimeMillis();
                ProductListActivity.d(d.a).a().a(a);
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
                textview = ProductListActivity.i(d.a);
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
                    ProductListActivity.d(d.a).b();
                }
                if (r.a(MagicApplication.getContext()))
                {
                    View view = ProductListActivity.j(d.a);
                    if (ProductListActivity.d(d.a).a().e().booleanValue())
                    {
                        byte0 = byte2;
                    } else
                    {
                        byte0 = 0;
                    }
                    view.setVisibility(byte0);
                } else
                {
                    ProductListActivity.j(d.a).setVisibility(8);
                }
                aa.a(ProductListActivity.a, (new StringBuilder()).append("Callback executed for ").append(System.currentTimeMillis() - l).append("ms. Sorting for ").append(b - c).append("ms.").toString());
            }

                    
                    {
                        d = ProductListActivity._cls9.this;
                        a = afuzzysearchresult;
                        b = l;
                        c = l1;
                        super();
                    }
        }

    }

}
