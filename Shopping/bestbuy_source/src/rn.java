// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class rn extends rh
{

    private boolean b;
    private ArrayList c;

    protected rn(DataHolder dataholder)
    {
        super(dataholder);
        b = false;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b) goto _L2; else goto _L1
_L1:
        int k;
        k = a.g();
        c = new ArrayList();
        if (k <= 0) goto _L4; else goto _L3
_L3:
        Object obj;
        String s1;
        c.add(Integer.valueOf(0));
        s1 = d();
        int i = a.a(0);
        obj = a.b(s1, 0, i);
        int j = 1;
_L9:
        if (j >= k) goto _L4; else goto _L5
_L5:
        String s;
        int l;
        l = a.a(j);
        s = a.b(s1, j, l);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        throw new NullPointerException((new StringBuilder()).append("Missing value for markerColumn: ").append(s1).append(", at row: ").append(j).append(", for window: ").append(l).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (s.equals(obj)) goto _L7; else goto _L6
_L6:
        c.add(Integer.valueOf(j));
        obj = s;
          goto _L7
_L4:
        b = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final Object a(int i)
    {
        b();
        return a(b(i), c(i));
    }

    protected abstract Object a(int i, int j);

    int b(int i)
    {
        if (i < 0 || i >= c.size())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
        } else
        {
            return ((Integer)c.get(i)).intValue();
        }
    }

    public int c()
    {
        b();
        return c.size();
    }

    protected int c(int i)
    {
        int k;
        if (i < 0 || i == c.size())
        {
            k = 0;
        } else
        {
            int j;
            if (i == c.size() - 1)
            {
                j = a.g() - ((Integer)c.get(i)).intValue();
            } else
            {
                j = ((Integer)c.get(i + 1)).intValue() - ((Integer)c.get(i)).intValue();
            }
            k = j;
            if (j == 1)
            {
                i = b(i);
                int l = a.a(i);
                String s = e();
                k = j;
                if (s != null)
                {
                    k = j;
                    if (a.b(s, i, l) == null)
                    {
                        return 0;
                    }
                }
            }
        }
        return k;
    }

    protected abstract String d();

    protected String e()
    {
        return null;
    }
}
