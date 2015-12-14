// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import cv;
import java.util.List;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            Recognition

final class o
    implements Recognition
{
    final class a
        implements Recognition.Result
    {

        private final String a;
        private final int b;

        public final int getScore()
        {
            return b;
        }

        public final String getText()
        {
            return a;
        }

        a(String s, int i)
        {
            a = s;
            b = i;
        }
    }


    private String a[];
    private int b[];
    private String c;
    private List d;

    public o()
    {
        a = null;
        b = null;
        c = null;
    }

    static String a(o o1, String s)
    {
        o1.c = s;
        return s;
    }

    static List a(o o1)
    {
        return o1.d;
    }

    static List a(o o1, List list)
    {
        o1.d = list;
        return list;
    }

    static int[] a(o o1, int ai[])
    {
        o1.b = ai;
        return ai;
    }

    static String[] a(o o1, String as[])
    {
        o1.a = as;
        return as;
    }

    final bf a()
    {
        return new bf() {

            private o a;

            private boolean a(cv cv1)
            {
                Object aobj[];
                int ai[];
                int i;
                try
                {
                    aobj = cv1.e("transcription");
                    o.a(a, com.nuance.nmdp.speechkit.recognitionresult.b.a(((byte []) (aobj))));
                    aobj = new String[o.a(a).size()];
                    ai = new int[o.a(a).size()];
                }
                // Misplaced declaration of an exception variable
                catch (cv cv1)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Unable to extract transcriptions from result", cv1);
                    o.a(a, new String[0]);
                    o.a(a, new int[0]);
                    o.a(a, null);
                    return false;
                }
                try
                {
                    cv1 = cv1.f("prompt");
                }
                // Misplaced declaration of an exception variable
                catch (cv cv1)
                {
                    cv1 = null;
                }
                i = 0;
                if (i >= o.a(a).size())
                {
                    break; /* Loop/switch isn't completed */
                }
                aobj[i] = ((DetailedResult)o.a(a).get(i)).toString();
                ai[i] = (int)((DetailedResult)o.a(a).get(i)).getConfidenceScore();
                i++;
                if (true) goto _L2; else goto _L1
_L2:
                break MISSING_BLOCK_LABEL_64;
_L1:
                o.a(a, ((String []) (aobj)));
                o.a(a, ai);
                o.a(a, cv1);
                return true;
            }

            public final boolean a()
            {
                return false;
            }

            public final volatile boolean a(Object obj)
            {
                return a((cv)obj);
            }

            public final volatile Object b()
            {
                return a;
            }

            
            {
                a = o.this;
                super();
            }
        };
    }

    public final List getDetailedResults()
    {
        return d;
    }

    public final Recognition.Result getResult(int i)
    {
        if (i < 0 || i >= b.length)
        {
            throw new IndexOutOfBoundsException("index must be >= 0 and < getResultCount().");
        } else
        {
            return new a(a[i], b[i]);
        }
    }

    public final int getResultCount()
    {
        return b.length;
    }

    public final String getSuggestion()
    {
        return c;
    }
}
