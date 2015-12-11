// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.f.d.a;
import com.shazam.model.Tag;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.android.l:
//            a, b

public final class i
    implements com.shazam.android.l.a
{

    private final b a[];

    public transient i(b ab[])
    {
        a = ab;
    }

    private List a(Tag tag)
    {
        ArrayList arraylist = new ArrayList();
        b ab[] = a;
        int k = ab.length;
        int j = 0;
        while (j < k) 
        {
            b b1 = ab[j];
            try
            {
                arraylist.add((android.support.v4.app.u.a)b1.a(tag));
            }
            catch (a a1) { }
            j++;
        }
        return arraylist;
    }

    public final volatile Object a(Object obj)
    {
        return a((Tag)obj);
    }
}
