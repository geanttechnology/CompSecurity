// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            ay, aw, s, q, 
//            az, bb, bc, bd, 
//            ah, am

public final class be
{

    private final ay a;

    public be()
    {
        a = new ay(aw.f);
    }

    public final am a(ah ah)
        throws s, q
    {
        ah = new bb(ah);
        bf bf = ah.a();
        ah = bc.a(ah.b(), bf);
        int k1 = ah.length;
        int i = 0;
        int k = 0;
        for (; i < k1; i++)
        {
            k += ah[i].a();
        }

        byte abyte0[] = new byte[k];
        for (int j = 0; j < k1; j++)
        {
            bc bc1 = ah[j];
            byte abyte1[] = bc1.b();
            int l1 = bc1.a();
            int i2 = abyte1.length;
            int ai[] = new int[i2];
            for (int l = 0; l < i2; l++)
            {
                ai[l] = abyte1[l] & 0xff;
            }

            int i1 = abyte1.length;
            try
            {
                a.a(ai, i1 - l1);
            }
            // Misplaced declaration of an exception variable
            catch (ah ah)
            {
                throw q.a();
            }
            for (i1 = 0; i1 < l1; i1++)
            {
                abyte1[i1] = (byte)ai[i1];
            }

            for (int j1 = 0; j1 < l1; j1++)
            {
                abyte0[j1 * k1 + j] = abyte1[j1];
            }

        }

        return bd.a(abyte0);
    }
}
