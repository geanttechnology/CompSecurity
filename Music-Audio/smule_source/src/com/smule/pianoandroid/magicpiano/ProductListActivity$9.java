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
    implements b
{

    final ProductListActivity a;

    public void a(com.smule.pianoandroid.search.SearchResult asearchresult[])
    {
        long l = System.currentTimeMillis();
        HashMap hashmap = new HashMap(asearchresult.length);
        int j = asearchresult.length;
        for (int i = 0; i < j; i++)
        {
            com.smule.pianoandroid.search.SearchResult searchresult = asearchresult[i];
            hashmap.put(searchresult.mKey, ak.a().a(searchresult.mKey).title);
        }

        Arrays.sort(asearchresult, new Comparator(hashmap) {

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
        });
        long l1 = System.currentTimeMillis();
        a.runOnUiThread(new Runnable(asearchresult, l1, l) {

            final com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult a[];
            final long b;
            final long c;
            final ProductListActivity._cls9 d;

            public void run()
            {
                byte byte2 = 8;
                long l2 = System.currentTimeMillis();
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
                aa.a(ProductListActivity.a, (new StringBuilder()).append("Callback executed for ").append(System.currentTimeMillis() - l2).append("ms. Sorting for ").append(b - c).append("ms.").toString());
            }

            
            {
                d = ProductListActivity._cls9.this;
                a = afuzzysearchresult;
                b = l;
                c = l1;
                super();
            }
        });
    }

    _cls2.c(ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}
