// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.List;

public final class ih
{

    final Bundle a;
    private ip b;

    public ih(ip ip1, boolean flag)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        } else
        {
            a = new Bundle();
            b = ip1;
            a.putBundle("selector", ip1.a);
            a.putBoolean("activeScan", flag);
            return;
        }
    }

    private void c()
    {
        if (b == null)
        {
            b = ip.a(a.getBundle("selector"));
            if (b == null)
            {
                b = ip.c;
            }
        }
    }

    public final ip a()
    {
        c();
        return b;
    }

    public final boolean b()
    {
        return a.getBoolean("activeScan");
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ih)
        {
            obj = (ih)obj;
            flag = flag1;
            if (a().equals(((ih) (obj)).a()))
            {
                flag = flag1;
                if (b() == ((ih) (obj)).b())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int i = a().hashCode();
        boolean flag;
        if (b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag ^ i;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("DiscoveryRequest{ selector=").append(a());
        stringbuilder.append(", activeScan=").append(b());
        StringBuilder stringbuilder1 = stringbuilder.append(", isValid=");
        c();
        ip ip1 = b;
        ip1.b();
        boolean flag;
        if (ip1.b.contains(null))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        stringbuilder1.append(flag);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }
}
