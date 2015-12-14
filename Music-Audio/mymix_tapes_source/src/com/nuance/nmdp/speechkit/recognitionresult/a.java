// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.recognitionresult;

import ey;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.nuance.nmdp.speechkit.recognitionresult:
//            AlternativeChoice, d

final class a
    implements AlternativeChoice
{

    private ey a;

    a(ey ey1)
    {
        a = ey1;
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
