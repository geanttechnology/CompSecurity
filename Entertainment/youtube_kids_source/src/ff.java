// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ff
{

    public static final fi a;
    public final Object b;

    public ff(Object obj)
    {
        b = obj;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ff)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ff) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((ff) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new fj();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new fh();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new fg();
        } else
        {
            a = new fi();
        }
    }
}
