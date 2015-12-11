// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;


// Referenced classes of package com.shazam.android.persistence.p:
//            j

public final class b
    implements j
{

    private final j a[];

    public transient b(j aj[])
    {
        a = aj;
    }

    public final void a(Object obj)
    {
        j aj[] = a;
        int k = aj.length;
        for (int i = 0; i < k; i++)
        {
            aj[i].a(obj);
        }

    }
}
