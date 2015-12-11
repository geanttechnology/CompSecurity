// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;


// Referenced classes of package android.support.v4.view.a:
//            ak, ai, ah, al, 
//            aj

public final class ag
{

    public static final aj a;
    public final Object b;

    public ag(Object obj)
    {
        b = obj;
    }

    public static ag a()
    {
        return new ag(a.a());
    }

    public final void a(int i)
    {
        a.b(b, i);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final void b(int i)
    {
        a.a(b, i);
    }

    public final void c(int i)
    {
        a.e(b, i);
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
        obj = (ag)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ag) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((ag) (obj)).b)) goto _L1; else goto _L4
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
            a = new ak();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new ai();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new ah();
        } else
        {
            a = new al();
        }
    }
}
