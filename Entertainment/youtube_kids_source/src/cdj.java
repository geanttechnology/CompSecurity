// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cdj
{

    public final Object a;
    public final int b;

    cdj(Object obj, int i)
    {
        b = i;
        a = obj;
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
            obj = (cdj)obj;
            if (b != ((cdj) (obj)).b)
            {
                return false;
            }
            if (a == null)
            {
                if (((cdj) (obj)).a != null)
                {
                    return false;
                }
            } else
            {
                return a.equals(((cdj) (obj)).a);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        return (i + 31) * 31 + b;
    }
}
