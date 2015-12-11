// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bss
{

    public final dsz a;
    public final int b;
    public final boolean c;
    public bqk d;

    public bss(dsz dsz1)
    {
        a = (dsz)b.a(dsz1);
        b = dsz1.a;
        if (dsz1.d != null && dsz1.d.a != null)
        {
            c = dsz1.d.a.a;
            return;
        } else
        {
            c = false;
            return;
        }
    }

    public final boolean a()
    {
        return b == 0;
    }

    public final boolean b()
    {
        return b == 0 || b == 3 || b == 4 || b == 5;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (bss)obj;
            if (a == null && ((bss) (obj)).a != null)
            {
                return false;
            }
            if (b != ((bss) (obj)).b)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return b + 31;
    }
}
