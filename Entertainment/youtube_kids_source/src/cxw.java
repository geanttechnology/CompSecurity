// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Pair;
import java.io.Serializable;
import java.util.List;

public final class cxw
    implements Serializable
{

    final cye a;
    final cya b;
    private final int c;

    cxw(int i, cye cye1, cya cya1)
    {
        c = i;
        a = cye1;
        b = cya1;
    }

    private Pair b(int i)
    {
        cye cye1 = a;
        i = cye1.a(i, false);
        if (i == -1)
        {
            return new Pair(null, null);
        }
        String s = (String)cye1.c.get(i);
        for (int j = ((Integer)cye1.b.get(i)).intValue(); i + 1 < cye1.a.size() && ((Integer)cye1.b.get(i + 1)).intValue() == j; i++) { }
        return new Pair(s, (String)cye1.c.get(i));
    }

    public final cyc a(int i)
    {
        cxy cxy1 = b.a(i);
        if (cxy1 == null || !cxy1.f) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = a;
        j = ((cye) (obj)).a(i, true);
        if (j != -1) goto _L4; else goto _L3
_L3:
        obj = new Pair(null, null);
_L6:
        return new cyc(c, i, (String)((Pair) (obj)).first, (String)((Pair) (obj)).second, cxy1);
_L4:
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = new StringBuilder();
        for (; j + 1 < ((cye) (obj)).a.size() && ((Integer)((cye) (obj)).a.get(j + 1)).intValue() <= i && ((Integer)((cye) (obj)).b.get(j + 1)).intValue() > i; j++)
        {
            String s = (String)((cye) (obj)).c.get(j);
            if (s.endsWith("<br/>"))
            {
                stringbuilder.append(s);
                stringbuilder1.append(s);
            }
        }

        stringbuilder.append((String)((cye) (obj)).c.get(j));
        int k = ((Integer)((cye) (obj)).b.get(j)).intValue();
        do
        {
label0:
            {
                if (j < ((cye) (obj)).a.size() && ((Integer)((cye) (obj)).b.get(j)).intValue() == k)
                {
                    String s1 = (String)((cye) (obj)).c.get(j);
                    if (!s1.endsWith("<br/>") && j + 1 < ((cye) (obj)).a.size() && ((Integer)((cye) (obj)).b.get(j + 1)).intValue() <= k)
                    {
                        break label0;
                    }
                    stringbuilder1.append(s1);
                }
                obj = new Pair(stringbuilder.toString(), stringbuilder1.toString());
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
_L2:
        obj = b(i);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final String toString()
    {
        return String.format("id: %d text: %s settings: %s", new Object[] {
            Integer.valueOf(c), a.toString(), b.toString()
        });
    }
}
