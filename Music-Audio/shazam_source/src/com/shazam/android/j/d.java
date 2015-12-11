// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;


// Referenced classes of package com.shazam.android.j:
//            o

public final class d
    implements o
{

    private final o a[];

    public transient d(o ao[])
    {
        a = ao;
    }

    public final String a(String s)
    {
        o ao[] = a;
        int j = ao.length;
        for (int i = 0; i < j; i++)
        {
            s = ao[i].a(s);
        }

        return s;
    }
}
