// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package p.dn;

import p.dl.a;
import p.dm.g;
import p.ds.c;
import p.ds.d;

// Referenced classes of package p.dn:
//            a

public class al extends p.dn.a
{

    public static final d g;
    public static final int h;

    public al(byte abyte0[])
    {
        super(h, "PNDR_GET_STATION_ART", 0, abyte0);
    }

    public String a(g g1)
    {
        if (g1 == g.c)
        {
            g1 = new StringBuffer(a());
            g1.append(" {");
            g1.append("maxPayloadLength=");
            g1.append(c());
            g1.append(",");
            g1.append("stationTokens=");
            g1.append("[");
            int ai[] = d();
            for (int i = 0; i < ai.length; i++)
            {
                g1.append(ai[i]);
                if (i + 1 < ai.length)
                {
                    g1.append(",");
                }
            }

            g1.append("]");
            g1.append("}");
            return g1.toString();
        } else
        {
            return super.a(g1);
        }
    }

    public int c()
    {
        byte abyte0[] = new byte[4];
        System.arraycopy(c, 1, abyte0, 0, abyte0.length);
        return (new c(abyte0)).c();
    }

    public int[] d()
    {
        int ai[] = new int[(c.length - 5) / 4];
        int j = 5;
        for (int i = 0; i < ai.length; i++)
        {
            byte abyte0[] = new byte[4];
            System.arraycopy(c, j, abyte0, 0, abyte0.length);
            ai[i] = (new c(abyte0)).c();
            j += 4;
        }

        return ai;
    }

    static 
    {
        g = a.ac;
        h = g.c();
    }
}
