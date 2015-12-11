// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.search;

import android.content.Context;
import com.crittercism.app.Crittercism;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.pianoandroid.search:
//            a, b

public class FuzzySearchIndex
{

    private static final String a = com/smule/pianoandroid/search/FuzzySearchIndex.getName();
    private String b;
    private String c;

    public FuzzySearchIndex()
    {
    }

    static String a()
    {
        return a;
    }

    static String a(FuzzySearchIndex fuzzysearchindex)
    {
        return fuzzysearchindex.b;
    }

    static String a(FuzzySearchIndex fuzzysearchindex, String s)
    {
        return fuzzysearchindex.b(s);
    }

    private String b(String s)
    {
        return (new StringBuilder()).append(" ").append(s.trim().toLowerCase()).append(" ").toString();
    }

    private void b()
    {
        (new File(b)).delete();
        File file = new File(c);
        file.delete();
        if (!file.mkdirs())
        {
            aa.b(a, (new StringBuilder()).append("Failed to create ").append(c).toString());
        }
    }

    static void b(FuzzySearchIndex fuzzysearchindex)
    {
        fuzzysearchindex.b();
    }

    public static native void closeIndex(long l);

    public static native boolean insertIndexPair(long l, String s, String s1);

    public static native long openIndexForRead(String s);

    public static native long openIndexForWrite(String s);

    public static native FuzzySearchResult[] searchTermInIndex(long l, String s, float f, int i);

    public FuzzySearchIndex a(String s)
    {
        c = (new StringBuilder()).append(MagicApplication.getContext().getFilesDir().getAbsolutePath()).append(File.separator).append("search").toString();
        b = (new StringBuilder()).append(c).append(File.separator).append(s).append(".index").toString();
        return this;
    }

    public Future a(String s, float f, a a1, com.smule.pianoandroid.search.b b1)
    {
        return com.smule.android.network.core.b.a(new Runnable(s, f, a1, b1) {

            final String a;
            final float b;
            final a c;
            final com.smule.pianoandroid.search.b d;
            final FuzzySearchIndex e;

            public void run()
            {
                synchronized (e)
                {
                    long l = System.currentTimeMillis();
                    String s1 = FuzzySearchIndex.a(e, a);
                    aa.a(FuzzySearchIndex.a(), (new StringBuilder()).append("Start searching for ").append(a).toString());
                    long l1 = FuzzySearchIndex.openIndexForRead(FuzzySearchIndex.a(e));
                    FuzzySearchResult afuzzysearchresult[] = FuzzySearchIndex.searchTermInIndex(l1, s1, b, c.ordinal());
                    FuzzySearchIndex.closeIndex(l1);
                    l1 = System.currentTimeMillis();
                    if (d != null)
                    {
                        d.a(afuzzysearchresult);
                    }
                    aa.a(FuzzySearchIndex.a(), (new StringBuilder()).append("End searching for ").append(a).append(". Found ").append(afuzzysearchresult.length).append(" results for ").append(l1 - l).append("ms. Callback for ").append(System.currentTimeMillis() - l1).append("ms").toString());
                }
                return;
                exception;
                fuzzysearchindex;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                e = FuzzySearchIndex.this;
                a = s;
                b = f;
                c = a1;
                d = b1;
                super();
            }
        });
    }

    public void a(Map map)
    {
        com.smule.android.network.core.b.a(new Runnable(map) {

            final Map a;
            final FuzzySearchIndex b;

            public void run()
            {
                try
                {
                    aa.a(FuzzySearchIndex.a(), (new StringBuilder()).append("Start indexing in file ").append(FuzzySearchIndex.a(b)).toString());
                    com.smule.pianoandroid.search.FuzzySearchIndex.b(b);
                    long l = FuzzySearchIndex.openIndexForWrite(FuzzySearchIndex.a(b));
                    Iterator iterator = a.entrySet().iterator();
                    java.util.Map.Entry entry;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        entry = (java.util.Map.Entry)iterator.next();
                    } while (FuzzySearchIndex.insertIndexPair(l, (String)entry.getKey(), FuzzySearchIndex.a(b, (String)entry.getValue())));
                    FuzzySearchIndex.closeIndex(l);
                    aa.a(FuzzySearchIndex.a(), "End indexing");
                    return;
                }
                catch (Exception exception)
                {
                    aa.b(FuzzySearchIndex.a(), "Failed to rebuild index", exception);
                    Crittercism.a("Failed to rebuild index");
                    Crittercism.a(exception);
                    return;
                }
            }

            
            {
                b = FuzzySearchIndex.this;
                a = map;
                super();
            }
        });
    }

    static 
    {
        System.loadLibrary("fuzzy_search");
    }
}
