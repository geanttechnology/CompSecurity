// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import java.util.Map;

public final class wc extends we
{

    private Map a;

    public wc()
    {
    }

    private wg c(String s)
    {
        try
        {
            Object obj = Class.forName(s, false, wc.getClassLoader());
            if (nz.isAssignableFrom(((Class) (obj))))
            {
                obj = (nz)((Class) (obj)).newInstance();
                return new wr(((nz) (obj)), (oh)a.get(((nz) (obj)).b()));
            }
            if (oz.isAssignableFrom(((Class) (obj))))
            {
                return new wp((oz)((Class) (obj)).newInstance());
            } else
            {
                acb.e((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            acb.e((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public wg a(String s)
    {
        return c(s);
    }

    public void a(Map map)
    {
        a = map;
    }

    public boolean b(String s)
    {
        boolean flag;
        try
        {
            flag = pe.isAssignableFrom(Class.forName(s, false, wc.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            acb.e((new StringBuilder()).append("Could not load custom event implementation class: ").append(s).append(", assuming old implementation.").toString());
            return false;
        }
        return flag;
    }
}
