// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eby extends eul
{

    public dyq a;
    private dqf b;
    private dsm c;

    public eby()
    {
        b = null;
        a = null;
        c = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x3f5caaa, b) + 0;
        }
        int i = j;
        if (a != null)
        {
            i = j + euj.b(0x49c742f, a);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(0x4a44aae, c);
        }
        i = j + eup.a(O);
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

            case 531518802: 
                if (b == null)
                {
                    b = new dqf();
                }
                eui1.a(b);
                break;

            case 618897786: 
                if (a == null)
                {
                    a = new dyq();
                }
                eui1.a(a);
                break;

            case 623007090: 
                if (c == null)
                {
                    c = new dsm();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x3f5caaa, b);
        }
        if (a != null)
        {
            euj1.a(0x49c742f, a);
        }
        if (c != null)
        {
            euj1.a(0x4a44aae, c);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
label0:
        {
            if (!(obj instanceof eby))
            {
                return false;
            }
            obj = (eby)obj;
            if ((b != null ? b.equals(((eby) (obj)).b) : ((eby) (obj)).b == null) && (a != null ? a.equals(((eby) (obj)).a) : ((eby) (obj)).a == null) && (c != null ? c.equals(((eby) (obj)).c) : ((eby) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eby) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eby) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }
}
