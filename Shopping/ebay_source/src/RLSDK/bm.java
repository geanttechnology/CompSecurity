// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            bu, v, ag, n

public final class bm extends bu
{

    private final int a[] = new int[4];

    public bm()
    {
    }

    protected final int a(ag ag1, int ai[], StringBuffer stringbuffer)
        throws v
    {
        int ai1[] = a;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int j1 = ag1.b;
        int i = ai[1];
        for (int j = 0; j < 4 && i < j1; j++)
        {
            stringbuffer.append((char)(a(ag1, ai1, i, d) + 48));
            for (int l = 0; l < ai1.length; l++)
            {
                i += ai1[l];
            }

        }

        i = a(ag1, i, true, c)[1];
        for (int k = 0; k < 4 && i < j1; k++)
        {
            stringbuffer.append((char)(a(ag1, ai1, i, d) + 48));
            for (int i1 = 0; i1 < ai1.length; i1++)
            {
                i += ai1[i1];
            }

        }

        return i;
    }

    final n b()
    {
        return n.g;
    }
}
