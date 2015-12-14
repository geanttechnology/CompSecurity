// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.util.Raw;

// Referenced classes of package net.lingala.zip4j.crypto.PBKDF2:
//            PRF, MacBasedPRF, PBKDF2Parameters

public class PBKDF2Engine
{

    protected PBKDF2Parameters parameters;
    protected PRF prf;

    public PBKDF2Engine()
    {
        parameters = null;
        prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pbkdf2parameters)
    {
        parameters = pbkdf2parameters;
        prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pbkdf2parameters, PRF prf1)
    {
        parameters = pbkdf2parameters;
        prf = prf1;
    }

    protected void INT(byte abyte0[], int i, int j)
    {
        abyte0[i + 0] = (byte)(j / 0x1000000);
        abyte0[i + 1] = (byte)(j / 0x10000);
        abyte0[i + 2] = (byte)(j / 256);
        abyte0[i + 3] = (byte)j;
    }

    protected byte[] PBKDF2(PRF prf1, byte abyte0[], int i, int j)
    {
        byte abyte1[] = abyte0;
        if (abyte0 == null)
        {
            abyte1 = new byte[0];
        }
        int i1 = prf1.getHLen();
        int j1 = ceil(j, i1);
        abyte0 = new byte[j1 * i1];
        int l = 0;
        int k = 1;
        do
        {
            if (k > j1)
            {
                if (j - (j1 - 1) * i1 < i1)
                {
                    prf1 = new byte[j];
                    System.arraycopy(abyte0, 0, prf1, 0, j);
                    return prf1;
                } else
                {
                    return abyte0;
                }
            }
            _F(abyte0, l, prf1, abyte1, i, k);
            l += i1;
            k++;
        } while (true);
    }

    protected void _F(byte abyte0[], int i, PRF prf1, byte abyte1[], int j, int k)
    {
        int l = prf1.getHLen();
        byte abyte3[] = new byte[l];
        byte abyte2[] = new byte[abyte1.length + 4];
        System.arraycopy(abyte1, 0, abyte2, 0, abyte1.length);
        INT(abyte2, abyte1.length, k);
        k = 0;
        abyte1 = abyte2;
        do
        {
            if (k >= j)
            {
                System.arraycopy(abyte3, 0, abyte0, i, l);
                return;
            }
            abyte1 = prf1.doFinal(abyte1);
            xor(abyte3, abyte1);
            k++;
        } while (true);
    }

    protected void assertPRF(byte abyte0[])
    {
        if (prf == null)
        {
            prf = new MacBasedPRF(parameters.getHashAlgorithm());
        }
        prf.init(abyte0);
    }

    protected int ceil(int i, int j)
    {
        int k = 0;
        if (i % j > 0)
        {
            k = 1;
        }
        return i / j + k;
    }

    public byte[] deriveKey(char ac[])
    {
        return deriveKey(ac, 0);
    }

    public byte[] deriveKey(char ac[], int i)
    {
        byte abyte0[] = (byte[])null;
        abyte0 = (byte[])null;
        if (ac == null)
        {
            throw new NullPointerException();
        }
        assertPRF(Raw.convertCharArrayToByteArray(ac));
        int j = i;
        if (i == 0)
        {
            j = prf.getHLen();
        }
        return PBKDF2(prf, parameters.getSalt(), parameters.getIterationCount(), j);
    }

    public PBKDF2Parameters getParameters()
    {
        return parameters;
    }

    public PRF getPseudoRandomFunction()
    {
        return prf;
    }

    public void setParameters(PBKDF2Parameters pbkdf2parameters)
    {
        parameters = pbkdf2parameters;
    }

    public void setPseudoRandomFunction(PRF prf1)
    {
        prf = prf1;
    }

    public boolean verifyKey(char ac[])
    {
        byte abyte0[] = getParameters().getDerivedKey();
        if (abyte0 != null && abyte0.length != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((ac = deriveKey(ac, abyte0.length)) == null || ac.length != abyte0.length)
        {
            continue;
        }
        int i = 0;
        do
        {
            if (i >= ac.length)
            {
                return true;
            }
            if (ac[i] != abyte0[i])
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void xor(byte abyte0[], byte abyte1[])
    {
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return;
            }
            abyte0[i] = (byte)(abyte0[i] ^ abyte1[i]);
            i++;
        } while (true);
    }
}
