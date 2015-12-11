// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.search;

import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.search:
//            FuzzySearchIndex, a, b

class d
    implements Runnable
{

    final String a;
    final float b;
    final a c;
    final b d;
    final FuzzySearchIndex e;

    public void run()
    {
        synchronized (e)
        {
            long l = System.currentTimeMillis();
            String s = FuzzySearchIndex.a(e, a);
            aa.a(FuzzySearchIndex.a(), (new StringBuilder()).append("Start searching for ").append(a).toString());
            long l1 = FuzzySearchIndex.openIndexForRead(FuzzySearchIndex.a(e));
            zzySearchResult azzysearchresult[] = FuzzySearchIndex.searchTermInIndex(l1, s, b, c.ordinal());
            FuzzySearchIndex.closeIndex(l1);
            l1 = System.currentTimeMillis();
            if (d != null)
            {
                d.a(azzysearchresult);
            }
            aa.a(FuzzySearchIndex.a(), (new StringBuilder()).append("End searching for ").append(a).append(". Found ").append(azzysearchresult.length).append(" results for ").append(l1 - l).append("ms. Callback for ").append(System.currentTimeMillis() - l1).append("ms").toString());
        }
        return;
        exception;
        fuzzysearchindex;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (FuzzySearchIndex fuzzysearchindex, String s, float f, a a1, b b1)
    {
        e = fuzzysearchindex;
        a = s;
        b = f;
        c = a1;
        d = b1;
        super();
    }
}
