// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public final class amx extends eul
{

    public amy a[];

    public amx()
    {
        a = amy.a;
    }

    public final int a()
    {
        int k = 0;
        int i = 0;
        if (a != null)
        {
            amy aamy[] = a;
            int l = aamy.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                amy amy1 = aamy[j];
                k = i;
                if (amy1 != null)
                {
                    k = i + euj.b(1, amy1);
                }
                j++;
                i = k;
            } while (true);
        }
        i = k + eup.a(O);
        P = i;
        return i;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i = eui1.a();
            switch (i)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int k = eup.a(eui1, 10);
                amy aamy[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aamy = new amy[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, aamy, 0, j);
                }
                for (a = aamy; j < a.length - 1; j++)
                {
                    a[j] = new amy();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new amy();
                eui1.a(a[j]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            amy aamy[] = a;
            int j = aamy.length;
            for (int i = 0; i < j; i++)
            {
                amy amy1 = aamy[i];
                if (amy1 != null)
                {
                    euj1.a(1, amy1);
                }
            }

        }
        eup.a(O, euj1);
    }
}
