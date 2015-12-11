// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            ya, xx, xy, xz, 
//            xu

public abstract class xv extends ya
{

    protected xx r;

    public xv()
    {
    }

    public void a(xu xu)
        throws IOException
    {
        if (r != null)
        {
            int i = 0;
            while (i < r.a()) 
            {
                r.a(i).a(xu);
                i++;
            }
        }
    }

    protected final boolean a(xv xv1)
    {
        if (r == null || r.b())
        {
            return xv1.r == null || xv1.r.b();
        } else
        {
            return r.equals(xv1.r);
        }
    }

    protected int b()
    {
        int j = 0;
        int k;
        if (r != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (j >= r.a())
                {
                    break;
                }
                i += r.a(j).a();
                j++;
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return e();
    }

    protected final int d()
    {
        if (r == null || r.b())
        {
            return 0;
        } else
        {
            return r.hashCode();
        }
    }

    public xv e()
        throws CloneNotSupportedException
    {
        xv xv1 = (xv)super.f();
        xz.a(this, xv1);
        return xv1;
    }

    public ya f()
        throws CloneNotSupportedException
    {
        return e();
    }
}
