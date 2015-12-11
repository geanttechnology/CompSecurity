// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            ay, aw, s, q, 
//            az, dd, dj, de, 
//            dg, ah, am

public final class dh
{

    private final ay a;

    public dh()
    {
        a = new ay(aw.e);
    }

    public final am a(ah ah, Hashtable hashtable)
        throws s, q
    {
        dd dd1 = new dd(ah);
        ah = dd1.b();
        di di = dd1.a().a();
        de ade[] = de.a(dd1.c(), ah, di);
        int i = 0;
        int j = 0;
        for (; i < ade.length; i++)
        {
            j += ade[i].a();
        }

        byte abyte0[] = new byte[j];
        i = 0;
        j = 0;
        for (; i < ade.length; i++)
        {
            de de1 = ade[i];
            byte abyte1[] = de1.b();
            int j1 = de1.a();
            int k1 = abyte1.length;
            int ai[] = new int[k1];
            for (int k = 0; k < k1; k++)
            {
                ai[k] = abyte1[k] & 0xff;
            }

            int l = abyte1.length;
            try
            {
                a.a(ai, l - j1);
            }
            // Misplaced declaration of an exception variable
            catch (ah ah)
            {
                throw q.a();
            }
            for (l = 0; l < j1; l++)
            {
                abyte1[l] = (byte)ai[l];
            }

            for (int i1 = 0; i1 < j1;)
            {
                abyte0[j] = abyte1[i1];
                i1++;
                j++;
            }

        }

        return dg.a(abyte0, ah, di, hashtable);
    }
}
