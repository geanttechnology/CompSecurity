// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.recognitionresult;

import ez;
import fc;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.nuance.nmdp.speechkit.recognitionresult:
//            DetailedResult, a, d, Token

final class c
    implements DetailedResult
{

    private fc a;

    c(fc fc1)
    {
        a = fc1;
    }

    public final List getAlternatives(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        ez ez1 = a.a(i, j);
        for (i = 0; i < ez1.a(); i++)
        {
            arraylist.add(new a(ez1.a(i)));
        }

        return arraylist;
    }

    public final double getConfidenceScore()
    {
        return a.b();
    }

    public final Token getTokenAtCursorPosition(int i)
    {
        return new d(a.b(i));
    }

    public final List getTokens()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < a.a(); i++)
        {
            arraylist.add(new d(a.a(i)));
        }

        return arraylist;
    }

    public final String toString()
    {
        return a.toString();
    }
}
