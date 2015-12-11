// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.Arrays;

public abstract class eun
{

    public int P;

    public eun()
    {
        P = -1;
    }

    public static final eun a(eun eun1, byte abyte0[])
    {
        return b(eun1, abyte0, 0, abyte0.length);
    }

    private static void a(eun eun1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = new euj(abyte0, 0, j);
            eun1.a(((euj) (abyte0)));
            if (((euj) (abyte0)).a - ((euj) (abyte0)).b != 0)
            {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", eun1);
        }
    }

    public static final boolean a(eun eun1, eun eun2)
    {
        boolean flag1 = false;
        boolean flag;
        if (eun1 == eun2)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (eun1 != null)
            {
                flag = flag1;
                if (eun2 != null)
                {
                    flag = flag1;
                    if (eun1.getClass() == eun2.getClass())
                    {
                        int i = eun1.a();
                        flag = flag1;
                        if (eun2.a() == i)
                        {
                            byte abyte0[] = new byte[i];
                            byte abyte1[] = new byte[i];
                            a(eun1, abyte0, 0, i);
                            a(eun2, abyte1, 0, i);
                            return Arrays.equals(abyte0, abyte1);
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static final byte[] a(eun eun1)
    {
        byte abyte0[] = new byte[eun1.a()];
        a(eun1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    private static eun b(eun eun1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = new eui(abyte0, 0, j);
            eun1.a(abyte0);
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            throw eun1;
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return eun1;
    }

    public int a()
    {
        P = 0;
        return 0;
    }

    public abstract eun a(eui eui1);

    public abstract void a(euj euj1);

    public String toString()
    {
        return a.b(this);
    }
}
